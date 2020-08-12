/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mouse.pkg1;


import java.sql.Connection;
import java.sql.DriverManager;




public class Tienich {
  
    public static Connection ketnoi(){
        try {            
        Connection cn = null;
            String url = "jdbc:sqlserver://Localhost:1433;databaseName=Mouse";
            String user = "sa";
            String pass = "123";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
           cn = DriverManager.getConnection(url, user, pass);
            return cn;
        } catch (Exception e) {
            System.out.println(e);
            throw new RuntimeException(e);
        }
        
}
}