package aula06;

import aula05.DateYMD;

public class main {
    public static void main(String[] args) {
        DateYMD dataNascTiago = new DateYMD(2004, 8, 9);
        DateYMD dataInscTiago = new DateYMD(2021, 9, 25);
        Student tiago = new Student("Tiago", 1234, dataNascTiago, dataInscTiago);

        DateYMD dataNascLina = new DateYMD(2004, 2, 20);
        DateYMD dataInscLina = new DateYMD(2022, 9, 25);
        Student lina = new Student("Lina", 4321, dataNascLina, dataInscLina);

        System.out.println(tiago.getNmec());
        System.out.println(lina.getNmec());
        System.out.println(tiago.getName());
    }
}
