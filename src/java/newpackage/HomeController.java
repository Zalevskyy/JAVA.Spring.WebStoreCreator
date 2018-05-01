/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.util.ArrayList;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author lv270669zia
 */
@Controller
public class HomeController {
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String store(ModelMap model) {
        ApplicationContext context = new ClassPathXmlApplicationContext("newSpringXMLConfig.xml");
        DepartmentJDBCTemplate departmentJDBCTemplate = (DepartmentJDBCTemplate)context.getBean("departmentJDBCTemplate");
      List<Department> deps = departmentJDBCTemplate.lists();
      StoreJDBCTemplate storeJDBCTemplate = (StoreJDBCTemplate)context.getBean("storeJDBCTemplate");     
      List<Store> stores = storeJDBCTemplate.lists();
      model.addAttribute("list", stores);
     model.addAttribute("departments", deps);
     SellerJDBCTemplate sellerJDBCTemplate = (SellerJDBCTemplate)context.getBean("sellerJDBCTemplate");      
      List<Seller> sellers = sellerJDBCTemplate.lists();
      model.addAttribute("sellers", sellers);
      return "home";
    }
    
    @RequestMapping(value = "/allstores", method = RequestMethod.GET)
    public String allStudent(ModelMap model) 
    {
      ApplicationContext context = new ClassPathXmlApplicationContext("newSpringXMLConfig.xml");
      StoreJDBCTemplate storeJDBCTemplate = (StoreJDBCTemplate)context.getBean("storeJDBCTemplate");     
      List<Store> stores = storeJDBCTemplate.lists();
      model.addAttribute("list", stores);
      return "allstores";
    }
 
        @RequestMapping(value = "/addstore", method = RequestMethod.GET)
    public String addStoreForm(ModelMap model) 
    {
//      ApplicationContext context = new ClassPathXmlApplicationContext("newSpringXMLConfig.xml");
//      StoreJDBCTemplate storeJDBCTemplate = (StoreJDBCTemplate)context.getBean("storeJDBCTemplate");
      model.addAttribute("command", new Store());
      
      return "addstore";
    }
    @RequestMapping(value = "/addstore", method = RequestMethod.POST)
    public String addStore(@ModelAttribute("newStore")Store store,  ModelMap model) 
    {
      ApplicationContext context = new ClassPathXmlApplicationContext("newSpringXMLConfig.xml");
      StoreJDBCTemplate storeJDBCTemplate = (StoreJDBCTemplate)context.getBean("storeJDBCTemplate");
      storeJDBCTemplate.create(store);
      
      List<Store> stores = storeJDBCTemplate.lists();
      model.addAttribute("list", stores);
      
      return "home";
    }
    
