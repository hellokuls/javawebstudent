package com.kuls.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class KulsUtils {

	public  Connection createDBConn(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url1="jdbc:mysql://localhost:3306/gsqstudent?serverTimezone=GMT%2B8";
            String userString="root";
            String psw="LS985548459";
            Connection conn=DriverManager.getConnection(url1, userString, psw);
            System.out.println("链接成功");
            return conn;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    public  void closeConn(Connection conn){
        try{
            conn.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
