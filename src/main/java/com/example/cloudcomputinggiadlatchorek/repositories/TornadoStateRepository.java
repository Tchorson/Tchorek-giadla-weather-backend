package com.example.cloudcomputinggiadlatchorek.repositories;


import com.example.cloudcomputinggiadlatchorek.model.TornadoState;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TornadoStateRepository extends CrudRepository<TornadoState,String> {
}
