package org.example.easyexcel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.PageReadListener;
import com.alibaba.excel.read.listener.ReadListener;
import com.alibaba.excel.read.metadata.ReadSheet;
import com.alibaba.excel.util.ListUtils;
import com.alibaba.fastjson.JSON;
import org.example.easyexcel.util.TestFileUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * 读的常见写法
 */
@Slf4j
public class ReadTest {

    /**
     * 同步的返回，不推荐使用，如果数据量大会把数据放到内存里面
     */
    @Test
    public void synchronousRead() {
        String fileName = TestFileUtil.getPath() + "demo" + File.separator + "demo.xlsx";
        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 同步读取会自动finish
        // DemoData属性字段要和excel里的列对应
        List<DemoData> list = EasyExcel.read(fileName).head(DemoData.class).sheet().doReadSync();
        for (DemoData data : list) {
            log.info("读取到数据:{}", JSON.toJSONString(data));
        }

        // 这里 也可以不指定class，返回一个list，然后读取第一个sheet 同步读取会自动finish
        List<Map<Integer, String>> listMap = EasyExcel.read(fileName).sheet().doReadSync();
        for (Map<Integer, String> data : listMap) {
            // 返回每条数据的键值对 表示所在的列 和所在列的值
            log.info("读取到数据:{}", JSON.toJSONString(data));
        }
    }

    /**
     * 读多个或者全部sheet，这里注意一个sheet不能读取多次，多次读取需要重新读取文件
     * <p>
     * 1. 创建excel对应的实体对象 参照{@link DemoData}
     * <p>
     * 2. 由于默认一行行的读取excel，所以需要创建excel一行一行的回调监听器，参照{@link DemoDataListener}
     * <p>
     * 3. 直接读即可
     */
    @Test
    public void repeatedRead() {
        String fileName = TestFileUtil.getPath() + "demo" + File.separator + "demo.xlsx";
        // 读取全部sheet
        // 这里需要注意 DemoDataListener的doAfterAllAnalysed 会在每个sheet读取完毕后调用一次。然后所有sheet都会往同一个DemoDataListener里面写
        EasyExcel.read(fileName, DemoData.class, new DemoDataListener()).doReadAll();

        // 读取部分sheet
        fileName = TestFileUtil.getPath() + "demo" + File.separator + "demo.xlsx";
        ExcelReader excelReader = null;
        try {
            excelReader = EasyExcel.read(fileName).build();

            // 这里为了简单 所以注册了 同样的head 和Listener 自己使用功能必须不同的Listener
            ReadSheet readSheet1 =
                    EasyExcel.readSheet(0).head(DemoData.class).registerReadListener(new DemoDataListener()).build();
            ReadSheet readSheet2 =
                    EasyExcel.readSheet(1).head(DemoData.class).registerReadListener(new DemoDataListener()).build();
            // 这里注意 一定要把sheet1 sheet2 一起传进去，不然有个问题就是03版的excel 会读取多次，浪费性能
            excelReader.read(readSheet1, readSheet2);
        } finally {
            if (excelReader != null) {
                // 这里千万别忘记关闭，读的时候会创建临时文件，到时磁盘会崩的
                excelReader.finish();
            }
        }
    }

    /**
     * 获取所有sheet
     */
    @Test
    public void sheet() {
        String fileName = TestFileUtil.getPath() + "demo" + File.separator + "demo.xlsx";
        ExcelReader excelReader = EasyExcel.read(fileName).build();
        List<ReadSheet> readSheets = excelReader.excelExecutor().sheetList();
        int size = readSheets.size();
        System.out.println("readSheets.size()=" + size);
        for (int i = 0; i < size; i++) {
            List<DemoData> dataList = EasyExcel.read(fileName).head(DemoData.class).sheet(i).doReadSync();
            for (DemoData demoData : dataList) {
                System.out.println(demoData);
            }
            System.out.println(dataList);
        }
    }

    /**
     * 当headRowNumber <= 0时，第一行也会被当作数据行而不是head
     */
    @Test
    public void nohead() {
        String fileName = TestFileUtil.getPath() + "demo" + File.separator + "demo.xlsx";
        List<Object> list = EasyExcel.read(fileName).headRowNumber(0).sheet().doReadSync();
        for (Object demoData : list) {
            System.out.println(demoData);
        }
    }

    /**
     * 最简单的读
     * <p>
     * 1. 创建excel对应的实体对象 参照{@link DemoData}
     * <p>
     * 2. 由于默认一行行的读取excel，所以需要创建excel一行一行的回调监听器，参照{@link DemoDataListener}
     * <p>
     * 3. 直接读即可
     */
    @Test
    public void simpleRead() {
        // 写法1：JDK8+ ,不用额外写一个DemoDataListener
        // since: 3.0.0-beta1
        String fileName = TestFileUtil.getPath() + "demo" + File.separator + "demo.xlsx";
        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
        // 这里每次会读取3000条数据 然后返回过来 直接调用使用数据就行
        EasyExcel.read(fileName, DemoData.class, new PageReadListener<DemoData>(dataList -> {
            for (DemoData demoData : dataList) {
                log.info("读取到一条数据{}", JSON.toJSONString(demoData));
            }
        })).sheet().doRead();

        // 写法2：
        // 匿名内部类 不用额外写一个DemoDataListener
        fileName = TestFileUtil.getPath() + "demo" + File.separator + "demo.xlsx";
        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
        EasyExcel.read(fileName, DemoData.class, new ReadListener<DemoData>() {
            /**
             * 单次缓存的数据量
             */
            public static final int BATCH_COUNT = 100;
            /**
             *临时存储
             */
            private List<DemoData> cachedDataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);

            @Override
            public void invoke(DemoData data, AnalysisContext context) {
                cachedDataList.add(data);
                if (cachedDataList.size() >= BATCH_COUNT) {
                    saveData();
                    // 存储完成清理 list
                    cachedDataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);
                }
            }

            @Override
            public void doAfterAllAnalysed(AnalysisContext context) {
                saveData();
            }

            /**
             * 加上存储数据库
             */
            private void saveData() {
                log.info("{}条数据，开始存储数据库！", cachedDataList.size());
                log.info("存储数据库成功！");
            }
        }).sheet().doRead();

        // 有个很重要的点 DemoDataListener 不能被spring管理，要每次读取excel都要new,然后里面用到spring可以构造方法传进去
        // 写法3：
        fileName = TestFileUtil.getPath() + "demo" + File.separator + "demo.xlsx";
        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
        EasyExcel.read(fileName, DemoData.class, new DemoDataListener()).sheet().doRead();

        // 写法4：
        fileName = TestFileUtil.getPath() + "demo" + File.separator + "demo.xlsx";
        // 一个文件一个reader
        ExcelReader excelReader = null;
        try {
            excelReader = EasyExcel.read(fileName, DemoData.class, new DemoDataListener()).build();
            // 构建一个sheet 这里可以指定名字或者no
            ReadSheet readSheet = EasyExcel.readSheet(0).build();
            // 读取一个sheet
            excelReader.read(readSheet);
        } finally {
            if (excelReader != null) {
                // 这里千万别忘记关闭，读的时候会创建临时文件，到时磁盘会崩的
                excelReader.finish();
            }
        }
    }

}
