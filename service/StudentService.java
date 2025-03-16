package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.StudentRepository;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Collection<Student> findStudentAll() {
        return studentRepository.findAll();
    }

    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student findStudent(long id) {
        return studentRepository.findById(id).get();
    }

    public void deleteStudent(long id) {
        studentRepository.deleteById(id);
    }

    public List<Student> findByAge(int age) {
        List<Student>aa=studentRepository.findAll();
        List<Student>bb=new ArrayList<>();
        for (Student variable:aa){
            if(variable.getAge()==age){
                bb.add(variable);
            }
        }
        return bb;
    }
}
