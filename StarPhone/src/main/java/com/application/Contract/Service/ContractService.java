package com.application.Contract.Service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.application.Contract.Entities.Contract;
import com.application.Contract.Repository.ContractRepository;

@Service
public class ContractService {

    private final ContractRepository contractRepository;

    public ContractService(ContractRepository cRepository) {

        this.contractRepository = cRepository;
    }

    public List<Contract> getContractsByUser_Id(UUID user_id) {
        return contractRepository.findByuser_id(user_id);
    }

    public int count() {
        return (int) contractRepository.count();
    }

}
