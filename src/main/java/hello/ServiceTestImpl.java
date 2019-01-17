package hello;

import org.springframework.stereotype.Service;

import io.micrometer.core.annotation.Timed;

//import com.codahale.metrics.annotation.Timed;

@Service
@Timed("hello.ServiceTestImpl")
public class ServiceTestImpl implements ServiceTest {
	private static final String BUSINESS= "business";
	private static final String SERVICE= "service";
	private static final String MODULE= "module";
	@Override
	@Timed(
			value="hello.ServiceTestImpl.test",
			extraTags = {
					"layer",BUSINESS, 
					"bean",SERVICE,
					"project",MODULE})
	public void test() {
		try {
			Thread.sleep(5000);
		} catch (Exception e) {}
		
	}
	
	@Override
	@Timed(
			value="hello.ServiceTestImpl.test2",
			extraTags = {
					"layer",BUSINESS, 
					"bean",SERVICE,
					"project",MODULE})
	public void test2() {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(2000);
		} catch (Exception e) {}
		
	}
}
