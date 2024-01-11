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
    private EntityAddress address;
}

