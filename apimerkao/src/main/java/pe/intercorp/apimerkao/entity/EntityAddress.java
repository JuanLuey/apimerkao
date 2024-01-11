package pe.intercorp.apimerkao.entity;
import lombok.Data;

@Data
public class EntityAddress {
   private String address;    
   private String departmentNumber;
   private String ubigeoCode;
   private EntityUbigeo ubigeo;
}
