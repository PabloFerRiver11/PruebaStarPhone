package com.application.MobileLine.Service;

import com.application.MobileLine.Entities.BlockedNumbers;
import com.application.MobileLine.Entities.MobileLine;
import com.application.MobileLine.Repository.MobileLineRepository;
import org.springframework.stereotype.Service;

@Service
public class MobileLineService {
    private final MobileLineRepository mobileLineRepository;

    public MobileLineService(MobileLineRepository mRepository) {
        this.mobileLineRepository = mRepository;
    }
    public void blockNumber(int phoneNumber, MobileLine mobileLine) {
        BlockedNumbers blockedNumber = new BlockedNumbers();
        blockedNumber.setBlockedNumber(phoneNumber);
        mobileLine.setNumeroBloqueado(blockedNumber);
        mobileLineRepository.save(mobileLine);
    }

    public void activateRoaming(MobileLine mobileline) {
        mobileline.setRoaming(true);
        mobileLineRepository.save(mobileline);

    }

    public void share(MobileLine mobileLine) {
        mobileLine.setShareData(true);
        mobileLineRepository.save(mobileLine);
    }
}
