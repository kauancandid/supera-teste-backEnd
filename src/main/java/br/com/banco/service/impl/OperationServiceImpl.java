package br.com.banco.service.impl;

import br.com.banco.repository.OperationRepository;
import br.com.banco.dto.OperationRequestDTO;
import br.com.banco.model.OperationModel;
import br.com.banco.service.OperationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class OperationServiceImpl implements OperationService {

    private OperationRepository operationRepository;

    public OperationServiceImpl(OperationRepository operationRepository) {
        this.operationRepository = operationRepository;
    }

    @Override
    public OperationModel saveOperation(OperationRequestDTO operationRequestDTO) {

        var operationModel= new OperationModel();
        operationModel.setBalance(operationRequestDTO.getBalance());
        operationModel.setName(operationRequestDTO.getName());
        operationModel.setValence(operationRequestDTO.getValence());
        operationModel.setInitialDate(operationRequestDTO.getInitialDate());
        operationModel.setEndDate(operationRequestDTO.getEndDate());

        this.operationRepository.save(operationModel);

        return operationModel;

    }

    @Override
    public OperationModel updateOperation(String operationId, OperationRequestDTO operationRequestDTO) {
        Optional<OperationModel> operationOptional = this.operationRepository.findById(UUID.fromString(operationId));
        if(operationOptional.isEmpty()) {
            throw new RuntimeException("Operador não encontrado!");
        }

        var operationModel = operationOptional.get();
        operationModel.setBalance(operationRequestDTO.getBalance());
        operationModel.setName(operationRequestDTO.getName());
        operationModel.setValence(operationRequestDTO.getValence());
        operationModel.setInitialDate(operationRequestDTO.getInitialDate());
        operationModel.setEndDate(operationRequestDTO.getEndDate());

        return this.operationRepository.save(operationModel);
    }

    @Override
    public OperationModel getOperationById(String operationId) {

        Optional<OperationModel> operationOptional = this.operationRepository.findById(UUID.fromString(operationId));
        if (operationOptional.isEmpty()) {
            throw new RuntimeException("Operador não encontrado!");
        }
        return operationOptional.get();
    }


    @Override
    public List<OperationModel> listAllOperation() {
        return operationRepository.findAll();
    }

    @Override
    public void deleteOperation(String operationId) {

        Optional<OperationModel> operationOptional = this.operationRepository.findById(UUID.fromString(operationId));
        if (operationOptional.isEmpty()) {
            throw new RuntimeException("Operador não encontrado!");
        }
        operationRepository.delete(operationOptional.get());
    }

}
