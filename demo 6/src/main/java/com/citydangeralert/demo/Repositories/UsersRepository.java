package com.citydangeralert.demo.Repositories;

import com.azure.spring.data.cosmos.repository.CosmosRepository;
import com.citydangeralert.demo.Entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UsersRepository extends CosmosRepository<UserEntity, String> {

}
