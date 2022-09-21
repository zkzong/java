package org.example.mp.config;

import com.baomidou.mybatisplus.core.parser.ISqlParser;
import com.baomidou.mybatisplus.core.parser.ISqlParserFilter;
import com.baomidou.mybatisplus.core.parser.SqlParserHelper;
import com.baomidou.mybatisplus.extension.parsers.DynamicTableNameParser;
import com.baomidou.mybatisplus.extension.parsers.ITableNameHandler;
import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class MybatisPlusConfiguration {

    public static ThreadLocal<String> myTableName = new ThreadLocal<>();

    //@Bean
    //public ISqlInjector sqlInjector() {
    //    return new LogicSqlInjector();
    //}

    /**
     * 配置乐观锁
     */
    @Bean
    public OptimisticLockerInterceptor optimisticLockerInterceptor() {
        return new OptimisticLockerInterceptor();
    }

    //@Bean
    //@Profile({"dev", "test"})
    //public PerformanceInterceptor performanceInterceptor() {
    //    PerformanceInterceptor performanceInterceptor = new PerformanceInterceptor();
    //    performanceInterceptor.setFormat(true);
    //    performanceInterceptor.setMaxTime(5L);
    //    return performanceInterceptor;
    //}

    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();

        ArrayList<ISqlParser> sqlParserList = new ArrayList<>();
        // 配置多租户
        //TenantSqlParser tenantSqlParser = new TenantSqlParser();
        //tenantSqlParser.setTenantHandler(new TenantHandler() {
        //    @Override
        //    public Expression getTenantId() {
        //        // 可能从 Session 配置文件或者静态变量等中取出
        //        return new LongValue(1088248166370832385L);
        //    }
        //
        //    @Override
        //    public String getTenantIdColumn() {
        //        return "manager_id";
        //    }
        //
        //    @Override
        //    public boolean doTableFilter(String tableName) {
        //        // 过滤表
        //        if ("role".equals(tableName)) {
        //            return true;
        //        }
        //        return false;
        //    }
        //});
        //sqlParserList.add(tenantSqlParser);

        // 动态表名实现
        DynamicTableNameParser dynamicTableNameParser = new DynamicTableNameParser();
        Map<String, ITableNameHandler> tableNameHandlerMap = new HashMap<>();
        tableNameHandlerMap.put("user", new ITableNameHandler() {
            @Override
            public String dynamicTableName(MetaObject metaObject, String sql, String tableName) {
                return myTableName.get();
            }
        });
        dynamicTableNameParser.setTableNameHandlerMap(tableNameHandlerMap);
        sqlParserList.add(dynamicTableNameParser);

        paginationInterceptor.setSqlParserList(sqlParserList);
        paginationInterceptor.setSqlParserFilter(new ISqlParserFilter() {
            @Override
            public boolean doFilter(MetaObject metaObject) {
                MappedStatement ms = SqlParserHelper.getMappedStatement(metaObject);
                if ("org.example.mp.dao.UserMapper.selectById".equals(ms.getId())) {
                    return true;
                }
                return false;
            }
        });

        return paginationInterceptor;
    }
}
