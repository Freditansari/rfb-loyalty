package com.fredy.service;

import com.fredy.service.dto.RfbLocationDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing RfbLocation.
 */
public interface RfbLocationService {

    /**
     * Save a rfbLocation.
     *
     * @param rfbLocationDTO the entity to save
     * @return the persisted entity
     */
    RfbLocationDTO save(RfbLocationDTO rfbLocationDTO);

    /**
     * Get all the rfbLocations.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    Page<RfbLocationDTO> findAll(Pageable pageable);

    /**
     * Get the "id" rfbLocation.
     *
     * @param id the id of the entity
     * @return the entity
     */
    RfbLocationDTO findOne(Long id);

    /**
     * Delete the "id" rfbLocation.
     *
     * @param id the id of the entity
     */
    void delete(Long id);

    /**
     * Search for the rfbLocation corresponding to the query.
     *
     * @param query the query of the search
     * 
     * @param pageable the pagination information
     * @return the list of entities
     */
    Page<RfbLocationDTO> search(String query, Pageable pageable);
}
