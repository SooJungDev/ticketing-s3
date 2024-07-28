package com.ticketing.performance.entity;

import com.ticketing.common.AbstractEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "place")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Place extends AbstractEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(nullable = false)
  private String name;

  @Column(name = "tel_no")
  private String telNo;

  @Column
  private String address;

  @Column(columnDefinition = "TEXT")
  private String description;

  @Column(name = "facility_info", columnDefinition = "TEXT")
  private String facilityInfo;

  @Column(name = "seat_count")
  private Integer seatCount;


}
