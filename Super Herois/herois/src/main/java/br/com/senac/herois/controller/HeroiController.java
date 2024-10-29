package br.com.senac.herois.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.senac.herois.entity.Heroi;
import br.com.senac.herois.repository.HeroiRepository;


@RestController
public class HeroiController {
    
    private final HeroiRepository heroiRepository;

    public HeroiController(HeroiRepository heroiRepository) {
        this.heroiRepository = heroiRepository;
    }
    
     @GetMapping("heroi/apelido/{apelido}")
    public ResponseEntity<?> getByApelido(@PathVariable String apelido) {
        return new ResponseEntity<>(heroiRepository.findByApelidoLike("%" + apelido + "%"), HttpStatus.OK);
    }

    @GetMapping("heroi/nome/{nome}")
    public ResponseEntity<?> getByNome(@PathVariable String nome) {
        return new ResponseEntity<>(heroiRepository.findByNomeLike("%" + nome + "%"), HttpStatus.OK);
    }

    @GetMapping("heroi/superpoder/{superpoder}")
    public ResponseEntity<?> getBySuperpoder(@PathVariable String superpoder) {
        return new ResponseEntity<>(heroiRepository.findBySuperpoderLike("%" + superpoder + "%"), HttpStatus.OK);
    }

    @ PostMapping ( "/heroi" )
    @SuppressWarnings("Convert2Diamond")
    
    public ResponseEntity < ? > salvarHerois (@ RequestBody List < Heroi > entidades ) {
        List < Heroi > cadastrosHerois ;

    try {
         cadastrosHerois = heroiRepository . saveAll ( entidades );
    }
    catch ( Exception e ) {
        return new ResponseEntity <  >( "Erro ao cadastrar heróis" , HttpStatus . BAD_REQUEST );
    }
        return new ResponseEntity < List < Heroi >>( cadastrosHerois , HttpStatus . OK );
    }
}