/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Admin
 */
public class Fruit {
    private String productid;
    private String productname;
    private String categoryid;
    private int numberofporducts;
    private String detail;
    private float price;
    private String image;

    public Fruit() {
    }

    public Fruit(String productid, String productname, String categoryid, int numberofporducts, String detail, float price, String image) {
        this.productid = productid;
        this.productname = productname;
        this.categoryid = categoryid;
        this.numberofporducts = numberofporducts;
        this.detail = detail;
        this.price = price;
        this.image = image;
    }

    public String getProductid() {
        return productid;
    }

    public String getProductname() {
        return productname;
    }

    public String getCategoryid() {
        return categoryid;
    }

    public int getNumberofporducts() {
        return numberofporducts;
    }

    public String getDetail() {
        return detail;
    }

    public float getPrice() {
        return price;
    }

    public String getImage() {
        return image;
    }

    public void setProductid(String productid) {
        this.productid = productid;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public void setCategoryid(String categoryid) {
        this.categoryid = categoryid;
    }

    public void setNumberofporducts(int numberofporducts) {
        this.numberofporducts = numberofporducts;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setImage(String image) {
        this.image = image;
    }
           
}
