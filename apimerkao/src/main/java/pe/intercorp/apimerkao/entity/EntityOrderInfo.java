package pe.intercorp.apimerkao.entity;

import lombok.Data;

@Data
public class EntityOrderInfo {
    private String orderNumber;
    private String ecommerceId;
    private String companyCode;
    private String saleEntity;
    private String saleEntityCode;
    private String username;
    private String freightAuthUsername;
    private String priceAuthUsername;
    private String saleWithoutStockUsername;
    private String generatedDate;
    private String totalAmount;
    private String status;
    private String stateCode;
    private String paymentMethod;
    private String startEffectiveDate;
    private String endEffectiveDate;
    private Boolean op14payment;
}

