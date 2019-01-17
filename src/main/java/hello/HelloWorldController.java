package hello;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import io.micrometer.core.annotation.Timed;
import io.micrometer.core.instrument.Measurement;
import io.micrometer.core.instrument.Meter;
import io.micrometer.core.instrument.MeterRegistry;

@Controller
@Timed("hello.HelloWorldController")
public class HelloWorldController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    

	@Autowired
	private ServiceTest serviceTest;
	
	@Autowired
	private ApplicationContext applicationContext;
	
	@Autowired
	@Qualifier("simpleMeterRegistry")
	private MeterRegistry simpleMeterRegistry;

    @GetMapping("/hello-world")
    @ResponseBody
    @Timed("servicetest.controller.sayhello")
    public Greeting sayHello(@RequestParam(name="name", required=false, defaultValue="Stranger") String name) {
    	serviceTest.test();
    	serviceTest.test2();
    	for(Meter meter : simpleMeterRegistry.getMeters()) {
    		if("servicetest.test2".equals(meter.getId().getName())) {
    			System.out.println(meter.getId());
    			for(Measurement measurement : meter.measure()) {
    				System.out.println(
    						measurement.getStatistic().name() + " : " +
    						measurement.getValue()
    						);
    			}
    		}
    	}
    	
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

}
