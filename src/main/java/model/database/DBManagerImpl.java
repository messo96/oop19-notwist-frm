package model.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import model.Log;

/**
 * Abstract class that establish a connection from remote database
 * 
 * @author Giovanni Messina
 *
 */
abstract class DBManagerImpl {

	private Connection conn;
	private Statement stmt;
	private Log log = Log.getInstance();

	public DBManagerImpl() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			open();
		} catch (ClassNotFoundException e) {
			e.getMessage();
		}

	}

	/**
	 * open connection for the transfer data
	 * 
	 * @return Statement object if open worked, null otherwise
	 */
	protected Statement open() {
		try {
			conn = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/7lncuOhnfh", "7lncuOhnfh",
					"DLmbbVHESb");
			stmt = conn.createStatement();
			System.out.println("Connecting..\n");

			return stmt;
		} catch (SQLException e) {
			log.logWarning("Error while connect with database" + e);
			JOptionPane.showMessageDialog(null, "Errore di connessione al database, controlla la connessione! ");

		}
		return null;
	}

	/**
	 * close the connection
	 */
	protected void close() {
		try {
			conn.close();
			System.out.println("Connection closed safely\n");
		} catch (SQLException e) {
			log.logWarning("Error while close connection " + e);
		}
	}

	/**
	 * 
	 * @return instance of Connection object
	 */
	protected Connection getConn() {
		return conn;
	}

}
