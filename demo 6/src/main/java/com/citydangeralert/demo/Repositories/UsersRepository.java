package com.citydangeralert.demo.Repositories;

import com.citydangeralert.demo.Entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UsersRepository extends JpaRepository<Users, String> {

}
