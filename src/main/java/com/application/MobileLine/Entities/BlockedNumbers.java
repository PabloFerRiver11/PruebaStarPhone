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

    @Column(name = "blockedNumber")
    private int blockedNumber;

    @Override
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public int getBlockedNumber() {
        return blockedNumber;
    }

    public void setBlockedNumber(int blockedNumber) {
        this.blockedNumber = blockedNumber;
    }
}
