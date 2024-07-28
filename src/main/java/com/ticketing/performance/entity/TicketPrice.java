package com.ticketing.performance.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "performance")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TicketPrice {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false)
  private BigDecimal price;

  private String seatGrade;

  private String seatGradeName;

  private String description;

  private BigDecimal salePrice;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "performance_id")
  private Performance performance;

  @Builder
  public TicketPrice(String name, BigDecimal price, String seatGrade, String seatGradeName,
      String description, BigDecimal salePrice) {
    this.name = name;
    this.price = price;
    this.seatGrade = seatGrade;
    this.seatGradeName = seatGradeName;
    this.description = description;
    this.salePrice = salePrice;
  }

  public void addPerformance(Performance performance) {
    this.performance = performance;
  }
}
