package com.application.MobileLine.Service;

import com.application.MobileLine.Entities.BlockedNumbers;
import com.application.MobileLine.Entities.MobileLine;
import com.application.MobileLine.Repository.MobileLineRepository;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class MobileLineService {
    private final MobileLineRepository mobileLineRepository;

    public MobileLineService(MobileLineRepository mRepository) {
        this.mobileLineRepository = mRepository;
    }

    public void blockNumber(int phoneNumberToBlock, int phoneNumber) {
        BlockedNumbers blockedNumber = new BlockedNumbers();
        MobileLine mLine = mobileLineRepository.findByPhoneNumber(phoneNumber);
        blockedNumber.setBlockedNumber(phoneNumberToBlock);
        mLine.addBlockedNumber(blockedNumber);
        mobileLineRepository.save(mLine);
    }

    public List<MobileLine> getMobileLineByContractId(UUID contract_id) {
        return mobileLineRepository.findMobileLineByContract_Id(contract_id);
    }

    public void activateRoaming(MobileLine mobileline) {
        mobileline.setRoaming(true);
        mobileLineRepository.save(mobileline);

    }

    public void activateShareData(MobileLine mobileLine) {
        mobileLine.setShareData(true);
        mobileLineRepository.save(mobileLine);
    }
}
