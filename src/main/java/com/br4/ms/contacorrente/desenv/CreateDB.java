package com.br4.ms.contacorrente.desenv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.derby.jdbc.EmbeddedDriver;

public class CreateDB {

	public static final String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
	public static final String JDBC_URL = "jdbc:derby:ccms;create=true";

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
//		Class<?> clazz = EmbeddedDriver.class;
		Class.forName(DRIVER);
		Connection connection = DriverManager.getConnection(JDBC_URL);
		connection.createStatement().execute("create table contaCorrente(idConta decimal(10))");

	}
}
