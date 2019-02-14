package hello.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import hello.service.ServiceTest;
import hello.service.bean.Greeting;
import io.micrometer.core.annotation.Timed;

@Controller
public class HelloWorldController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

	@Autowired
	private ServiceTest serviceTest;

    @GetMapping("/hello-world")
    @ResponseBody
    @Timed("servicetest.controller.sayhello")
    public Greeting sayHello(@RequestParam(name="name", required=false, defaultValue="Stranger") String name) {
    	serviceTest.test();
    	serviceTest.test2();
    	
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

}
