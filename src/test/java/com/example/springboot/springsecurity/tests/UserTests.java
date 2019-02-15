package com.example.springboot.springsecurity.tests;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.springboot.springsecurity.model.Role;
import com.example.springboot.springsecurity.model.User;
import com.example.springboot.springsecurity.repository.UserRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
@Transactional(propagation = Propagation.NOT_SUPPORTED)
public class UserTests {
	
	@Autowired
    private UserRepository userRepository;	

	@Test
	public void test() {
		User user = new User();
		user.setEmail("test@test.com");
		user.setFirstName("Santiago");
		user.setLastName("Rodriguez");
		user.setPassword("qwerty");	
		user.setRoles(Arrays.asList(new Role("ROLE_USER")));
		
		User created = userRepository.save(user);
		
		System.out.println(created.getEmail());
		
	}
	
	@Test	
	public void testB() {
		User user = userRepository.getOne(-1L);
		
		//assertNotNull(user);
		System.out.println(user.getEmail());
	}

}
