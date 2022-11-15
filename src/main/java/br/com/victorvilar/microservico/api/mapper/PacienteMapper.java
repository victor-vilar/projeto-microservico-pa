package br.com.victorvilar.microservico.api.mapper;

import br.com.victorvilar.microservico.api.request.PacienteRequest;
import br.com.victorvilar.microservico.api.response.PacienteResponse;
import br.com.victorvilar.microservico.domain.entity.Paciente;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class PacienteMapper {


    private final ModelMapper mapper;

    public Paciente toPaciente(PacienteRequest pacienteRequest){
        return mapper.map(pacienteRequest,Paciente.class);
    }

    public PacienteResponse toPacienteResponse(Paciente paciente){
        return mapper.map(paciente,PacienteResponse.class);
    }

   public List<PacienteResponse> toPacienteResponseList(List<Paciente> listaDepacientes){
        return listaDepacientes.stream().map(e-> toPacienteResponse(e)).collect(Collectors.toList());
    }


}
