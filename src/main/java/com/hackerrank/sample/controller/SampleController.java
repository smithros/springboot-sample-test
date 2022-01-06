package com.hackerrank.sample.controller;

import com.hackerrank.sample.data.Data;
import com.hackerrank.sample.data.DataDto;
import com.hackerrank.sample.service.DataService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/endpoint")
public class SampleController {

    private final DataService service;

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public ResponseEntity<DataDto> insert(@RequestBody final DataDto data) {
        final DataDto response = this.service.insert(data);
        return Optional.ofNullable(response)
                .map(ResponseEntity::ok)
                .orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    @RequestMapping(value = "/select", method = RequestMethod.GET)
    public ResponseEntity<List<Data>> select() {
        return Optional.ofNullable(this.service.select())
                .map(ResponseEntity::ok)
                .orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }


    @RequestMapping(value = "/select/{id}", method = RequestMethod.GET)
    public ResponseEntity<Data> selectById(@PathVariable("id") final long id) {
        return Optional.ofNullable(this.service.selectById(id))
                .map(ResponseEntity::ok)
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<Data> delete(@PathVariable("id") final long id) {
        return Optional.ofNullable(this.service.delete(id))
                .map(ResponseEntity::ok)
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
