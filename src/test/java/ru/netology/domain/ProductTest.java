package ru.netology.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.manager.ProductManager;
import ru.netology.repository.Repository;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    private final Repository repository = new Repository();
    private final ProductManager manager = new ProductManager(repository);

    Product product1 = new Book(1, "Maxoynee 1", 100, "Минтимер Шаймиев");
    Product product2 = new Book(2, "Maxoynee 2", 200, "Минтимер Шаймиев");
    Product product3 = new Book(3, "Maxoynee 3", 301, "Минтимер Шаймиев");
    Product product4 = new Smartphone(4, "Maxphone", 1000, "Samsung");
    Product product5 = new Smartphone(5, "Maxapple", 2000, "Apple");
    Product product6 = new Smartphone(6, "MaxBBK", 3001, "BBK Electronics");


    @BeforeEach
    void setUp() {
        manager.add(product1);
        manager.add(product2);
        manager.add(product3);
        manager.add(product4);
        manager.add(product5);
        manager.add(product6);

    }


    @Test
    void searchBySmartphoneName() {
        Product[] actual = manager.searchBy("MaxBBK");
        Product[] expected = {product6};
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchByBookName() {
        Product[] actual = manager.searchBy("Maxoynee 1");
        Product[] excepted = {product1};
        assertArrayEquals(excepted, actual);


    }

    @Test
    void shouldFindSomeProducts() {
        Product[] actual = manager.searchBy("Maxoynee");
        Product[] excepted = {product1, product2, product3};
        Assertions.assertArrayEquals(excepted, actual);
    }

    @Test
    void shouldFindOneProduct() {
        Product[] actual = manager.searchBy("Maxoynee 1");
        Product[] excepted = {product1};
        assertArrayEquals(excepted, actual);
    }

    @Test
    void shouldFindZeroProduct() {
        Product[] actual = manager.searchBy("Iphone");
        Product[] excepted = {};
        assertArrayEquals(excepted, actual);
    }
}