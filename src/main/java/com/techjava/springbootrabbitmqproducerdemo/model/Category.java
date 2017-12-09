package com.techjava.springbootrabbitmqproducerdemo.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id", scope = Category.class)
public class Category {

    private String categoryName;

    private List<Item> itemList;

    public Category() {
    }

    public Category(String categoryName, List<Item> itemList) {
        this.categoryName = categoryName;
        this.itemList = itemList;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    /**
     *
     * Show Detail View
     */
    public String toString(){
        JSONObject jsonInfo = new JSONObject();

        try {
            jsonInfo.put("categoryName", this.categoryName);

            JSONArray itemArray = new JSONArray();
            if (this.itemList != null) {
                this.itemList.forEach(item -> {
                    JSONObject subJson = new JSONObject();
                    try {
                        subJson.put("itemName", item.getItemName());
                    } catch (JSONException e) {}

                    itemArray.put(subJson);
                });
            }
            jsonInfo.put("items", itemArray);
        } catch (JSONException e1) {}
        return jsonInfo.toString();
    }
}
