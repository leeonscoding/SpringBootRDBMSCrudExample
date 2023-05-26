package com.leeonscoding.CRUDExample;

import com.leeonscoding.CRUDExample.domain.Paste;
import com.leeonscoding.CRUDExample.services.PasteService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Configuration
@EnableScheduling
@Log4j2
public class Scheduler {

    @Autowired
    PasteService pasteService;

    @Scheduled(fixedDelay = 5, timeUnit = TimeUnit.MINUTES)
    public void deletePastPastes() {
        List<Paste> pastes = pasteService.getOneByDeletionDateTime();
        pastes.forEach(p -> {
            pasteService.deletePaste(p.getId());
            log.error("Deleted paste, id is " + p.getId());
        });
        log.error("Scheduler service is called : ");
    }

}
