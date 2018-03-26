package com.fredy.service;


import java.time.LocalDateTime;

import com.fredy.repository.RfbEventRepository;
import com.fredy.repository.RfbLocationRepository;


import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import com.fredy.domain.RfbLocation;


/**
 * RfbEventCodeService
 *  Service to run daily and generate random event code
 *  this is a tutorial for a scheduled service and getting data from JPA repository
 *
 */
@Service
public class RfbEventCodeService {

    private final RfbLocationRepository locationRepository; 
    private final RfbEventRepository EventRepo;
    

    

    public RfbEventCodeService(RfbLocationRepository locationRepository, RfbEventRepository eventRepo) {
		super();
		this.locationRepository = locationRepository;
		EventRepo = eventRepo;
	}




	//@Scheduled(cron = "* * * * * ?")//run every second
    @Scheduled(cron = "0 * * * * ?") //run every minute
    public void generateCode()
    {
    	try {
            
    		final org.slf4j.Logger log = LoggerFactory.getLogger(RfbEventCodeService.class);
            log.debug("this is scheduler test from debug.. please ignore... time right now is: " + LocalDateTime.now().toString());

            List<RfbLocation> locations = locationRepository.findAllByRunDayOfWeek(1);
           // RfbLocation findResults= RfbLocationRepository.findByLocationName("Jakart");
            log.debug(locations.toString());
          
    		
    	}catch (Exception e) {
			
		}
    
    }

    
}