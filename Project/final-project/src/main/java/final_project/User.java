package final_project;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

/**
 * User entity class.
 * This class is mapped to a database table named app_user.
 */
@Entity
@Table(name = "app_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String jobName;
    private String status;
    private Date createdAt;
    private Date updatedAt;
    private String jobType;



    public User() {}

    public User(String jobName, String status, Date createdAt, Date updatedAt, String jobType) {
        this.jobName = jobName;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.jobType = jobType;
    }

    public User(String jobName, String status, Date createdAt, Date updatedAt) {
        this.jobName = jobName;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.jobType = ""; // or this.password = UUID.randomUUID().toString()); this for creat password automatically
    }


    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String name) {
        this.jobName = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String email) {
        this.status = email;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date phone) {
        this.createdAt = phone;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date address) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + jobName + '\'' +
                ", email='" + status + '\'' +
                ", phone='" + createdAt + '\'' +
                ", address='" + updatedAt + '\'' +
                ", password='" + jobType + '\'' +
                '}';
    }
}
