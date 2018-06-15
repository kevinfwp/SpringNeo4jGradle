package com.example.demo;

import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;


@NodeEntity
public class Person {

	@Id @GeneratedValue private Long id;
	
	private String name;
	
	public Person() {
		// TODO Auto-generated constructor stub
	}
	
	public Person(String name) {
		this.name = name;
	}
	
	@Relationship(type="»œ ∂")
	public Set<Person> people;
	
	@Relationship(type="œ≤ª∂")
	public Set<Person> loves;
	
	public void know(Person person) {
		// TODO Auto-generated method stub
		if (people == null) {
			people = new HashSet<>();
		}
		people.add(person);
	}
	
	public void lovewith(Person person) {
		if (loves == null) {
			loves = new HashSet<>();
		}
		loves.add(person);
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.name + " know => " 
				+ Optional.ofNullable(this.people).orElse(
						Collections.emptySet()).stream()
				.map(Person::getName)
				.collect(Collectors.toList());
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
