package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BookCatalogTest {

    private BookCatalog bc;
    private Book book1;

    public BookCatalogTest() {
        bc = new BookCatalog();
        book1 = new Book(1, "Learning Java", "", "", "", 0);
        bc.addBook(book1);
    }

    //G
    @Test
    public void testAddABook() {
        int initialBookCount = bc.getNumberOfBooks();
        Book newBook = new Book(2, "Java for Beginners", "Author Name", "ISBN123",
                "IT", 200);
        bc.addBook(newBook);
        assertEquals(initialBookCount + 1, bc.getNumberOfBooks());
    }

    //G
    @Test
    public void testFindBook() throws BookNotFoundException {

        Book foundBook = bc.findBook("Learning Java");
        assertEquals(book1.getTitle(), foundBook.getTitle(), "Bokens titel matchar inte förväntad titel");
        assertEquals(book1.getAuthor(), foundBook.getAuthor(), "Bokens författare matchar inte förväntad författare");
        assertEquals(book1.getIsbn(), foundBook.getIsbn(), "Bokens ISBN matchar inte förväntad ISBN");

    }

    //G
    @Test
    public void testFindBookIgnoringCase() throws BookNotFoundException {

        Book foundBook = bc.findBook("learning java");
        assertEquals(book1.getTitle(), foundBook.getTitle(), "Bokens titel matchar inte förväntad titel");
        assertEquals(book1.getAuthor(), foundBook.getAuthor(), "Bokens författare matchar inte förväntad författare");
        assertEquals(book1.getIsbn(), foundBook.getIsbn(), "Bokens ISBN matchar inte förväntad ISBN");

    }

    //G
    @Test
    public void testFindBookWithExtraSpaces() throws BookNotFoundException {

        Book foundBook = bc.findBook("    learning java   ");
        assertEquals(book1.getTitle(), foundBook.getTitle(), "Bokens titel matchar inte förväntad titel");
        assertEquals(book1.getAuthor(), foundBook.getAuthor(), "Bokens författare matchar inte förväntad författare");
        assertEquals(book1.getIsbn(), foundBook.getIsbn(), "Bokens ISBN matchar inte förväntad ISBN");

    }

    //VG
    // This test should throw BookNotFoundException in order to pass.
    @Test
    public void testFindBookThatDoesntExist() throws BookNotFoundException {

        assertThrows(BookNotFoundException.class, () -> {
            bc.findBook("Learning not Java");
        }, "Boken hittades inte i katalogen");

    }

}
