package hello;

import java.time.Duration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import io.micrometer.core.aop.TimedAspect;
//import com.netflix.spectator.atlas.AtlasConfig;
//
//import io.micrometer.atlas.AtlasMeterRegistry;
import io.micrometer.core.instrument.Clock;
import io.micrometer.core.instrument.MeterRegistry;

@SpringBootApplication
//@EnableAspectJAutoProxy
public class HelloWorldApplication {

//	@Bean
//    TimedAspect timedAspect(MeterRegistry registry) {
//        return new TimedAspect(registry);
//    }
	
	public static void main(String[] args) {
		
		// this config must be here?
		/*AtlasConfig atlasConfig = new AtlasConfig() {
		    @Override
		    public Duration step() {
		        return Duration.ofSeconds(4);
		    }

		    @Override
		    public String get(String k) {
		        return null; // accept the rest of the defaults
		    }
		};
		
		MeterRegistry registry = new AtlasMeterRegistry(atlasConfig, Clock.SYSTEM);
		registry.counter("page.visitors", "age","20s");*/
		
		SpringApplication.run(HelloWorldApplication.class, args);
	}

}
