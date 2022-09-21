package org.example.pdf;

import org.junit.Test;

public class DownloadPdfTest {

    @Test
    public void downLoadByUrl() {
        try {
            DownloadPdf.downLoadByUrl("https://www.mybiosource.com/images/tds/protocol_samples/MBS700_Antibody_Set_Sandwich_ELISA_Protocol.pdf",
                    "ELISA.pdf", "/upload/protocol");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}