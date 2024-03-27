package aula06;

import aula05.DateYMD;

public class Student extends Person {
    private static int nextNmec = 0;
    private int nMec;
    private DateYMD registryDate;

    public Student(String name, int cc, DateYMD birthDate, DateYMD registryDate){
        super(name, cc, birthDate);
        nMec = nextNmec++;
        this.registryDate = registryDate;

    }

    public int getNmec(){ return nMec; }
    public DateYMD getRegistryDate(){ return registryDate; }

    public void setRegistryDate(DateYMD newRegistryDate){ registryDate = newRegistryDate; }
}
