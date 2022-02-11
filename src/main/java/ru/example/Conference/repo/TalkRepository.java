package ru.example.Conference.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.example.Conference.entity.Talk;

import java.util.List;

@Repository
public interface TalkRepository extends JpaRepository<Talk, Long> {
}
