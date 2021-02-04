package com.admin.crawler.mapper;

import com.admin.crawler.entity.TableInfo;
import com.admin.crawler.entity.TestUser;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;



public class TableRowMapper implements RowMapper {

    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        TableInfo tableInfo = new TableInfo(
                rs.getString("columnName"),
                rs.getString("dataType"),
                rs.getString("columnComment")
                );
        return tableInfo;
    }
}
