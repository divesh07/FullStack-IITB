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
public class ImageController {

    @Autowired
    private ImageService imageService;

    //This method displays all the images in the user home page after successful login
    @RequestMapping("images")
    public String getUserImages(Model model) {
        //Complete the method
        //Get all the hard-coded images in the application using getAllImages() method in ImageService class and add them to the model with 'images' as the key
        List<Image> images = new ArrayList<>();
        images = imageService.getAllImages();
        model.addAttribute("images",images);
        return "images";
    }
}
