package final_project;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "ci_cd_jobs")  // Name of the table in the database
public class CICDJob {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Automatically generate primary key
    private Long id;

    @Column(nullable = false)  // Make jobName a required field
    private String jobName;

    @Column(nullable = false)  // Make status a required field
    private String status;

    @Column(nullable = false)  // Make jobType a required field
    private String jobType;

    @Column(name = "created_at", nullable = false, updatable = false)  // Auto set when created
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)  // Auto set on update
    private LocalDateTime updatedAt;

    // Default constructor
    public CICDJob() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    // Constructor with parameters
    public CICDJob(String jobName, String status, String jobType, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.jobName = jobName;
        this.status = status;
        this.jobType = jobType;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public CICDJob(String s, String pending, String build) {
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

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    // Update the updatedAt timestamp before saving to the database
    @PreUpdate
    private void updateTimestamp() {
        this.updatedAt = LocalDateTime.now();
    }

    // Override equals() and hashCode() methods for entity comparison
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CICDJob)) return false;
        CICDJob ciCdJob = (CICDJob) o;
        return id != null && id.equals(ciCdJob.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    // toString method for debugging purposes
    @Override
    public String toString() {
        return "CICDJob{" +
                "id=" + id +
                ", jobName='" + jobName + '\'' +
                ", status='" + status + '\'' +
                ", jobType='" + jobType + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
