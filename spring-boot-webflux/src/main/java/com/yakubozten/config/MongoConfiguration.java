package com.yakubozten.config;

import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;


@Configuration
public class MongoConfiguration extends AbstractReactiveMongoConfiguration {


    @Override
    public MongoClient reactiveMongoClient(){
        return MongoClients.create("mongodb://localhost:27017");
    }
    @Override
    protected String getDatabaseName() {
        return "mydb";
    }
}
