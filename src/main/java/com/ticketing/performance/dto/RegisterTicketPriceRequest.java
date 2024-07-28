package com.ticketing.performance.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.math.BigDecimal;
import lombok.Builder;

@Builder
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public record RegisterTicketPriceRequest(
    String name,
    BigDecimal price,
    String seatGrade,
    String seatGradeName,
    String description,
    BigDecimal salePrice
) {

}
