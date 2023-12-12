package com.citydangeralert.demo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.citydangeralert.demo.Entities.Task;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task,String> {
}

