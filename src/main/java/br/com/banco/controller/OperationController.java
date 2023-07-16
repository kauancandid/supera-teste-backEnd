package br.com.banco.controller;

import br.com.banco.model.OperationModel;
import br.com.banco.service.impl.OperationServiceImpl;
import br.com.banco.dto.OperationRequestDTO;
import br.com.banco.dto.OperationResponseDTO;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController()
@RequestMapping(value = "/operation", produces="application/json")
public class OperationController {
    private final OperationServiceImpl operationService;

    public OperationController(OperationServiceImpl operationService) {
        this.operationService = operationService;
    }


    @ApiOperation("This method is used to save a operation.")
    @PostMapping()
    public ResponseEntity<OperationResponseDTO> saveOperation(@RequestBody @Valid OperationRequestDTO operationRequestDTO) {
        OperationModel classificationProcessesModel = this.operationService.saveOperation(operationRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(OperationResponseDTO.convertToDTO(classificationProcessesModel));
    }

    @ApiOperation("This method is used to update operationId data.")
    @PatchMapping("update/{classificationId}")
    public ResponseEntity<OperationResponseDTO> updateOperationId(@PathVariable String classificationId,
                                                                      @RequestBody @Valid OperationRequestDTO operationRequestDTO) {

        var classification = this.operationService.updateOperation(classificationId, operationRequestDTO);
        return ResponseEntity.status(HttpStatus.OK).body(OperationResponseDTO.convertToDTO(classification));
    }

    @ApiOperation("This method is used to list all operation data.")
    @GetMapping("/get-all")
    public ResponseEntity<List<OperationResponseDTO>> listOperation() {

        List<OperationModel> classificationProcessesModels = this.operationService.listAllOperation();
        List<OperationResponseDTO> classificationProcessesResponseDTOS = new ArrayList<>();
        for (OperationModel classificationModel : classificationProcessesModels) {
            classificationProcessesResponseDTOS.add(OperationResponseDTO.convertToDTO(classificationModel));
        }

        return ResponseEntity.status(HttpStatus.OK).body(classificationProcessesResponseDTOS);
    }

    @ApiOperation("This method is used to list operation data.")
    @GetMapping("get/{classificationId}")
    public ResponseEntity<OperationResponseDTO> listProcessesId(@PathVariable String classificationId) {
        var classificationProcessesModel = this.operationService.getOperationById(classificationId);

        return ResponseEntity.status(HttpStatus.OK).body(OperationResponseDTO.convertToDTO(classificationProcessesModel));
    }

    @ApiOperation("This method is used to delete one operation registered.")
    @DeleteMapping("delete/{classificationId}")
    public ResponseEntity deleteOperation(@PathVariable String classificationId) {
        this.operationService.deleteOperation(classificationId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
