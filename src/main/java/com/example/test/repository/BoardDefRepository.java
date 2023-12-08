package com.example.test.repository;

import com.example.test.model.entity.BoardDef;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardDefRepository extends JpaRepository<BoardDef, String> {
}
