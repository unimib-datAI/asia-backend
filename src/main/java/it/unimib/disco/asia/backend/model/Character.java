package it.unimib.disco.asia.backend.model;

import org.springframework.data.annotation.Id;

import com.arangodb.springframework.annotation.Document;
import com.fasterxml.jackson.databind.ObjectMapper;

@Document("characters")
public class Character {

	@Id
	private String id;

	private String name;
	private String surname;
	private boolean alive;
	private Integer age;

	public Character() {
		super();
	}

	public Character(final String name, final String surname, final boolean alive) {
		super();
		this.name = name;
		this.surname = surname;
		this.alive = alive;
	}

	public Character(final String name, final String surname, final boolean alive, final Integer age) {
		super();
		this.name = name;
		this.surname = surname;
		this.alive = alive;
		this.age = age;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		ObjectMapper mapper = new ObjectMapper();
		String out = "";
		try { 
			out = mapper.writeValueAsString(this);
		}catch(Exception e) { e.printStackTrace();}
		
		return out;
	}
}
