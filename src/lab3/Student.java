package lab3;
import java.io.PrintWriter;
import java.util.Scanner;
public class Student{
    public String name="no name";
    public String surname="no surname";
    public int age=0;
    public double GPA=0.0;
    public void Scan(Scanner input){
        if(input.hasNext()){
            this.name = input.next().trim();
        }else{
            System.out.println("no name");
        }
        if(input.hasNext()){
            this.surname = input.next().trim();
        }else{
            System.out.println("no surname");
        }
        if(input.hasNextInt()){
            this.age = input.nextInt();
        }else{
            System.out.println("no age");
        }
        if(input.hasNextDouble()){
            this.GPA = input.nextDouble();
        }else{
            System.out.println("no GPA");
        }
    }

    public boolean equals(Object other){
        if (other == this) {
            return true;
        }
        if (other == null || other.getClass() != this.getClass()) {
            return false;
        }
        if(other instanceof Student){
            Student otherStudent = (Student) other;
            boolean flag=true;
            if(!(this.name.equals(otherStudent.name))){
                flag=false;
            }
            if(!(this.surname.equals(otherStudent.surname))){
                flag=false;
            }
            if(this.age!= otherStudent.age){
                flag=false;
            }
            if(this.GPA!= otherStudent.GPA){
                flag=false;
            }
            return flag;
        }
        return false;
    }
    @Override
    public int hashCode(){
        return this.toString().hashCode()%91;
    }
    public String toString(){
        String res = "";
        res += this.name+" "+this.surname+" "+String.valueOf(this.age)+" "+String.valueOf(this.GPA);
        return res;
    }
    public void Print(PrintWriter output){
        output.print(this.toString());
    }
    public Student(){
        this.name="no name";
        this.age = 0;
        this.surname = "no surname";
        this.GPA = 0.0;
    }
    public Student(String _name,String _surname,int _age,double _gpa){
        this.name=_name;
        this.age = _age;
        this.surname = _surname;
        this.GPA =_gpa;
    }
}