package techBlog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import techBlog.model.Post;
import techBlog.repository.PostRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PostService {

    // Add deependency
    @Autowired
    private PostRepository repository;

    // Srping IOC container would call these default contructors
    public PostService() {
        System.out.println("**********Post Service**********");
    }

    public List<Post> getAllPosts() {
        return repository.getAllPosts();
    }


    public Post getLatestPost() {
        return repository.getLatestPost();
    }

    /*public ArrayList<Post> getOnePost() {
        ArrayList<Post> posts = new ArrayList<>();

        Post post1 = new Post();
        post1.setTitle("This is users first post");
        post1.setBody("Users first post body with valid content");
        post1.setDate(new Date());
        posts.add(post1);


        // JDBC code , to be replaced by JPA -> Hibernate
        Connection connection = null;
        try {
            // Load the driver
            Class.forName("org.postgresql.Driver");

            // DriverManager class in JDBC

            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5433/companydb", "postgres", "postgres");
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * FROM posts where id = 4");
            while (rs.next()) {
                Post post = new Post();
                post.setTitle(rs.getString("title"));
                post.setBody(rs.getString("body"));
                posts.add(post);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return posts;
    }*/

    public void createPost(Post newPost){
        newPost.setDate(new Date());
        repository.createPost(newPost);
        System.out.println("New Post :" + newPost);
    }
}
