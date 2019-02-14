package hello.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import hello.service.Daemon;
import io.micrometer.core.instrument.Measurement;
import io.micrometer.core.instrument.Meter;
import io.micrometer.core.instrument.MeterRegistry;

@Service
public class DaemonImpl implements Daemon {

	@Autowired
	@Qualifier("simpleMeterRegistry")
	private MeterRegistry simpleMeterRegistry;
	
	@Async
	@Override
	public void init() {
		while(true) {
			System.out.println("---------------------------------------------------");
			for(Meter meter : simpleMeterRegistry.getMeters()) {
				if(meter.getId() != null && "MERCURY".equals(meter.getId().getTag("context"))) {
					System.out.println(
							"Metrics for "+meter.getId().getName()+":"+"\n"+
							"\tService: "+meter.getId().getTag("service")+"\n"+
							"\tClass: "+meter.getId().getTag("class")+"\n"+
							"\tMethod: "+meter.getId().getTag("method")+"\n"+
							"\tNode: "+meter.getId().getTag("node"));
					
					for(Measurement measurement : meter.measure()) {
						System.out.println(
								"\t"+measurement.getStatistic().name() + ": " +
										measurement.getValue()
								);
					}
					System.out.println("");
	    		}
	    	}
			
			goSleep();
		}
	}
	
	private void goSleep() {
		try {
			Thread.sleep(10000);			
		} catch(Exception e) {
			System.out.println("Can't sleep :(");
		}
	}
}
