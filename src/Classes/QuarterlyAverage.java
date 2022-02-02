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
        System.out.println();
        workWithData();

    }

    public void workWithData ( ) {

        for ( String counter : infoAboutStudents ) {
            double average = 0 ;
            int gradePointsCounter = 0 ;
            String name = "" ;
            double notaTeza = 0 ;
            StringTokenizer myString = new StringTokenizer(counter,",") ;
            while ( myString.hasMoreTokens() ) {
                String getValue = myString.nextToken() ;

                if ( getValue.endsWith("teza")) {
                    notaTeza = Integer.parseInt(getValue.substring(0, getValue.lastIndexOf("teza")).trim());
                }else {
                    try {
                        int transform = Integer.parseInt(getValue);
                        gradePointsCounter++;
                        average += transform;
                    } catch (NumberFormatException e) {
                        name = getValue;
                    }
                }

            }
            System.out.println(name + " " + ((average/gradePointsCounter)*3+notaTeza)/4);
        }

    }


}
