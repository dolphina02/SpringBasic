package com.bbanddak.bbanddak.controller;

import com.bbanddak.bbanddak.service.WashService;
import com.bbanddak.bbanddak.vo.Wash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/wash")
public class WashController {

    private WashService washService;

    @Autowired
    public WashController(WashService washService) {
        this.washService = washService;
    }

    @GetMapping("/{wash}")
    public ResponseEntity<Wash> getWashInfoByWashId(@PathVariable String wash_id) {
        Wash wash = washService.getWashInfoByWashId(wash_id);
        if (wash != null) {
            return new ResponseEntity<>(wash, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{washAndStatus}")
    public ResponseEntity<Wash> getWashStatus(@PathVariable String wash_id, String status) {
        Wash wash = washService.getWashInfoByWashIdAndStatus(wash_id, status);
        return wash != null
                ? ResponseEntity.ok(wash) // method chaining
                : ResponseEntity.notFound().build();
    }

    @GetMapping("/{washStatus}")
    public ResponseEntity<String> getWashStatus(@PathVariable String wash_id) {
        String washStatus = washService.getWashStatus(wash_id);
        return washStatus != null
                ? ResponseEntity.ok(washStatus) // method chaining
                : ResponseEntity.notFound().build();
    }

    @PostMapping("/request")
    public ResponseEntity<String> requestWash(@RequestBody Wash washRequest) {
        String wash_id = washService.requestWash(washRequest);
        return ResponseEntity.ok(wash_id);
    }

}
