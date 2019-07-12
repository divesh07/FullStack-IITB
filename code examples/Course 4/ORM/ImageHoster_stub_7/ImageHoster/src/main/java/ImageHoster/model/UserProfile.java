package ImageHoster.model;

import javax.persistence.*;

//Write the annotation to specify that the corresponding class is a JPA entity

//Write the annotation to provide more options to customize the mapping, explicitly mentioning that the name of the table in the database is 'user_profile'
@Entity
@Table(name="user_profile")
public class UserProfile {

    //Write the annotation to specify that the corresponding attribute is a primary key
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //Write the annotation to specify that the attribute will be mapped to the column in the database.
    //Also explicitly mention the column name as 'id'
    @Column(name="id")
    private Integer id;

    //Write the annotation to specify that the attribute will be mapped to the column in the database.
    //Also explicitly mention the column name as 'full_name'
    @Column(name="full_name")
    private String fullName;

    //Write the annotation to specify that the attribute will be mapped to the column in the database.
    //Also explicitly mention the column name as 'email_address'
    @Column(name="email_address")
    private String emailAddress;

    //Write the annotation to specify that the attribute will be mapped to the column in the database.
    //Also explicitly mention the column name as 'mobile_number'
    @Column(name="mobile_number")
    private String mobileNumber;

    public UserProfile() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
}
