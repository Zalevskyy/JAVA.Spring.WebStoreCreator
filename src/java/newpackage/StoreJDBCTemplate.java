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
public class StoreJDBCTemplate implements TDAO {
    private DataSource dataSource;
   private JdbcTemplate jdbcTemplateObject;
   @Override
   public void setDataSource(DataSource dataSource) {
      this.dataSource = dataSource;
      this.jdbcTemplateObject = new JdbcTemplate(dataSource);
   }
   @Override
   public void create(Object item) {
      Store store = (Store) item;
      String name = store.getName();
      String type = store.getType();
      String SQL = "insert into Store (name, type ) values (?, ?)";
      jdbcTemplateObject.update( SQL, name, type);
      //System.out.println("Created Store Name = " + name + " Type = " + type);
      return;
   }
   @Override
   public Store getT(Integer id) {
      String SQL = "select * from Store where id = ?";
      Store store = jdbcTemplateObject.queryForObject(SQL, 
         new Object[]{id}, new StoreMapper());      
      return store;
   }
   @Override
   public List<Store> lists() {
      String SQL = "select * from Store";
      List <Store> stores = jdbcTemplateObject.query(SQL, new StoreMapper());
      return stores;
   }
   @Override
   public void delete(Integer id) {
      String SQL = "delete from Store where id = ?";
      jdbcTemplateObject.update(SQL, id);
      System.out.println("Deleted Record with ID = " + id );
      return;
   }
   @Override
   public void update(Integer id, Object item){
      Store store = (Store) item;
      String name = store.getName();
      String type = store.getType();
      String SQL = "update Store set name = ? type = ? where id = ?";
      jdbcTemplateObject.update(SQL, name, type, id);
      //System.out.println("Updated Record with ID = " + id );
      return;
   }

}
