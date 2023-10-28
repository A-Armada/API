package br.com.tiagofernandes.armada.job;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jobs")
public class JobController {

  @Autowired
  private IJobRepository jobRepository;

  @PostMapping("/create")
  public ResponseEntity<JobModel> create(@RequestBody JobModel jobModel) {
    var jobCreated = this.jobRepository.save(jobModel);

    return ResponseEntity.status(HttpStatus.CREATED).body(jobCreated);
  }

  @GetMapping("/")
  public ResponseEntity<List<JobModel>> list() {
    var jobs = this.jobRepository.findAll();

    return ResponseEntity.status(HttpStatus.OK).body(jobs);
  }
}
