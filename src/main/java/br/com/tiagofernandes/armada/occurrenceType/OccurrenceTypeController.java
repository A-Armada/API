package br.com.tiagofernandes.armada.occurrenceType;

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
@RequestMapping("occurrences/types")
public class OccurrenceTypeController {
  @Autowired
  private IOccurrenceTypeRepository occurrenceTypeRepository;

  @PostMapping("/create")
  public ResponseEntity<?> create(@RequestBody OccurrenceTypeModel occurrenceTypeModel) {
    var occurrenceTypeCreated = this.occurrenceTypeRepository.save(occurrenceTypeModel);

    return ResponseEntity.status(HttpStatus.CREATED).body(occurrenceTypeCreated);
  }

  @GetMapping
  public ResponseEntity<List<OccurrenceTypeModel>> list() {
    var occurrenceTypes = this.occurrenceTypeRepository.findAll();

    return ResponseEntity.status(HttpStatus.OK).body(occurrenceTypes);
  }
}
