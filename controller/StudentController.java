package ru.hogwarts.school.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.entity.EntityLastPage;
import ru.hogwarts.school.service.StudentService;

import java.util.Collection;
import java.util.Collections;

@RestController
@RequestMapping("/student")

public class StudentController {

    private final StudentService studentService;


    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    @Operation(summary = "Добавляем студента")
    public Student createStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }

    @PutMapping
    @Operation(summary = "Проводим корректировку введенных данных")
    public Student editStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }

    @DeleteMapping("{id}")
    @Operation(summary = "Проводим удаление студента по заданному id")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    @Operation(summary = "В случае если введено значение min>max данные значения меняются местами")
    public ResponseEntity<Collection<Student>> getStudentInfo(@RequestParam(defaultValue = "0") int min,
                                                              @RequestParam(defaultValue = "0") int max) {
        if (min > max) {
            int revers = max;
            max = min;
            min = revers;
        }
        if (min >= 0) {
            return ResponseEntity.ok(studentService.findByAgeBetween(min, max));
        }
        return ResponseEntity.ok(Collections.emptyList());
    }

    @GetMapping("{id}")
    @Operation(summary = "Поиск студента по id")
    public ResponseEntity<Student> getStudentInfoId(@PathVariable Long id) {
        Student student = studentService.findStudent(id);
        if (student == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(student);
    }

    @GetMapping("faculty/{studentId}")
    @Operation(summary = "Получаем факультет студента по указанному id")
    public ResponseEntity<String> getFaculty(@PathVariable long studentId) {
        return ResponseEntity.ok(studentService.getFacultyId(studentId));
    }

    @GetMapping("/count")
    @Operation(summary = "Получаем количество студентов в школе")
    public ResponseEntity<Integer> getCount() {
        return ResponseEntity.ok(studentService.getCount());
    }

    @GetMapping("/avgAge")
    @Operation(summary = "Получаем средний возраст студентов в школе")
    public ResponseEntity<Integer> getAvrAge() {
        return ResponseEntity.ok(studentService.getAvrAge());
    }

    @GetMapping("/getPage")
    @Operation(summary = "Выводим данные по последним 5 студентам")
    public ResponseEntity<Collection<EntityLastPage>> getStudentPage() {
          return ResponseEntity.ok(studentService.getLastPage());
      }
}

