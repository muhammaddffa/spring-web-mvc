package learnspringboot.webmvc.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthController {

    @PostMapping(path = "/auth/login", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseEntity<String> login(
            @RequestParam(name = "username") String username,
            @RequestParam(name = "password") String password) {
        if ("dade".equals(username) && "rahasia".equals(password)) {
//          return new ResponseEntity<>("OK", HttpStatus.OK);
            return ResponseEntity.status(HttpStatus.OK).body("OK");
        } else {
//          return new ResponseEntity<>("KO", HttpStatus.UNAUTHORIZED);
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("KO");
        }
    }
}
