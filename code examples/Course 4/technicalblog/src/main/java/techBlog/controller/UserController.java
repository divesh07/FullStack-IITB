package techBlog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import techBlog.model.Post;
import techBlog.model.User;
import techBlog.service.PostService;
import techBlog.service.UserService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    PostService postService;

    @Autowired
    UserService userService;

    @RequestMapping("clickPost")
    public String clickPost()
    {
        return "UnderConstruction";
    }

    @RequestMapping("users/login")
    public String login(){
        return "users/login";
    }

    @RequestMapping(value = "users/login", method = RequestMethod.POST)
    public String loginUser(User user){
        // redirect to controller listening to /posts
        if ( userService.login(user)) {
            return "redirect:/posts";
        }else{
            return "users/login";
        }
    }

    @RequestMapping(value = "users/logout", method = RequestMethod.POST)
    public String logoutUser(Model model){
        //ArrayList<Post> posts = postService.getAllPosts();
        List<Post> posts = postService.getAllPosts();
        // redirect to index.html
        model.addAttribute("posts", posts);
        return "index";
    }

    // This is the default GET method
    @RequestMapping("users/registration")
    public String registration(){
        //redirects to users/registation.html
        return "users/registration";
    }

    @RequestMapping(value = "users/registration", method = RequestMethod.POST)
    public String registerUser(User user){
        // redirect to controller listening to /posts
        return "users/login";
    }


}
