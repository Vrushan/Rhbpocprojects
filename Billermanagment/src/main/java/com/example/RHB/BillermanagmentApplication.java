package com.example.RHB;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.example.RHB.Audit.AuditAwareimpl;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditaware")
public class BillermanagmentApplication {
	
	
	@Bean
	public AuditorAware<String> auditaware()
	{
		return new AuditAwareimpl();
	}

	public static void main(String[] args) {
		SpringApplication.run(BillermanagmentApplication.class, args);
	}

}
