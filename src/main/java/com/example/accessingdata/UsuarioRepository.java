package com.example.accessingdata;


import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
/**
 * UsuarioRepository
 */
public interface UsuarioRepository extends CrudRepository<Usuario, Integer>{

    public Usuario findById(int id);
    public Iterable<Usuario> findAll(Sort sort);
    public Usuario findByNome(String nome);
    public Usuario findByEmail(String email);
    public Usuario findByStatus(String status);
    public Usuario findByLocal(String local);
    public Usuario findByInicioPrevisto(String inicioPrevisto);
    public Usuario findByIniciodaCirurgia(String iniciodaCirurgia);
    public Usuario findByfImdaCirurgia(String fimCirurgia);
    public Usuario findBySaidaPrevista(String saidaPrevista); 

}