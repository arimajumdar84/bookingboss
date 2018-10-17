package com.bookingboss.bookingbossjavatest.config;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class H2DBInitConfig {

    private DataSource dataSource;

    @Autowired
    public H2DBInitConfig(DataSource dataSource){
        this.dataSource = dataSource;
    }

    /**
     * Initialize H2 DB tables and insert data into table
     */
    @PostConstruct
    public void initialize() {
        try {
            Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            statement.executeUpdate(
                    "CREATE TABLE if not exists Products(" +
                            "id INTEGER Primary key, " +
                            "name varchar(30) not null," +
                            "quantity INTEGER  not null," +
                            "sale_amount INTEGER not null)"
            );

            statement.executeUpdate("MERGE INTO `products` (`id`,`name`,`quantity`,`sale_amount`) " +
                    "VALUES (1,'Rover',373,105)");
            statement.executeUpdate("MERGE INTO `products` (`id`,`name`,`quantity`,`sale_amount`) " +
                    "VALUES (2,'Maserati',747,104)");
            statement.executeUpdate("MERGE INTO `products` (`id`,`name`,`quantity`,`sale_amount`) " +
                    "VALUES (3,'Mercedes',820,117)");
            statement.executeUpdate("MERGE INTO `products` (`id`,`name`,`quantity`,`sale_amount`) " +
                    "VALUES (4,'Mitsubishi',268,48)");
            statement.executeUpdate("MERGE INTO `products` (`id`,`name`,`quantity`,`sale_amount`) " +
                    "VALUES (5,'Daihatsu',724,82)");
            statement.executeUpdate("MERGE INTO `products` (`id`,`name`,`quantity`,`sale_amount`) " +
                    "VALUES (6,'Fiat',223,84)");
            statement.executeUpdate("MERGE INTO `products` (`id`,`name`,`quantity`,`sale_amount`) " +
                    "VALUES (7,'Skoda',453,143)");
            statement.executeUpdate("MERGE INTO `products` (`id`,`name`,`quantity`,`sale_amount`) " +
                    "VALUES (8,'Maybach',472,126)");
            statement.executeUpdate("MERGE INTO `products` (`id`,`name`,`quantity`,`sale_amount`) " +
                    "VALUES (9,'Mercedes-Benz',630,90)");
            statement.executeUpdate("MERGE INTO `products` (`id`,`name`,`quantity`,`sale_amount`) " +
                    "VALUES (10,'Pontiac',700,16)");
            statement.executeUpdate("MERGE INTO `products` (`id`,`name`,`quantity`,`sale_amount`) " +
                    "VALUES (11,'Toyota',418,127)");
            statement.executeUpdate("MERGE INTO `products` (`id`,`name`,`quantity`,`sale_amount`) " +
                    "VALUES (12,'Dodge',623,116)");
            statement.executeUpdate("MERGE INTO `products` (`id`,`name`,`quantity`,`sale_amount`) " +
                    "VALUES (13,'Bentley',896,32)");
            statement.executeUpdate("MERGE INTO `products` (`id`,`name`,`quantity`,`sale_amount`) " +
                    "VALUES (14,'Smart',505,125)");
            statement.executeUpdate("MERGE INTO `products` (`id`,`name`,`quantity`,`sale_amount`) " +
                    "VALUES (15,'Subaru',610,136)");
            statement.executeUpdate("MERGE INTO `products` (`id`,`name`,`quantity`,`sale_amount`) " +
                    "VALUES (17,'Mazda',511,33)");
            statement.executeUpdate("MERGE INTO `products` (`id`,`name`,`quantity`,`sale_amount`) " +
                    "VALUES (18,'Suzuki',817,98)");
            statement.executeUpdate("MERGE INTO `products` (`id`,`name`,`quantity`,`sale_amount`) " +
                    "VALUES (20,'De Lorean',989,37)");
            statement.executeUpdate("MERGE INTO `products` (`id`,`name`,`quantity`,`sale_amount`) " +
                    "VALUES (21,'Rolls-Royce',826,109)");
            statement.executeUpdate("MERGE INTO `products` (`id`,`name`,`quantity`,`sale_amount`) " +
                    "VALUES (22,'Lancia',650,39)");
            statement.executeUpdate("MERGE INTO `products` (`id`,`name`,`quantity`,`sale_amount`) " +
                    "VALUES (23,'Dino',386,124)");
            statement.executeUpdate("MERGE INTO `products` (`id`,`name`,`quantity`,`sale_amount`) " +
                    "VALUES (24,'BMW',954,118)");
            statement.executeUpdate("MERGE INTO `products` (`id`,`name`,`quantity`,`sale_amount`) " +
                    "VALUES (25,'Lincoln',555,97)");
            statement.executeUpdate("MERGE INTO `products` (`id`,`name`,`quantity`,`sale_amount`) " +
                    "VALUES (26,'Lotus',202,136)");
            statement.executeUpdate("MERGE INTO `products` (`id`,`name`,`quantity`,`sale_amount`) " +
                    "VALUES (27,'Citroen',975,109)");
            statement.executeUpdate("MERGE INTO `products` (`id`,`name`,`quantity`,`sale_amount`) " +
                    "VALUES (28,'Porsche',648,137)");
            statement.executeUpdate("MERGE INTO `products` (`id`,`name`,`quantity`,`sale_amount`) " +
                    "VALUES (29,'KIA',871,80)");
            statement.executeUpdate("MERGE INTO `products` (`id`,`name`,`quantity`,`sale_amount`) " +
                    "VALUES (30,'Mini',698,92)");

            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
