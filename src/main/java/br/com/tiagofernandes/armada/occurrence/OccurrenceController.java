package br.com.tiagofernandes.armada.occurrence;

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
@RequestMapping("/occurrences")
public class OccurrenceController {

  @Autowired
  private IOccurrenceRepository occurrenceRepository;

  @GetMapping
  public ResponseEntity<List<OccurrenceModel>> list() {
    var occurrences = this.occurrenceRepository.findAll();

    return ResponseEntity.status(HttpStatus.OK).body(occurrences);
  }

  @GetMapping("/last")
  public ResponseEntity<OccurrenceModel> last() {
    var lastOccurrence = this.occurrenceRepository.findAllByOrderByIdDesc().get(0);

    return ResponseEntity.status(HttpStatus.OK).body(lastOccurrence);
  }

  @PostMapping("/create")
  public ResponseEntity<OccurrenceModel> create(@RequestBody OccurrenceModel occurrenceModel) {
    var occurrenceCreated = this.occurrenceRepository.save(occurrenceModel);

    return ResponseEntity.status(HttpStatus.CREATED).body(occurrenceCreated);
  }
}
