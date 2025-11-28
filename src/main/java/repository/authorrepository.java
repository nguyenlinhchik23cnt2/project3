package repository;

import Entity.author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface authorrepository extends JpaRepository<author, Long> {
}
