import java.util.Scanner;
import java.util.Arrays;

public class FractionalKnapsack {

    static class Item {
        int value, weight;

        Item(int value, int weight) {
            this.value = value;
            this.weight = weight;
        }
    }

    // Comparison function: sorts items by value/weight ratio (descending)
    static void sortItemsByRatio(Item[] arr) {
        Arrays.sort(arr, (a, b) -> {
            double r1 = (double) a.value / a.weight;
            double r2 = (double) b.value / b.weight;
            return Double.compare(r2, r1);
        });
    }

    static double fractionalKnapsack(int capacity, Item[] arr) {
        sortItemsByRatio(arr);

        int currentWeight = 0;
        double finalValue = 0.0;

        for (Item item : arr) {
            if (currentWeight + item.weight <= capacity) {
                currentWeight += item.weight;
                finalValue += item.value;
            } else {
                int remain = capacity - currentWeight;
                finalValue += ((double) item.value / item.weight) * remain;
                break;
            }
        }

        return finalValue;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of items: ");
        int n = sc.nextInt();

        System.out.print("Enter knapsack capacity: ");
        int capacity = sc.nextInt();

        Item[] arr = new Item[n];

        System.out.println("Enter value and weight for each item:");
        for (int i = 0; i < n; i++) {
            System.out.print("Item " + (i + 1) + " - Value: ");
            int value = sc.nextInt();
            System.out.print("Item " + (i + 1) + " - Weight: ");
            int weight = sc.nextInt();
            arr[i] = new Item(value, weight);
        }

        double maxValue = fractionalKnapsack(capacity, arr);
        System.out.printf("The maximum value is: %.2f\n", maxValue);

        sc.close();
    }
}
