package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import dto.Product;

@Configuration
public class AppConfig {

    @Bean(name = "product1")
    @Scope("singleton")
    public Product product1() {
        return new Product(1, "Product One", 100.0, "This is the first product.");
    }

    @Bean
    @Scope("prototype")
    public Product product2() {
    	Product product= new Product();
    	product.setId(2);
    	product.setName("Product Two");
    	product.setPrice(200.0);
    	product.setDescription("This is the first product.");
        return product;
    }

    @Bean
    public Product product3() {
        return new Product(3, "Product Three", 100.0, "This is the first product.");
    }

}
