package lab3;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class StudentNumber {
    public int data=0;
    public void Scan(Scanner input){
        if(input.hasNextInt()){
            this.data = input.nextInt();
        }else{
            System.out.println("no data");
        }
    }
    public void Print(PrintWriter output){
        String res=this.toString();
        output.print(res);
    }
    @Override
    public boolean equals(Object other){
        if (other == this) {
            return true;
        }
        if (other == null || other.getClass() != this.getClass()) {
            return false;
        }
        if (other instanceof StudentNumber) {
            StudentNumber rhs = (StudentNumber) other;
            return this.data == rhs.data;
        }
        return false;
    }

    /*public int hashCode(int module){
        return this.data%module;
    }*/
    @Override
    public int hashCode(){
        Integer code = Integer.valueOf(this.data);
        return code.hashCode()%91;
    }
    public String toString(){
        String res="";
        res+=String.valueOf(this.data);
        return res;
    }
    public StudentNumber(){
        this.data =0;
    }
    public StudentNumber(int newData){
        this.data = newData;
    }
}
