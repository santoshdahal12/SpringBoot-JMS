package myproject.goodperson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.core.JmsTemplate;

import mysample.goodperson_schema.Person;

@SpringBootApplication
public class GoodpersonpublisherApplication implements CommandLineRunner {

	@Autowired
	JmsTemplate jmsTemplate;
	@Value("${outbound.endpoint}")
	private String destination;
	
	public static void main(String[] args) {
		SpringApplication.run(GoodpersonpublisherApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		// TODO Auto-generated method stub
		
		Person person= new Person();
		person.setName("santosh");
		person.setGraduationYear((short) 2012);
		person.setSalary((short) 3000);
		person.setType("good");
		jmsTemplate.convertAndSend(destination, person);
	}
}
