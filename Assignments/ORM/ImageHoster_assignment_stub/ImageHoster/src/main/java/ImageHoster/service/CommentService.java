package ImageHoster.service;

import ImageHoster.model.Comment;
import ImageHoster.model.Tag;
import ImageHoster.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    public Comment createComment(Comment comment) {
        return commentRepository.createComment(comment);
    }
    //Call the getAllComments() method in the Repository and obtain a List of all the images in the database
    public List<Comment> getAllComments() {
        return commentRepository.getAllComments();
    }


    public List<Comment> getAllCommentsForImage(Integer imageId) {
        return commentRepository.getAllCommentsForImage(imageId);
    }

}
