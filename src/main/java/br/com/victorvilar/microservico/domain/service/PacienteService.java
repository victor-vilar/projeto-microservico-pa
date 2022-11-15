package br.com.victorvilar.microservico.domain.service;

import br.com.victorvilar.microservico.domain.entity.Paciente;
import br.com.victorvilar.microservico.domain.exception.BusinessException;
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

       Optional<Paciente> cpf = repository.findByCpf(paciente.getCpf());
        if(cpf.isPresent()){
            throw new BusinessException("Paciente já registrado !!");
        }
        return this.repository.save(paciente);


    }

    public Paciente alterar(Paciente paciente, Long id){
        if(repository.findById(id).isPresent()){
            paciente.setId(repository.findById(id).get().getId());
            repository.save(paciente);

        };
        return paciente;
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
