package org.example.students_manage.rest;

import org.example.students_manage.dao.StudentDAO;
import org.example.students_manage.entity.Students;
import org.example.students_manage.handle.HandleException;
import org.example.students_manage.handle.MyHandler;
import org.example.students_manage.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentsController {

    private StudentService studentService;
    @Autowired
    public StudentsController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Students> getAllStudents(){
        return this.studentService.getAllStudents();
    }
    @GetMapping("/{id}")
    public Students getStudentById(@PathVariable int id){
        Students result = this.studentService.getStudentById(id);
        if(result == null){
            throw new HandleException("Khong tim thay sinh vien co ma: " + id);
        }
        return result;
    }
    @PostMapping
    public void addStudent(@RequestBody Students students){
        students.setId(0);// bat buoc them moi va phat sinh id
        this.studentService.addStudent(students);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Students> updateStudent(@PathVariable int id, @RequestBody Students students){
        Students existing = this.studentService.getStudentById(id);
        if(existing != null){
            existing.setFirstName(students.getFirstName());
            existing.setLastName(students.getLastName());
            existing.setEmail(students.getEmail());
            studentService.updateStudent(existing);
            return ResponseEntity.ok(existing);
        }
        return ResponseEntity.notFound().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity <Void> deleteStudent(@PathVariable int id){
        Students existing = this.studentService.getStudentById(id);
        if(existing != null){
            studentService.deleteStudentById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
     }
}
