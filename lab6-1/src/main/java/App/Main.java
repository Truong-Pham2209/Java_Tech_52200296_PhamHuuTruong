package App;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dto.Product;

public class Main {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

		Product product1a = (Product) context.getBean("product1");
		Product product1b = (Product) context.getBean("product1");

		Product product2a = (Product) context.getBean("product2");
		Product product2b = (Product) context.getBean("product2");

		Product product3a = (Product) context.getBean("product3");
		Product product3b = (Product) context.getBean("product3");

		System.out.println("Product 1a: " + product1a);
		System.out.println("Product 1b: " + product1b);
		System.out.println("Product 2a: " + product2a);
		System.out.println("Product 2b: " + product2b);
		System.out.println("Product 3a: " + product3a);
		System.out.println("Product 3b: " + product3b);

		System.out.println("\nProduct 1a == Product 1b: " + (product1a == product1b)); // prototype
		System.out.println("Product 2a == Product 2b: " + (product2a == product2b)); // prototype
		System.out.println("Product 3a == Product 3b: " + (product3a == product3b)); // singleton

		((ClassPathXmlApplicationContext) context).close();

	}
}
