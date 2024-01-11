package pe.intercorp.apimerkao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;

import pe.intercorp.apimerkao.entity.EntitySaleNote;

public class MapperSaleNote implements RowMapper<EntitySaleNote> {
    @Override
    @Nullable
    public EntitySaleNote mapRow(ResultSet rs, int rowNum) throws SQLException {
        var result = new EntitySaleNote();
        result.setSalenote(rs.getString("salenote")); //SALENOTE
        return result;
    }
}

