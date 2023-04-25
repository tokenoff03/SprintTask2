package com.example.sprinttask2;

import java.sql.*;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DBManager {

    private static Connection connection;
    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/SprintTask2",
                    "postgres","00000000");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static ArrayList<Items> getAllItems(){
        ArrayList<Items> items = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("" + "SELECT * FROM items");
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                Long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                float price = resultSet.getFloat("price");
                items.add(new Items(id,name,description,price));
            }
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return items;
    }

    public static ArrayList<Users> getAllUsers(){
        ArrayList<Users> users = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("" + "SELECT * FROM public.users");
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                Long id = resultSet.getLong("id");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                String full_name = resultSet.getString("full_name");
                users.add(new Users(id,email,password,full_name));
            }
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return users;
    }


}
