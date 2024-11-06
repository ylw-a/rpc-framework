package com.framework.server;

import com.framework.server.naming.util.AppContextUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ServerApplication {

	public static void main(String[] args) {
		ApplicationContext run = SpringApplication.run(ServerApplication.class, args);
		AppContextUtil.setApplicationContext(run);
	}

}
