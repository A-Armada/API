package br.com.tiagofernandes.armada.job;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IJobRepository extends JpaRepository<JobModel, UUID> {

}