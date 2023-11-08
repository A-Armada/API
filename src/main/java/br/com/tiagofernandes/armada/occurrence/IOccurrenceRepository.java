package br.com.tiagofernandes.armada.occurrence;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IOccurrenceRepository extends JpaRepository<OccurrenceModel, UUID> {
  List<OccurrenceModel> findAllByOrderByIdDesc();
}