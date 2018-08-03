package it.unimib.disco.asia.backend.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.arangodb.ArangoDB;
import com.arangodb.ArangoDB.Builder;
import com.arangodb.springframework.annotation.EnableArangoRepositories;
import com.arangodb.springframework.config.AbstractArangoConfiguration;

@SpringBootApplication
@EnableArangoRepositories(basePackages = { "it.unimib.disco.asia.backend" })
@ComponentScan({"it.unimib.disco.asia.backend.*" })
public class Application extends AbstractArangoConfiguration{

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	  @Override
	  public Builder arango() {
	    return new ArangoDB.Builder().host("localhost", 8529).user("root").password("password");
	  }
	  
	  @Override
	  public String database() {
	    return "arango-demo"; 
	  }
}
