package com.sergioarboleda.rentcar.repositories;

import com.sergioarboleda.rentcar.models.Client;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ClientCrudRepository extends CrudRepository<Client,Integer> {

    Optional<Client> findByNickname(String nickname);
}
