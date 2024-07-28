package com.ticketing.performance.controller;

import com.ticketing.performance.dto.RegisterPerformanceRequest;
import com.ticketing.performance.mapper.PerformanceMapper;
import com.ticketing.performance.service.PerformanceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/admin/api/v1/performance")
public class PerformanceAdminController {

  private final PerformanceService performanceService;

  @PostMapping("/register/{placeId}")
  public ResponseEntity<Long> register(@PathVariable("placeId") Long placeId,
      @RequestBody RegisterPerformanceRequest request) {
    performanceService.register(placeId, PerformanceMapper.INSTANCE.toPerformance(request));
    return ResponseEntity.ok().build();
  }
}
