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

        workWithData();

    }

    public void workWithData ( ) {

        for ( String counter : infoAboutStudents ) {
            double average = 0 ;
            int gradePointsCounter = 0 ;
            String name = "" ;
            double notaTeza = 0 ;
            StringTokenizer myString = new StringTokenizer(counter,",") ;
            double finalGrade ;
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
            finalGrade = ((average/gradePointsCounter)*3+notaTeza)/4;
            if ( addContentInFile(name, finalGrade)) {
                System.out.println("Student was added");
            }else{
                System.out.println("ERROR");
            }
        }

    }

    public boolean addContentInFile ( String studentName, double studentGrade ) {

        boolean isAdded = false ;
        String studentInformation ="Student name: " + studentName + "\n"
                                + "Final grade: " + studentGrade + "\n\n";
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter("C:\\WorkWithFiles\\src\\Files\\numeleInitial_medii.txt",true)) ;
            out.write(studentInformation);
            out.close();
            isAdded = true ;
        }catch (IOException e) {
            e.printStackTrace();
        }
        return isAdded ;
    }


}
