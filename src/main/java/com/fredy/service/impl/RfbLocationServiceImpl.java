package com.fredy.service.impl;

import com.fredy.service.RfbLocationService;
import com.fredy.domain.RfbLocation;
import com.fredy.repository.RfbLocationRepository;
import com.fredy.repository.search.RfbLocationSearchRepository;
import com.fredy.service.dto.RfbLocationDTO;
import com.fredy.service.mapper.RfbLocationMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import static org.elasticsearch.index.query.QueryBuilders.*;

/**
 * Service Implementation for managing RfbLocation.
 */
@Service
@Transactional
public class RfbLocationServiceImpl implements RfbLocationService {

    private final Logger log = LoggerFactory.getLogger(RfbLocationServiceImpl.class);

    private final RfbLocationRepository rfbLocationRepository;

    private final RfbLocationMapper rfbLocationMapper;

    private final RfbLocationSearchRepository rfbLocationSearchRepository;

    public RfbLocationServiceImpl(RfbLocationRepository rfbLocationRepository, RfbLocationMapper rfbLocationMapper, RfbLocationSearchRepository rfbLocationSearchRepository) {
        this.rfbLocationRepository = rfbLocationRepository;
        this.rfbLocationMapper = rfbLocationMapper;
        this.rfbLocationSearchRepository = rfbLocationSearchRepository;
    }

    /**
     * Save a rfbLocation.
     *
     * @param rfbLocationDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public RfbLocationDTO save(RfbLocationDTO rfbLocationDTO) {
        log.debug("Request to save RfbLocation : {}", rfbLocationDTO);
        RfbLocation rfbLocation = rfbLocationMapper.toEntity(rfbLocationDTO);
        rfbLocation = rfbLocationRepository.save(rfbLocation);
        RfbLocationDTO result = rfbLocationMapper.toDto(rfbLocation);
        rfbLocationSearchRepository.save(rfbLocation);
        return result;
    }

    /**
     * Get all the rfbLocations.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<RfbLocationDTO> findAll(Pageable pageable) {
        log.debug("Request to get all RfbLocations");
        return rfbLocationRepository.findAll(pageable)
            .map(rfbLocationMapper::toDto);
    }

    /**
     * Get one rfbLocation by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public RfbLocationDTO findOne(Long id) {
        log.debug("Request to get RfbLocation : {}", id);
        RfbLocation rfbLocation = rfbLocationRepository.findOne(id);
        return rfbLocationMapper.toDto(rfbLocation);
    }

    /**
     * Delete the rfbLocation by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete RfbLocation : {}", id);
        rfbLocationRepository.delete(id);
        rfbLocationSearchRepository.delete(id);
    }

    /**
     * Search for the rfbLocation corresponding to the query.
     *
     * @param query the query of the search
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<RfbLocationDTO> search(String query, Pageable pageable) {
        log.debug("Request to search for a page of RfbLocations for query {}", query);
        Page<RfbLocation> result = rfbLocationSearchRepository.search(queryStringQuery(query), pageable);
        return result.map(rfbLocationMapper::toDto);
    }
}
