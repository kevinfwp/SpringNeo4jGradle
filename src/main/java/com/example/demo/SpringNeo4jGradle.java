package com.example.demo;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class SpringNeo4jGradle {

	
	private static final Logger log = LoggerFactory.getLogger(SpringNeo4jGradle.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringNeo4jGradle.class, args);
	}
	@Bean
	CommandLineRunner demo(PersonRepository personRepository) {
		return args ->{
			personRepository.deleteAll();
			Person a = new Person("A");
			Person b = new Person("B");
			Person c = new Person("C");
			Person d = new Person("D");
			Person e = new Person("E");
			Person fang = new Person("fang");
			personRepository.save(fang);
			

			fang.know(c);
			fang.lovewith(a);

			
			personRepository.save(fang);
			
			List<Person> people = Arrays.asList(a,b,c,d,e,fang);
			log.info("befor");
			people.stream().forEach(person -> log.info("\t" + person.toString()));
			
			personRepository.save(a);
			personRepository.save(b);
			personRepository.save(c);
			personRepository.save(d);
			
			e.lovewith(fang);
			personRepository.save(e);
			
		//	a = personRepository.findByName(a.getName());
			
			a.know(b);
			a.know(c);
			a.know(d);
			a.know(e);
			a.lovewith(fang);
			personRepository.save(a);
			
		//	b = personRepository.findByName(b.getName());
			
			b.know(c);
			b.know(e);
			personRepository.save(b);

			System.out.println("<---->");
			people.stream().forEach(person -> log.info("\t" + personRepository.findByName(person.getName())));
		};
	}
}