public class Podstawka extends Product {
    int id;
    int price;

    public Podstawka(int id) {
        this.id = id;
    }

    public void setPriceNetto(int priceext) {
        this.price = priceext;
    }
}
