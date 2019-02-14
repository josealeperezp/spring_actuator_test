package hello;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

import hello.service.Daemon;

@SpringBootApplication
@EnableAsync
public class Application {
	
	@Autowired
	private Daemon daemon;
	
	public static void main(String[] args) {
		
		SpringApplication.run(Application.class, args);
	}
	
	@PostConstruct
	public void initDaemon() {
		daemon.init();
	}

}
