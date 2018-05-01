/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author lv270669zia
 */
class DepartmentJDBCTemplate implements TDAO {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;
    
    @Override
    public void setDataSource(DataSource dataSource) {
      this.dataSource = dataSource;
      this.jdbcTemplateObject = new JdbcTemplate(dataSource);
   }

    @Override
    public void create(Object item) {
        Department department = (Department) item;
      String name = department.getName();
      String type = department.getType();
      Integer store_id = department.getStore_id();
      //List<Seller> sellers = department.getSellerList();
      String SQL = "insert into Department (name, type, store_id) values (?,?,?)";
      jdbcTemplateObject.update( SQL, name, type, store_id);
      //System.out.println("Created Record for department Name = " + name);
    }

    @Override
    public Object getT(Integer id) {
        String SQL = "select * from Department where id = ?";
      Department department = jdbcTemplateObject.queryForObject(SQL, 
         new Object[]{id}, new DepartmentMapper());      
      return department;
    }

    @Override
    public List<Department> lists() {
        String SQL = "select * from Department";
      List <Department> departments = jdbcTemplateObject.query(SQL, new DepartmentMapper());
      return departments;
    }

    @Override
    public void delete(Integer id) {
      String SQL = "delete from Department where id = ?";
      jdbcTemplateObject.update(SQL, id);
      //System.out.println("Deleted Record with ID = " + id );
    }

    @Override
    public void update(Integer id, Object item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public List<Department> listsOf(Integer id) {
        String SQL = "select * from Department where store_id=?";
      List <Department> departments = jdbcTemplateObject.query(SQL, new DepartmentMapper(), id);
      return departments;
    }
}
