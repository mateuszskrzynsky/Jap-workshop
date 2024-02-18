package com.example.japworkshop.repository;

import com.example.japworkshop.model.entity.EntryCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntryCardRepository extends JpaRepository<EntryCard,Long> {
}
