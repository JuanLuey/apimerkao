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
