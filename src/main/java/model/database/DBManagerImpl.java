package model.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

/**
 * Abstract class that establish a connection from remote database
 * @author gio
 *
 */
abstract class DBManagerImpl {

	private Connection conn;
	private Statement stmt;

	public DBManagerImpl() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			open();
		} catch (ClassNotFoundException e) {
			e.getStackTrace();
		}

	}

	/**
	 * open connection for the transfer data
	 * @return Statement object if open worked, null otherwise
	 */
	protected Statement open() {
		try {
			conn = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/7lncuOhnfh", "7lncuOhnfh",
					"DLmbbVHESb");
			stmt = conn.createStatement();
			return stmt;
		} catch (SQLException e) {
			System.out.println("Error while connect with database" + e);
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
		} catch (SQLException e) {
			System.out.println(e);
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
