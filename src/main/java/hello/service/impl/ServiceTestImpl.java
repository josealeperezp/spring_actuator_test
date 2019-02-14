package hello.service.impl;

import org.springframework.stereotype.Service;

import hello.service.ServiceTest;
import io.micrometer.core.annotation.Timed;

@Service
public class ServiceTestImpl implements ServiceTest {
	
	private static final String SERVICE= "serviceTest";
	private static final String NODE= "node1";
	@Override
	@Timed(
			value="hello.ServiceTestImpl.test",
			extraTags = {
					"context",	"MERCURY",
					"service",	SERVICE,
					"node",		NODE})
	public void test() {
		try {
			Thread.sleep(5000);
		} catch (Exception e) {}
		
	}
	
	@Override
	@Timed(
			value="hello.ServiceTestImpl.test2",
			extraTags = {
					"context",	"MERCURY",
					"service",	SERVICE,
					"node",		NODE})
	public void test2() {
		try {
			Thread.sleep(2000);
		} catch (Exception e) {}
		
	}
}
