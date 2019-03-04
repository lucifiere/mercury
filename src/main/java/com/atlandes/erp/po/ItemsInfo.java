package com.atlandes.erp.po;

public class ItemsInfo {

     /**
      * 货物编号
      */
    private Integer id;
    /**
     * 货物名称
     */
    private String itemsName;
    /**
     * 货物产地
     */
    private String itemsOrigin;
    /**
     * 货物规格
     */
    private String itemsScale;
    /**
     *货物可供数量
     */
    private Integer itemsCounts;
    /**
     * 货物采购合同号
     */
    private String itemsOrderNo;
    /**
     * 货物加工合同号
     */
    private String itemsAddNo;
    /**
     * 货物运输合同号
     */
    private String itemsTranNo;
    /**
     * 货物入库合同号
     */
    private String itemsInStoreNo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getItemsName() {
        return itemsName;
    }

    public void setItemsName(String itemsName) {
        this.itemsName = itemsName;
    }

    public String getItemsOrigin() {
        return itemsOrigin;
    }

    public void setItemsOrigin(String itemsOrigin) {
        this.itemsOrigin = itemsOrigin;
    }

    public String getItemsScale() {
        return itemsScale;
    }

    public void setItemsScale(String itemsScale) {
        this.itemsScale = itemsScale;
    }

    public Integer getItemsCounts() {
        return itemsCounts;
    }

    public void setItemsCounts(Integer itemsCounts) {
        this.itemsCounts = itemsCounts;
    }

    public String getItemsOrderNo() {
        return itemsOrderNo;
    }

    public void setItemsOrderNo(String itemsOrderNo) {
        this.itemsOrderNo = itemsOrderNo;
    }

    public String getItemsAddNo() {
        return itemsAddNo;
    }

    public void setItemsAddNo(String itemsAddNo) {
        this.itemsAddNo = itemsAddNo;
    }

    public String getItemsTranNo() {
        return itemsTranNo;
    }

    public void setItemsTranNo(String itemsTranNo) {
        this.itemsTranNo = itemsTranNo;
    }

    public String getItemsInStoreNo() {
        return itemsInStoreNo;
    }

    public void setItemsInStoreNo(String itemsInStoreNo) {
        this.itemsInStoreNo = itemsInStoreNo;
    }
}
