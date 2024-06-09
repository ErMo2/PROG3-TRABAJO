/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.ZAP2.DBManager;

/**
 *
 * @author Alejandro
 */
import java.sql.Connection;
import java.sql.DriverManager;
public class DBManager {
    public static String url = "jdbc:mysql://"+
            "prog3ta2024.cj021lp5tn3y.us-east-1.rds.amazonaws.com"+
            ":3306/prog3?useSSL=false";
    public static String user = "admin";
    public static String password = "abcProg3Ta20241";
    private static DBManager dbmanager;
    private Connection con;
    public static DBManager getInstance(){
        if(dbmanager==null){
            createInstance();
        }
        return dbmanager;
    }
    public Connection getConnection(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con= DriverManager.getConnection(url,user,password);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        
        return con;
    }
    //tmb estatic
    private static void createInstance(){
        if(dbmanager==null){
            dbmanager = new DBManager();
        }
    }
}
