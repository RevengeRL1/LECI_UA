package aula04;

public class Rectangle {
    double length;
    double width;
    
    public Rectangle(double length, double width){
        assert length > 0;
        assert width > 0;
        this.length = length;
        this.width = width;
    }

    public double getLength(){
        return length;
    }

    public double getWidth(){
        return width;
    }

    public double getArea(){
        return length * width;
    }

    public void setLength(double newLength){
        length = newLength;
    }

    public void setWidth(double newWidth){
        width = newWidth;
    }

    public boolean equals(Rectangle r2){
        if (this.length == r2.getLength() && this.width == r2.getWidth()){ return true; }
        return false;
    }

    @Override
    public String toString(){
        String result = String.format("Rectangle with width %.2f, length %.2f and area %.2f", this.width, this.length, this.getArea());
        return result;
    }
}
