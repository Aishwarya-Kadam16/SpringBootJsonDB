package com.SpringBoot.project.JsonDB;

import io.jsondb.JsonDBTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JsonDBConfig {

    @Value("${jsondb.db.location}")
    private String dbFilesLocation;

    @Value("${jsondb.db.scan.package}")
    private String baseScanPackage;

    @Bean
    public JsonDBTemplate jsonDBTemplate() {
        return new JsonDBTemplate(dbFilesLocation, baseScanPackage);
    }
}