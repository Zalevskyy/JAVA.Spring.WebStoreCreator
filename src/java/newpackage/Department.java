/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
//import javax.persistence.OneToMany;

/**
 *
 * @author lv270669zia
 */
@Entity
public class Department implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String type;
     
//    @OneToMany(mappedBy = "department")
//    private List<Seller> sellerList;
    
    @ManyToOne
    @JoinColumn(name = "store_id")
    //private Store store;
    private Integer store_id;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }
        /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the store
     */
    public Integer getStore_id() {
        return store_id;
    }

    /**
     * @param store the store to set
     */
    public void setStore_id(Integer id) {
        this.store_id = id;
    }

    /**
     * @return the cashierList
     */
//    public List<Seller> getSellerList() {
//        return sellerList;
//    }
//   
//    /**
//     * @param sellerList the sellerList to set
//     */
//    public void setSellerList(List<Seller> sellerList) {
//        this.sellerList = sellerList;
//    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Department)) {
            return false;
        }
        Department other = (Department) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "newpackage.Depertment[ id=" + id + " ]";
    }

    
}
