package ca.wglabs.hello;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
@EnableAutoConfiguration
public class HelloController {

    @RequestMapping("/")
    @ResponseBody
    String ping() {
        return "Hello World! " + new Date();
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(HelloController.class, args);
    }
}
