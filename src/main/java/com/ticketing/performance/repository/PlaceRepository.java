package com.ticketing.performance.repository;

import com.ticketing.performance.entity.Place;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaceRepository extends JpaRepository<Place, Long> {

}