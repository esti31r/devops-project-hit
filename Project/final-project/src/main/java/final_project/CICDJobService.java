package final_project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CICDJobService {

    @Autowired
    private CICDJobRepository ciCdJobRepository;

    // Create a job using the CreateDTO
    public CICDJob createJob(CICDJobCreateDTO createDTO) {
        CICDJob job = new CICDJob();
        job.setJobName(createDTO.getJobName());
        job.setStatus(createDTO.getStatus());  // Set status from DTO
        job.setJobType(createDTO.getJobType());  // Set jobType from DTO
        job.setCreatedAt(LocalDateTime.now());  // Auto set the createdAt timestamp
        job.setUpdatedAt(LocalDateTime.now());  // Set initial updatedAt timestamp

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

    // Update a job using the Update DTO
    public CICDJob updateJob(CICDJobUpdateDTO updateDTO) {
        Optional<CICDJob> existingJobOptional = ciCdJobRepository.findById(updateDTO.getId());
        if (existingJobOptional.isPresent()) {
            CICDJob existingJob = existingJobOptional.get();
            // Update fields from the DTO
            existingJob.setJobName(updateDTO.getJobName());
            existingJob.setStatus(updateDTO.getStatus());  // Update status
            existingJob.setJobType(updateDTO.getJobType());  // Update jobType
            // Handle config or any other fields as necessary

            return ciCdJobRepository.save(existingJob);
        } else {
            throw new RuntimeException("Job not found with id: " + updateDTO.getId());
        }
    }
}
