package br.com.victorvilar.microservico.api.mapper;

import br.com.victorvilar.microservico.api.request.PacienteRequest;
import br.com.victorvilar.microservico.api.response.PacienteResponse;
import br.com.victorvilar.microservico.domain.entity.Paciente;

import java.util.List;
import java.util.stream.Collectors;

public abstract class PacienteMapper {


    public static Paciente toPaciente(PacienteRequest pacienteRequest){
        Paciente pacienteCriado = new Paciente();
        pacienteCriado.setNome(pacienteRequest.getNome());
        pacienteCriado.setCpf(pacienteRequest.getCpf());
        pacienteCriado.setSobreNome(pacienteRequest.getSobreNome());
        pacienteCriado.setEmail(pacienteRequest.getEmail());
        return pacienteCriado;
    }

    public static PacienteResponse toPacienteResponse(Paciente paciente){
        PacienteResponse pacienteResponse = new PacienteResponse();
        pacienteResponse.setId(paciente.getId());
        pacienteResponse.setNome(paciente.getNome());
        pacienteResponse.setSobreNome(paciente.getSobreNome());
        pacienteResponse.setEmail(paciente.getEmail());
        pacienteResponse.setCpf(paciente.getCpf());
        return pacienteResponse;
    }


    public static List<PacienteResponse> toPacienteResponseList(List<Paciente> listaDepacientes){
        return listaDepacientes.stream().map(e-> toPacienteResponse(e)).collect(Collectors.toList());
    }
}
