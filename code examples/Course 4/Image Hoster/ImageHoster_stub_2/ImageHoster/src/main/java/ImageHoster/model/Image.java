package ImageHoster.model;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Image {

    //id of the image
    private Integer id;

    //title of the image
    private String title;

    //The image in Base64 format
    private String imageFile;

    //Description of the image
    private String description;

    //Date on which the image is posted
    private Date date;

    //Write the constructor for id, title, imageFile, and date

    public Image(Integer id, String title, String imageFile, String description, Date date) {
        this.id = id;
        this.title = title;
        this.imageFile = imageFile;
        this.description = description;
        this.date = date;
    }


    //Write getter and setter for all the attributes

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
}
