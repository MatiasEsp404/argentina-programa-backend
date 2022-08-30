package com.argentina.programa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "INFORMATION")
public class InformationEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(nullable = false)
  private String firstName;
  @Column(nullable = false)
  private String lastName;
  @Column(nullable = false, unique = true)
  private String email;
  @Column(nullable = false, unique = true)
  private String linkedin;
  @Column(nullable = false, unique = true)
  private String gitHub;
  @Column(nullable = false)
  private String country;
  @Column(nullable = false)
  private String province;
  @Column(nullable = false)
  private String location;
  @Column(nullable = false, unique = true)
  private String phoneNumber;
  @Column(nullable = false)
  private String seniority;
  @Column(nullable = false)
  private String profilePicture;
  @Column(nullable = false)
  private String coverImage;

}
