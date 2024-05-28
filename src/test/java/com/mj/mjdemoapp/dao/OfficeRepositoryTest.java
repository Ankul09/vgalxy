package com.mj.mjdemoapp.dao;

import com.mj.mjdemoapp.entities.Officer;
import com.mj.mjdemoapp.entities.Rank;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class OfficeRepositoryTest {
    @Autowired
    private OfficerRepository dao;

    @Autowired
    private JdbcTemplate template;

    // Retrives the current list of ids

    List<Integer> ids() {
        return template.query("SELECT id FROM officers",
                (rs, rc) -> rs.getInt("id"));
    }

    @Test
    void save() {
        // Arrange
        Officer officer = new Officer(null,
                Rank.ENSIGN,
                "Kshitija",
                "Shete");

        // Act
        officer = dao.save(officer);

        // Assert
        assertNotNull(officer.getId());
    }

    @Test
    void findByIdThatExists() {
        ids().forEach((id) -> {
            Optional<Officer> officer = dao.findById(id);
            assertTrue(officer.isPresent());
            assertEquals(id, officer.get().getId());
        });
    }

    @Test
    void findByIdThatDoesNotExist() {
        org.assertj.core.api.Assertions.assertThat(ids()).doesNotContain(999);
        Optional<Officer> office = dao.findById(999);
        assertFalse(office.isPresent());
    }

    @Test
    void findAll() {
        List<String> namesFromDb = dao.findAll()
                .stream()
                .map(Officer::getFirstName)
                .toList();
        org.assertj.core.api.Assertions.assertThat(namesFromDb).containsAll(List.of(
                "Mayuresh", "Ankul", "Ankit", "Rishab",
                "Shubham", "Surbhi", "Priyanka", "Shriya"
        ));
    }

    @Test
    void count() {
        assertEquals(ids().size(), dao.count());
    }

    @Test
    void delete() {
        ids().forEach(id -> {
            Optional<Officer> officer = dao.findById(id);
            assertTrue(officer.isPresent());
            dao.delete(officer.get());
        });

        assertEquals(0, dao.count());
    }

    @Test
    void existsById() {
        ids().forEach(id -> assertTrue(dao.existsById(id)));
    }

    @Test
    void findAllByLastNameContainingAndRanks() {
        dao.findAllByLastNameContainingAndRank("a", Rank.CAPTAIN)
                .stream()
                .forEach(System.out::println);
    }
}