package ProductManager;
import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RepositoryTest {
    @Test
    public void testRemoveWhenProductExist() {
        Repository repo = new Repository();

        Book book1 = new Book(1, "Sherlock Holmes and Dr. Watson", 100, "A.C.Doyle");
        Book book2 = new Book(2, "Gone with the Wind", 200, "M.Mitchell");
        Book book3 = new Book(3, "Jane Eyre", 300, "Charlotte Bronte");

        repo.add(book1);
        repo.add(book2);
        repo.add(book3);
        repo.removeById(1);
        Product[] actual = repo.findAll();
        Product[] expected = {book2, book3};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void TestRemoveById() {
        Repository repo = new Repository();

        Book book1 = new Book(1, "Sherlock Holmes and Dr. Watson", 100, "A.C.Doyle");
        Book book2 = new Book(2, "Gone with the Wind", 200, "M.Mitchell");
        Book book3 = new Book(3, "Jane Eyre", 300, "Charlotte Bronte");

        repo.add(book1);
        repo.add(book2);
        repo.add(book3);
        repo.removeById(2);
        Product[] actual = repo.findAll();
        Product[] expected = {book1, book3};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void TestSmartphone() {
        Repository repo = new Repository();
        Smartphone smartphone1 = new Smartphone(11, "Samsung S21", 515, "Samsung");
        Smartphone smartphone2 = new Smartphone(12, "Samsung S22", 212, "Samsung");
        Smartphone smartphone3 = new Smartphone(13, "Samsung S20", 474, "Samsung");

        repo.add(smartphone1);
        repo.add(smartphone2);
        repo.add(smartphone3);
        Product[] actual = repo.findAll();
        Product[] expected = {smartphone1, smartphone2, smartphone3};
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void TestSmartphoneAndBook() {
        Repository repo = new Repository();

        Smartphone smartphone1 = new Smartphone(11, "Samsung S21", 515, "Samsung");
        Smartphone smartphone2 = new Smartphone(12, "Samsung S22", 212, "Samsung");
        Book book1 = new Book(1, "Sherlock Holmes and Dr. Watson", 100, "A.C.Doyle");

        repo.add(smartphone1);
        repo.add(smartphone2);
        repo.add(book1);
        Product[] actual = repo.findAll();
        Product[] expected = {smartphone1, smartphone2, book1};
        Assertions.assertArrayEquals(expected, actual);

    }
    @Test
    public void testRemoveWhenProductNotExist() {
        Repository repo = new Repository();
        Book book1 = new Book(1, "Sherlock Holmes and Dr. Watson", 100, "A.C.Doyle");
        Book book2 = new Book(2, "Gone with the Wind", 200, "M.Mitchell");
        Book book3 = new Book(3, "Jane Eyre", 300, "Charlotte Bronte");
        repo.add(book1);
        repo.add(book2);
        repo.add(book3);
        repo.removeById(4);
        Product[] actual = repo.findAll();
        Product[] expected = {book1, book2, book3};
        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void test1RemoveWhenProductNotExist() {
        Repository repo = new Repository();
        Book book1 = new Book(1, "Sherlock Holmes and Dr. Watson", 100, "A.C.Doyle");
        Book book2 = new Book(2, "Gone with the Wind", 200, "M.Mitchell");
        Book book3 = new Book(3, "Jane Eyre", 300, "Charlotte Bronte");
        repo.add(book1);
        repo.add(book2);
        repo.add(book3);

        Assertions.assertThrows(NotFoundException.class,
                () -> repo.removeById(4)
        );
    }
}





