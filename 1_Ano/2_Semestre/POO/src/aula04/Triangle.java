package aula04;

public class Triangle {
    double side1, side2, side3;

    public Triangle(double side1, double side2, double side3){
        assert (side1 > 0 && side2 > 0 && side3 > 0);
        assert (side1 + side2 > side3);
        assert (side2 + side3 > side1);
        assert (side1 + side3 > side2);
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public double getSide1(){
        return side1;
    }

    public double getSide2(){
        return side2;
    }

    public double getSide3(){
        return side3;
    }

    public double getArea(){
        double semiPerimeter = (side1 + side2 + side3) / 2;
        return Math.sqrt(semiPerimeter * (semiPerimeter - side1) * (semiPerimeter - side2) * (semiPerimeter - side3));
    }

    public void setSide1(double newSide1){
        side1 = newSide1;
    }

    public void setSide2(double newSide2){
        side2 = newSide2;
    }

    public void setSide3(double newSide3){
        side3 = newSide3;
    }

    public boolean equals(Triangle t2){
        if (this.side1 == t2.getSide1() && this.side2 == t2.getSide2() && this.side3 == t2.getSide3()){
            return true;
        }
        return false;
    }

    @Override
    public String toString(){
        String result = String.format("Triangle with sides %.2f, %.2f, %.2f and area %.2f", this.side1, this.side2, this.side3, this.getArea());
        return result;
    }
}
