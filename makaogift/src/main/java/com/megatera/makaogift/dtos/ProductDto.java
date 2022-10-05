package com.megatera.makaogift.dtos;

public class ProductDto {
  private Long id;
  private String brand;
  private String name;
  private Long price;

  public ProductDto() {
  }

  public Long getId() {
    return id;
  }

  public String getBrand() {
    return brand;
  }

  public String getName() {
    return name;
  }

  public Long getPrice() {
    return price;
  }

  public ProductDto(Long id, String brand, String name, Long price) {
    this.id = id;
    this.brand = brand;
    this.name = name;
    this.price = price;
  }
}
