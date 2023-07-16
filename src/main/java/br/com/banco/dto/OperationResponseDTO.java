package br.com.banco.dto;

import br.com.banco.model.OperationModel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@Data
public class OperationResponseDTO {

    private UUID id;
    private Date initialDate;
    private Date endDate;
    private String name;
    private double valence;
    private double balance;


    public static OperationResponseDTO convertToDTO(OperationModel operation) {

        var operationResponseDTO = new OperationResponseDTO();
        operationResponseDTO.setId(operation.getId());
        operationResponseDTO.setInitialDate(operation.getInitialDate());
        operationResponseDTO.setEndDate(operation.getEndDate());
        operationResponseDTO.setName(operation.getName());
        operationResponseDTO.setValence(operation.getValence());
        operationResponseDTO.setBalance(operation.getBalance());

        return operationResponseDTO;
    }
}