    @RequestMapping(value = "/deletestore", method = RequestMethod.GET)
    public String deleteStore(Integer id,  ModelMap model) 
    {
      ApplicationContext context = new ClassPathXmlApplicationContext("newSpringXMLConfig.xml");
      StoreJDBCTemplate storeJDBCTemplate = (StoreJDBCTemplate)context.getBean("storeJDBCTemplate");
      storeJDBCTemplate.delete(id);
      
      DepartmentJDBCTemplate departmentJDBCTemplate = (DepartmentJDBCTemplate)context.getBean("departmentJDBCTemplate");      
      List<Department> deps = departmentJDBCTemplate.lists();
        model.addAttribute("departments", deps);
        
      List<Store> stores = storeJDBCTemplate.lists();
      model.addAttribute("list", stores);

      SellerJDBCTemplate sellerJDBCTemplate = (SellerJDBCTemplate)context.getBean("sellerJDBCTemplate");
      List<Seller> sellers = sellerJDBCTemplate.lists();
      model.addAttribute("sellers", sellers);
      
      return "home";
    }
    @RequestMapping(value = "/adddepartment", method = RequestMethod.GET)
    public String addDepartmentForm(Integer id,  ModelMap model) 
    {
      model.addAttribute("storeId", id);
      model.addAttribute("command", new Department());
      return "adddepartment";
    }
    @RequestMapping(value = "/adddepartment", method = RequestMethod.POST)
    public String addDepartment(@ModelAttribute("newDepartment")Department department,  ModelMap model) 
    {
      ApplicationContext context = new ClassPathXmlApplicationContext("newSpringXMLConfig.xml");
      DepartmentJDBCTemplate departmentJDBCTemplate = (DepartmentJDBCTemplate)context.getBean("departmentJDBCTemplate");
      departmentJDBCTemplate.create(department);
      
      List<Department> departments = departmentJDBCTemplate.lists();
      model.addAttribute("departments", departments);
      StoreJDBCTemplate storeJDBCTemplate = (StoreJDBCTemplate)context.getBean("storeJDBCTemplate");     
      List<Store> stores = storeJDBCTemplate.lists();
      model.addAttribute("list", stores);
      return "home";
    }
    @RequestMapping(value = "/deletedepartment", method = RequestMethod.GET)
    public String deleteDepartment(Integer id,  ModelMap model) 
    {
      ApplicationContext context = new ClassPathXmlApplicationContext("newSpringXMLConfig.xml");
      StoreJDBCTemplate storeJDBCTemplate = (StoreJDBCTemplate)context.getBean("storeJDBCTemplate");

      
      DepartmentJDBCTemplate departmentJDBCTemplate = (DepartmentJDBCTemplate)context.getBean("departmentJDBCTemplate");      
      departmentJDBCTemplate.delete(id);
      List<Department> deps = departmentJDBCTemplate.lists();
        model.addAttribute("departments", deps);
        
      List<Store> stores = storeJDBCTemplate.lists();
      model.addAttribute("list", stores);

      SellerJDBCTemplate sellerJDBCTemplate = (SellerJDBCTemplate)context.getBean("sellerJDBCTemplate");
      List<Seller> sellers = sellerJDBCTemplate.lists();
      model.addAttribute("sellers", sellers);
      
      return "home";
    }
    @RequestMapping(value = "/addseller", method = RequestMethod.GET)
    public String addSellerForm(Integer id,  ModelMap model) 
    {
      model.addAttribute("departmentId", id);
      model.addAttribute("command", new Seller());
      return "addseller";
    }
    @RequestMapping(value = "/addseller", method = RequestMethod.POST)
    public String addSeller(@ModelAttribute("newSeller")Seller seller,  ModelMap model) 
    {
      ApplicationContext context = new ClassPathXmlApplicationContext("newSpringXMLConfig.xml");
      SellerJDBCTemplate sellerJDBCTemplate = (SellerJDBCTemplate)context.getBean("sellerJDBCTemplate");
      sellerJDBCTemplate.create(seller);
      
      List<Seller> sellers = sellerJDBCTemplate.lists();
      model.addAttribute("sellers", sellers);
      
      DepartmentJDBCTemplate departmentJDBCTemplate = (DepartmentJDBCTemplate)context.getBean("departmentJDBCTemplate");
      List<Department> departments = departmentJDBCTemplate.lists();
      model.addAttribute("departments", departments);
      
      StoreJDBCTemplate storeJDBCTemplate = (StoreJDBCTemplate)context.getBean("storeJDBCTemplate");     
      List<Store> stores = storeJDBCTemplate.lists();
      model.addAttribute("list", stores);
      
      return "home";
    }
    @RequestMapping(value = "/deleteseller", method = RequestMethod.GET)
    public String deleteSeller(Integer id,  ModelMap model) 
    {
      ApplicationContext context = new ClassPathXmlApplicationContext("newSpringXMLConfig.xml");
      SellerJDBCTemplate sellerJDBCTemplate = (SellerJDBCTemplate)context.getBean("sellerJDBCTemplate");
      sellerJDBCTemplate.delete(id);
      
        DepartmentJDBCTemplate departmentJDBCTemplate = (DepartmentJDBCTemplate)context.getBean("departmentJDBCTemplate");
        List<Department> deps = departmentJDBCTemplate.lists();
        model.addAttribute("departments", deps);
        
      StoreJDBCTemplate storeJDBCTemplate = (StoreJDBCTemplate)context.getBean("storeJDBCTemplate");     
      List<Store> stores = storeJDBCTemplate.lists();
      model.addAttribute("list", stores);

      List<Seller> sellers = sellerJDBCTemplate.lists();
      model.addAttribute("sellers", sellers);
      
      return "home";
    }
    
    @RequestMapping(value = "/departments", method = RequestMethod.GET)
    public String departments(Integer id, ModelMap model) {
        ApplicationContext context = new ClassPathXmlApplicationContext("newSpringXMLConfig.xml");
        DepartmentJDBCTemplate departmentJDBCTemplate = (DepartmentJDBCTemplate)context.getBean("departmentJDBCTemplate");
      List<Department> departments = departmentJDBCTemplate.listsOf(id);
      model.addAttribute("departments", departments);
      StoreJDBCTemplate storeJDBCTemplate = (StoreJDBCTemplate)context.getBean("storeJDBCTemplate");     
      Store store = storeJDBCTemplate.getT(id);
      model.addAttribute("store", store);
      
//     model.addAttribute("departments", deps);
//     SellerJDBCTemplate sellerJDBCTemplate = (SellerJDBCTemplate)context.getBean("sellerJDBCTemplate");      
//      Seller seller = (Seller)sellerJDBCTemplate.getT(id);
//      model.addAttribute("seller", seller);
      return "departments";
    }
    @RequestMapping(value = "/sellers", method = RequestMethod.GET)
    public String seller(Integer id, ModelMap model) {
        ApplicationContext context = new ClassPathXmlApplicationContext("newSpringXMLConfig.xml");
        SellerJDBCTemplate sellerJDBCTemplate = (SellerJDBCTemplate)context.getBean("sellerJDBCTemplate");
      List<Seller> sellers = sellerJDBCTemplate.listsOf(id);
       model.addAttribute("sellers", sellers);
      DepartmentJDBCTemplate departmentJDBCTemplate = (DepartmentJDBCTemplate)context.getBean("departmentJDBCTemplate");
      Department department = (Department) departmentJDBCTemplate.getT(id);
      model.addAttribute("department", department);
      
      return "sellers";
    }
}
