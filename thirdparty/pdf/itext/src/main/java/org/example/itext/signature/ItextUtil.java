package org.example.itext.signature;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfSignatureAppearance;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.security.BouncyCastleDigest;
import com.itextpdf.text.pdf.security.DigestAlgorithms;
import com.itextpdf.text.pdf.security.ExternalDigest;
import com.itextpdf.text.pdf.security.ExternalSignature;
import com.itextpdf.text.pdf.security.MakeSignature;
import com.itextpdf.text.pdf.security.PrivateKeySignature;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.cert.Certificate;

/**
 * @Author: zkzong
 * @Date: 2018.9.5
 */
public class ItextUtil {

    public static final char[] PASSWORD = "123456".toCharArray();//keystory密码

    /**
     * 单多次签章通用
     *
     * @param src
     * @param target
     * @param signatureInfos
     * @throws GeneralSecurityException
     * @throws IOException
     * @throws DocumentException
     */
    public void sign(String src, String target, SignatureInfo... signatureInfos) {
        InputStream inputStream = null;
        FileOutputStream outputStream = null;
        ByteArrayOutputStream result = new ByteArrayOutputStream();
        try {
            inputStream = new FileInputStream(src);
            for (SignatureInfo signatureInfo : signatureInfos) {
                ByteArrayOutputStream tempArrayOutputStream = new ByteArrayOutputStream();
                PdfReader reader = new PdfReader(inputStream);
                //创建签章工具PdfStamper ，最后一个boolean参数是否允许被追加签名
                PdfStamper stamper = PdfStamper.createSignature(reader, tempArrayOutputStream, '\0', null, true);
                // 获取数字签章属性对象
                PdfSignatureAppearance appearance = stamper.getSignatureAppearance();
                appearance.setReason(signatureInfo.getReason());
                appearance.setLocation(signatureInfo.getLocation());
                //设置签名的签名域名称，多次追加签名的时候，签名预名称不能一样，图片大小受表单域大小影响（过小导致压缩）
                appearance.setVisibleSignature(signatureInfo.getFieldName());
                //读取图章图片
                Image image = Image.getInstance(signatureInfo.getImagePath());
                appearance.setSignatureGraphic(image);
                appearance.setCertificationLevel(signatureInfo.getCertificationLevel());
                //设置图章的显示方式，如下选择的是只显示图章（还有其他的模式，可以图章和签名描述一同显示）
                appearance.setRenderingMode(signatureInfo.getRenderingMode());
                // 摘要算法
                ExternalDigest digest = new BouncyCastleDigest();
                // 签名算法
                ExternalSignature signature = new PrivateKeySignature(signatureInfo.getPk(), signatureInfo.getDigestAlgorithm(), null);
                // 调用itext签名方法完成pdf签章
                MakeSignature.signDetached(appearance, digest, signature, signatureInfo.getChain(), null, null, null, 0, signatureInfo.getSubfilter());
                //定义输入流为生成的输出流内容，以完成多次签章的过程
                inputStream = new ByteArrayInputStream(tempArrayOutputStream.toByteArray());
                result = tempArrayOutputStream;
            }
            outputStream = new FileOutputStream(new File(target));
            outputStream.write(result.toByteArray());
            outputStream.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != outputStream) {
                    outputStream.close();
                }
                if (null != inputStream) {
                    inputStream.close();
                }
                if (null != result) {
                    result.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        try {
            ItextUtil app = new ItextUtil();
            //将证书文件放入指定路径，并读取keystore ，获得私钥和证书链
            String pkPath = "E:/keystore/test.cer";
            KeyStore ks = KeyStore.getInstance("PKCS12");
            ks.load(new FileInputStream(pkPath), PASSWORD);
            String alias = ks.aliases().nextElement();
            PrivateKey pk = (PrivateKey) ks.getKey(alias, PASSWORD);
            Certificate[] chain = ks.getCertificateChain(alias);
            String src = "pdf/sign-template.pdf";
            //封装签章信息
            SignatureInfo info = new SignatureInfo();
            info.setReason("理由");
            info.setLocation("位置");
            info.setPk(pk);
            info.setChain(chain);
            info.setCertificationLevel(PdfSignatureAppearance.NOT_CERTIFIED);
            info.setDigestAlgorithm(DigestAlgorithms.SHA1);
            info.setFieldName("bing");
            info.setImagePath("image/bing.png");
            info.setRenderingMode(PdfSignatureAppearance.RenderingMode.GRAPHIC);

            SignatureInfo info1 = new SignatureInfo();
            info1.setReason("理由1");
            info1.setLocation("位置1");
            info1.setPk(pk);
            info1.setChain(chain);
            info1.setCertificationLevel(PdfSignatureAppearance.NOT_CERTIFIED);
            info1.setDigestAlgorithm(DigestAlgorithms.SHA1);
            info1.setFieldName("google");
            info1.setImagePath("image/google.png");
            info1.setRenderingMode(PdfSignatureAppearance.RenderingMode.GRAPHIC);

            app.sign(src, "pdf/sign.pdf", info, info1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
