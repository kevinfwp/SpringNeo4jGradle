package com.example.demo;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.CrudRepository;


public interface PersonRepository extends Neo4jRepository<Person, Long> {
	Person findByName(String name);
}
