package br.com.banco.repository;



import br.com.banco.model.OperationModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OperationRepository extends JpaRepository<OperationModel, UUID> {

}
