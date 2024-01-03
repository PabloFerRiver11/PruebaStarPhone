package com.application.MobileLine.Entities;

import com.application.General.AbstractEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import java.util.UUID;

@Entity
@Table(name = "fee", indexes = {
        @Index(name = "idx_fee", columnList = "id", unique = false)
})
public class Fee extends AbstractEntity {

    @Id
    @GeneratedValue
    @JdbcTypeCode(SqlTypes.CHAR)
    @Column(name = "id")
    private UUID id;

    @NotEmpty
    @Column(name = "title", nullable = false)
    private String title;

    @NotEmpty
    @Column(name = "descriptionMobile", nullable = false)
    private String descriptionMobile;

    @NotEmpty
    @Column(name = "descriptionFiber", nullable = false)
    private String descriptionFiber;

    @NotEmpty
    @Column(name = "descriptionTV", nullable = false)
    private String descriptionTV;

    @NotEmpty
    @Column(name = "monthlyprice", nullable = false)
    private double monthlyprice;

    @NotEmpty
    @Column(name = "maxMobileLines", nullable = false)
    private int maxMobileLines;

    @Override
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescriptionMobile() {
        return descriptionMobile;
    }

    public void setDescriptionMobile(String descriptionMobile) {
        this.descriptionMobile = descriptionMobile;
    }

    public String getDescriptionFiber() {
        return descriptionFiber;
    }

    public void setDescriptionFiber(String descriptionFiber) {
        this.descriptionFiber = descriptionFiber;
    }

    public String getDescriptionTV() {
        return descriptionTV;
    }

    public void setDescription(String descriptionTV) {
        this.descriptionTV = descriptionTV;
    }

    public double getMonthlyprice() {
        return this.monthlyprice;
    }

    public void setMonthlyprice(double monthlyprice) {
        this.monthlyprice = monthlyprice;
    }

    public int getMaxMobileLines() {
        return this.maxMobileLines;
    }

    public void setMaxMobileLines(int maxMobileLines) {
        this.maxMobileLines = maxMobileLines;
    }
}