package ArcTech.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DBInput {


    public static String getInput(String value) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(value);
        System.out.flush();//Ensures that the last of the data you had already written actually gets out to the file.


        return bufferedReader.readLine();

    }


    public static int getInt(String value) throws NumberFormatException, IOException {
        String in=getInput(value);
        return Integer.parseInt(in);
    }

    public String Query(String query){
       // query="SELECT id, firstname FROM student WHERE id=3"
        query="";
        return query;
    }
}
