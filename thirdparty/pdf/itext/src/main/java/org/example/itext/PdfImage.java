package org.example.itext;

import com.itextpdf.text.Image;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfStamper;

import java.util.List;

public class PdfImage {

    /**
     * 插入图片
     *
     * @param ps
     * @param s
     */
    public static void insertImage(PdfStamper ps, AcroFields s) {

        try {
            List<AcroFields.FieldPosition> listBing = s.getFieldPositions("bing");
            int pageBing = listBing.get(0).page;
            Rectangle signRectBing = listBing.get(0).position;

            Image imageBing = Image.getInstance("../image/bing.png");
            PdfContentByte underBing = ps.getOverContent(pageBing);
            float xBing = signRectBing.getLeft();
            float yBing = signRectBing.getBottom();
            imageBing.setAbsolutePosition(xBing, yBing);
            imageBing.scaleToFit(signRectBing.getWidth(), signRectBing.getHeight());
            underBing.addImage(imageBing);

            List<AcroFields.FieldPosition> listGoogle = s.getFieldPositions("google");
            int pageGoogle = listGoogle.get(0).page;
            Rectangle signRectGoogle = listGoogle.get(0).position;

            Image imageGoogle = Image.getInstance("../image/google.png");
            PdfContentByte underGoogle = ps.getOverContent(pageGoogle);
            float xGoogle = signRectGoogle.getLeft();
            float yGoogle = signRectGoogle.getBottom();
            imageGoogle.setAbsolutePosition(xGoogle, yGoogle);
            imageGoogle.scaleToFit(signRectGoogle.getWidth(), signRectGoogle.getHeight());
            underGoogle.addImage(imageGoogle);

            ps.setFormFlattening(true);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
