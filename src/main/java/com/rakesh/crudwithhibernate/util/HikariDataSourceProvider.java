package com.rakesh.crudwithhibernate.util;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class HikariDataSourceProvider {
    private static volatile HikariDataSource dataSource;
	
	public static HikariDataSource getHikariDataSource() {
		if(dataSource == null) {
			synchronized(HikariDataSourceProvider.class) {
				if(dataSource == null) {
					HikariConfig hikariConfig = new HikariConfig();
					hikariConfig.setDriverClassName("com.mysql.cj.jdbc.Driver");
					//not a http connection, it is a jdbc connection to mysql server
					//wrong: hikariConfig.setJdbcUrl("http://localhost:3306/studenttribedb");
					//correct version:
					hikariConfig.setJdbcUrl("jdbc:mysql://localhost:3306/rakeshdb");
					hikariConfig.setUsername("root");
					hikariConfig.setPassword("root");
					hikariConfig.setMaximumPoolSize(5);
					hikariConfig.setMinimumIdle(2);
					
					HikariDataSource hikariDataSource = new HikariDataSource(hikariConfig);
					dataSource = hikariDataSource;
				}
			}
		}
		return dataSource;
	}
}
