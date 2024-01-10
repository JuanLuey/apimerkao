package pe.intercorp.apimerkao.entity;
import lombok.Data;

@Data
public class EntityCustomerInfo {
    private String customer;
    private String documentType;
    private String identityDocument;
    private String contactPhone;
    private String contactEmail;  
}


    // "customer": "Jose Avalos",
    //     "documentType": "DNI",
    //     "identityDocument": "71472174",
    //     "contactPhone": "999999998",
    //     "contactEmail": "test@test.pe"