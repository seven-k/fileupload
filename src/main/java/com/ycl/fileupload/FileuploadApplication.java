package com.ycl.fileupload;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author yin.cl
 * @since 2019/5/13 21:07
 */

@SpringBootApplication
@Slf4j
public class FileuploadApplication {

    public static void main(String[] args) {
        SpringApplication.run(FileuploadApplication.class, args);
        log.info("start success");
    }

}
