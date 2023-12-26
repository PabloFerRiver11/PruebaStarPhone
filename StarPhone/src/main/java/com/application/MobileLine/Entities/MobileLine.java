package com.application.MobileLine.Entities;

import com.application.General.AbstractEntity;
import com.application.Contract.Entities.Contract;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "mobileline", indexes = {
        @Index(name = "idx_contract", columnList = "contract_id", unique = false)
})
public class MobileLine extends AbstractEntity {

    @Id
    @GeneratedValue
    @JdbcTypeCode(SqlTypes.CHAR)
    @Column(name = "id")
    private UUID id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "contract_id")
    private Contract contract;

    @NotEmpty
    @Column(name = "name", nullable = false)
    private String name;

    @NotEmpty
    @Column(name = "surname", nullable = false)
    private String surname;

    @NotEmpty
    @Column(name = "serviceType", nullable = false)
    @Enumerated(EnumType.STRING)
    private ServiceType serviceType;

    @NotEmpty
    @Column(name = "monthlyPrice", nullable = false)
    private double monthlyPrice;

    @NotEmpty
    @Column(name = "phoneNumber", nullable = false)
    private int phoneNumber;

    @NotEmpty
    @Column(name = "phoneModel", nullable = false)
    private String phoneModel;

    @Column(name = "roaming", nullable = false)
    private boolean roaming;

    @Column(name = "shareData", nullable = false)
    private boolean shareData;

    @Column(name = "monthlyDataVolume", nullable = false)
    private double monthlyDataVolume;

    @Column(name = "totalCalls", nullable = false)
    private int totalCalls;

    @Column(name = "SMS", nullable = false)
    private int SMS;

    @Column(name = "dataContract", nullable = false)
    private double dataContract;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "linea_movil_id")
    private List<BlockedNumbers> numerosBloqueados;

    @Override
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public String getName() {
        return name;
    }

    public void setNombre(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public double getMonthlyPrice() {
        return monthlyPrice;
    }

    public void setMonthlyPrice(double monthlyPrice) {
        this.monthlyPrice = monthlyPrice;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneModel() {
        return phoneModel;
    }

    public void setPhoneModel(String phoneModel) {
        this.phoneModel = phoneModel;
    }

    public boolean isRoaming() {
        return roaming;
    }

    public void setRoaming(boolean roaming) {
        this.roaming = roaming;
    }

    public boolean isShareData() {
        return shareData;
    }

    public void setShareData(boolean shareData) {
        this.shareData = shareData;
    }

    public Double getMonthlyDataVolume() {
        return monthlyDataVolume;
    }

    public void setMonthlyDataVolume(Double monthlyDataVolume) {
        this.monthlyDataVolume = monthlyDataVolume;
    }

    public int getTotalCalls() {
        return totalCalls;
    }

    public void setTotalCalls(int totalcalls) {
        this.totalCalls = totalcalls;
    }

    public int getSMS() {
        return SMS;
    }

    public void setSMS(int SMS) {
        this.SMS = SMS;
    }

    public Double getDataContract() {
        return dataContract;
    }

    public void setDataContract(Double dataContract) {
        this.dataContract = dataContract;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }
}