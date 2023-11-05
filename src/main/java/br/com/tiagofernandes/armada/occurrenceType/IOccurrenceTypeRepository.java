package br.com.tiagofernandes.armada.occurrenceType;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IOccurrenceTypeRepository extends JpaRepository<OccurrenceTypeModel, UUID> {

}