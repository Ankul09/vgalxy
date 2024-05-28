package com.mj.mjdemoapp.dao;

import com.mj.mjdemoapp.entities.Officer;
import com.mj.mjdemoapp.entities.Rank;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OfficerRepository extends JpaRepository<Officer, Integer> {

    List<Officer> findAllByLastNameContainingAndRank(String lastName, Rank rank);
}
