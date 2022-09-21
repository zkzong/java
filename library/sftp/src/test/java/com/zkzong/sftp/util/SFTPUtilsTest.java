package org.example.sftp.util;

import com.jcraft.jsch.SftpException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Vector;

import static org.junit.Assert.*;

public class SFTPUtilsTest {

    SFTPUtils sftp;

    @Before
    public void before() {
        sftp = new SFTPUtils("192.168.88.111", "root", "root");
        sftp.connect();
    }

    @Test
    public void batchDownLoadFile() {
        sftp.batchDownLoadFile("/test/", "D:/test/", "", "", false);
    }

    @Test
    public void downloadFile() {
        sftp.downloadFile("/test/", "1.txt", "D:/", "1.txt");
    }

    @Test
    public void uploadFile() {
        sftp.uploadFile("/test/", "1.txt", "D:/tmp/", "1.txt");
    }

    @Test
    public void bacthUploadFile() {
        sftp.bacthUploadFile("/test/", "D:/tmp/", false);
    }

    //@Test
    //public void deleteFile() {
    //    sftp.deleteFile("/test/1/11/test.txt");
    //}

    @Test
    public void createDir() {
        boolean dir = sftp.createDir("/test/1/11");
        System.out.println(dir);
    }

    @Test
    public void isDirExist() {
        boolean dir = sftp.isDirExist("test");
        System.out.println(dir);
    }

    @Test
    public void deleteSFTP() {
        sftp.deleteSFTP("/test/1/11/", "test.txt");
    }

    //@Test
    //public void mkdirs() {
    //    sftp.mkdirs("/test/test.txt");
    //}

    @Test
    public void listFiles() throws SftpException {
        Vector vector = sftp.listFiles("/");
        System.out.println(vector);
    }

    @After
    public void after() {
        sftp.disconnect();
    }
}