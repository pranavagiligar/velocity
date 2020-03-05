package com.example.config

import com.mongodb.MongoClientURI
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.core.env.Environment
import org.springframework.data.mongodb.MongoDbFactory
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.SimpleMongoDbFactory


class MongoConfig {
    @Autowired
    private lateinit var env: Environment

    @Bean
    fun mongoDbFactory(): MongoDbFactory? {
        return SimpleMongoDbFactory(MongoClientURI(env.getProperty("spring.data.mongodb.uri")))
    }

    @Bean
    fun mongoTemplate(): MongoTemplate? {
        return MongoTemplate(mongoDbFactory())
    }
}