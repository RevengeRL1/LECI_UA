package aula04;

import java.util.Scanner;

class Car {
    public String make;
    public String model;
    public int year;
    public int kms;

    public Car(String make, String model, int year, int kms) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.kms = kms;
    }

    public void drive(int distance) {
        kms += distance;
        //TODO: acumular distância percorrida
    }

}

public class CarDemo {

    static Scanner sc = new Scanner(System.in);

    static int registerCars(Car[] cars) {
        String answer, make, model;
        int year, kms;
        int carCount = 0;
        while(true){
            System.out.print("Insert car manufacturer, model, year and kilometers separated by a comma (blank to stop): ");
            answer = sc.nextLine();
            if(answer == ""){ break; }
            String[] values = answer.split(",");
            make = values[0];
            model = values[1];
            year = Integer.parseInt(values[2]);
            kms = Integer.parseInt(values[3]);
            cars[carCount] = new Car(make, model, year, kms);
            carCount++;
        }
        return carCount;
   }

    static void registerTrips(Car[] cars, int numCars) {
        // TODO: pede dados das viagens ao utilizador e atualiza informação do carro
        // registo de viagens termina quando o utilizador inserir uma linha vazia
        while(true){ 
            System.out.print("Register a trip using the car:distance format (blank to stop):  ");
            String answer = sc.nextLine();
            if(answer == ""){ break; }
            String[] values = answer.split(":");
            int car = Integer.parseInt(values[0]);
            int distance = Integer.parseInt(values[1]);
            if(car > numCars || car < 0){ continue; }
            cars[car].drive(distance);
        }


    }


    static void listCars(Car[] cars) {
        // TODO: lista todos os carros registados
        // Exemplo de resultado
        // Carros registados: 
        // Toyota Camry, 2010, kms: 234346
        // Renault Megane Sport Tourer, 2015, kms: 32536
        System.out.println("Registered cars: ");
        for (Car car : cars){
            if (car != null){
                System.out.println(car);
            }
        }
        
        System.out.println("\n");
    }

    public static void main(String[] args) {

        Car[] cars = new Car[10];

        int numCars = registerCars(cars);

        if (numCars>0) {
            listCars(cars);
            registerTrips(cars, numCars);
            listCars(cars);
        }

        sc.close();

    }
}