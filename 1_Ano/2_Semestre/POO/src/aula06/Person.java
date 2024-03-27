package aula06;

import aula05.DateYMD;

public class Person {
    private String name;
    private int cc;
    private DateYMD birthDate;

    public Person(String name, int cc, DateYMD birthDate){
        this.name = name; 
        this.cc = cc;
        this.birthDate = birthDate;
    }

    public String getName(){ return name; }
    public int getCc(){ return cc; }
    public DateYMD getBirthDate() { return birthDate; }

    public void setName(String newName){ name = newName; }
    public void setCc(int newCc){ cc = newCc; }
    public void setBirthDate(DateYMD newBirthDate){ birthDate = newBirthDate; }


}
