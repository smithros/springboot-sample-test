package com.hackerrank.sample.repo;

import com.hackerrank.sample.data.Data;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DataRepository extends CrudRepository<Data, Long> {

    List<Data> findAllByOrderByIdAsc();
}
