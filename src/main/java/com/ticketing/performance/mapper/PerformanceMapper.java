package com.ticketing.performance.mapper;

import com.ticketing.performance.dto.RegisterPerformanceRequest;
import com.ticketing.performance.dto.RegisterTicketPriceRequest;
import com.ticketing.performance.entity.Performance;
import com.ticketing.performance.entity.TicketPrice;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PerformanceMapper {

  PerformanceMapper INSTANCE = Mappers.getMapper(PerformanceMapper.class);

  Performance toPerformance(RegisterPerformanceRequest request);

  TicketPrice toTicketPrice(RegisterTicketPriceRequest request);

}
