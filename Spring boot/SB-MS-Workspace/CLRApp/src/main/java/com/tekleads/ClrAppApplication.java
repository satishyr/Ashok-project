package com.tekleads;

import java.util.List;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ClrAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClrAppApplication.class, args);
		System.out.println("Start Class run() method completed");
	}

	@Bean
	CommandLineRunner commandLineRunner() {
		return args -> {
			System.out.println("commandLineRunner Bean");
		};
	}

	@Bean
	ApplicationRunner appRunner() {
		System.out.println("ApplicationRunner::Bean");
		return args -> {
			List<String> nonOptArgs = args.getNonOptionArgs();
			nonOptArgs.forEach(arg -> {
				System.out.println("Arg ::" + arg);
			});
		};
	}

}
