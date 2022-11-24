package ru.netology.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.manager.ProductManager;
import ru.netology.repository.Repository;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    private Repository repository = new Repository();
    private ProductManager manager = new ProductManager(repository);

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
    void searchByManufacturer() {

        Product[] actual = manager.searchBy("Samsung");
        Product[] expected = {
                new Smartphone(4, "Maxphone", 1000, "Samsung")
        };
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchBySmartphoneName() {
        Product[] actual = manager.searchBy("MaxBBK");
        Product[] expected = {new Smartphone(6, "MaxBBK", 3001, "BBK Electronics")};
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchByBookName() {
        Product[] actual = manager.searchBy("Maxoynee 1");
        Product[] excepted = {new Book(1, "Maxoynee 1", 100, "Минтимер Шаймиев")};
        assertArrayEquals(excepted, actual);
    }

    @Test
    void searchByAuthor() {
        Product[] actual = manager.searchBy("Минтимер Шаймиев");
        Product[] expected = {
                new Book(1, "Maxoynee 1", 100, "Минтимер Шаймиев"),
                new Book(2, "Maxoynee 2", 200, "Минтимер Шаймиев"),
                new Book(3, "Maxoynee 3", 301, "Минтимер Шаймиев"),
        };
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchByWrongBrand() {
        Product[] actual = manager.searchBy("Максоуни 1");
        Product[] expected = {};
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchByWrongAuthor() {
        Product[] actual = manager.searchBy("Он");
        Product[] expected = {};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindTheSameText() {
        Product[] expected = {product1, product2, product3};
        Product[] actual = manager.searchBy("Минтимер Шаймиев");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveById() {

        repository.removeById(4);
        Product[] actual = repository.findAll();
        Product[] expected = {
                new Book(1, "Maxoynee 1", 100, "Минтимер Шаймиев"),
                new Book(2, "Maxoynee 2", 200, "Минтимер Шаймиев"),
                new Book(3, "Maxoynee 3", 301, "Минтимер Шаймиев"),
                new Smartphone(5, "Maxapple", 2000, "Apple"),
                new Smartphone(6, "MaxBBK", 3001, "BBK Electronics"),

        };
        assertArrayEquals(expected, actual);
    }


}