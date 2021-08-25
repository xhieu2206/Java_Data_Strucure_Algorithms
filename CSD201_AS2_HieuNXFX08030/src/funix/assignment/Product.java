package funix.assignment;

public class Product {
    private final String id;
    private final String name;
    private final int price;
    private final int quantity;

    public Product(String id, String name, int quantity, int price) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return getId() + " | " + getName() + " | " + getQuantity() + " | " + getPrice();
    }
}
