package br.com.victorvilar.microservico.api.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PacienteRequest {


    private String nome;
    private String sobreNome;
    private String cpf;
    private String email;


}
