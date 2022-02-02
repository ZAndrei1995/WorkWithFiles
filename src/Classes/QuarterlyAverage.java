package Classes;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class QuarterlyAverage {

    ArrayList<String> infoAboutStudents = new ArrayList<>() ;

    public QuarterlyAverage() {}

    public void readFromFile ( ) {

        try {
            File file = new File("C:\\WorkWithFiles\\src\\Files\\numeleInitial.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file)) ;
            reader.readLine();
            String line ;
            while ((line = reader.readLine()) != null){
                infoAboutStudents.add(line) ;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(infoAboutStudents);
        workWithData();

    }

    public void workWithData ( ) {

        for ( String counter : infoAboutStudents ) {
            double average = 0 ;
            int gradePointsCounter = 0 ;
            StringTokenizer myString = new StringTokenizer(counter) ;
            while ( myString.hasMoreTokens() ) {
                String getValue = myString.nextToken(",!@#$%^&*()_+=-]['/ ") ;
                if ( isNumberic(getValue) ) {
                    int transform = Integer.parseInt(getValue) ;
                    gradePointsCounter++ ;
                    average += transform ;
                }

            }
            System.out.println(average/gradePointsCounter);
        }

    }

    private boolean isNumberic ( String myString ) {
        return myString != null && myString.matches("[0-9]+") ;
    }

    private boolean containsALetter ( String myString ) {
        return myString != null && myString.matches("[0-9]{0,2}t+") ;
    }


}
