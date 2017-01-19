package myproject.goodpersonreceiving;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.annotation.JmsListener;

import mysample.goodperson_schema.Person;

@SpringBootApplication
@EnableJms
public class ReceivinggoodpersonApplication {

	private static final Logger log= Logger.getLogger(ReceivinggoodpersonApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(ReceivinggoodpersonApplication.class, args);
	}
	
	@JmsListener(destination="${inbound.endpoint}")
	public void receivePerson(Person person){
		
		log.info(person);
	}
}
