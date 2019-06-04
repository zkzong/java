package com.zkzong.serializable;

import java.io.Externalizable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class ExternalizableTest implements Externalizable {
    private transient String content = "是的，我将会被序列化，不管我是否被transient关键字修饰";

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(content);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        content = (String) in.readObject();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ExternalizableTest et = new ExternalizableTest();
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(new File("externalizable.out")));
        out.writeObject(et);

        ObjectInput input = new ObjectInputStream(new FileInputStream(new File("externalizable.out")));
        et = (ExternalizableTest) input.readObject();
        System.out.println(et.content);
        out.close();
        input.close();
    }
}
