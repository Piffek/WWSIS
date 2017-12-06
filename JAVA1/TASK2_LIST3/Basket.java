import java.util.ArrayList;

public class Basket {
    double basket_VAT = 0.24D;
    int priceNetto = 0;
    Product product;
    ArrayList<Product> productList = new ArrayList();

    public Basket() {
    }

    public void add(Product product) {
        this.product = product;
        this.productList.add(product);
    }

    public int getTotalNettoPrice() {
        this.iteration();
        return this.priceNetto;
    }

    public double getTotalBruttoPrice() {
        double price_vat = (double)this.priceNetto * this.basket_VAT;
        return (double)this.priceNetto - price_vat;
    }

    public void removeBasket() {
        this.productList.clear();
    }

    public void remoteProduct(int id) {
        for(int i = 0; i < this.productList.size(); ++i) {
            if (((Product)this.productList.get(i)).id == id) {
                this.productList.remove(i);
            }
        }

    }

    public void iteration() {
        for(int i = 0; i < this.productList.size(); ++i) {
            this.priceNetto += ((Product)this.productList.get(i)).getPriceNetto();
        }

    }
}
