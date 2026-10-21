package com.example.sp_lab;

import com.example.sp_lab.component.SingletonComponent;
import com.example.sp_lab.component.TransientComponent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpLabApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(SpLabApplication.class, args);

		TransientComponent tc = context.getBean(TransientComponent.class);
		SingletonComponent sc = context.getBean(SingletonComponent.class);

		tc.operation();
		sc.operation();
	}

}
