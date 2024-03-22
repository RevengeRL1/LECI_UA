package aula04;

class Product {
    private String name;
    private double price;
    private int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public double getTotalValue() {
        return price * quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int  getQuantity() {
        return quantity;
    }
}


class CashRegister {
    private Product[] products = new Product[5];
    private int currentIndex;

    public void addProduct(Product product){
        products[currentIndex] = product;
        currentIndex++;
    }

    public double getTotalValue(){
        double total = 0;
        for(Product product : products){
            total += product.getTotalValue();
        }
        return total;
    }

    @Override
    public String toString(){
        String result = String.format("\n%-15s %-10s %-10s %-10s\n", "Product", "Price", "Quantity", "Total");
        for(Product product : products){
            if(product != null){
                result += String.format("%-15s %-10.2f %-10d %-10.2f\n", product.getName(), product.getPrice(), product.getQuantity(), product.getTotalValue());
            }
        }
        result += String.format("\nTotal value: %.2f", this.getTotalValue());
        return result;
    }

}

public class CashRegisterDemo {

    public static void main(String[] args) {

        // Creates and adds 5 new products
        CashRegister cr = new CashRegister();
        cr.addProduct(new Product("Book", 9.99, 3));
        cr.addProduct(new Product("Pen", 1.99, 10));
        cr.addProduct(new Product("Headphones", 29.99, 2));
        cr.addProduct(new Product("Notebook", 19.99, 5));
        cr.addProduct(new Product("Phone case", 5.99, 1));
        
        System.out.println(cr);

    }
}