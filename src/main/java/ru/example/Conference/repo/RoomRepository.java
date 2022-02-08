package ru.example.Conference.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.example.Conference.entity.Room;
@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
}
