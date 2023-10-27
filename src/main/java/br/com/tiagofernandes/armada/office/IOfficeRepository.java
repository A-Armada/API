package br.com.tiagofernandes.armada.office;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IOfficeRepository extends JpaRepository<OfficeModel, UUID> {

}