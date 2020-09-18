package ArcTech.company;

import JDBCone.tables.Students;

import java.sql.*;


public class MySQLConnection {

                /**
                 * Declare constants to be used for connecting to the database
                 */
                private  String USERNAME;
                private  String PASSWORD;
                private  String ADDRESS;
                Connection connection = null;
                Statement statement = null;
                ResultSet resultSet = null; //Knows what was returned by a SELECT Query


                public MySQLConnection() {
                }


                public MySQLConnection(String USERNAME, String PASSWORD) {
                this.USERNAME=USERNAME;
                this.PASSWORD=PASSWORD;
                ADDRESS="jdbc:mysql://127.0.0.1:4406/school?autoReconnect=true&useSSL=true";
            }



            /**
             * Establish a connection
             */
            public void Connect() throws SQLException {


                try
                {

                    connection= DriverManager.getConnection(ADDRESS,USERNAME,PASSWORD);//DataSource is better than Driver Manager
                    System.out.println("Connected");


                    /**
                     * The statement allows to scroll through the results
                     * Knows how to run SQL
                     */
                    statement=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                    resultSet=statement.executeQuery("SELECT* FROM student");//query statement and the results are assigned to resultset

                    //resultSet.last();//This means the cursor is on the last row in the database
                    //System.out.println(resultSet.getRow());//returns the number of rows in the table


                    /**
                     * From the created custom package
                     */
                    Students.getStudents(resultSet);//get all the rows from the database

                    resultSet.last();//This means the cursor is on the last row in the database, in this case it sets the cursor to the last row
                    System.out.println("Last row "+resultSet.getString("firstname"));//prints what is on the last row because of the above


                    /**
                     * To obtain specific columns in all rows
                     */
                    System.out.println(resultSet.getString("firstName")+" "+resultSet.getString("lastName"));


                    /**
                     * To obtain rows other than first and last
                     */
                    resultSet.absolute(2);
                    System.out.println(resultSet.getString("firstName")+" "+resultSet.getString("lastName"));

                    for (int i=1;i<5;i++){
                        resultSet.absolute(i);
                        System.out.println(resultSet.getString("firstName")+" "+resultSet.getString("lastName"));
                    }

                }
                catch (SQLException ex)
                {
                    System.out.println("SQLException: "+ex.getMessage());
                    System.out.println("SQLState: "+ex.getSQLState());
                    System.out.println("VendorError: "+ex.getErrorCode());
                }
                finally
                {

                    /**
                     * You close the same way you opened the connections down top
                     */

                    if (resultSet!=null)
                    {
                        resultSet.close();
                    }

                    if (statement!=null)
                    {
                        statement.close();
                    }

                    if (connection!=null)
                    {
                        connection.close();
                    }

                }
            }
}
