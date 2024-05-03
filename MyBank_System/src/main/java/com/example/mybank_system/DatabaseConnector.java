package com.example.mybank_system;

import javafx.scene.control.Alert;

import java.io.IOException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseConnector {

    // Sign Up to database
    public static void SignUpDb(String username, String nationality, String  email, String  password){
        String url ="jdbc:postgresql://localhost:5432/Bank";
        String userName = "postgres";
        String passWord = "12345678";

        String Username = username;
        String Nationality = nationality;
        String Email = email;
        String Password = password;


        String query = "insert into bank_signup (username,nationality,email,password) values(?,?,?,?)";

        try(Connection con = DriverManager.getConnection(url,userName,passWord);
            PreparedStatement pst = con.prepareStatement(query)){

            pst.setString(1,Username);
            pst.setString(2,Nationality);
            pst.setString(3,Email);
            pst.setString(4,Password);

            pst.executeUpdate();

            //Making Alerts
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Registration Completed");
            alert.showAndWait();

        }catch (SQLException ex){
            Logger lgr = Logger.getLogger(DatabaseConnector.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }


    public static void LoginCheck(String email, String password){
        String url ="jdbc:postgresql://localhost:5432/Bank";
        String userName = "postgres";
        String passWord = "12345678";

        String Email = email;
        String Password = password;


        String query = "SELECT email,password FROM bank_signup WHERE email=? AND password=?";
        ResultSet rs;

        try(Connection con = DriverManager.getConnection(url,userName,passWord);
            PreparedStatement pst = con.prepareStatement(query)){

            pst.setString(1,Email);
            pst.setString(2,Password);

            rs = pst.executeQuery();

            if(rs.next()){
                email = rs.getString("email");
                password = rs.getString("password");

                // changing scene
                HelloApplication.MainMenu();

            }
            pst.executeQuery(query);

        } catch (SQLException ex) {
            throw new RuntimeException(ex);

        } catch (IOException ex) {

            throw new RuntimeException(ex);
        }


    }
    public static void WithdrawMoney(String Amount, String withdrawal, String Balance){
        String url ="jdbc:postgresql://localhost:5432/Bank";
        String userName = "postgres";
        String passWord = "12345678";

        String amount = Amount;
        String Withdrawal = withdrawal;
        String balance = Balance;

        String query = "insert into withdrawdb(amount,withdrawamount,balance) values (CAST(? AS INTEGER),CAST(? AS INTEGER),CAST(? AS INTEGER))";

        try(Connection con = DriverManager.getConnection(url,userName,passWord);
            PreparedStatement pst = con.prepareStatement(query)){

            pst.setDouble(1, Double.parseDouble(amount));
            pst.setDouble(2, Double.parseDouble(Withdrawal));
            pst.setDouble(3, Double.parseDouble(balance));

            pst.executeUpdate();

            //Making Alerts
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Transaction Completed");
            alert.showAndWait();
            HelloApplication.Thankyou();

        }catch (SQLException ex){
            Logger lgr = Logger.getLogger(DatabaseConnector.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static void SentMoney(String accountNumber, String sentAmount){
        String url ="jdbc:postgresql://localhost:5432/Bank";
        String userName = "postgres";
        String passWord = "12345678";

        String AccountNumber = accountNumber;
        String SentAmount = sentAmount;


        String query = "insert into sentdb(accountnumber,amount) values (?,CAST(? AS INTEGER))";

        try(Connection con = DriverManager.getConnection(url,userName,passWord);
            PreparedStatement pst = con.prepareStatement(query)){

            pst.setString(1, AccountNumber);
            pst.setDouble(2, Double.parseDouble(SentAmount));

            pst.executeUpdate();

            //Making Alerts
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Transaction Completed");
            alert.showAndWait();
            HelloApplication.Thankyou();

        }catch (SQLException ex){
            Logger lgr = Logger.getLogger(DatabaseConnector.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void ChangePassword(String Oldemail, String Oldpassword, String Newpassword){
        String url ="jdbc:postgresql://localhost:5432/Bank";
        String userName = "postgres";
        String passWord = "12345678";

        String Email = Oldemail;
        String Password = Oldpassword;



        String selectQuery = "SELECT email,password FROM bank_signup WHERE email=? AND password=?";

        String updateQuery = "UPDATE bank_signup SET password=? WHERE email=? AND password=?";


        try(Connection con = DriverManager.getConnection(url,userName,passWord);
            PreparedStatement Selectpst = con.prepareStatement(selectQuery);
            PreparedStatement Updatepst = con.prepareStatement(updateQuery)){

            // check if they match
            Selectpst.setString(1,Email);
            Selectpst.setString(2,Password);
            ResultSet rs = Selectpst.executeQuery();


            if(rs.next()){
                // Update the password if the old email and password match
                Updatepst.setString(1, Newpassword);
                Updatepst.setString(2, Email);
                Updatepst.setString(3, Password);

                int rowsAffected = Updatepst.executeUpdate();

                if(rowsAffected > 0) {
                    //Making Alerts
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setContentText("Password is successfully changed");
                    alert.showAndWait();

                    HelloApplication.Thankyou();
                }
                else
                {
                    //Making Alerts
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Password or email is incorrect");
                    alert.showAndWait();
                }
            }
        }
        catch (SQLException ex)
        {
            throw new RuntimeException(ex);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
