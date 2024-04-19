package aula06;
import aula05.DateYMD;

public class Professor extends Person{
    private String category;
    private String department;

    public Professor(String name, int cc, DateYMD birthDate, String category, String department){
        super(name, cc, birthDate);
        this.category = category;
        this.department = department;
    }

    public String getCategory(){ return category; }
    public String getDepartment(){ return department; }

    public void setCategory(String newCategory){
        if(newCategory.equals("Auxiliar") || newCategory.equals("Associado") || newCategory.equals("Catedrático")){
            category = newCategory;
        }
        else{
            System.out.println("Invalid category");
        }
    }

    public void setDepartment(String newDepartment){
        department = newDepartment;
    }
}
