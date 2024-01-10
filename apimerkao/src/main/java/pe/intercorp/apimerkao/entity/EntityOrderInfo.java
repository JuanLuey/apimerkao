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

// "orderInfo": {
// "orderNumber": "2400015754772",
// "ecommerceId": "1704828935977-01",
// "companyCode": "SPSA",
// "saleEntity": "JOKR MAKRO SANTA ANITA",
// "saleEntityCode": "SPSA-1501",
// "username": "MERKAO",
// "freightAuthUsername": "-",
// "priceAuthUsername": "-",
// "saleWithoutStockUsername": "-",
// "generatedDate": "2024-01-09",
// "totalAmount": "-",
// "status": "Pagada",
// "stateCode": "PAYED",
// "paymentMethod": "CASH_ON_DELIVERY",
// "startEffectiveDate": "09/01/2024",
// "endEffectiveDate": "09/01/2024",
// "op14payment": false