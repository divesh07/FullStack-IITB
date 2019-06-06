package ImageHoster.controller;

import ImageHoster.model.Image;
import ImageHoster.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    //Write the code to inject the ImageService bean
    @Autowired
    ImageService imageService;

    @RequestMapping("/")
    public String getAllImages(Model model) {
        List<Image> images = new ArrayList<>();

        images = imageService.getAllImages();
        //Call getAllImages() method in ImageService class to get the list of all images
        //Add the list of images in the model with the key as "images"
        model.addAttribute("images", images);

        return "index";
    }
}