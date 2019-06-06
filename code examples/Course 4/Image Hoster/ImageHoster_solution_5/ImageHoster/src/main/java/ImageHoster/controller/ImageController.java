package ImageHoster.controller;

import ImageHoster.HardCodedImage;
import ImageHoster.model.Image;
import ImageHoster.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;

@Controller
public class ImageController {

    @Autowired
    private ImageService imageService;

    @Autowired
    private HardCodedImage hardCodedImage;

    //This method displays all the images in the user home page after successful login
    @RequestMapping("images")
    public String getUserImages(Model model) {
        List<Image> images = imageService.getAllImages();
        model.addAttribute("images", images);
        return "images";
    }

    //This method is called when the details of the specific image with corresponding title are to be displayed
    //The logic is to get the image from the databse with corresponding title. After getting the image from the database the details are shown
    //But since the images are not stored in the database, therefore, we have hard-coded two images here
    //If the title of the image is 'Dr. Strange', an image object is created with all the corresponding details
    //If the title of the image is 'SpiderMan', an image object is created with all the corresponding details
    //The image object is added to the model and 'images/image.html' file is returned
    @RequestMapping("/images/{title}")
    public String showImage(@PathVariable("title") String title, Model model) {
        Date date = new Date();
        Image image = null;
        if (title.equals("Dr. Strange")) {
            image = new Image(1, "Dr. Strange", hardCodedImage.getDrStrange(), "Dr. Strange has a time stone", date);
        } else if (title.equals("SpiderMan")) {
            image = new Image(2, "SpiderMan", hardCodedImage.getSpiderMan(), "Spider man dies in Infinity War", date);
        }

        model.addAttribute("image", image);
        return "images/image";
    }

    public HardCodedImage getHardCodedImage() {
        return hardCodedImage;
    }

    public void setHardCodedImage(HardCodedImage hardCodedImage) {
        this.hardCodedImage = hardCodedImage;
    }
}
