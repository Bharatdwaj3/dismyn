import java.util.*;

public class FractionalKnapsack {
    static class Item {
        int weight, value;
        Item(int v, int w) { value = v; weight = w; }
    }

    public static double getMaxValue(Item[] items, int W) {
        Arrays.sort(items, (a, b) -> Double.compare((double)b.value/b.weight, (double)a.value/a.weight));
        double total = 0;
        for (Item item : items) {
            if (W >= item.weight) {
                W -= item.weight;
                total += item.value;
            } else {
                total += (double)item.value * W / item.weight;
                break;
            }
        }
        return total;
    }

    public static void main(String[] args) {
        Item[] items = { new Item(60, 10), new Item(100, 20), new Item(120, 30) };
        System.out.println(getMaxValue(items, 50));
    }
}