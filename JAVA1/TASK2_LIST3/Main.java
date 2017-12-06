public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        Product biurko = new Product(1);
        biurko.setColor("Green");
        biurko.setName("Biurko");
        biurko.setPriceNetto(24);
        Podstawka podstawka = new Podstawka(1);
        podstawka.setPriceNetto(20);
        biurko.addAccessory(podstawka);
        Product monitor = new Product(4);
        monitor.setPriceNetto(100);
        Basket basket = new Basket();
        basket.add(biurko);
        basket.add(monitor);
        basket.remoteProduct(4);
        System.out.println(basket.getTotalNettoPrice());
        System.out.println(basket.getTotalBruttoPrice());
    }
}
