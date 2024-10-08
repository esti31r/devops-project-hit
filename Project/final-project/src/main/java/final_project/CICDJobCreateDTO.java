package final_project;

import lombok.Data;

@Data
public class CICDJobCreateDTO {
    private String jobName;
    private String status;  // Add status to create DTO
    private String jobType;  // Add jobType to create DTO
    private String config; // Assuming you still have this for configuration

    // Add any additional fields as necessary
}
