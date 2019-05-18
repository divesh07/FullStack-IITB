package springboot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.net.www.content.text.plain;

@Controller
public class mvcController {

    @RequestMapping("/hellospringHtml")
    //@ResponseBody // disable this so that call is intercepter by view resolver thymeleaf in this case
    // which maps the view name -> index to view -> index.html and sends it back to dispatcher servlet
    public String helloSpringHtml(){
        return "index"; // checks for index.html in resources
    }

    @RequestMapping("/hellospring")
    public String helloSpring(){
        return "techblog";
    }

    @RequestMapping("/hellospringtext")
    @ResponseBody //- to directly retuns this as response plain text
    public String helloSpringText(){
        return "Hello Spring";
    }
}
