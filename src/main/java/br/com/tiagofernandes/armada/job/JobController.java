package br.com.tiagofernandes.armada.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jobs")
public class JobController {

  @Autowired
  private IJobRepository officeRepository;

  @PostMapping("/create")
  public ResponseEntity<?> create(@RequestBody JobModel jobModel) {
    var jobCreated = this.officeRepository.save(jobModel);

    return ResponseEntity.status(HttpStatus.CREATED).body(jobCreated);
  }
}
