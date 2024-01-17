package lab3;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
public class MyHashMapTest{
    public static void main(String[] args)throws Exception {
        //String inputAddress = "lab3/input.txt";
        String outputAddress = "output.txt";
        //File inputFile = new File(inputAddress);
        //Scanner input = new Scanner(inputFile);
        PrintWriter output = new PrintWriter(outputAddress);

        //in-work

        MyHashMap<StudentNumber,Student> database = new MyHashMap<>();




        database.put(new StudentNumber(0),new Student("Pavel","Chekalov",22,5.0d));
        database.put(new StudentNumber(1),new Student("Sveta","Popova",19,5.0d));
        ArrayList<StudentNumber> dbKeys = database.show_keys();
        ArrayList<Student> dbValues = database.showValues();
        for(int i=0;i<dbKeys.size();i++){
            dbKeys.get(i).Print(output);
            output.print(" : ");
            dbValues.get(i).Print(output);
            output.println();
        }
        database.get(new StudentNumber(0)).Print(output);
        output.println();
        database.remove(new StudentNumber(0));
        dbKeys = database.show_keys();
        dbValues = database.showValues();
        for(int i=0;i<dbKeys.size();i++){
            dbKeys.get(i).Print(output);
            output.print(" : ");
            dbValues.get(i).Print(output);
            output.println();
        }
        database.put(new StudentNumber(1),new Student("Sveta","Popova",20,10.0d));
        dbKeys = database.show_keys();
        dbValues = database.showValues();
        for(int i=0;i<dbKeys.size();i++){
            dbKeys.get(i).Print(output);
            output.print(" : ");
            dbValues.get(i).Print(output);
            output.println();
        }
        output.close();
        String outputAddress2 = "output2.txt";
        output = new PrintWriter(outputAddress2);
        for(int i=3;i<100;i++){
            database.put(new StudentNumber(i/*9*17*33*/),new Student("James","Bond",i,1.0d));
            output.println(database.size());
        }
        dbKeys = database.show_keys();
        dbValues = database.showValues();
        for(int i=0;i<dbKeys.size();i++){
            dbKeys.get(i).Print(output);
            output.print(" : ");
            dbValues.get(i).Print(output);
            output.println();
        }
        output.println("------------");
        for(int i=99;i>-1;i--){
            Student oneStudent = database.get(new StudentNumber(i));
            if(oneStudent == null){
                output.print("null student");
            }else{
                oneStudent.Print(output);
            }
            output.println();
        }
        output.close();
        return;

    }

}