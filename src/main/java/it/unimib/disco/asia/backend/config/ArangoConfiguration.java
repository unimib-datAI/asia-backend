package it.unimib.disco.asia.backend.config;

import com.arangodb.ArangoDB;
import com.arangodb.ArangoDB.Builder;
import com.arangodb.springframework.annotation.EnableArangoRepositories;
import com.arangodb.springframework.config.AbstractArangoConfiguration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.logging.Logger;

@Configuration
@EnableArangoRepositories(basePackages = { "it.unimib.disco.asia.backend" })
public class ArangoConfiguration extends AbstractArangoConfiguration {

    private static final Logger logger = Logger.getLogger(ArangoConfiguration.class.getName());

    @Value( "${arango.host:localhost}" )
    String host;

    @Value( "${arango.port:8529}" )
    int port;

    @Value( "${arango.user:root}" )
    String user;

    @Value( "${arango.dbname:arango-demo}" )
    String dbName;

    @Value( "${arango.password:null}" )
    String password;

    @Override
    public Builder arango() {
        //logConfiguration();
        return new ArangoDB.Builder().host(this.host, this.port).user(this.user).password(this.password);
    }

    @Override
    public String database() {
        return this.dbName;
    }


    @PostConstruct
    public void logConfiguration(){

        logger.info("Arango ip: "+host);
        logger.info("Arango port: "+port);
        logger.info("Arango user: "+user);
        logger.info("Arango dbName: "+dbName);
    }

}