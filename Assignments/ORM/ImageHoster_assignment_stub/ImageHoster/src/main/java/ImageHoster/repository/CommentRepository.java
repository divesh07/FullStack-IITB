package ImageHoster.repository;

import ImageHoster.model.Comments;
import ImageHoster.model.Image;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

//The annotation is a special type of @Component annotation which describes that the class defines a data repository
@Repository
public class CommentRepository {

    //Get an instance of EntityManagerFactory from persistence unit with name as 'imageHoster'
    @PersistenceUnit(unitName = "imageHoster")
    private EntityManagerFactory emf;


    //The method creates an instance of EntityManager
    //Executes JPQL query to fetch all the comments from the database
    //Returns the list of all the comments fetched from the database
    public List<Comments> getAllComments() {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Comments> query = em.createQuery("SELECT c from Comments c", Comments.class);
        return query.getResultList();
    }

}
