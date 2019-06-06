
package ImageHoster.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController{
    public HomeController() {
        System.out.println("Initializing Home Controller");
    }

    @RequestMapping("/")
    public String display(){
        return "index";
    }
}