package com.ticketing.performance.entity;

import com.ticketing.common.AbstractEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Getter
@Entity
@Table(name = "performance")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Performance extends AbstractEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "place_id")
  private Place place;

  @OneToMany(mappedBy = "performance", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
  private List<TicketPrice> ticketPrices = new ArrayList<>();

  @Column(nullable = false)
  private String name;

  @Column(nullable = false)
  private ZonedDateTime startTime;

  @Column(nullable = false)
  private ZonedDateTime endTime;

  private String posterUrl;

  private String cast;

  private String crew;

  private Long runningTime;

  private String productCompany;

  @Enumerated(EnumType.STRING)
  private Status status;

  @Enumerated(EnumType.STRING)
  private Category category;

  @Enumerated(EnumType.STRING)
  private ViewingAge viewingAge;

  @Getter
  @RequiredArgsConstructor
  public enum Status {
    PREPARE("공연준비중"),
    ON_SHOW("공연중"),
    END_OF_SHOW("공연종료");

    private final String description;
  }

  @Getter
  @RequiredArgsConstructor
  public enum Category {
    THEATER("연극"),
    CONCERT("콘서트"),
    CLASSIC("클래식"),
    DANCE("무용"),
    TRADITIONAL("전통예술"),
    EXHIBITION("전시회"),
    MUSICAL("뮤지컬"),
    ETC("기타");

    private final String description;
  }

  @Getter
  @RequiredArgsConstructor
  public enum ViewingAge {
    ALL("전체관람가"),
    CHILD("어린이관람가"),
    ADULT("성인관람가");

    private final String description;
  }


  public Performance(List<TicketPrice> ticketPrices, String name, ZonedDateTime startTime,
      ZonedDateTime endTime, String posterUrl, String cast, String crew, Long runningTime,
      String productCompany, Status status, Category category, ViewingAge viewingAge) {
    this.ticketPrices = ticketPrices;
    this.name = name;
    this.startTime = startTime;
    this.endTime = endTime;
    this.posterUrl = posterUrl;
    this.cast = cast;
    this.crew = crew;
    this.runningTime = runningTime;
    this.productCompany = productCompany;
    this.status = status;
    this.category = category;
    this.viewingAge = viewingAge;
  }

  @Builder

  public void addPlace(Place place) {
    this.place = place;
  }
}
