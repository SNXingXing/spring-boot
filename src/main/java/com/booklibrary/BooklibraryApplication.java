package com.booklibrary;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/***
 * @author star
 */
@SpringBootApplication
@MapperScan("com.booklibrary.*")
@ServletComponentScan
public class BooklibraryApplication {

    public static void main(String[] args) {
         SpringApplication.run(BooklibraryApplication.class, args);

    }
}
