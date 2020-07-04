package com.kafka.action.chapter6.avro;

import com.sun.xml.internal.ws.encoding.soap.DeserializationException;
import org.apache.avro.io.BinaryDecoder;
import org.apache.avro.io.DatumReader;
import org.apache.avro.io.DecoderFactory;
import org.apache.avro.specific.SpecificDatumReader;
import org.apache.avro.specific.SpecificRecordBase;
import org.apache.kafka.common.serialization.Deserializer;

import java.io.ByteArrayInputStream;
import java.util.Map;

/**
 * Description:Avro反序列化器 <br/>
 *
 * @author moudaen
 * @version 1.0
 */
public class AvroDeserializer<T extends SpecificRecordBase> implements Deserializer<T> {

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {

    }

    @Override
    public void close() {

    }

    @Override
    public T deserialize(String topic, byte[] data) {
        if (null == data) {
            return null;
        }
        try {
            // 根据主题名topic从TopicEnum中获取该主题对应的SpecificRecordBase类型的实体类
            SpecificRecordBase record = TopicEnum.getEnum(topic).getDataType();
            if (null == record) {
                return null;
            }
            // 得到schema实例化DatumReader
            DatumReader<T> userDatumReader = new SpecificDatumReader<>(
                    record.getSchema());
            BinaryDecoder binaryEncoder = DecoderFactory.get()
                    .directBinaryDecoder(new ByteArrayInputStream(data), null);
            return userDatumReader.read(null, binaryEncoder);
        } catch (Exception e) {
            throw new DeserializationException(e.getMessage());
        }
    }
}
