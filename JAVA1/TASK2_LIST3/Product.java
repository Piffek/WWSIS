public class Product implements ProductInterface {
    int id;
    int price;
    String name;
    String color;
    String description;
    double VAT = 0.24D;

    public Product(int id) {
        this.id = id;
    }

    public Product() {
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return this.color;
    }

    public double getPriceBrutto() {
        double price_vat = (double)this.getPriceNetto() * this.VAT;
        return (double)this.getPriceNetto() - price_vat;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

    public void addAccessory(Podstawka podstawka) {
        this.price += podstawka.price;
    }

    public void setPriceNetto(int price) {
        this.price = price;
    }

    public int getPriceNetto() {
        return this.price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
