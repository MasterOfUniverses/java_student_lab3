package lab3;

public class StudentHash extends HashAble<StudentNumber,Student>{
    public Integer getHashForValue(Student value, int module){
        int result=0;
        for(int i=0;i<value.name.length();i++){
            result+=(int)value.name.charAt(i);
            result = result%module;
        }
        for(int i=0;i<value.surname.length();i++){
            result+=(int)value.surname.charAt(i);
            result = result%module;
        }
        return result;
    }
    public Integer getHashForKey(StudentNumber key, int module){
        return key.data%module;
    }
    public Student defaultValue(){
        return new Student();
    }
    public StudentNumber defaultKey(){
        return new StudentNumber();
    }
}
