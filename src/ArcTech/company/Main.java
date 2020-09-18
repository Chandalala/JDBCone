package ArcTech.company;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {



    private static  final String SQL ="SELECT id, firstName, fee FROM student WHERE fee<=?";

    public static void main(String[] args) throws SQLException {

                MySQLConnection conOne=new MySQLConnection("root","zambuko1");
                conOne.Connect();

                double maxFee;
                try
                    {
                        maxFee=DBInput.getInt("Enter a maximum fee: ");
                    }
                catch (IOException e)
                    {
                        e.printStackTrace();
                    }

        ResultSet resultSet=null;
        Connection connection = 


//        DBInput dbInput=new DBInput();
//
//                dbInput.Query("SELECT id, firstname FROM student WHERE id=3");


    }
}
