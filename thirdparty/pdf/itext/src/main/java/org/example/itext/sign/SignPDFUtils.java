package com.example.itext.sign;

import com.itextpdf.text.Image;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfSignatureAppearance;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.security.BouncyCastleDigest;
import com.itextpdf.text.pdf.security.DigestAlgorithms;
import com.itextpdf.text.pdf.security.ExternalDigest;
import com.itextpdf.text.pdf.security.ExternalSignature;
import com.itextpdf.text.pdf.security.MakeSignature;
import com.itextpdf.text.pdf.security.PrivateKeySignature;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.Security;
import java.security.cert.Certificate;
import java.util.UUID;

public class SignPDFUtils {
    /**
     * @param password     秘钥密码
     * @param keyStorePath 秘钥文件路径
     * @param inputStream  签名的PDF文件
     * @param signImage    *            签名图片文件
     *                     * @param x
     *                     *            x坐标
     *                     * @param y
     *                     *            y坐标
     *                     * @return
     */
    public static byte[] sign(String password, String keyStorePath, InputStream inputStream, String signImage, float x, float y, int page, String reason, String location) {
        PdfReader reader = null;
        ByteArrayOutputStream signPDFData = null;
        PdfStamper stp = null;
        FileInputStream fos = null;
        try {
            BouncyCastleProvider provider = new BouncyCastleProvider();
            Security.addProvider(provider);// KeyStore ks = KeyStore.getInstance("JKS", new BouncyCastleProvider());
            KeyStore ks = KeyStore.getInstance("JKS");
            fos = new FileInputStream(keyStorePath); // 私钥密码 为Pkcs生成证书是的私钥密码 123456
            ks.load(fos, password.toCharArray());
            String alias = (String) ks.aliases().nextElement();
            // 获得私钥
            PrivateKey privateKey = (PrivateKey) ks.getKey(alias, password.toCharArray());
            // 获得证书链
            Certificate[] chain = ks.getCertificateChain(alias);
            reader = new PdfReader(inputStream);
            signPDFData = new ByteArrayOutputStream();
            //创建签章工具PdfStamper ，最后一个boolean参数
            //false的话，pdf文件只允许被签名一次，多次签名，最后一次有效
            //true的话，pdf可以被追加签名，验签工具可以识别出每次签名之后文档是否被修改
            stp = PdfStamper.createSignature(reader, signPDFData, '\0', null, true);
            stp.setFullCompression();
            // 获取数字签章属性对象，设定数字签章的属性
            PdfSignatureAppearance sap = stp.getSignatureAppearance();
            // 设置签章原因
            sap.setReason(reason);
            // 设置签章地点
            sap.setLocation(location);
            // 使用png格式透明图片
            Image image = Image.getInstance(signImage);
            sap.setImageScale(0);
            sap.setSignatureGraphic(image);
            // 设置签章的显示方式，如下选择的是只显示图章（还有其他的模式，可以图章和签名描述一同显示）
            sap.setRenderingMode(PdfSignatureAppearance.RenderingMode.GRAPHIC);
            //设置签名的位置，页码，签名域名称，多次追加签名的时候，签名预名称不能一样
            //签名的位置，是图章相对于pdf页面的位置坐标，原点为pdf页面左下角
            //四个参数的分别是，图章左下角x，图章左下角y，图章右上角x，图章右上角y
            sap.setVisibleSignature(new Rectangle(x, y, x + 185, y + 68), page,
                    UUID.randomUUID().toString().replaceAll("-", ""));
            stp.getWriter().setCompressionLevel(5);
            // 摘要算法
            ExternalDigest digest = new BouncyCastleDigest();
            // 签章算法
            ExternalSignature signature = new PrivateKeySignature(privateKey, DigestAlgorithms.SHA512, provider.getName());
            // ExternalSignature signature = new PrivateKeySignature(privateKey, DigestAlgorithms.SHA512, provider.getName());
            // 进行盖章操作 CMS高级电子签名(CAdES)的长效签名规范
            MakeSignature.signDetached(sap, digest, signature, chain, null, null, null, 0, MakeSignature.CryptoStandard.CADES);
            stp.close();
            reader.close();
            return signPDFData.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (signPDFData != null) {
                try {
                    signPDFData.close();
                } catch (IOException e) {
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {

                }
            }
        }
        return null;
    }
}
