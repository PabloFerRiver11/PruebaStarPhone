package com.application.MobileLine.Entities;

import com.application.General.AbstractEntity;
import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.UUID;

@Entity
@Table(name = "blockedNumbers")
public class BlockedNumbers extends AbstractEntity {
    @Id
    @GeneratedValue
    @JdbcTypeCode(SqlTypes.CHAR)
    @Column(name = "id")
    private UUID id;

    @Column(name = "mobileLine_id")
    private UUID mobileLine_id;

    @Column(name = "blockedNumber")
    private int blockedNumber;

    @Override
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getMobileLineId() {
        return mobileLine_id;
    }

    public void setMobileLineId(UUID mobileLine_id) {
        this.mobileLine_id = mobileLine_id;
    }

    public int getBlockedNumber() {
        return blockedNumber;
    }

    public void setBlockedNumber(int blockedNumber) {
        this.blockedNumber = blockedNumber;
    }
}
