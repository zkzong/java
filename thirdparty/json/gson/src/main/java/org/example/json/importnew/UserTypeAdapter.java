package org.example.json.importnew;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

/**
 * Created by Zong on 2017/3/23.
 */
public class UserTypeAdapter extends TypeAdapter<User> {
    @Override
    public void write(JsonWriter out, User value) throws IOException {
        out.beginObject();
        out.name("name").value(value.getName());
        out.name("age").value(value.getAge());
        out.name("email").value(value.getEmailAddress());
        out.endObject();
    }

    @Override
    public User read(JsonReader in) throws IOException {
        User user = new User();
        in.beginObject();
        while (in.hasNext()) {
            switch (in.nextName()) {
                case "name":
                    user.setName(in.nextString());
                    break;
                case "age":
                    user.setAge(in.nextInt());
                    break;
                case "email":
                case "email_address":
                case "emailAddress":
                    user.setEmailAddress(in.nextString());
                    break;
                default:
                    break;
            }
        }
        in.endObject();
        return user;
    }
}
