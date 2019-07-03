import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Lab9 {
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		System.out.println("Welcome to Graham's Market!");
		System.out.println();
		System.out.println("Item             Price");
		System.out.println("=======================");

		HashMap<String, Double> items = new HashMap<>();
		items.put("Apple", 0.69);
		items.put("Banana", 0.89);
		items.put("Orange", 0.79);
		items.put("Pear", 0.59);
		items.put("Steak", 9.99);
		items.put("Fish", 13.99);
		items.put("Crackers", 1.99);
		items.put("Nuts", 1.59);

		ArrayList<String> order = new ArrayList<>();
		ArrayList<Double> prices = new ArrayList<>();
		ArrayList<Integer> quantities = new ArrayList<>();
		String[] itemsArray = new String[8];
		itemsArray = items.keySet().toArray(itemsArray);
		char answer = 'y';

		do {
			for(int i = 0; i < items.size(); i++) {
				System.out.printf("%-11s      %-10s\n", (i+1) + ": " + items.keySet().toArray()[i], 
						"$ " + items.values().toArray()[i]);
			}
			System.out.println("What would you like to order? (enter a number)");
			try {
				int selection = input.nextInt();
				if(selection > 0 && selection < 9) {
					order.add(itemsArray[selection-1]);
					prices.add(items.get(itemsArray[selection-1]));
					System.out.println("How many would you like to order?");
					int quantity = input.nextInt();
					quantities.add(quantity);
				} else {
					System.out.println("I'm sorry, we don't carry that item.");
				} 
			} catch (java.util.InputMismatchException ex) {
				System.out.println("I'm sorry, we don't carry that item.");
				input.nextLine();
			}
			System.out.println("Would you like to continue? (y/n)");
			answer = input.next().charAt(0);
		} while	(answer == 'y' || answer == 'Y');
		
		System.out.println("Item                 Price");
		System.out.println("===========================");
		
		for(int i = 0; i < order.size(); i++) {
			System.out.printf("%-15s      %-10s\n", (i+1) + ": " + order.get(i)
			+ " x " + quantities.get(i), "$" + prices.get(i));
		}
		
		System.out.println();
		Double sum = 0.0;
		for(int i = 0; i < prices.size(); i ++) {
			sum += prices.get(i)*quantities.get(i);
		}
		
		System.out.println("Total: $" + sum);
		System.out.println("Average Price: $" + average(prices));
		System.out.println("Most expensive item: " + mostExpensive(prices, order));
		System.out.println("Least expensive item: " + leastExpensive(prices, order));
	}
	
	public static Double average(ArrayList<Double> list) {
		Double sum = 0.0;
		for(int i = 0; i < list.size(); i ++) {
			sum += list.get(i);
		}
		sum /= list.size();
		int format = (int) (sum*100);
		Double average = format/100.00;
		return average;
	}
	
	public static String mostExpensive(ArrayList<Double> list, ArrayList<String> string) {
		int x = list.indexOf(Collections.max(list));
		return string.get(x);
	}
	
	public static String leastExpensive(ArrayList<Double> list, ArrayList<String> string) {
		int x = list.indexOf(Collections.min(list));
		return string.get(x);
	}
}
