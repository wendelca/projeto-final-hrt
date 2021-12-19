package com.example.accessingdata;


import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
/**
 * UsuarioRepository
 */
public interface UsuarioRepository extends CrudRepository<User, Integer>{

    public User findById(int id);
    public Iterable<User> findAll(Sort sort);

}