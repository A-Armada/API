package br.com.tiagofernandes.armada.user;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import br.com.tiagofernandes.armada.office.OfficeModel;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity(name = "tb_users")
public class UserModel {
  @Id
  @GeneratedValue(generator = "UUID")
  private UUID id;

  private String firstName;
  private String lastName;
  private String username;
  private String password;

  private String street;
  private Integer number;
  private String neighborhood;

  private String city;
  private String state;
  private String zipCode;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "officemodel_id")
  private OfficeModel office;

  @CreationTimestamp
  private LocalDateTime createdAt;
}