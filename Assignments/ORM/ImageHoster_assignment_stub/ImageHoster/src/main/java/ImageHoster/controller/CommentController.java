package ImageHoster.controller;

import ImageHoster.model.Comments;
import ImageHoster.model.Image;
import ImageHoster.service.CommentService;
import ImageHoster.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;

    @RequestMapping("/comments")
    public String getAllComments(Model model) {
        List<Comments> comments = commentService.getAllCOmments();
        model.addAttribute("comments", comments);
        return "index";
    }
}