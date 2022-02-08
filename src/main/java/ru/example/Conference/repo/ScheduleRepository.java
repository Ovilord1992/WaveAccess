package ru.example.Conference.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.example.Conference.entity.Schedule;
@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
}
