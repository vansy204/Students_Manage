package org.example.students_manage.dao;

import org.example.students_manage.entity.Students;

import java.util.List;

public interface StudentDAO {
    public List<Students> findAll();
    public Students getById(int id);
    public Students add(Students students);
    //update
    public Students saveAndFlush(Students students);
    public void deleteById(int id);
}

