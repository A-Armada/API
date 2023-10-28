package br.com.tiagofernandes.armada.job;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "tb_offices")
public class JobModel {
  @Id
  @GeneratedValue
  private UUID id;

  private String name;

  @CreationTimestamp
  private LocalDateTime createdAt;
}
