/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 *
 * @author Miramar
 */
public class DbHandle {
  public Connection con;

    /**
    * DbHandle constructor establish the database connection to the scores database which has two tables 
    * users --> has username and ID
    * tictac --> has scores for each user wins, loss and ties
    */ 
  
        public  DbHandle() throws SQLException{
          DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
          con = DriverManager.getConnection ("jdbc:mysql://localhost:3306/scores","root","");

          }


    /**
    *
    * Insert Function inserts username into the users table in the database, and checks if username already exists or not 
    * if its not it will insert it otherwise no insertion will happen 
     * @param table 
     * @param field
     * @param value
     * @throws java.sql.SQLException
     * 
    */
        public void Insert(String table,String field,String value) throws SQLException {

            if (!CheckUsername(value.toLowerCase())){

                try { 

                    String strQuery = " INSERT INTO table (field) VALUES (?)";
                    String query = strQuery.replace("table",table);
                    query = query.replace("field",field);
                    PreparedStatement stmt = con.prepareStatement(query);
                    stmt.setString(1, value.toLowerCase());
                    stmt.executeUpdate();
                    stmt.close();
                        con.close();            
                }catch (SQLException ex) {
                          Logger.getLogger(DbHandle.class.getName()).log(Level.SEVERE, null, ex);
                }


            }
        }
    
      /**
    * Function checkUserID take specific player id and the table name where it will search for it and return true if its found 
    * and return false if not found.
    */
  
        public boolean CheckUserID(int p_id,String table) throws SQLException {
               String query = "select p_id from table where p_id = ? ";
               query = query.replace("table",table);
               PreparedStatement stmt = con.prepareStatement(query);
               stmt.setInt(1,p_id);
               ResultSet rs =  stmt.executeQuery();
               return rs.next();


        }  
    
     /**
    * Function checkUserName checks whether the database table users has that username or not and return boolean.
     * @param name
    */
  
        public boolean CheckUsername(String name) throws SQLException {
           String query = "select username from users where username = ? ";
                  PreparedStatement stmt = con.prepareStatement(query);
                  stmt.setString(1,name);
                  ResultSet rs =  stmt.executeQuery();

                 return rs.next();


           }


      /**
    * Function used to get specific username its player id in the table
     * @param username
     * @return 
     * @throws java.sql.SQLException
    */
        
        public int getUserId(String username) throws SQLException{
             String query = "select p_id from users where username = ? ";
             PreparedStatement stmt = con.prepareStatement(query);
             stmt.setString(1,username);
             ResultSet rs =  stmt.executeQuery();
             if(rs.next()){
                return rs.getInt(1);}


             return 0;


             }

          /**
    * Function insertScore takes the username and its score and the name of the field that score relates to whether its wins, losses or ties
    * and insert it into the table if its the first time to insert score in the field else update that field and do not overwrite.
     * @param username
     * @param score
     * @param field
     * @throws java.sql.SQLException
    */
        
        public void insertScore(String username, int score, String field) throws SQLException{
           if (CheckUserID(getUserId(username),"tictac")==false){
                      String strQuery = " INSERT INTO tictac ( p_id ,field) VALUES (?,?)";
                      String query = strQuery.replace("field",field);
                      PreparedStatement stmt = con.prepareStatement(query);
                      stmt.setInt(1, getUserId(username));
                      stmt.setInt(2,score);
                      stmt.executeUpdate();
                      stmt.close();
                      con.close();  
           }

           else{

                  updateScore ("tictac", field ,score,getUserId(username));
           }
        }
        
          /**
    * Function getScore takes username and the field (wins,losses,ties) and returns the score exists in it.
     * @param field
     * @param p_id
     * @return 
     * @throws java.sql.SQLException
    */
  
        public int getScore (String field ,int p_id) throws SQLException{
            String query = "select field from tictac where p_id = ? ";
            query = query.replace("field",field);
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setInt(1,p_id);
            ResultSet rs =  stmt.executeQuery();
            if(rs.next()){
              return rs.getInt(1);}


            return 0;
    }
  
      /**
    * Function updateScore takes table name and column and the new score and player id and updates the old score with the new one.  
     * @param table
     * @param field
     * @param score
     * @param p_id
     * @throws java.sql.SQLException
    */
        public void updateScore (String table, String field ,int score, int p_id) throws SQLException{

                      String strQuery = " UPDATE table SET field = ? where p_id = ? ";
                      String query = strQuery.replace("table",table);
                      query =query.replace("field",field);
                      PreparedStatement stmt = con.prepareStatement(query);
                      stmt.setInt(1,getScore(field,p_id)+score);
                      stmt.setInt(2, p_id);
                      stmt.executeUpdate();
                      stmt.close();
                      con.close();
        }
  
     

  
     
     
}