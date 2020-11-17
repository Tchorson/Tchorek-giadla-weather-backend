package com.example.cloudcomputinggiadlatchorek.controller;

import com.example.cloudcomputinggiadlatchorek.logic.FuzzyLogic;
import com.example.cloudcomputinggiadlatchorek.service.TornadoStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@CrossOrigin
public class TornadoStateController {

    @Autowired
    TornadoStateService tornadoStateService;

    @GetMapping(path = "/getAllRecords", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getCollections(){
        return ResponseEntity.ok().body(tornadoStateService.getAllRecords());
    }

}
