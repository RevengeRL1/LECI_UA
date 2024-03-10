package aula04;

public class Circulo {
    double raio;
    int area;

    public Circulo(double raio, int area){
        this.raio = raio;
        this.area = area;
    }
    
    public double getRaio(){
        return raio;
    }

    public void setRaio(double newRaio){
        raio = newRaio;
    }

    public int getArea(){
        return area;
    }

    public static void main(String[] args) {
        Circulo c1 = new Circulo(3, 6);
        System.out.println(c1.getRaio());
        c1.setRaio(10);
        System.out.println(c1.getRaio());
        
    }
}
