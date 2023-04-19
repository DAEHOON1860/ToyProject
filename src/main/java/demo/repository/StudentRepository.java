package demo.repository;

import demo.domain.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    @Query(value = "insert into student(name,password) values(:#{#student.name},:#{#student.password})",
            nativeQuery = true)
    @Modifying
    @Transactional
    void insertInfo(@Param(value = "student") Student student);

    @Query(value = "select * from student where name = :name", nativeQuery = true)
    List<Student> findByName(@Param(value = "name") String name);
}