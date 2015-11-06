package dao;


import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;



public class JDBCMannager {
 
    private static Connection  connection = null;
    
    private JDBCMannager(){};
    
    public static synchronized Connection getInstance() {

        if(connection == null) {
       
        	try{
        		Class.forName("com.mysql.jdbc.Driver");
        		connection = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/finalproject?useUnicode=yes&amp;characterEncoding=UTF-8&amp;autoReconnect=true","root","root");
        	}catch (ClassNotFoundException e) {
        		System.out.println("드라이버를 찾을수없습니다 : "+e);
        	}
    		catch(SQLException e){
    			System.out.println(e.getMessage());
    		}           
        }
        
        return connection; 
    }
    
    
}
