

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bonstine_stark
 */
public class myConnection {
    
    public static Connection getConnection() throws SQLException, ClassNotFoundException
    {
        Connection con = null;
        
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javacontacts", "root", "loll");
                
        return con;
    }
    
}
