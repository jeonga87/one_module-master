package com.example.demo.config;

import com.example.demo.attach.policy.DirectoryPathPolicy;
import com.example.demo.attach.policy.impl.DateDirectoryPathPolicy;
import com.example.demo.config.properties.FileUploadProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.inject.Inject;

@Configuration
public class FileUploadConfiguration {

    @Inject
    private FileUploadProperties fileUploadProperties;

    @Bean
    public DirectoryPathPolicy dateDirectoryPathPolicy() {
        DateDirectoryPathPolicy policy = new DateDirectoryPathPolicy(
            DateDirectoryPathPolicy.DATE_SUBDIR_TYPE.YYYY_MM,
            fileUploadProperties.getSaveDir(),
            fileUploadProperties.getTempDir()
        );

        return policy;
    }
}
