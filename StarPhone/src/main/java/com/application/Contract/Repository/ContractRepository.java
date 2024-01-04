package com.application.Contract.Repository;

import com.application.Contract.Entities.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository

public interface ContractRepository extends JpaRepository<Contract, UUID> {

        List<Contract> findByuser_id(UUID user_id);
}
