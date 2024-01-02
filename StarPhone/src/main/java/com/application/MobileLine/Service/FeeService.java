package com.application.MobileLine.Service;

import com.application.MobileLine.Repository.FeeRepository;
import com.application.MobileLine.Entities.Fee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeeService {
    private final FeeRepository feeRepository;

    public FeeService(FeeRepository feeRepository) {
        this.feeRepository = feeRepository;
    }

    public List<Fee> findAll() {
        return feeRepository.findAll();
    }
}