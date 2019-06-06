package techBlog.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "posts")
public class Post {

    // Primary key
    // Column is not mandatory , required in case column name is different than in the table
    // @Id - to specific primary key
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // hbm2.ddl would auto create the primary key
    // AUTO , IDENTITY , SEQUENCE and TABLE
    @Column(name = "id")
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "body")
    private String body;

    // Would throw SQL Grammar Exception if date is not present in the table
    // so we need to skip this mapping
    //@Transient - Since we would now use bhm2.ddl , it would auto create / update the table
    // applied transient as this wasnt present in the table ,but hbm2.ddl would auto create it

    @Column(name = "date")
    private Date date;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
