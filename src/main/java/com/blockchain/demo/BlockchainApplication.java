package com.blockchain.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.oas.annotations.EnableOpenApi;
@EnableOpenApi
@ComponentScan(basePackages = {"com.blockchain.demo.Controller"})
@SpringBootApplication
@MapperScan("com/blockchain/demo/Mapper")
public class BlockchainApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlockchainApplication.class, args);
	}

}
