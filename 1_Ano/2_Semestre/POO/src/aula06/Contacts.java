package aula06;

public class Contacts {
    private static int currentId = 1;
    private int id;
    private Person person;
    private String email;
    private String phone;

    public Contacts(Person person, String email, String phone){
        this.id = currentId++;
        this.person = person;
        this.email = email;
        this.phone = phone;
    }
}
