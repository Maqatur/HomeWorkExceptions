package ru.netology.homework.exceptions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductTest {
    Product product = new Product (5, "First", 50);

    @Test
    public void findByIdPositiveTest() {
        ShopRepository shopRepository = new ShopRepository();
        shopRepository.findById(5);

        int expected = 5;
        int actual = product.getId();

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void findByIdNegativeTest() {
        ShopRepository shopRepository = new ShopRepository();
        shopRepository.findById(3);

        Product expected = null;
        Product actual = shopRepository.findById(3);

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void removeTest() {
        ShopRepository shopRepository = new ShopRepository();
        shopRepository.add(product);
        shopRepository.remove(5);

        Product[] expected = {};
        Product[] actual = shopRepository.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void notFoundExceptionsTest() {
        ShopRepository shopRepository = new ShopRepository();
        shopRepository.add(product);

        Assertions.assertThrows(NotFoundException.class, () -> {
            shopRepository.remove(-1);
        });
    }

}
