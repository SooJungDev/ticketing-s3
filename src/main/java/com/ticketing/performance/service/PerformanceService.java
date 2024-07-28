package com.ticketing.performance.service;

import com.ticketing.performance.entity.Performance;

public interface PerformanceService {

  Long register(Long placeId, Performance performance);

}
