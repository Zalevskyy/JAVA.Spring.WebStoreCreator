/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author lv270669zia
 */
public class DepartmentMapper implements RowMapper<Department> {

    @Override
    public Department mapRow(ResultSet rs, int i) throws SQLException {
        Department department = new Department();
      department.setId(rs.getInt("id"));
      department.setName(rs.getString("name"));
      department.setType(rs.getString("type"));
      department.setStore_id(rs.getInt("store_id"));
      //List<Seller> sellerList = (List<Seller>) rs.getArray("sellerList");
      //department.setSellerList(sellerList);

      return department;
    }
    
}
