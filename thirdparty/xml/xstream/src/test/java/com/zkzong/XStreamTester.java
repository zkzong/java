package com.zkzong;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import org.junit.Before;
import org.junit.Test;
import org.xml.sax.InputSource;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.sax.SAXSource;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.stream.StreamResult;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class XStreamTester {

    private Student student;

    @Before
    public void before() {
        student = getStudentDetails();
    }

    @Test
    public void test() {
        XStream xstream = new XStream(new StaxDriver());

        //Object to XML Conversion
        String xml = xstream.toXML(student);
        System.out.println(formatXml(xml));

        //XML to Object Conversion
        Student student1 = (Student) xstream.fromXML(xml);
        System.out.println(student1);
    }

    private Student getStudentDetails() {
        Student student = new Student();
        student.setFirstName("Mahesh");
        student.setLastName("Parashar");
        student.setRollNo(1);
        student.setClassName("1st");

        Address address = new Address();
        address.setArea("H.No. 16/3, Preet Vihar.");
        address.setCity("Delhi");
        address.setState("Delhi");
        address.setCountry("India");
        address.setPincode(110012);

        student.setAddress(address);
        return student;
    }

    public static String formatXml(String xml) {
        try {
            Transformer serializer = SAXTransformerFactory.newInstance().newTransformer();
            serializer.setOutputProperty(OutputKeys.INDENT, "yes");
            serializer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
            Source xmlSource = new SAXSource(new InputSource(new ByteArrayInputStream(xml.getBytes())));
            StreamResult res = new StreamResult(new ByteArrayOutputStream());
            serializer.transform(xmlSource, res);
            return new String(((ByteArrayOutputStream) res.getOutputStream()).toByteArray());
        } catch (Exception e) {
            return xml;
        }
    }
}
