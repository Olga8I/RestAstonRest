package org.example;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.example.db.ConnectionManager;
import org.example.db.ConnectionManagerImpl;
import org.example.util.InitSqlScheme;

@Configuration
public class Main {

    @Bean
    public ConnectionManager connectionManager() {
        return ConnectionManagerImpl.getInstance();
    }

    @Bean
    public InitSqlScheme initSqlScheme(ConnectionManager connectionManager) {
        return new InitSqlScheme(connectionManager);
    }

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
        ConnectionManager connectionManager = context.getBean(ConnectionManager.class);
        InitSqlScheme initSqlScheme = context.getBean(InitSqlScheme.class);

        initSqlScheme.initSqlScheme(connectionManager);
        initSqlScheme.initSqlData(connectionManager);
    }
}