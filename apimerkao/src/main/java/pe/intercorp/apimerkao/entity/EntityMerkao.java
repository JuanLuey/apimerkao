package pe.intercorp.apimerkao.entity;
import java.util.List;

import lombok.Data;

@Data
public class EntityMerkao {
    private EntityCustomerInfo customerInfo;
    private EntityOrderInfo orderInfo;
    private List<EntityDetail> details;
}
