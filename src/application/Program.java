package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entites.ImportedProduct;
import entites.Product;
import entites.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
	
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Product> products = new ArrayList<>();
		
		System.out.print("Enter the number of products: ");
		int n = sc.nextInt();
		
		for(int i = 0; i < n; i++) {
			System.out.println("Product #" + (i+1) + " data:");
			System.out.print("Common, used or imported (c/u/i)? ");
			char type = sc.next().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Price: ");
			double price = sc.nextDouble();
		
			if(type == 'c') {
				products.add(new Product(name,price));
				System.out.println();
			}
			else if (type == 'i') {
				System.out.print("Customs fee: ");
				double customsFee = sc.nextDouble();
				products.add(new ImportedProduct(name,price,customsFee));
				System.out.println();
			}
			else {
				System.out.print("Manufacture date (DD/MM/YYYY): ");
				Date manufactureDate = sdf2.parse(sc.next());
				products.add(new UsedProduct(name,price,manufactureDate));
				System.out.println();
			}
		}
		System.out.println("PRICE TAGS:");
		for(Product x : products) {
			System.out.println(x.priceTag());
			
		}
		
		
		
		sc.close();

	}

}
