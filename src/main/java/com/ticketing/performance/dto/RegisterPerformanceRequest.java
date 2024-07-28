package com.ticketing.performance.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.ticketing.performance.entity.Performance.Category;
import com.ticketing.performance.entity.Performance.Status;
import com.ticketing.performance.entity.Performance.ViewingAge;
import java.util.List;
import lombok.Builder;

@Builder
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public record RegisterPerformanceRequest(
    String name,
    List<RegisterTicketPriceRequest> ticketPrices,
    String description,
    String startTime,
    String endTime,
    String posterUrl,
    String cast,
    String crew,
    Long runningTime,
    String productCompany,
    Status status,
    Category category,
    ViewingAge viewingAge
) {

}
