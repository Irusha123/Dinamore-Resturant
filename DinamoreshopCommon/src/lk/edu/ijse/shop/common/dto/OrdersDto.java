/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.shop.common.dto;

/**
 *
 * @author Irusha Yujitha
 */

public class OrdersDto extends SuperDto implements Comparable<OrdersDto>{

    private String oid;
    
    private String date;
    private int qty;
    private String itemCode;
    private String cid;
    private String name;
    private String address;
    private String tel;
    private String type;
    private String endTime;
    private String startTime;
    private String chefName;

    public OrdersDto() {
    }
     public OrdersDto(String oid, String cid, int qty,String itemCode,String type) {
         this.type=type;
        this.qty = qty;
        this.oid = oid;
         this.cid = cid;
         this.itemCode = itemCode;
    }

    public OrdersDto(String oid,String date, int qty, String itemCode, String cid, String name, String address, String tel,String type,String startTime,String endTime,String chefName) {
        this.oid = oid;
        this.date = date;
        this.qty = qty;
        this.itemCode = itemCode;
        this.cid = cid;
        this.name = name;
        this.address = address;
        this.tel = tel;
        this.type=type;
        this.startTime=startTime;
        this.endTime=endTime;
        this.chefName=chefName;
    }

    
    @Override
    public int compareTo(OrdersDto t) {
       return this.getOid().equals(t.getOid())? 0:1;
    }

    /**
     * @return the oid
     */
    public String getOid() {
        return oid;
    }

    /**
     * @param oid the oid to set
     */
    public void setOid(String oid) {
        this.oid = oid;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return the qty
     */
    public int getQty() {
        return qty;
    }

    /**
     * @param qty the qty to set
     */
    public void setQty(int qty) {
        this.qty = qty;
    }

    /**
     * @return the itemCode
     */
    public String getItemCode() {
        return itemCode;
    }

    /**
     * @param itemCode the itemCode to set
     */
    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    /**
     * @return the cid
     */
    public String getCid() {
        return cid;
    }

    /**
     * @param cid the cid to set
     */
    public void setCid(String cid) {
        this.cid = cid;
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
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the tel
     */
    public String getTel() {
        return tel;
    }

    /**
     * @param tel the tel to set
     */
    public void setTel(String tel) {
        this.tel = tel;
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
     * @return the endTime
     */
    public String getEndTime() {
        return endTime;
    }

    /**
     * @param endTime the endTime to set
     */
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    /**
     * @return the startTime
     */
    public String getStartTime() {
        return startTime;
    }

    /**
     * @param startTime the startTime to set
     */
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    /**
     * @return the chefName
     */
    public String getChefName() {
        return chefName;
    }

    /**
     * @param chefName the chefName to set
     */
    public void setChefName(String chefName) {
        this.chefName = chefName;
    }
  
}
