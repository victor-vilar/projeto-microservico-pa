package br.com.victorvilar.microservico.api.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PacienteResponse {
    private Long id;
    private String nome;
    private String sobreNome;
    private String cpf;
    private String email;

}
