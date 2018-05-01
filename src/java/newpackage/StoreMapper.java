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
public class StoreMapper implements RowMapper<Store> {

    //public StoreMapper() {    }
    @Override
    public Store mapRow(ResultSet rs, int rowNum) throws SQLException {
      Store store = new Store();
      store.setId(rs.getInt("id"));
      store.setName(rs.getString("name"));
      store.setType(rs.getString("type"));
      //List<Department> departmentList = (List<Department>) rs.getArray("departmentList");
      //store.setDepartmentList(departmentList);
      return store;
   }
}
