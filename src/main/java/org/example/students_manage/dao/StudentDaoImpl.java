package org.example.students_manage.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.example.students_manage.entity.Students;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class StudentDaoImpl implements StudentDAO{
    EntityManager entityManager;
    @Autowired
    public StudentDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    @Override
    public List<Students> findAll() {
        String jpql = "SELECT s FROM Students s";
        Query query = entityManager.createQuery(jpql,Students.class);
        return query.getResultList();
    }

    @Override
    public Students getById(int id) {
        return entityManager.find(Students.class,id);
    }

    @Override
    public Students add(Students students) {
        entityManager.persist(students);
        return students;
    }

    @Override

    public Students saveAndFlush(Students students) {
        students = entityManager.merge(students);
        entityManager.flush();
        return students;
    }

    @Override
    public void deleteById(int id) {
        entityManager.remove(entityManager.find(Students.class,id));
    }
}
