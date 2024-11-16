package com.example.tacos;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller //On it's own, @Controller doesn't do much. Its primary purpose is to identify this class as a component for
//Compoent scanning. Because HomeController is annotated with @Controller, Spring's component scanning automatically
//discovers it and creates an instance of HomeController as a bean in the Spring appication context.
public class HomeController {
    
    //The home method is as simple as controller methods come. It's annotated with @GetMapping to indicate that if an HTTP GET
    //request is received for the root path /, then this method should handle that request. It does so by doing nothing more than
    //returning a String value of home. This value is interpreted as the logical name of a view. How that view is implemented
    //depends on a few factors, but because Thymeleaf is in your classpath, you can define that template with Thymeleaf.
    @GetMapping("/")
    public String home() {
        return "home";
    }
}
