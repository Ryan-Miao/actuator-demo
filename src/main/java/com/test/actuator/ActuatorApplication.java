package com.test.actuator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.endpoint.Endpoint;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class ActuatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(ActuatorApplication.class, args);
	}


	@Bean
	public Endpoint myEndpoint(){
		return new Endpoint<Map<String,Object>>() {
			@Override
			public String getId() {
				return "my-endpoint";
			}

			@Override
			public boolean isEnabled() {
				return true;
			}

			@Override
			public boolean isSensitive() {
				return false;
			}

			@Override
			public Map<String,Object> invoke() {
				final Map<String, Object> dataToDisplay = new HashMap<>();
				dataToDisplay.put("some", "thing");
				dataToDisplay.put("you", "want");
				return dataToDisplay;
			}
		};
	}
}
