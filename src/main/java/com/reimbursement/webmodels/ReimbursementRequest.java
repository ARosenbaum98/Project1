package com.reimbursement.webmodels;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name ="p1_reimbursement_requests")
public class ReimbursementRequest {
    @Id
    @Column(name = "request_id", nullable = false)
    private Long id;

    @Column(name = "is_pending", nullable = false)
    private Boolean isPending = false;

    @Column(name = "is_approved")
    private Boolean isApproved;

    @Column(name = "amount", nullable = false, precision = 8, scale = 2)
    private BigDecimal amount;

    @Column(name = "description", nullable = false, length = 180)
    private String description;

    @Column(name = "date_of_purchase", nullable = false)
    private Instant dateOfPurchase;

    @Column(name = "date_of_submission", nullable = false)
    private Instant dateOfSubmission;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public Instant getDateOfSubmission() {
        return dateOfSubmission;
    }

    public void setDateOfSubmission(Instant dateOfSubmission) {
        this.dateOfSubmission = dateOfSubmission;
    }

    public Instant getDateOfPurchase() {
        return dateOfPurchase;
    }

    public void setDateOfPurchase(Instant dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Boolean getIsApproved() {
        return isApproved;
    }

    public void setIsApproved(Boolean isApproved) {
        this.isApproved = isApproved;
    }

    public Boolean getIsPending() {
        return isPending;
    }

    public void setIsPending(Boolean isPending) {
        this.isPending = isPending;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ReimbursementRequest{" +
                "id=" + id +
                ", isPending=" + isPending +
                ", isApproved=" + isApproved +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                ", dateOfPurchase=" + dateOfPurchase +
                ", dateOfSubmission=" + dateOfSubmission +
                ", user= " + user.getFname() + " " + user.getLname() + ": "+getUser()+
                '}';
    }
}
