package vn.techzen.academy_12.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class HelloWorldController {
    @RequestMapping("/greeting")
    public ResponseEntity<String> greeting(@RequestParam(defaultValue = "") String name) {
        String message = String.format("Hello %s!!!", name.isEmpty() ? "" : name);
        return ResponseEntity.ok(message);
    }
}
