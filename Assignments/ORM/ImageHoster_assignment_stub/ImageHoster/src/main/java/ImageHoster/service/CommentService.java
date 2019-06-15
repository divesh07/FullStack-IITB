package ImageHoster.service;

import ImageHoster.model.Comments;
import ImageHoster.model.Image;
import ImageHoster.repository.CommentRepository;
import ImageHoster.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    //Call the getAllComments() method in the Repository and obtain a List of all the images in the database
    public List<Comments> getAllCOmments() {
        return commentRepository.getAllComments();
    }


}
