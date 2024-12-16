package com.task.personal.repository;

import com.task.personal.Entity.TareaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TareaRepository extends JpaRepository<TareaEntity, Long> {
}
