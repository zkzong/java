package org.example.mongodb.springdata.config;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;

@Configuration
public class SpringMongoConfig extends AbstractMongoConfiguration {
    @Override
    protected String getDatabaseName() {
        return "test";
    }

    @Bean
    @Override
    public Mongo mongo() throws Exception {
        return new MongoClient("127.0.0.1");
    }

    @Override
    public MappingMongoConverter mappingMongoConverter() throws Exception {
        MappingMongoConverter mmc = super.mappingMongoConverter();
        mmc.setTypeMapper(new DefaultMongoTypeMapper(null));
        return mmc;
    }
}
