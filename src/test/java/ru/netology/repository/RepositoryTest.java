package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

import static org.junit.jupiter.api.Assertions.*;

class RepositoryTest {

    private final Repository repository = new Repository();


    Product product1 = new Book(1, "Maxoynee 1", 100, "Минтимер Шаймиев");
    Product product2 = new Book(2, "Maxoynee 2", 200, "Минтимер Шаймиев");
    Product product3 = new Book(3, "Maxoynee 3", 301, "Минтимер Шаймиев");
    Product product4 = new Smartphone(4, "Maxphone", 1000, "Samsung");
    Product product5 = new Smartphone(5, "Maxapple", 2000, "Apple");
    Product product6 = new Smartphone(6, "MaxBBK", 3001, "BBK Electronics");


    @BeforeEach
    void setUp() {
        repository.save(product1);
        repository.save(product2);
        repository.save(product3);
        repository.save(product4);
        repository.save(product5);
        repository.save(product6);

    }

    @Test
    void shouldRemoveById() {

        repository.removeById(2);
        Product[] actual = repository.findAll();
        Product[] expected = {product1, product3, product4, product5, product6};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindAll() {
        Product[] actual = repository.findAll();
        Product[] expected = {product1, product2, product3, product4, product5, product6};
        assertArrayEquals(expected, actual);
    }


}