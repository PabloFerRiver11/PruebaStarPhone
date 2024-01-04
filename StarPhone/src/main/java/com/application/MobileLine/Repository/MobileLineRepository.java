package com.application.MobileLine.Repository;

import com.application.MobileLine.Entities.MobileLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MobileLineRepository extends JpaRepository<MobileLine, UUID> {
}
