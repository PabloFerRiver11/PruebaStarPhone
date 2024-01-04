package com.application.MobileLine.Entities;

import com.application.General.AbstractEntity;
import com.application.Contract.Entities.Contract;
import com.application.User.Entities.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
    @Size(min = 9, max = 9)
    @Column(name = "DNI", unique = true)
    private String DNI;



    @NotEmpty
    @Enumerated(EnumType.STRING)
    @Column(name = "serviceType", nullable = false)
    private ServiceType serviceType;

    @NotEmpty
    @Column(name = "phoneNumber", nullable = false,unique = true)
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

    @Column(name = "totalSMS", nullable = false)
    private int totalSMS;

    @Column(name = "totalDataContract", nullable = false)
    private double totalDataContract;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "mobileLine_id")
    private List<BlockedNumbers> numerosBloqueados;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    @NotNull
    private User user;

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





    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public String getPhoneModel() {
        return phoneModel;
    }

    public void setPhoneModel(String phoneModel) {
        this.phoneModel = phoneModel;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
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

    public int getTotalSMS() {
        return totalSMS;
    }

    public void setTotalSMS(int totalSMS) {
        this.totalSMS = totalSMS;
    }

    public Double getTotalDataContract() {
        return totalDataContract;
    }
    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public void setTotalDataContract(Double totalDataContract) {
        this.totalDataContract = totalDataContract;
    }

    public List<BlockedNumbers> getNumerosBloqueados() {
        return this.numerosBloqueados;
    }

    public void setNumerosBloqueados(List<BlockedNumbers> numerosBloqueados) {
        this.numerosBloqueados = numerosBloqueados;
    }
    public void setNumeroBloqueado(BlockedNumbers numeroBloqueado) {
        this.numerosBloqueados.add(numeroBloqueado);
    }

}
