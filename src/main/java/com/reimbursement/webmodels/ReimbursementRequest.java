package com.reimbursement.webmodels;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name ="p1_reimbursement_requests")
public class ReimbursementRequest {
    @Id
    @Column(name = "request_id", nullable = false)
    private int id;

    @Column(name = "is_pending", nullable = false)
    private Boolean isPending = false;

    @Column(name = "is_approved")
    private Boolean isApproved;

    @Column(name = "amount", nullable = false, precision = 8, scale = 2)
    private double amount;

    @Column(name = "description", nullable = false, length = 180)
    private String description;

    @Column(name = "date_of_purchase", nullable = false)
    private LocalDateTime dateOfPurchase;

    @Column(name = "date_of_submission", nullable = false)
    private LocalDateTime dateOfSubmission;

    @Column(name = "date_of_approval")
    private LocalDateTime dateOfApproval;

    @JoinColumn(name = "p1_users", referencedColumnName = "user_id")
    @ManyToOne(targetEntity = User.class, cascade = CascadeType.ALL)
    private User user;

    public ReimbursementRequest(int id, Boolean isPending, Boolean isApproved, double amount, String description, LocalDateTime dateOfPurchase, LocalDateTime dateOfSubmission, LocalDateTime dateOfApproval, User user) {
        this.id = id;
        this.isPending = isPending;
        this.isApproved = isApproved;
        this.amount = amount;
        this.description = description;
        this.dateOfPurchase = dateOfPurchase;
        this.dateOfSubmission = dateOfSubmission;
        this.dateOfApproval = dateOfApproval;
        this.user = user;
    }

    public ReimbursementRequest() {

    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Boolean getPending() {
        return isPending;
    }

    public void setPending(Boolean pending) {
        isPending = pending;
    }

    public Boolean getApproved() {
        return isApproved;
    }

    public void setApproved(Boolean approved) {
        isApproved = approved;
    }

    public LocalDateTime getDateOfApproval() {
        return dateOfApproval;
    }

    public void setDateOfApproval(LocalDateTime dateOfApproval) {
        this.dateOfApproval = dateOfApproval;
    }

    public LocalDateTime getDateOfSubmission() {
        return dateOfSubmission;
    }

    public void setDateOfSubmission(LocalDateTime dateOfSubmission) {
        this.dateOfSubmission = dateOfSubmission;
    }

    public LocalDateTime getDateOfPurchase() {
        return dateOfPurchase;
    }

    public void setDateOfPurchase(LocalDateTime dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
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


    public int getId() {
        return id;
    }

    public void setId(int id) {
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
                ", dateOfApproval=" + dateOfApproval +
                ", user= " + user.getFname() + " " + user.getLname() + ": "+getUser()+
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReimbursementRequest that = (ReimbursementRequest) o;
        return id == that.id && Double.compare(that.amount, amount) == 0 && isPending.equals(that.isPending) && Objects.equals(isApproved, that.isApproved) && Objects.equals(description, that.description) && dateOfPurchase.equals(that.dateOfPurchase) && dateOfSubmission.equals(that.dateOfSubmission) && Objects.equals(dateOfApproval, that.dateOfApproval) && user.equals(that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, isPending, isApproved, amount, description, dateOfPurchase, dateOfSubmission, dateOfApproval, user);
    }

    @Override
    public ReimbursementRequest clone(){
        return new ReimbursementRequest(id, isPending, isApproved, amount, description, dateOfPurchase, dateOfSubmission, dateOfApproval, user);
    }

}
