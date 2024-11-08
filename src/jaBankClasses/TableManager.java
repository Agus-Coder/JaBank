package jaBankClasses;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TableManager {

	public void createTransferTable() {

		Connection c = DBManager.connect();
		
		String sql = "CREATE TABLE transfers ( id INTEGER AUTO_INCREMENT PRIMARY KEY, t_from VARCHAR(256) , t_to VARCHAR(256), amount DOUBLE, state VARCHAR(256) )";

		try {
			Statement s = c.createStatement();
			s.execute(sql);
		} catch (SQLException e) {
			try {
				c.rollback();
				e.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				c.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		

	}
	
	public void dropTransfersTable() {

		Connection c = DBManager.connect();
		
		String sql = "DROP TABLE transfers";
		
		try {
			Statement s = c.createStatement();
			s.execute(sql);
			c.commit();
		} catch (SQLException e) {
			try {
				c.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				c.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		

	}
	
    public static void main(String[] args) {
        TableManager manager = new TableManager();

        System.out.println("Creating the 'transfers' table...");
        manager.createTransferTable();
        System.out.println("Table created successfully.");
    }

}
