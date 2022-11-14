package br.com.victorvilar.microservico.domain.service;

import br.com.victorvilar.microservico.domain.entity.Paciente;
import br.com.victorvilar.microservico.domain.repository.PacienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class PacienteService {

    @Autowired
    private final PacienteRepository repository;

    public Paciente salvar(Paciente paciente){
        return this.repository.save(paciente);
        //TODO VALIDAR SE O CPF JA EXISTE
    }

    public void deletar(Long id){
        repository.deleteById(id);
    }

    public List<Paciente> listarTodos(){
        return repository.findAll();
    }

    public Optional<Paciente> buscarPorId(Long id){
        return repository.findById(id);
    }



}
