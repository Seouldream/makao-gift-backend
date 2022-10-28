package com.megatera.makaogift.dtos;

public class ProductDto {
  private Long id;
  private String brand;
  private String name;
  private Long price;
  private String description;
  private String url;

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

  public String getDescription() {
    return description;
  }

  public String getUrl() {
    return url;
  }

  public ProductDto(Long id, String brand, String name, Long price, String description, String url) {
    this.id = id;
    this.brand = brand;
    this.name = name;
    this.price = price;
    this.description = description;
    this.url= url;
  }
}
