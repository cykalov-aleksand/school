package ru.hogwarts.school.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.hogwarts.school.entity.EntityLastPage;
import ru.hogwarts.school.model.Student;

import java.util.Collection;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Collection<Student> findByAge(int age);
    Collection<Student>findByAgeGreaterThan(int age);
    @Query(value = "SELECT COUNT (id) FROM student",nativeQuery = true)
    Integer getCount();
    @Query(value = "SELECT AVG (age) FROM student",nativeQuery = true)
    Integer getAvrAge();
    @Query(value = "SELECT id, name, age FROM student ORDER BY id DESC LIMIT 5",nativeQuery = true)
    Collection<EntityLastPage> lastPage();
   }

