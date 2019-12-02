package com.company.commentservice;

import com.company.commentservice.model.Comment;
import com.company.commentservice.respository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import java.time.LocalDate;

@SpringBootApplication
@EnableDiscoveryClient
@EnableEurekaClient
@EnableCaching
public class CommentServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(CommentServiceApplication.class, args);

	}

}
