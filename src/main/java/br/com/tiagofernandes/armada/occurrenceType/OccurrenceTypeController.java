package br.com.tiagofernandes.armada.occurrenceType;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

  @GetMapping("/{id}")
  public ResponseEntity<?> getById(@PathVariable UUID id) {
    var occurrence = this.occurrenceTypeRepository.findById(id).orElse(null);

    if (occurrence == null) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuário não encontrado!");
    }

    return ResponseEntity.status(HttpStatus.OK).body(occurrence);
  }
}
