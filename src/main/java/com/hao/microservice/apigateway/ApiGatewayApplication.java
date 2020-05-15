package com.hao.microservice.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.discovery.PatternServiceRouteMapper;
import org.springframework.context.annotation.Bean;

@EnableZuulProxy
@SpringBootApplication
public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}

    /**
     * 使用正则表达式指定路由规则
     * @return
     *//*
	@Bean
	public PatternServiceRouteMapper serviceRouteMapper(){


	    return new PatternServiceRouteMapper("(?<name>^.+)-(?<version>v.+$)",
                "${version}/${name}");

    }*/


}
