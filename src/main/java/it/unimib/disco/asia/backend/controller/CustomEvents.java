package it.unimib.disco.asia.backend.controller;


import it.unimib.disco.asia.backend.model.customevent.CustomEventLogicBaseUnit;
import it.unimib.disco.asia.backend.service.CustomEventsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomEvents {

    @Autowired
    private CustomEventsService customEventsService;

    @RequestMapping(value = "customevents", produces = "application/json")
    public String getCustomEvents(@RequestBody List<List<CustomEventLogicBaseUnit>> lstLogic) {


        return String.join(", ", customEventsService.retrieveIds(lstLogic));

    }

}
