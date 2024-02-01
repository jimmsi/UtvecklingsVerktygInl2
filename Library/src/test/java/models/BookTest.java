package models;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class BookTest {

	//G
	@Test
	public void test2EqualBooks() {

		Book b1 = new Book(1, "Fem på nya äventyr", "Enid Blyton",
				"ISBN13509135", "barn/ungdom", 250);
		Book b2 = new Book(1, "Fem på nya äventyr", "Enid Blyton",
				"ISBN13509135", "Barn/ungdom", 250);
		assertEquals(b1, b2);

	}

	//G
	@Test
	public void test2NonEqualBooks() {

		Book b1 = new Book(2, "Fem på nya äventyr", "Enid Blyton",
				"ISBN13509135", "barn/ungdom", 250);
		Book b2 = new Book(3, "Fem i fara", "Enid Blyton",
				"ISBN13509167", "Barn/ungdom", 233);
		assertNotEquals(b1, b2);

	}

}
