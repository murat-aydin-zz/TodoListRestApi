package com.example.huawei.huaweiapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableJpaAuditing
public class HuaweiapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(HuaweiapiApplication.class, args);
	}

}
