package final_project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/jobs")
public class CICDJobController {

    
    @Autowired
    private CICDJobService ciCdJobService;

    @PostMapping
    public ResponseEntity<CICDJob> createJob(@RequestBody CI/CDJob job) {
        CICDJob createdJob = ciCdJobService.createJob(job);
        return new ResponseEntity<>(createdJob, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CICDJob> getJobById(@PathVariable Long id) {
        return ciCdJobService.getJobById(id)
                .map(job -> ResponseEntity.ok(job))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<CICDJob> getAllJobs() {
        return ciCdJobService.getAllJobs();
    }

    @GetMapping("/status/{status}")
    public List<CICDJob> getJobsByStatus(@PathVariable String status) {
        return ciCdJobService.getJobsByStatus(status);
    }

    @GetMapping("/type/{jobType}")
    public List<CICDJob> getJobsByJobType(@PathVariable String jobType) {
        return ciCdJobService.getJobsByJobType(jobType);
    }

    @GetMapping("/date-range")
    public List<CICDJob> getJobsByDateRange(@RequestParam LocalDateTime startDate, @RequestParam LocalDateTime endDate) {
        return ciCdJobService.getJobsByDateRange(startDate, endDate);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJob(@PathVariable Long id) {
        ciCdJobService.deleteJob(id);
        return ResponseEntity.noContent().build();
    }
}
