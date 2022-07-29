package com.company;


import java.sql.*;
import java.util.Properties;


/**
 * @author FuKang.Huang
 */
public class sqldb {
    private static String DriverName="com.mysql.cj.jdbc.Driver";
    private static String Url = "jdbc:mysql://127.0.0.1:3307/login5?serverTimezone=Asia/Shanghai&useSSL=false";
    private static String UserName = "AyolK0";
    private static String PassWord = "Asdfghjkl.000";


    static {
        Properties properties = new Properties();
        /*
        try {
            properties.load(new FileReader("src/dp.properties"));
            DriverName = properties.getProperty("DriverName");
            Url = properties.getProperty("Url");
            UserName = properties.getProperty("UserName");
            PassWord = properties.getProperty("PassWord");
        } catch (IOException e) {
            e.printStackTrace();
        }

         */
        try {
            Class.forName(DriverName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    private Connection connection = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    public void getConnection() {
        try {

            connection = DriverManager.getConnection(Url,UserName,PassWord);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void getInsert(int id,String username,String passwd){

        try{
            String inserts1 = "INSERT INTO alogin (id,userid,passwd) VALUES("  + id + "," + "'" + username + "'"+"," + "'" + passwd + "'" +")";
            DriverManager.getConnection(Url,UserName,PassWord).createStatement().execute(inserts1);
            DriverManager.getConnection(Url,UserName,PassWord).createStatement().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    //注销

    //登录认证

    public boolean getDuplicateID(String username){
        String sql = "select * from alogin where userid = '"+username+"'";
        String userId = "a";
        try {
            java.sql.Connection conn = DriverManager.getConnection(Url,UserName,PassWord);
            Statement stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery(sql);
            while(result.next()){
                userId = result.getString("userid");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        if(userId.equals(username)){
            return true;
        }else{
            return false;
        }
    }


    public boolean getLogin(String username ,String password){
        String sql = "select * from alogin where userid = '"+username+"'";
        String userId = "a";
        String PassWd="b";
        try {
            java.sql.Connection conn = DriverManager.getConnection(Url,UserName,PassWord);
            Statement stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery(sql);
            while(result.next()){
                userId = result.getString("userid");
                PassWd = result.getString("passwd");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        if(userId.equals(username) && password.equals(PassWd)){
            return true;
        }else{
            return false;
        }
    }
    //获取最后一位的id
    private int i1;
    public int getLastId(){

        //select id from alogin ORDER BY id desc LIMIT 1;
        String serectid1= "select id from alogin ORDER BY id desc LIMIT 1";
        try {
            java.sql.Connection conn = DriverManager.getConnection(Url,UserName,PassWord);
            Statement stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery(serectid1);
            while (result.next()){
                i1 = result.getInt("id");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        int i=0;
        return ++i1;
    }
    public void closeConnection() {
        //断开连接
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
