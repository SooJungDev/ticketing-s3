package com.ticketing.performance.service.impl;

import com.ticketing.performance.entity.Performance;
import com.ticketing.performance.repository.PerformanceRepository;
import com.ticketing.performance.repository.PlaceRepository;
import com.ticketing.performance.service.PerformanceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class PerformanceServiceImpl implements PerformanceService {

  private final PerformanceRepository performanceRepository;
  private final PlaceRepository placeRepository;

  @Transactional
  @Override
  public Long register(Long placeId, Performance performance) {
    var place = placeRepository.findById(placeId);
    if (place.isEmpty()) {
      throw new IllegalArgumentException("공연장소 아이디가 존재하지 않습니다.");
    }

    performance.addPlace(place.get());
    final Performance save = performanceRepository.save(performance);
    performance.getTicketPrices().forEach(ticketPrice -> ticketPrice.addPerformance(save));
    return save.getId();
  }
}
