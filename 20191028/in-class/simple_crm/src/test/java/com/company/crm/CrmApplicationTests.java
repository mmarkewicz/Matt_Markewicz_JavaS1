package com.company.crm;

import com.company.crm.dao.CustomerRepository;
import com.company.crm.dao.NoteRepository;
import com.company.crm.dto.Customer;
import com.company.crm.dto.Note;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CrmApplicationTests {

	@Autowired
    CustomerRepository customerRepo;

	@Autowired
    NoteRepository noteRepo;

	@Test
	public void contextLoads() {
	}

	@Test
	public void createTest() {
		noteRepo.deleteAll();
		customerRepo.deleteAll();

		Note note = new Note();
		note.setContent("This is a test note");
		Set<Note> noteSet = new HashSet<>();
		noteSet.add(note);

		Note note2 = new Note();
		note2.setContent("This is the SECOND test note.");
		noteSet.add(note2);

		Customer customer = new Customer();
        customer.setFirstName("Joe");
        customer.setLastName("Smith");
        customer.setPhone("111-222-3456");
        customer.setCompany("BigCo");
        customerRepo.save(customer);
        note.setCustomerId(customer.getId());
        note2.setCustomerId(customer.getId());

		noteRepo.save(note);
		noteRepo.save(note2);

		List<Customer> customerList = customerRepo.findAll();
		assertEquals(1, customerList.size());

		noteSet =  customerList.get(0).getNotes();
		assertEquals(2, noteSet.size());

	}
}
