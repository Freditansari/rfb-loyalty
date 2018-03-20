package com.fredy.service.impl;

import com.fredy.service.RfbEventAttendanceService;
import com.fredy.domain.RfbEventAttendance;
import com.fredy.repository.RfbEventAttendanceRepository;
import com.fredy.repository.search.RfbEventAttendanceSearchRepository;
import com.fredy.service.dto.RfbEventAttendanceDTO;
import com.fredy.service.mapper.RfbEventAttendanceMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import static org.elasticsearch.index.query.QueryBuilders.*;

/**
 * Service Implementation for managing RfbEventAttendance.
 */
@Service
@Transactional
public class RfbEventAttendanceServiceImpl implements RfbEventAttendanceService {

    private final Logger log = LoggerFactory.getLogger(RfbEventAttendanceServiceImpl.class);

    private final RfbEventAttendanceRepository rfbEventAttendanceRepository;

    private final RfbEventAttendanceMapper rfbEventAttendanceMapper;

    private final RfbEventAttendanceSearchRepository rfbEventAttendanceSearchRepository;

    public RfbEventAttendanceServiceImpl(RfbEventAttendanceRepository rfbEventAttendanceRepository, RfbEventAttendanceMapper rfbEventAttendanceMapper, RfbEventAttendanceSearchRepository rfbEventAttendanceSearchRepository) {
        this.rfbEventAttendanceRepository = rfbEventAttendanceRepository;
        this.rfbEventAttendanceMapper = rfbEventAttendanceMapper;
        this.rfbEventAttendanceSearchRepository = rfbEventAttendanceSearchRepository;
    }

    /**
     * Save a rfbEventAttendance.
     *
     * @param rfbEventAttendanceDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public RfbEventAttendanceDTO save(RfbEventAttendanceDTO rfbEventAttendanceDTO) {
        log.debug("Request to save RfbEventAttendance : {}", rfbEventAttendanceDTO);
        RfbEventAttendance rfbEventAttendance = rfbEventAttendanceMapper.toEntity(rfbEventAttendanceDTO);
        rfbEventAttendance = rfbEventAttendanceRepository.save(rfbEventAttendance);
        RfbEventAttendanceDTO result = rfbEventAttendanceMapper.toDto(rfbEventAttendance);
        rfbEventAttendanceSearchRepository.save(rfbEventAttendance);
        return result;
    }

    /**
     * Get all the rfbEventAttendances.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<RfbEventAttendanceDTO> findAll(Pageable pageable) {
        log.debug("Request to get all RfbEventAttendances");
        return rfbEventAttendanceRepository.findAll(pageable)
            .map(rfbEventAttendanceMapper::toDto);
    }

    /**
     * Get one rfbEventAttendance by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public RfbEventAttendanceDTO findOne(Long id) {
        log.debug("Request to get RfbEventAttendance : {}", id);
        RfbEventAttendance rfbEventAttendance = rfbEventAttendanceRepository.findOne(id);
        return rfbEventAttendanceMapper.toDto(rfbEventAttendance);
    }

    /**
     * Delete the rfbEventAttendance by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete RfbEventAttendance : {}", id);
        rfbEventAttendanceRepository.delete(id);
        rfbEventAttendanceSearchRepository.delete(id);
    }

    /**
     * Search for the rfbEventAttendance corresponding to the query.
     *
     * @param query the query of the search
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<RfbEventAttendanceDTO> search(String query, Pageable pageable) {
        log.debug("Request to search for a page of RfbEventAttendances for query {}", query);
        Page<RfbEventAttendance> result = rfbEventAttendanceSearchRepository.search(queryStringQuery(query), pageable);
        return result.map(rfbEventAttendanceMapper::toDto);
    }
}
