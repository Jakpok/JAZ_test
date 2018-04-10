package repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import main.webapp.User;

public class DummyUsersRepository implements UsersRepository{

	private static List<User> db = new ArrayList<User>();
	
	private static boolean useHSQL = false;
	private static Connection conn = null;
	
	private String createTableSql = "CREATE TABLE users(id INT GENERATED BY DEFAULT AS IDENTITY,username VARCHAR(30),password VARCHAR(30),email VARCHAR(30),premium TINYINT,admin TINYINT)";
	
	public DummyUsersRepository(){
		if(useHSQL){
			if(conn == null){
				 try {
			         //Registering the HSQLDB JDBC driver
			         Class.forName("org.hsqldb.jdbc.JDBCDriver");
			         //Creating the connection with HSQLDB
			         conn = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/workdb", "SA", "");
			         if (conn!= null){
			            System.out.println("Connection created successfully");
			            Statement create = conn.createStatement();
			            create.executeQuery(createTableSql);		            
			         }else{
			            System.out.println("Problem with creating connection");
			         }
			      
			      }  catch (Exception e) {
			         e.printStackTrace(System.out);
			      }
			}
		}
		//dodananie konta admina
		if(db.size() == 0){
			User admin = new User("admin","admin","admin@gmail.com");
			admin.setAdmin(true);
			db.add(admin);
		}
	}

	@Override
	public void add(User user) {
		db.add(user);
		
	}

	@Override
	public int count() {
		return db.size();
	}
	
	@Override
	public User getUserByName(String username) {
		for(User user : db){
			if(user.getUsername().equalsIgnoreCase(username))
				return user;
		}
		return null;
	}

	@Override
	public User[] getAllUsers() {
		User[] users = db.toArray(new User[db.size()]);
		return users;
	}

	@Override
	public void updateUser(User user) {
		//update danych do sql
		
	}

}