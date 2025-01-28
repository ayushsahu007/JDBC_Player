package dao;

import java.sql.*;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class PlayerDao {
    static Scanner sc = new Scanner(System.in);
    public static Connection buildConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_playerdb?user=root&password=root");
        } catch (ClassNotFoundException | SQLException e) {
           e.printStackTrace();
        }
        return connection;
    }
    public void addPlayer(){
        Connection connection =  buildConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO player VALUES(?,?,?,?,?,?)");
            System.out.println("Enter Player Id ");
            preparedStatement.setInt(1,sc.nextInt());
            System.out.println("Enter Player Name  ");
            preparedStatement.setString(2,sc.next());
            System.out.println("Enter Player Age ");
            preparedStatement.setInt(3,sc.nextInt());
            System.out.println("Enter Player Country ");
            preparedStatement.setString(4,sc.next());
            System.out.println("Ipl Team ");
            preparedStatement.setString(5,sc.next());
            System.out.println("Ipl Salary ");
           preparedStatement.setInt(6,sc.nextInt());

            int rowAffected = preparedStatement.executeUpdate();

            if (rowAffected>0){
                System.out.println(rowAffected+"ALL Data Inserted");
            }else
                System.out.println("Data not Insterd");

        } catch (SQLException  |NoSuchElementException e) {
            e.printStackTrace();
        }

    }
    public  void findAllPlayerByCountry(){
       Connection connection = buildConnection();
       try {

           PreparedStatement preparedStatement = connection.prepareStatement("select playerName from player where playerCountry = ?");
           System.out.println("Enter a Country Name ");
           preparedStatement.setString(1,sc.next());
           ResultSet resultSet = preparedStatement.executeQuery();
               while (resultSet.next()){
                   String playerName = resultSet.getString("playerName");
                   System.out.println(playerName);
               }

       } catch (SQLException e) {
          e.printStackTrace();
       }

    }
    public void findAllPlayerbyIplTeam(){
       Connection connection = buildConnection();
       try {
           PreparedStatement preparedStatement = connection.prepareStatement("Select playerName from player where iplTeam = ?");
           System.out.println("Enter IPL Team ");
           preparedStatement.setString(1,sc.next());
           ResultSet resultSet = preparedStatement.executeQuery();
           while (resultSet.next()){
               String playerName = resultSet.getString("playerName");
               System.out.println(playerName);
           }
       } catch (SQLException e) {
           e.printStackTrace();
       }

    }
    public void findPlayerBetweenAge(){
       Connection connection = buildConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("Select playerName from player where playerAge between ? and ?");
            System.out.println("Enter a Age ");
            preparedStatement.setInt(1,sc.nextInt());
            System.out.println("Enter a Age ");
            preparedStatement.setInt(2,sc.nextInt());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String playerName = resultSet.getString("playerName");
                System.out.println(playerName);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updatePlayerSalaryById(){
    Connection connection = buildConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM player where playerId = ? ");
            System.out.println("Enter Player ID ");
            preparedStatement.setInt(1,sc.nextInt());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int playerId = resultSet.getInt("playerId");
                int currentSalary = resultSet.getInt("iplSalary");
                preparedStatement = connection.prepareStatement("UPDATE player SET iplSalary = ? WHERE playerId = ?");
                preparedStatement.setInt(1,currentSalary+500000);
                preparedStatement.setInt(2,playerId);
                preparedStatement.executeUpdate();
            }

        } catch (NullPointerException |SQLException e) {
           e.printStackTrace();
        }
    }
    public void updatePlayerSalaryBetweenAge(){
       Connection connection = buildConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM player where playerAge Between ? AND ? ");
            System.out.println("Enter Initial age ");
            preparedStatement.setInt(1,sc.nextInt());
            System.out.println("Enter Final age");
            preparedStatement.setInt(2,sc.nextInt());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int playerId = resultSet.getInt("playerId");
                int currentSalary = resultSet.getInt("iplSalary");
                preparedStatement = connection.prepareStatement("UPDATE player SET iplSalary = ? WHERE playerId = ?");
                      preparedStatement.setInt(1,currentSalary+500000);
                      preparedStatement.setInt(2,playerId);
                      preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void daleteAllPlayerByCountry(){
      Connection connection = buildConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("Delete from player where playerCountry = ?");
            System.out.println("Enter Country Name ");
            preparedStatement.setString(1,sc.next());
            int rowAffected = preparedStatement.executeUpdate();
            if (rowAffected>0){
                System.out.println(rowAffected+"Data Delete SuccessFully");
            }else
                System.out.println("Data not Deleted");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deletePlayerById(){
      Connection connection =  buildConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("Delete from player where playerId = ?");
            System.out.println("Enter Player Id ");
            preparedStatement.setInt(1,sc.nextInt());
            int rowAffected = preparedStatement.executeUpdate();
            if (rowAffected>0){
                System.out.println(rowAffected+"Data Delete SuccessFully");
            }else
                System.out.println("Data not Deleted");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}
