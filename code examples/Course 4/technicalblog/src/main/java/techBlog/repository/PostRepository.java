package techBlog.repository;

import org.springframework.stereotype.Repository;
import techBlog.model.Post;

import javax.persistence.*;
import java.util.List;

@Repository
public class PostRepository {

    // injects Entity Manager Factory
    @PersistenceUnit(unitName = "technicalblog")
    private EntityManagerFactory emf;

    public List<Post> getAllPosts(){

        // Create Enity manager instance
        EntityManager em = emf.createEntityManager();

        // Use JPQL ( JPA Query Lang )
        TypedQuery<Post> query = em.createQuery("select p from Post p", Post.class);

        final List<Post> resultList = query.getResultList();

        //query.getSingleResult();
        return resultList;
    }

    public Post getLatestPost(){
        final EntityManager em = emf.createEntityManager();

        // finds record based on the primary key
        return em.find(Post.class, 3); // find the record in the post table where primary key ( id == 3 )

    }

    public Post createPost(Post newPost){
        EntityManager em = emf.createEntityManager();
        final EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(newPost);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
        }
        return newPost;
    }
}
