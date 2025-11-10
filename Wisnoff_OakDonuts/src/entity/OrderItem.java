package entity;

public class OrderItem {
    private int id; // order id
    private int menuItemId;
    private String name;
    private int quantity;
    private double price; // price per item

    public OrderItem(int id, int menuItemId, String name, int quantity, double price) {
        this.id = id;
        this.menuItemId = menuItemId;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public OrderItem(int menuItemId, String name, int quantity, double price) {
        this(-1, menuItemId, name, quantity, price);
    }

    public int getId() {
        return id;
    }

    public int getMenuItemId() {
        return menuItemId;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public double getTotal() {
        return price * quantity;
    }

    @Override
    public String toString() {
        return quantity + " x " + name + " @ $" + String.format("%.2f", price) + " = $" + String.format("%.2f", getTotal());
    }
}

