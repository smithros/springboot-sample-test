package com.hackerrank.sample.service;

import com.hackerrank.sample.data.Data;
import com.hackerrank.sample.data.DataDto;
import com.hackerrank.sample.repo.DataRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class DataService {

    private final DataRepository repo;

    public DataDto insert(final DataDto dto) {
        Data data = new Data();
        data.setFirstName(dto.getFirstName());
        data.setLastName(dto.getLastName());
        data.setPhoneNumber(dto.getPhoneNumber());
        data.setDate(dto.getDate());
        this.repo.save(data);
        return dto;
    }

    public List<Data> select() {
        return this.repo.findAllByOrderByIdAsc();
    }

    public Data selectById(final long id) {
        Optional<Data> byId = this.repo.findById(id);
        return byId.orElse(null);
    }

    public Data delete(final long id) {
        this.repo.deleteById(id);
        return new Data();
    }
}

