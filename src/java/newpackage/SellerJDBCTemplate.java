/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.util.Date;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author lv270669zia
 */
public class SellerJDBCTemplate implements TDAO  {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;
    
    @Override
    public void setDataSource(DataSource dataSource) {
      this.dataSource = dataSource;
      this.jdbcTemplateObject = new JdbcTemplate(dataSource);
   }

    @Override
    public void create(Object item) {
        Seller seller = (Seller) item;
      String name = seller.getName();
      String surname = seller.getSurname();
      Date birthday = seller.getBirthday();
      Integer salary = seller.getSalary();
      Integer department_id = seller.getDepartment_id();
      String SQL = "insert into Seller (name, surname, birthday, salary, department_id ) values (?,?,?,?,?)";
      jdbcTemplateObject.update( SQL, name, surname,birthday,salary,department_id);
      System.out.println("Created Record for seller Name = " + name);
    }

    @Override
    public Object getT(Integer id) {
        String SQL = "select * from Seller where id = ?";
      Seller seller = jdbcTemplateObject.queryForObject(SQL, 
         new Object[]{id}, new SellerMapper());      
      return seller;
    }

    @Override
    public List lists() {
        String SQL = "select * from Seller";
      List <Seller> sellers = jdbcTemplateObject.query(SQL, new SellerMapper());
      return sellers;
    }

    @Override
    public void delete(Integer id) {
      String SQL = "delete from Seller where id = ?";
      jdbcTemplateObject.update(SQL, id);
      //System.out.println("Deleted Record with ID = " + id );
    }

    @Override
    public void update(Integer id, Object item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    List<Seller> listsOf(Integer id) {
        String SQL = "select * from Seller where department_id = ?";
      List<Seller> sellers = jdbcTemplateObject.query(SQL, 
         new Object[]{id}, new SellerMapper());      
      return sellers;
    }
    
}
