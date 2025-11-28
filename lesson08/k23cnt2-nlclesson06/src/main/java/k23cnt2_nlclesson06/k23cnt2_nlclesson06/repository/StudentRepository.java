package k23cnt2_nlclesson06.k23cnt2_nlclesson06.repository;

import k23cnt2_nlclesson06.k23cnt2_nlclesson06.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
