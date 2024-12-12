package vn.techzen.academy_12.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    @RequestMapping("/greeting")
    public String greeting(@RequestParam(defaultValue = "") String name) {
        return String.format("Hello  %s!!! " ,name);
    }

}
