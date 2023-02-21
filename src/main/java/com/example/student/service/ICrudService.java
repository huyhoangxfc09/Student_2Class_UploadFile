package com.example.student.service;

import java.util.List;

public interface ICrudService <E>{
    List<E> findAll();
    void save(E e);
    void update(int id, E e);
    void delete(int id);
    E findById(int id);
}
