package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter client data:");
		System.out.print("Name: ");
		String name = sc.nextLine();
		
		System.out.print("Email: ");
		String email = sc.nextLine();
		
		System.out.print("Birth Date (DD/MM/YYYY): ");
		Date dataNascimento = sdf.parse(sc.nextLine());
		
		
		Client c1 = new Client(name, email, dataNascimento);
		
		System.out.println();
		System.out.println("Enter order data: ");
		System.out.println("Status: ");
		String status = sc.nextLine();
		
		System.out.print("How many items to his order? ");
		int n = sc.nextInt();
		sc.nextLine();
				
		Order order = new Order(01, new Date(), OrderStatus.valueOf(status), c1);
		
		for(int i=0; i<n;i++) {
			System.out.println();
			System.out.println("Enter #" + (1+i) + " item data: ");
			System.out.print("Product name: ");
			String pName = sc.nextLine();
			System.out.print("Product price: ");
			double pPrice = sc.nextDouble();
			System.out.print("Quantity: ");
			int pQuantity = sc.nextInt();
			sc.nextLine();
			
			Product p = new Product(pName, pPrice);
			OrderItem o = new OrderItem(pQuantity, pPrice, p);
			order.addItem(o);		
		}
						
		System.out.println();	
		System.out.println("ORDER SUMMARY:");		
		System.out.println(order);		
	}
}
