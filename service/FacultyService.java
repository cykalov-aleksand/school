package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.repository.FacultyRepository;

import java.util.Collection;
import java.util.List;

@Service
public class FacultyService {

    private final FacultyRepository facultyRepository;

    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    public Collection<Faculty> findStudentAll() {
        return facultyRepository.findAll();
    }

    public Faculty addFaculty(Faculty student) {
        return facultyRepository.save(student);
    }

    public Faculty findFaculty(long id) {
        return facultyRepository.findById(id).get();
    }

    public void deleteFaculty(long id) {
        facultyRepository.deleteById(id);
    }
    public List<Faculty> findByColor(String color) {
        return facultyRepository.findByName(color);
    }

}
