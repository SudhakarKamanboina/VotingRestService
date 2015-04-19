package config;

/**
 * Created by sudh on 2/21/2015.
 */
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import config.services.ModeratorRepository;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.authentication.UserCredentials;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.Arrays;

@ComponentScan(basePackages = {"config"})
@EnableAutoConfiguration
@EnableMongoRepositories
@EnableScheduling
@Configuration
public class ApplicationConf extends AbstractMongoConfiguration
{
    public static void main(String[] args) {
        SpringApplication.run(ApplicationConf.class, args);
    }

    @Override
    protected String getDatabaseName() {
        return  "cmpe273";
    }

    @Override
    public MongoClient mongo() throws Exception {
        MongoCredential credential = MongoCredential.createCredential("sudhakar", "cmpe273", "sudhakar".toCharArray());
        MongoClient mclient =  new MongoClient(new ServerAddress("localhost",27017), Arrays.asList(credential));
        return mclient;
    }

    @Override
    protected String getMappingBasePackage() {
        return "config.beans";
    }

    /*@Override
    protected UserCredentials getUserCredentials() {
        UserCredentials cre = new UserCredentials("sudhakar", "sudhakar");
        return null;
    }*/

    @Bean
    MongoMappingContext springDataMongoMappingContext() {
        return new MongoMappingContext();
    }

}
