package ImageHoster.controller;

import ImageHoster.model.Comment;
import ImageHoster.model.Image;
import ImageHoster.model.User;
import ImageHoster.service.CommentService;
import ImageHoster.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private ImageService imageService;

    @RequestMapping(value = "/image/{imageId}/{imageTitle}/comments", method = RequestMethod.POST)
    public String getAllComments(@RequestParam("comment") String description, @PathVariable("imageId") Integer imageId, @PathVariable("imageTitle") String imageTitle, Model model, HttpSession session) {
        List<Comment> comments = new ArrayList<>();
        // Alternate way to get All images using repository
        //comments = commentService.getAllCommentsForImage(imageId);

        Comment comment = new Comment();
        Image image = imageService.getImageById(imageId);
        model.addAttribute("image", image);
        model.addAttribute("tags", image.getTags());
        try {
            comment.setCreatedDate(new Date());
            comment.setUser((User) session.getAttribute("loggeduser"));
            comment.setText(description);
            comment.setImage(image);
            comments.add(comment);
            commentService.createComment(comment);
            //model.addAttribute("comments", comments);
            model.addAttribute("comments", image.getComments());

        } catch (Exception e) {
            System.out.println("Exception caught while trying to read comment");
            return "images/image";
        }
        return "images/image";
    }

}