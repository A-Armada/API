package br.com.tiagofernandes.armada.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

  @Autowired
  private IUserRepository userRepository;

  @PostMapping("/create")
  public ResponseEntity<UserModel> create(@RequestBody UserModel userModel) {
    var userCreated = this.userRepository.save(userModel);

    return ResponseEntity.status(HttpStatus.CREATED).body(userCreated);
  }
}
