package com.practice.microservice.currencycalculationservice;

import brave.sampler.Sampler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class CurrencyCalculationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyCalculationServiceApplication.class, args);
	}

	/**
	 * Tracing id provided by sleuth
	 */
	@Bean
	public Sampler defaultSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}
}
