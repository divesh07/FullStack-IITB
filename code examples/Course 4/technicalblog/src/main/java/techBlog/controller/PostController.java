package techBlog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import techBlog.model.Post;
import techBlog.service.PostService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {

    @Autowired
    private PostService postService;

    @RequestMapping("posts")
    public String getUserPosts(Model model){

        //ArrayList<Post> posts = new ArrayList<>();
        //ArrayList<Post> posts = postService.getOnePost();
        //model.addAttribute("posts", posts);
        //Post latestPost = postService.getLatestPost();
        //posts.add(latestPost);
        //model.addAttribute("posts", latestPost);
        List<Post> posts = postService.getAllPosts();

        model.addAttribute("posts", posts);
        //redirects to post.html
        return "posts";
    }

    @RequestMapping("/posts/newpost")
    public String newPost() {
        // redirect to create.html
        return "posts/create";
    }

    @RequestMapping(value = "/posts/create", method = RequestMethod.POST)
    public String createPost(Post newPost) {
        postService.createPost(newPost);
        return "redirect:/posts"; // redirects to /posts
    }
}
