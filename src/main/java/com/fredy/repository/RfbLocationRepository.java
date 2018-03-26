package com.fredy.repository;

import com.fredy.domain.RfbLocation;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;

import java.time.LocalDate;
import java.util.List;


/**
 * Spring Data JPA repository for the RfbLocation entity.
 */
@SuppressWarnings("unused")
@Repository
public interface RfbLocationRepository extends JpaRepository<RfbLocation, Long> {
    List<RfbLocation> findAllByRunDayOfWeek(Integer dayofWeek);

    RfbLocation findByLocationName(String name);

}
