package config.handlers;

import config.services.IModeratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by sudh on 4/14/2015.
 */

@Component
public class SchedulerConf {

    @Autowired
    IModeratorService serviceObj;

    @Scheduled(fixedRate = 50000)
    public void messageScheduler()
    {
        System.out.println("Scheduler Started");
        serviceObj.checkForExpiredPolls();
    }
}
