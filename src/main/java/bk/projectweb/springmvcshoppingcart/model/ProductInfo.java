package bk.projectweb.springmvcshoppingcart.model;
 
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import bk.projectweb.springmvcshoppingcart.entity.Product;
 
public class ProductInfo {
    private String code;
    private String name;
    private double price;
 
    private boolean newProduct=false;
 
    // Upload file.
    private CommonsMultipartFile fileData;
    private CommonsMultipartFile fileData1; 
    
    public ProductInfo() {
    }
 
    public ProductInfo(Product product) {
        this.code = product.getCode();
        this.name = product.getName();
        this.price = product.getPrice();
    }
 
    // Không thay đổi Constructor này,
    // nó được sử dụng trong Hibernate query.
    public ProductInfo(String code, String name, double price) {
        this.code = code;
        this.name = name;
        this.price = price;
    }
 
    public String getCode() {
        return code;
    }
 
    public void setCode(String code) {
        this.code = code;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public double getPrice() {
        return price;
    }
 
    public void setPrice(double price) {
        this.price = price;
    }
 
    public CommonsMultipartFile getFileData() {
        return fileData;
    }
 
    public void setFileData(CommonsMultipartFile fileData) {
        this.fileData = fileData;
    }
    
    
    public CommonsMultipartFile getFileData1() {
        return fileData1;
    }
 
    public void setFileData1(CommonsMultipartFile fileData) {
        this.fileData1 = fileData;
    }
    
    
 
    public boolean isNewProduct() {
        return newProduct;
    }
 
    public void setNewProduct(boolean newProduct) {
        this.newProduct = newProduct;
    }
 
}