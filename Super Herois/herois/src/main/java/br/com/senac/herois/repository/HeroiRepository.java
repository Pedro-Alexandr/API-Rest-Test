package br.com.senac.herois.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.senac.herois.entity.Heroi;

public interface HeroiRepository extends JpaRepository<Heroi, Integer> {
    
    ArrayList<Heroi> findByNomeLike(String nome);

    ArrayList<Heroi> findByApelidoLike(String apelido);
    
    ArrayList<Heroi> findBySuperpoderLike(String superpoder);
    
}
