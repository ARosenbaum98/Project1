package com.reimbursement.webmodels;

import java.time.LocalDateTime;
import java.util.Objects;

public class ReimbursementRequest {
    private int id;
    private int userId;
    private boolean isPending;
    private boolean isApproved;
    private double amount;
    private String description;
    private LocalDateTime dateOfPurchase;
    private LocalDateTime dateOfSubmission;
    private LocalDateTime dateOfApproval;
    private int approvingManagerId;

    public ReimbursementRequest(int id, int userId, boolean isPending, boolean isApproved, double amount, String description, LocalDateTime dateOfPurchase, LocalDateTime dateOfSubmission, LocalDateTime dateOfApproval, int approvingManagerId) {
        this.id = id;
        this.setUserId(userId);
        this.setPending(isPending);
        this.setApproved(isApproved);
        this.setAmount(amount);
        this.setDescription(description);
        this.setDateOfPurchase(dateOfPurchase);
        this.setDateOfSubmission(dateOfSubmission);
        this.setDateOfApproval(dateOfApproval);
        this.setApprovingManagerId(approvingManagerId);
    }

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public boolean isPending() {
        return isPending;
    }

    public void setPending(boolean pending) {
        this.isPending = pending;
    }

    public boolean isApproved() {
        return isApproved;
    }

    public void setApproved(boolean approved) {
        this.isApproved = approved;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDateOfPurchase() {
        return dateOfPurchase;
    }

    public void setDateOfPurchase(LocalDateTime dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }

    public LocalDateTime getDateOfSubmission() {
        return dateOfSubmission;
    }

    public void setDateOfSubmission(LocalDateTime dateOfSubmission) {
        this.dateOfSubmission = dateOfSubmission;
    }

    public LocalDateTime getDateOfApproval() {
        return dateOfApproval;
    }

    public void setDateOfApproval(LocalDateTime dateOfApproval) {
        this.dateOfApproval = dateOfApproval;
    }

    public int getApprovingManagerId() {
        return approvingManagerId;
    }

    public void setApprovingManagerId(int approvingManagerId) {
        this.approvingManagerId = approvingManagerId;
    }

    @Override
    public String toString() {
        return "ReimbursementRequest{" +
                "id=" + this.getId() +
                ", userId=" + this.getUserId() +
                ", isPending=" + this.isPending() +
                ", isApproved=" + this.isApproved() +
                ", amount=" + this.getAmount() +
                ", description='" + this.getDescription() + '\'' +
                ", dateOfPurchase=" + this.getDateOfPurchase() +
                ", dateOfSubmission=" + this.getDateOfSubmission() +
                ", dateOfApproval=" + this.getDateOfApproval() +
                ", approvingManagerId=" + this.getApprovingManagerId() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReimbursementRequest that = (ReimbursementRequest) o;
        return getId() == that.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public ReimbursementRequest clone(){
        return new ReimbursementRequest(this.getId(), this.getUserId(), this.isPending(), this.isApproved(), this.getAmount(), this.getDescription(), this.getDateOfPurchase(), this.getDateOfSubmission(), this.getDateOfApproval(), this.getApprovingManagerId());
    }
}
