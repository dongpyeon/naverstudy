package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"mycar.*","naver.storage","person.*,guest.*"})
@EntityScan("*.data")
@EnableJpaRepositories({"mycar.repository","person.data","guest.data"}) //여러개 쓸때는 중괄호 넣고 아니면 *로 통합가능
public class MyCarJpaBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyCarJpaBootApplication.class, args);
	}

}
