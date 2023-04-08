package vn.techmaster.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    // Xử lý request có đường dẫn "/register" với mọi HTTP method
    @RequestMapping("/register")
    public ResponseEntity<?> register() {
        return ResponseEntity.ok("resgiter");
    }

    // Xử lý request có đường dẫn "/login" với mọi HTTP method
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<?> login() {
        return ResponseEntity.ok("login");
    }
}
