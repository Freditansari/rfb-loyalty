package com.fredy.repository;

import java.time.LocalDate;

import com.fredy.domain.RfbEvent;
import com.fredy.domain.RfbLocation;

import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the RfbEvent entity.
 */
@SuppressWarnings("unused")
@Repository
public interface RfbEventRepository extends JpaRepository<RfbEvent, Long> {
    RfbEvent findByRfbLocationAndEventDate(RfbLocation location, LocalDate date);

}
