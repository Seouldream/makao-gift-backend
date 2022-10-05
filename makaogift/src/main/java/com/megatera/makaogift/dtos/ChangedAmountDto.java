package com.megatera.makaogift.dtos;

public class ChangedAmountDto {
  private Long changedAmount;

  public ChangedAmountDto() {
  }

  public ChangedAmountDto(Long changedAmount) {
    this.changedAmount = changedAmount;
  }

  public Long getChangedAmount() {
    return changedAmount;
  }
}