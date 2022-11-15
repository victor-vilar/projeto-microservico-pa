package br.com.victorvilar.microservico.api.controller;

import br.com.victorvilar.microservico.api.mapper.PacienteMapper;
import br.com.victorvilar.microservico.api.request.PacienteRequest;
import br.com.victorvilar.microservico.api.response.PacienteResponse;
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
    public ResponseEntity<PacienteResponse> salvar(@RequestBody PacienteRequest pacienteRequest){
        Paciente pacienteSalvo = PacienteMapper.toPaciente(pacienteRequest);
        PacienteResponse pacienteResponse = PacienteMapper.toPacienteResponse(service.salvar(pacienteSalvo));
        return ResponseEntity.status(HttpStatus.CREATED).body(pacienteResponse);
    }

    @GetMapping
    public ResponseEntity<List<PacienteResponse>> buscarTodos(){
        List<PacienteResponse> listaPaciente = PacienteMapper.toPacienteResponseList(service.listarTodos());
        return ResponseEntity.status(HttpStatus.OK).body(listaPaciente);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id){
        Optional<Paciente> paciente = service.buscarPorId(id);
        if(paciente.isPresent()){
            return ResponseEntity.status(HttpStatus.FOUND).body(PacienteMapper.toPacienteResponse(paciente.get()));
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<PacienteResponse> alterar(@RequestBody PacienteRequest paciente, @PathVariable Long id){
        Paciente pacienteSalvo = service.alterar(PacienteMapper.toPaciente(paciente), id);
        return ResponseEntity.status(HttpStatus.OK).body(PacienteMapper.toPacienteResponse(pacienteSalvo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        service.deletar(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
