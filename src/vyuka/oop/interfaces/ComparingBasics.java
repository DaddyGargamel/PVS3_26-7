package vyuka.oop.interfaces;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ComparingBasics {

    static void printList(ArrayList<Item> items){
        for (Item i : items){
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        ArrayList<Item> items = new ArrayList<>();

        items.add(new Item("potato", 100, 0.33));
        items.add(new Item("bramburky", 500, 2));
        items.add(new Item("Pilsner Urquell 12°", 1000, 1.5));
        items.add(new Item("kure na paprice", 5, 8));

        printList(items);
        System.out.println("\n");
        Collections.sort(items);
        printList(items);
        System.out.println("\n");
    }
}

class Item implements Comparable<Item>{
    String name;
    int quantity;
    double price;

    public static Comparator<Item> BY_PRICE = new Comparator<Item>() {
        @Override
        public int compare(Item o1, Item o2) {
            return Double.compare(o1.price, o2.price);
        }
    };

    public Item(String name, int quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    @Override
    public String toString() {
        return name + ", " + quantity + "×, " + price + "$";
    }

    @Override
    public int compareTo(Item o) {
        return Double.compare(this.price, o.price);
    }
}



