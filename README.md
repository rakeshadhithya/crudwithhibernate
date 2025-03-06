# crudwithhibernate

Hibernate Project: Utilizing a Hikari datasource instead of the default driver manager to get connections, this project implements the concept of connection pooling.

# Features

- takes inputs from console
- performs crud with a table in database server

# Skills

- Hikari Datasource for connection pooling
- singleton pattern on hikari datasource provider class and session factory util class
- hibernate xml configurations without using a single annotation

# Installation Guide

- make sure you jave jdk installed, mine is JDK 17
- make sure you have mysql installed
- download the project and in vscode(preferred)
- run 'mvn clean install ' to build the project from scratch
- make sure the dependencies are downloaded

# Usage

- change database details in the src/main/java/com/rakesh/crudwith/hibernate/util/HikariDataSource.java class to match as per your database
- run the main function in App.java
- try different inputs in the command line
