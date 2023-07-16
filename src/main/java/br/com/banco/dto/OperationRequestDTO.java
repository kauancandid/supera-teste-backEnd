package br.com.banco.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class OperationRequestDTO {

    @NotNull(message = "Campo data de inicio não pode ser vazio")
    private Date initialDate;

    @NotNull(message = "Campo data de termino não pode ser vazio")
    private Date endDate;

    @NotBlank(message = "Campo nome não pode ser vazio")
    private String name;

    private double valence;

    @NotNull(message = "Campo saldo não pode ser vazio")
    private double balance;

}
