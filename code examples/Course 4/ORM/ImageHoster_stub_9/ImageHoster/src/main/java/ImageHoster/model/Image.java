package ImageHoster.model;

import javax.persistence.*;
import java.util.Date;


//Write the annotation to specify that the corresponding class is a JPA entity
//Write the annotation to provide more options to customize the mapping.
//Here the name of the table to be created in the database is to be explicitly mentioned as 'images'. Hence the table named 'images' will be created in the database with all the columns mapped to all the attributes in 'Image' class
public class Image {

    //Write the annotation to specify that the attribute is a primary key
    //Write the annotation to specify that the Generation type is AUTO
    //Also write the annotation to map this attribute to a column in the database and also explicitly specify the column name as 'id'
    private Integer id;

    @Column(name = "title")
    private String title;

    // Text is a Postgres specific column type that allows you to save
    // text based data that will be longer than 256 characters
    // this is a base64 encoded version of the image
    @Column(columnDefinition = "TEXT")
    private String imageFile;


    @Column(name = "description")
    private String description;

    @Column(name = "date")
    private Date date;

    //The 'images' table is mapped to 'users' table with Many:One mapping
    //One image can have only one user (owner) but one user can have multiple images
    //FetchType is EAGER
    //Write the annotation to implement the above feature
    //Write the annotation to indicate that the name of the column in 'images' table referring the primary key in 'users' table will be 'user_id'
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="user_id")
    private User user;

    public Image() {
    }

    public Image(int i, String s, String s1, Date date) {
        this.id = i;
        this.title = s;
        this.imageFile = s1;
        this.date = date;
    }

    public Image(int i, String s, String s1, String s2, Date date) {
        this.id = i;
        this.title = s;
        this.imageFile = s1;
        this.description = s2;
        this.date = date;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageFile() {
        return imageFile;
    }

    public void setImageFile(String imageFile) {
        this.imageFile = imageFile;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
