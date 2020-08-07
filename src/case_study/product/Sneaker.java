package case_study.product;

import java.io.Serializable;
import java.util.Comparator;

public class Sneaker implements Serializable {
    private String id;
    private String name;
    private int amount;
    private String size;
    private int price;
    private String brand;


    public Sneaker() {

    }

    public Sneaker(String id, String name, int amount, String size, int price, String brand) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.size = size;
        this.price = price;
        this.brand = brand;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Sneaker{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", amount='" + amount + '\'' +
                ", size='" + size + '\'' +
                ", price=" + price +
                ", brand='" + brand + '\'' +
                '}';
    }

}
