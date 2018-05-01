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
public class SellerMapper implements RowMapper<Seller> {

    @Override
    public Seller mapRow(ResultSet rs, int i) throws SQLException {
        Seller seller = new Seller();
      seller.setId(rs.getInt("id"));
      seller.setName(rs.getString("name"));
      seller.setSurname(rs.getString("surname"));
      seller.setBirthday(rs.getDate("birthday"));
      seller.setSalary(rs.getInt("salary"));
      seller.setDepartment_id(rs.getInt("department_id"));
      return seller;
    }
    
}
