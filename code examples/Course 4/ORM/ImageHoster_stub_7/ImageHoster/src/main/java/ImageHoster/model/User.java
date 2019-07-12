package ImageHoster.model;

import javax.persistence.*;

//Write the annotation to specify that the corresponding class is a JPA entity

//Write the annotation to provide more options to customize the mapping, explicitly mentioning that the name of the table in the database is 'users'
@Entity
@Table(name="users")
public class User {

    //Write the annotation to specify that the corresponding attribute is a primary key
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //Write the annotation to specify that the attribute will be mapped to the column in the database.
    //Also explicitly mention the column name as 'id'
    @Column(name="id")
    private Integer id;

    //Write the annotation to specify that the attribute will be mapped to the column in the database.
    //Also explicitly mention the column name as 'username'
    @Column(name="username")
    private String username;

    //Write the annotation to specify that the attribute will be mapped to the column in the database.
    //Also explicitly mention the column name as 'password'
    @Column(name="password")
    private String password;

    //Write the annotation to specify the below mentioned features
    //The 'users' table is mapped to 'user_profile' table with One:One mapping
    //Also if a record in 'user_profile' table is deleted or updated, then all the records in 'users' table associated to that particular record in 'user_profile' table will be deleted or updated  first and then the record in the 'user_profile' table will be deleted or updated
    //FetchType is EAGER

    //Write the annotation to indicate that the name of the column in 'users' table referring the primary key in 'user_profile' table will be 'profile_id'
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="profile_id")
    private UserProfile profile;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserProfile getProfile() {
        return profile;
    }

    public void setProfile(UserProfile profile) {
        this.profile = profile;
    }
}

