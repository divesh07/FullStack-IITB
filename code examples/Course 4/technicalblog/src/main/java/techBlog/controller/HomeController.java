package techBlog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import techBlog.model.Post;
import techBlog.service.PostService;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    // Srping IOC container would call these default contructors
    public HomeController() {
        System.out.println("Home Controller");
    }

    // Auto wired is used for dependency injection
    // Gets the object of Post class without using the new operator
    @Autowired
    public PostService postService;

    @RequestMapping("/")
    public String getAllPosts(Model model) {
        // Check all the posts when on home page
        //ArrayList<Post> posts = postService.getAllPosts();
        List<Post> posts = postService.getAllPosts();
        model.addAttribute("posts", posts);

        return "index";
    }

    @RequestMapping("/info")
    public String testAssignment(Model model) {
        // Check all the posts when on home page
        return "feature/info";
    }

}
