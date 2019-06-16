package ImageHoster.repository;

import ImageHoster.model.Comment;
import ImageHoster.model.Tag;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

//The annotation is a special type of @Component annotation which describes that the class defines a data repository
@Repository
public class CommentRepository {

    //Get an instance of EntityManagerFactory from persistence unit with name as 'imageHoster'
    @PersistenceUnit(unitName = "imageHoster")
    private EntityManagerFactory emf;

    public Comment createComment(Comment comment) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            em.persist(comment);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
        return comment;
    }

    //The method creates an instance of EntityManager
    //Executes JPQL query to fetch all the comments from the database
    //Returns the list of all the comments fetched from the database
    public List<Comment> getAllComments() {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Comment> query = em.createQuery("SELECT c from Comment c", Comment.class);
        return query.getResultList();
    }

    public List<Comment> getAllCommentsForImage(Integer imageId) {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Comment> query = em.createQuery("SELECT c from Comment c where c.image = :image", Comment.class).setParameter("image", imageId);
        return query.getResultList();
    }

}
