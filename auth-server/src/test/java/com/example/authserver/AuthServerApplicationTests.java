package com.example.authserver;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.assertj.core.api.Assertions.assertThat;

@Testcontainers
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) // deactivate the default behaviour
@SpringBootTest
class AuthServerApplicationTests {

	@Container
	static PostgreSQLContainer postgresqlContainer = new PostgreSQLContainer("postgres:15-alpine")
			.withDatabaseName("postgres")
			.withUsername("postgres")
			.withPassword("postgres");
	@Autowired
	ApplicationContext context;

	@DynamicPropertySource
	static void setProperties(DynamicPropertyRegistry registry) {
		registry.add("spring.datasource.url", postgresqlContainer::getJdbcUrl);
		registry.add("spring.datasource.username", postgresqlContainer::getUsername);
		registry.add("spring.datasource.password", postgresqlContainer::getPassword);
	}

	@Test
	void contextLoads() {
		assertThat(context).isNotNull();
	}

}
