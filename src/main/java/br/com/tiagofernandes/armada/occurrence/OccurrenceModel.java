package br.com.tiagofernandes.armada.occurrence;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "tb_occurrences")
public class OccurrenceModel {
  @Id
  @GeneratedValue(generator = "UUID")
  private UUID id;

  private String title;
  private String description;

  private String street;
  private Integer number;
  private String neighborhood;

  private String city;
  private String state;

  private UUID occurrenceType;

  @CreationTimestamp
  private LocalDateTime createdAt;
}
