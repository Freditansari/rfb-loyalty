package com.fredy.repository.search;

import com.fredy.domain.RfbLocation;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Spring Data Elasticsearch repository for the RfbLocation entity.
 */
public interface RfbLocationSearchRepository extends ElasticsearchRepository<RfbLocation, Long> {
}
