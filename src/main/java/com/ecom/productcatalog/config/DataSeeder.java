package com.ecom.productcatalog.config;

import com.ecom.productcatalog.model.Category;
import com.ecom.productcatalog.model.Product;
import com.ecom.productcatalog.repository.CategoriesRepo;
import com.ecom.productcatalog.repository.ProductRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DataSeeder implements CommandLineRunner {

    private final CategoriesRepo categoriesRepo;
    private final ProductRepo productRepo;

    public DataSeeder(CategoriesRepo categoriesRepo, ProductRepo productRepo) {
        this.categoriesRepo = categoriesRepo;
        this.productRepo = productRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        if (productRepo.count() == 0 && categoriesRepo.count() == 0) {
            // create categories
            Category Electronics = new Category();
            Electronics.setName("Electronics");

            Category Home = new Category();
            Home.setName("Home");

            Category Kitchen = new Category();
            Kitchen.setName("Kitchen");

            Category Decor = new Category();
            Decor.setName("Decor");

            categoriesRepo.saveAll(Arrays.asList(Electronics, Home, Kitchen, Decor));

            // create products
            Product Phone = new Product();
            Phone.setName("Phone");
            Phone.setDescription("Latest Smart Phone");
            Phone.setImageUrl("https://placehold.co/600x400");
            Phone.setPrice(799.99);
            Phone.setCategory(Electronics);

            Product Laptop = new Product();
            Laptop.setName("Laptop");
            Laptop.setDescription("Latest M4 Pro chip Macbook Pro");
            Laptop.setImageUrl("https://placehold.co/600x400");
            Laptop.setPrice(50000.00);
            Laptop.setCategory(Electronics);

            Product TV = new Product();
            TV.setName("TV");
            TV.setDescription("Latest OLED Smart TV ");
            TV.setImageUrl("https://placehold.co/600x400");
            TV.setPrice(10000.00);
            TV.setCategory(Electronics);

            Product Knife = new Product();
            Knife.setName("Knife");
            Knife.setDescription("Japanese steel Knife");
            Knife.setImageUrl("https://placehold.co/600x400");
            Knife.setPrice(599.99);
            Knife.setCategory(Kitchen);

            Product Pan = new Product();
            Pan.setName("Pan");
            Pan.setDescription("Stainless Steel Pan");
            Pan.setImageUrl("https://placehold.co/600x400");
            Pan.setPrice(299.99);
            Pan.setCategory(Kitchen);

            Product Apron = new Product();
            Apron.setName("Apron");
            Apron.setDescription(" Coton Apron with protective layer to prevent stains");
            Apron.setImageUrl("https://placehold.co/600x400");
            Apron.setPrice(399.99);
            Apron.setCategory(Kitchen);

            Product Carpet = new Product();
            Carpet.setName("Carpet");
            Carpet.setDescription("Persian Carpet");
            Carpet.setImageUrl("https://placehold.co/600x400");
            Carpet.setPrice(11756.99);
            Carpet.setCategory(Home);

            Product Table = new Product();
            Table.setName("Table");
            Table.setDescription("Table made of the most premium teakwood");
            Table.setImageUrl("https://placehold.co/600x400");
            Table.setPrice(20000.00);
            Table.setCategory(Home);

            Product Shoerack = new Product();
            Shoerack.setName("Shoerack");
            Shoerack.setDescription("Shoerack with multiple shelves");
            Shoerack.setImageUrl("https://placehold.co/600x400");
            Shoerack.setPrice(7000.00);
            Shoerack.setCategory(Home);

            Product Painting = new Product();
            Painting.setName("Painting");
            Painting.setDescription("painting by Mushasi-San");
            Painting.setImageUrl("https://placehold.co/600x400");
            Painting.setPrice(15000.00);
            Painting.setCategory(Decor);

            Product Vase = new Product();
            Vase.setName("Vase");
            Vase.setDescription("Porcelain Vase");
            Vase.setImageUrl("https://placehold.co/600x400");
            Vase.setPrice(799.99);
            Vase.setCategory(Decor);

            productRepo.saveAll(Arrays.asList(Phone, Laptop, TV, Knife, Pan, Apron, Carpet, Table, Shoerack, Painting, Vase));
        }
    }
}
