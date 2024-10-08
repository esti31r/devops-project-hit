package final_project;
import lombok.Data;

@Data
public class CICDJobUpdateDTO {
    private Long id; // Job ID, must be provided for updates
    private String jobName;
    private String status; // Add status to update DTO
    private String jobType; // Add jobType to update DTO
    private String config; // Assuming you might also want to update configuration

    // Include any other fields you want to update
}
