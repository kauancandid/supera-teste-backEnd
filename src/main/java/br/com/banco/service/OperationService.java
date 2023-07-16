package br.com.banco.service;

import br.com.banco.dto.OperationRequestDTO;
import br.com.banco.model.OperationModel;

import java.util.List;

public interface OperationService {
    OperationModel saveOperation(OperationRequestDTO operationRequestDTO);
    OperationModel updateOperation(String classificationId, OperationRequestDTO operationRequestDTO);
    OperationModel getOperationById(String operationId);
    List<OperationModel> listAllOperation();
    void deleteOperation(String OperationId);
}
