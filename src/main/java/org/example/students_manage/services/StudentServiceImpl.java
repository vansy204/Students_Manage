package org.example.students_manage.services;

import jakarta.transaction.Transactional;
import org.example.students_manage.dao.StudentDAO;
import org.example.students_manage.entity.Students;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServiceImpl implements StudentService{
    private StudentDAO studentDAO;
    @Autowired
    public StudentServiceImpl(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    @Override
    public List<Students> getAllStudents() {
        return this.studentDAO.findAll();
    }

    @Override
    public Students getStudentById(int id) {
        return this.studentDAO.getById(id);
    }

    @Override
    @Transactional
    public Students addStudent(Students student) {
        return this.studentDAO.add(student);
    }

    @Override
    @Transactional
    public Students updateStudent(Students student) {
        return this.studentDAO.saveAndFlush(student);
    }

    @Override
    @Transactional
    public void deleteStudentById(int id) {
        this.studentDAO.deleteById(id);
    }
}
