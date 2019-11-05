package com.infosys.springboot.restful.user;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/user/account/sum")
@RequiredArgsConstructor
public class AccountSumAPI {
	
	@Autowired
	UserService userService;
	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		List <User>users = userService.findAllUsers();
		users.forEach(x -> x.getAccounts().forEach(y -> x.setBalanceSum(y.getBalance())));
		return ResponseEntity.ok(users);
    }
}