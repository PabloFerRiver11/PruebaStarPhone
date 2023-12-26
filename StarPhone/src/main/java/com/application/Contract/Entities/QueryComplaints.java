package com.application.Contract.Entities;

import com.application.General.AbstractEntity;
import com.application.MobileLine.Entities.MobileLine;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "ConsultasReclamaciones")
public class QueryComplaints extends AbstractEntity {
    @Id
    @GeneratedValue
    @JdbcTypeCode(SqlTypes.CHAR)
    @Column(name = "id")
    private UUID id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "mobileLine_id")
    private MobileLine mobileLine;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "contract_id")
    private Contract contract;

    @NotEmpty
    @Column(name = "description")
    private String description;

    // Estado
    @NotEmpty
    @Column(name = "status")
    private String status;

    // Fecha Creacion
    @NotEmpty
    @Column(name = "createDate")
    private LocalDate createDate;

    @NotEmpty
    @Column(name = "resolutionDate")
    private LocalDate resolutionDate;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "responseComplaints_id")
    private List<ResponseComplaints> responseComplaints;

    public List<ResponseComplaints> getResponseComplaints() {
        return responseComplaints;
    }

    public void setResponseComplaints(ResponseComplaints responseComplaint) {
        responseComplaints.add(responseComplaint);
    }

    @Override
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public MobileLine getMobileLine() {
        return mobileLine;
    }

    public void setMobileLine(MobileLine mobileLine) {
        this.mobileLine = mobileLine;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getCreatDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public LocalDate getResolutionDate() {
        return resolutionDate;
    }

    public void setResolutionDate(LocalDate resolutionDate) {
        this.resolutionDate = resolutionDate;
    }
}
