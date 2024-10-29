package br.com.senac.herois.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.senac.herois.entity.Equipe;
import br.com.senac.herois.repository.EquipeRepository;


@RestController
public class EquipeController {

    private final EquipeRepository equipeRepository;

    public EquipeController(EquipeRepository equipeRepository) {
        this.equipeRepository = equipeRepository;
    }

    @GetMapping("/equipe")
    public ResponseEntity<?> getEquipe() {
        return new ResponseEntity<>(equipeRepository.findAll(), HttpStatus.OK);
    }
    
     @ PostMapping ( "/equipe" )
    @SuppressWarnings("Convert2Diamond")
    
    public ResponseEntity < ? > salvarEquipe (@ RequestBody List < Equipe > entidades ) {
        List < Equipe > cadastroEquipes;

    try {
         cadastroEquipes = equipeRepository.saveAll ( entidades );
    }
    catch ( Exception e ) {
        return new ResponseEntity <  >( "Erro ao cadastrar Equipes" , HttpStatus . BAD_REQUEST );
    }
        return new ResponseEntity < List < Equipe >>( cadastroEquipes , HttpStatus . OK );
    }
}
