package com.myorg.spring.useraction.api;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.myorg.spring.useraction.api.dao.UserRepository;
import com.myorg.spring.useraction.api.model.User;
import com.myorg.spring.useraction.api.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootMockitoApplicationTests {

	@Autowired
	private UserService service;

	@MockBean
	private UserRepository repository;

	@SuppressWarnings("unchecked")
	@Test
	public void getUsersTest() {
		when(repository.findAll()).thenReturn(Stream
				.of(new User(01, "param", "j", 97, "p@p.gmail.com", "addr1",
						"unit test 1", null, null),
						new User(02, "ram", "s", 80, "r@r.gmail.com", "addr2",
								"unit test 2", null, null))
				.collect(Collectors.toList()));
		assertEquals(2, service.getUsers().size());
	}

	@Test
	public void getUserbyAddressTest() {
		String address = "Bangalore";
		when(repository.findByAddress(address)).thenReturn(Stream
				.of(new User(01, "param", "j", 97, "p@p.gmail.com", "addr1",
						"unit test 1", null, null))
				.collect(Collectors.toList()));
		assertEquals(1, service.getUserbyAddress(address).size());
	}

	@Test
	public void saveUserTest() {
		User user = new User(01, "param", "j", 97, "p@p.gmail.com", "addr1",
				"unit test 1", null, null);
		when(repository.save(user)).thenReturn(user);
		assertEquals(user, service.addUser(user));
	}

	@Test
	public void deleteUserTest() {
		User user = new User(01, "param", "j", 97, "p@p.gmail.com", "addr1",
				"unit test 1", null, null);
		service.deleteUser(user);
		verify(repository, times(1)).delete(user);
	}
	@Test(expected = Exception.class)
	public void exceptionWhileSavingData() {
		User user = new User(01, "name_morethan_db_column_size", "j", 97,
				"p@p.gmail.com", "addr1", "unit test 1", null, null);
		// when(myRepository.save(any())).thenThrow(Exception.class);
		when(repository.save(user)).thenThrow(Exception.class);
	}

}
