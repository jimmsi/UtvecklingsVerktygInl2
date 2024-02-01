package models;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import utilities.GenderType;

import java.time.LocalDate;

public class LoanTest {

	//VG
	@Test
	public void testDueDate() {

		Customer customer = new Customer("Student", "Jimmy", "Emanuelsson",
				"Ostindiegatan 19F", "0707817888", "jimmyem@gmail.com",
				1, GenderType.MALE);
		Book b1 = new Book(1, "Fem på nya äventyr", "Enid Blyton",
				"ISBN13509135", "barn/ungdom", 250);
		Loan loan = new Loan(1, customer, b1);

		LocalDate dueDate = loan.getDueDate();
		LocalDate expectedDueDate = LocalDate.now().plusDays(14);

		assertEquals(expectedDueDate, dueDate, "Förfallodatum matchar inte förväntat förfallodatum");

   }
}