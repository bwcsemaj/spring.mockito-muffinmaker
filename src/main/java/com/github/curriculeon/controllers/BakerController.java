package com.github.curriculeon.controllers;

import com.github.curriculeon.services.BakerService;
import com.github.curriculeon.models.Baker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/baker-controller")
public class BakerController {
    
    private final BakerService service;

    @Autowired
    public BakerController(BakerService service) {
        this.service = service;
    }

    @RequestMapping("/")
    public ResponseEntity<Iterable<Baker>> index() {
        return new ResponseEntity<>(service.index(), HttpStatus.OK);
    }
    
    @RequestMapping(name = "/show", method = RequestMethod.GET)
    public ResponseEntity<Baker> show(@RequestParam(name = "id", required = true) Long id) {
        return new ResponseEntity<>(service.show(id), HttpStatus.OK);
    }
    
    @RequestMapping(name = "/create", method = RequestMethod.POST)
    public ResponseEntity<Baker> create(Baker baker) {
        return new ResponseEntity<>(service.create(baker), HttpStatus.CREATED);
    }
    
    @RequestMapping(name = "/update", method = RequestMethod.PUT)
    public ResponseEntity<Baker> update(@RequestParam(name = "id") Long id, Baker baker) {
        return new ResponseEntity<>(service.update(id, baker), HttpStatus.OK);
    }

    @RequestMapping(name = "/destroy", method = RequestMethod.DELETE)
    public ResponseEntity<Boolean> destroy(@RequestParam(name = "id") Long id) {
        return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
    }
}
