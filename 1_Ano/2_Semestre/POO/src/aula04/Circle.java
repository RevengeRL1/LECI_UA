package aula04;

public class Circle {
    private double radius;

    public Circle(double radius){
        this.radius = radius;
    }

    public double getRadius(){
        return radius;
    }

    public double getArea(){
        return Math.PI * radius * radius;
    }

    public void setRadius(double newRadius){
        radius = newRadius;
    }

    public boolean equals(Circle c2){
        if(radius == c2.getRadius()){
            return true;
        }
        return false;
    }

    @Override
    public String toString(){
        String result = String.format("Circle has a radius of %.2f and an area of %.2f", radius, this.getArea());
        return result;
    }
}
