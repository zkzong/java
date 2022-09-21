package org.example.mongodb.config;

import com.mongodb.MongoClient;
import com.mongodb.WriteConcern;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

@Configuration
public class MongoConfig {

	@Bean
	public MongoDbFactory mongoDbFactory() throws Exception {

		MongoClient mongo = new MongoClient("127.0.0.1");
		SimpleMongoDbFactory simpleMongoDbFactory = new SimpleMongoDbFactory(mongo, "test");
		return simpleMongoDbFactory;

	}

	@Bean
	public MongoTemplate mongoTemplate() throws Exception {

		MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory());

		// show error, should off on production to speed up performance
		mongoTemplate.setWriteConcern(WriteConcern.SAFE);

		return mongoTemplate;

	}

}