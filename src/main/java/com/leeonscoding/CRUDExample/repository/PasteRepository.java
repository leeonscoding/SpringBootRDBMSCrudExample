package com.leeonscoding.CRUDExample.repository;

import com.leeonscoding.CRUDExample.domain.Paste;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
public interface PasteRepository extends JpaRepository<Paste, Long> {
    @Query("SELECT p from Paste p WHERE p.deletionDateTime < CURRENT_TIMESTAMP")
    List<Paste> findByDeletionDateTime();
}

