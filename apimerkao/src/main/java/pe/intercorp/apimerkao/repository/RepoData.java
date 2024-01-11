package pe.intercorp.apimerkao.repository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import pe.intercorp.apimerkao.entity.EntityMerkao;
import pe.intercorp.apimerkao.entity.EntitySaleNote;
import pe.intercorp.apimerkao.mapper.MapperSaleNote;

@Repository
public class RepoData {

        @Autowired

        private JdbcTemplate jdbcTemplate;

        public List<EntitySaleNote> getSaleNote() {

                List<EntitySaleNote> saleNotes = null;

                String SQLSeq = """
                                 SELECT '2400015754772' AS SALENOTE FROM DUAL
                                """;
                saleNotes = jdbcTemplate.query(SQLSeq,
                                new Object[] {},
                                new int[] {},
                                new MapperSaleNote());

                return saleNotes;
        }

        /*
         * SELECT DOM.NOTA_VENTA AS SALENOTE
         * FROM DAD_ORDER_HD_MERKAO DOM
         * WHERE DOM.ORDERNUMBER IS NULL
         * GROUP BY DOM.NOTA_VENTA
         */

        public int updateSaleNote(EntityMerkao entityMerkao) {

                String v_sql = """
                                INSERT INTO EINTERFACE.IFH_STG_MERKAO_GET_API_DAD
                                (
                                NOTA_VENTA,
                                ORDERNUMBER,
                                ECOMMERCEID,
                                CUSTOMER,
                                DOCUMENTTYPE,
                                IDENTITYDOCUMENT,
                                CONTACTPHONE,
                                CONTACTEMAIL,
                                DESTINATIONCODE,
                                DESTINATION,
                                DISPATCHNUMBER,
                                DELIVERYMODE,
                                ADDRESS,
                                DEPARTMENTNUMBER,
                                UBIGEOCODE,
                                DISTRICT,
                                PROVINCE,
                                DEPARTMENT
                                )
                                VALUES
                                (
                                ?,
                                ?,
                                ?,
                                ?,
                                ?,
                                ?,
                                ?,
                                ?,
                                ?,
                                ?,
                                ?,
                                ?,
                                ?,
                                ?,
                                ?,
                                ?,
                                ?,
                                ?
                                )
                                """;
                var i = jdbcTemplate.update(v_sql, entityMerkao.getOrderInfo().getOrderNumber().toString(),
                                entityMerkao.getOrderInfo().getOrderNumber().toString(),
                                entityMerkao.getOrderInfo().getEcommerceId().toString(),
                                entityMerkao.getCustomerInfo().getCustomer().toString(),
                                entityMerkao.getCustomerInfo().getDocumentType().toString(),
                                entityMerkao.getCustomerInfo().getIdentityDocument().toString(),
                                entityMerkao.getCustomerInfo().getContactPhone().toString(),
                                entityMerkao.getCustomerInfo().getContactEmail().toString(),
                                entityMerkao.getDetails().get(0).getDestinationCode().toString(),
                                entityMerkao.getDetails().get(0).getDestination().toString(),
                                entityMerkao.getDetails().get(0).getDispatchNumber().toString(),
                                entityMerkao.getDetails().get(0).getDeliveryMode().toString(),
                                entityMerkao.getDetails().get(0).getAddress().getAddress().toString(),
                                entityMerkao.getDetails().get(0).getAddress().getDepartmentNumber().toString(),
                                entityMerkao.getDetails().get(0).getAddress().getUbigeoCode().toString(),
                                entityMerkao.getDetails().get(0).getAddress().getUbigeo().getDistrict().toString(),
                                entityMerkao.getDetails().get(0).getAddress().getUbigeo().getProvince().toString(),
                                entityMerkao.getDetails().get(0).getAddress().getUbigeo().getDepartment().toString());

                return i;

        }

}
