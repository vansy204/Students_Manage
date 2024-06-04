package org.example.students_manage.services;

import org.example.students_manage.entity.Students;

import java.util.List;

public interface StudentService {
    public List<Students> getAllStudents();
    public Students getStudentById(int id);
    public Students addStudent(Students student);
    public Students updateStudent(Students student);
    public void deleteStudentById(int id);
}
