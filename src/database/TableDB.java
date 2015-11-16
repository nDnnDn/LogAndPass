package database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TableDB {
public Connection conn=null;
public Statement stmt=null;
public ResultSet rs=null;
public TableDB(){

}

//Log user into the system
//returns TRUE if user is registered 
public boolean logIn(String userLogin, String userPassword){
try{
	Class.forName("com.mysql.jdbc.Driver");
	conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lesson1", "root", "root");
	stmt = conn.createStatement(); 
	String sqlQuery = "Select Count(*) from People WHERE login='" + userLogin + "' AND password='" + userPassword + "'"; 
	rs = stmt.executeQuery(sqlQuery);
	rs.next();
	if(rs.getInt(1) == 1) return true;
	}
	catch( SQLException se ) {
		System.out.println ("SQLError: " + se.getMessage ()
				+ " code: " + se.getErrorCode ());
		} catch( Exception e ) {
		      System.out.println(e.getMessage()); 
		      e.printStackTrace(); 
		} finally{
			try{
			rs.close();     
			stmt.close(); 
			conn.close();  
			} catch(Exception e){
				e.printStackTrace();
			} 
		}
return false;	
}

//Register user 
//return TRUE if user with such login or password doesn't exist 
//register user into DBMS
public boolean registration(String userLogin, String userPassword, String firstName, String lastName, String email){
	try{
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lesson1", "root", "root");
		stmt = conn.createStatement(); 
		String sqlQuery = "Select Count(*) from People WHERE login='" + userLogin + "' OR password='" + userPassword + "'"; 
		rs = stmt.executeQuery(sqlQuery);
		rs.next();
		if(rs.getInt(1) == 0){
			sqlQuery = "Insert into People values "
					+ "('" + userLogin + "', '" + userPassword + "', '" + firstName + "', '" + lastName + "', '" + email + "')";
			stmt.executeUpdate(sqlQuery);		
			return true;
		}
		}
		catch( SQLException se ) {
			System.out.println ("SQLError: " + se.getMessage ()
					+ " code: " + se.getErrorCode ());
			} catch( Exception e ) {
			      System.out.println(e.getMessage()); 
			      e.printStackTrace(); 
			} finally{
				try{
				rs.close();     
				stmt.close(); 
				conn.close();  
				} catch(Exception e){
					e.printStackTrace();
				} 
			}
	return false;	
}


//Gets first_name
public String getField(String field, String userLogin){
try{
	Class.forName("com.mysql.jdbc.Driver");
	conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lesson1", "root", "root");
	stmt = conn.createStatement(); 
	String sqlQuery = "Select " + field + " from People WHERE login='" + userLogin + "'"; 
	rs = stmt.executeQuery(sqlQuery);
	rs.next();
	return rs.getString(1);
	}
	catch( SQLException se ) {
		System.out.println ("SQLError: " + se.getMessage ()
				+ " code: " + se.getErrorCode ());
		} catch( Exception e ) {
			System.out.println(e.getMessage()); 
			e.printStackTrace(); 
		} finally{
			try{
			rs.close();     
			stmt.close(); 
			conn.close();  
			} catch(Exception e){
				e.printStackTrace();
			} 
		}
	return "fuck!";
}
/*public static void main(String[] args){
TableDB table = new TableDB();
System.out.println(table.getField("first_name", "Max1"));
}*/
}
