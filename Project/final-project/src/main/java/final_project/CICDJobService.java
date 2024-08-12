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

    public CICDJob createJob(CICDJob job) {
        return ciCdJobRepository.save(job);
    }

    public Optional<CICDJob> getJobById(Long id) {
        return ciCdJobRepository.findById(id);
    }

    public List<CICDJob> getAllJobs() {
        return ciCdJobRepository.findAll();
    }

    public List<CICDJob> getJobsByStatus(String status) {
        return ciCdJobRepository.findByStatus(status);
    }

    public List<CICDJob> getJobsByJobType(String jobType) {
        return ciCdJobRepository.findByJobType(jobType);
    }

    public List<CICDJob> getJobsByDateRange(LocalDateTime startDate, LocalDateTime endDate) {
        return ciCdJobRepository.findByCreatedAtBetween(startDate, endDate);
    }

    public void deleteJob(Long id) {
        ciCdJobRepository.deleteById(id);
    }

    protected void onCreate() {
        Date createdAt = new Date();
    }
}
