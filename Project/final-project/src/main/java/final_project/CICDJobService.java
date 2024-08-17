package final_project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CICDJobService {

    @Autowired
    private CICDJobRepository ciCdJobRepository;

    // Create a job using DTO
    public CICDJob createJob(CICDJobCreateDTO createDTO) {
        CICDJob job = new CICDJob();
        job.setJobName(createDTO.getJobName());
        job.setDescription(createDTO.getDescription());
        job.setConfig(createDTO.getConfig());
        job.setCreatedAt(new Date()); // Assuming you have this field in your entity
        // Set other fields as needed

        return ciCdJobRepository.save(job);
    }

    // Get a job by ID
    public Optional<CICDJob> getJobById(Long id) {
        return ciCdJobRepository.findById(id);
    }

    // Get all jobs
    public List<CICDJob> getAllJobs() {
        return ciCdJobRepository.findAll();
    }

    // Get jobs by status
    public List<CICDJob> getJobsByStatus(String status) {
        return ciCdJobRepository.findByStatus(status);
    }

    // Get jobs by job type
    public List<CICDJob> getJobsByJobType(String jobType) {
        return ciCdJobRepository.findByJobType(jobType);
    }

    // Get jobs by date range
    public List<CICDJob> getJobsByDateRange(LocalDateTime startDate, LocalDateTime endDate) {
        return ciCdJobRepository.findByCreatedAtBetween(startDate, endDate);
    }

    // Delete a job
    public void deleteJob(Long id) {
        ciCdJobRepository.deleteById(id);
    }

    // Update a job using DTO
    public CICDJob updateJob(CICDJobUpdateDTO updateDTO) {
        // Retrieve existing job
        Optional<CICDJob> existingJobOptional = ciCdJobRepository.findById(updateDTO.getId());
        if (existingJobOptional.isPresent()) {
            CICDJob existingJob = existingJobOptional.get();
            // Update fields
            existingJob.setJobName(updateDTO.getJobName());
            existingJob.setDescription(updateDTO.getDescription());
            existingJob.setConfig(updateDTO.getConfig());
            // Update other fields as needed

            return ciCdJobRepository.save(existingJob);
        } else {
            // Handle the case where the job doesn't exist, e.g., throw an exception
            throw new RuntimeException("Job not found with id: " + updateDTO.getId());
        }
    }

    protected void onCreate() {
        Date createdAt = new Date();
        // You can store the created date in your entity here if needed
    }
}
