package it.unimib.disco.asia.backend.config;

import com.arangodb.ArangoDB;
import com.arangodb.ArangoDB.Builder;
import com.arangodb.springframework.annotation.EnableArangoRepositories;
import com.arangodb.springframework.config.AbstractArangoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.logging.Logger;

@Configuration
@ConfigurationProperties(prefix = "arango")
@EnableArangoRepositories(basePackages = { "it.unimib.disco.asia.backend" })
public class ArangoConfig extends AbstractArangoConfiguration {

    private static final Logger logger = Logger.getLogger(ArangoConfig.class.getName());

    private String host;
    private int port;
    private String dbName;
    private String username;
    private String password;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public Builder arango() {
        //logConfiguration();
        return new ArangoDB.Builder().host(this.host, this.port).user(this.username).password(this.password);
    }

    @Override
    public String database() {
        return this.dbName;
    }


    @PostConstruct
    public void logConfiguration(){

        logger.info("Arango ip: "+host);
        logger.info("Arango port: "+port);
        logger.info("Arango user: "+username);
        logger.info("Arango dbName: "+dbName);
    }


}