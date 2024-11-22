package com.juanguijordan.mspoc.order.dto;

public class OrderDTO {
    private Long id;
    private String sku;
    private String productName;
    private Integer units;
    private CustomerDTO customer;

    public OrderDTO() {
    }

    public OrderDTO(Long id, String sku, String productName, Integer units, CustomerDTO customer) {
        this.id = id;
        this.sku = sku;
        this.productName = productName;
        this.units = units;
        this.customer = customer;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getSku() {
        return sku;
    }
    public void setSku(String sku) {
        this.sku = sku;
    }
    
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    
    public Integer getUnits() {
        return units;
    }
    public void setUnits(Integer units) {
        this.units = units;
    }
    
    public CustomerDTO getCustomer() {
        return customer;
    }
    public void setCustomer(CustomerDTO customer) {
        this.customer = customer;
    }
}
