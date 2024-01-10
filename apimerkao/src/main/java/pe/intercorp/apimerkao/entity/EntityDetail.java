package pe.intercorp.apimerkao.entity;

import lombok.Data;

@Data
public class EntityDetail {
    private String skuCode;
    private double skuPartialSequence;
    private String description;

    private String line;
    private String lpnNumber;
    private double totalItems;
    private double canceledItems;
    private double deliveredItems;
    private double availableItems;
    private String origin;
    private String originCode;
    private String originType;
    private String destinationCode;
    private String destination;
    private String deliveryDate;
    private String withdrawalEffectiveDate;
    private String dispatchNumber;
    private String deliveryMode;
    private String withdrawPerson;
    private String withdrawPersonDocument;
}

// "skuCode": "108119",
// "skuPartialSequence": 0,
// "description": "A1 FILETE DE ATUN AC VEG LA 170GR",
// "line": "SPSA-F0029",
// "lpnNumber": "-",
// "totalItems": 10,
// "canceledItems": 0,
// "deliveredItems": 0,
// "availableItems": 10,
// "origin": "JOKR MAKRO SANTA ANITA",
// "originCode": "SPSA-1501",
// "originType": "TD",
// "destinationCode": "SPSA-ZN-106",
// "destination": "Avenida San Borja Norte,NRO: 1079,DPTO: 302,PISO: ,",
// "deliveryDate": "2024-01-09",
// "withdrawalEffectiveDate": null,
// "dispatchNumber": "2400015754772-1",
// "deliveryMode": "HOME_DELIVERY",
// "withdrawPerson": null,
// "withdrawPersonDocument": null,