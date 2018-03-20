package com.fredy.service;

import com.fredy.service.dto.RfbEventDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing RfbEvent.
 */
public interface RfbEventService {

    /**
     * Save a rfbEvent.
     *
     * @param rfbEventDTO the entity to save
     * @return the persisted entity
     */
    RfbEventDTO save(RfbEventDTO rfbEventDTO);

    /**
     * Get all the rfbEvents.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    Page<RfbEventDTO> findAll(Pageable pageable);

    /**
     * Get the "id" rfbEvent.
     *
     * @param id the id of the entity
     * @return the entity
     */
    RfbEventDTO findOne(Long id);

    /**
     * Delete the "id" rfbEvent.
     *
     * @param id the id of the entity
     */
    void delete(Long id);

    /**
     * Search for the rfbEvent corresponding to the query.
     *
     * @param query the query of the search
     * 
     * @param pageable the pagination information
     * @return the list of entities
     */
    Page<RfbEventDTO> search(String query, Pageable pageable);
}
