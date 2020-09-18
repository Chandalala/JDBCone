package JDBCone.tables;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Students {

    public static void getStudents(ResultSet resultSet) throws SQLException {

        /**
         * A loop to move and read the data in the table
         * Reading information from a database
         */

        while (resultSet.next())
        {
            StringBuffer studentDetails = new StringBuffer();

            studentDetails.append("\nStudents ID "+resultSet.getInt("id"));//get int because id is an integer
            studentDetails.append("\nFirst Name "+resultSet.getString("firstName"));
            studentDetails.append("\nLast Name "+resultSet.getString("lastName"));
         //   stringBuffer.append(resultSet.getDate("dob")+" ");

            System.out.println(studentDetails.append("h"));


        }
    }


}
