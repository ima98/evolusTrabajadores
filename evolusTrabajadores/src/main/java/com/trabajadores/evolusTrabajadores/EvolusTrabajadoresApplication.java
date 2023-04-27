package com.trabajadores.evolusTrabajadores;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
//(exclude = {
//org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class}
//)
@ComponentScan(basePackages = { "com.trabajadores.*" })
//@EnableAutoConfiguration
//@ComponentScan
@SpringBootApplication
public class EvolusTrabajadoresApplication {

	public static void main(String[] args) {
		SpringApplication.run(EvolusTrabajadoresApplication.class, args);
	}

}
