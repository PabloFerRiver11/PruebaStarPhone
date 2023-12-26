package com.application.Contract.Entities;

import com.application.General.AbstractEntity;
import com.application.MobileLine.Entities.MobileLine;
import com.application.User.Entities.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "contract", indexes = {
        @Index(name = "idx_user", columnList = "user_id", unique = false)
})
public class Contract extends AbstractEntity {
    @Id
    @GeneratedValue
    @JdbcTypeCode(SqlTypes.CHAR)
    @Column(name = "id")
    private UUID id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    @NotNull
    private User user;

    @NotEmpty
    @Column(name = "startDate")
    private LocalDate startDate;

    @NotEmpty
    @Column(name = "endDate")
    private LocalDate endDate;

    @NotEmpty
    @Column(name = "status")
    private String status;

    @OneToMany(mappedBy = "contract")
    private List<MobileLine> mobileLines;

    @OneToMany(mappedBy = "contract")
    private List<Bill> bills;

    @OneToMany(mappedBy = "contract")
    private List<QueryComplaints> queryComplaints;

    @Override
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<MobileLine> getMobileLines() {
        return mobileLines;
    }

    public void setMobileLines(MobileLine mobileLine) {
        mobileLines.add(mobileLine);
    }

    public List<Bill> getBills() {
        return bills;
    }

    public void setFacturas(Bill bill) {
        bills.add(bill);
    }

    public List<QueryComplaints> getQueryComplaints() {
        return queryComplaints;
    }

    public void setQueryComplaints(QueryComplaints queryComplaint) {
        queryComplaints.add(queryComplaint);
    }

}
