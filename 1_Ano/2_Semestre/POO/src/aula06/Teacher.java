package aula06;
import aula05.DateYMD;

public class Teacher extends Person{
    private String category;
    private String department;

    public Teacher(String name, int cc, DateYMD birthDate, String category, String department){
        super(name, cc, birthDate);
        this.category = category;
        this.department = department;
    }

    public String getCategory(){ return category; }
    public String getDepartment(){ return department; }
}
