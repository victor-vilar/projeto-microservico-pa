package br.com.victorvilar.microservico.api.controller;

import br.com.victorvilar.microservico.domain.entity.Paciente;
import br.com.victorvilar.microservico.domain.service.PacienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/paciente")
@RequiredArgsConstructor
public class PacienteController {

    @Autowired
    private final PacienteService service;

    @PostMapping
    public ResponseEntity<Paciente> salvar(@RequestBody Paciente paciente){
     Paciente pacienteSalvo = service.salvar(paciente);
        return ResponseEntity.status(HttpStatus.CREATED).body(pacienteSalvo);
    }

    @GetMapping
    public ResponseEntity<List<Paciente>> buscarTodos(){
        List<Paciente> listaPaciente = service.listarTodos();
        return ResponseEntity.status(HttpStatus.OK).body(listaPaciente);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id){
        Optional<Paciente> paciente = service.buscarPorId(id);
        if(paciente.isPresent()){
            return ResponseEntity.status(HttpStatus.FOUND).body(paciente.get());

        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("");
        }
    }
}
