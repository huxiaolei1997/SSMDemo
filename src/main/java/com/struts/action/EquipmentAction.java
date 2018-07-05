package com.struts.action;

import com.opensymphony.xwork2.ActionSupport;
import com.struts.constant.Constant;
import com.struts.model.Equipment;
import com.struts.model.Pager;
import com.struts.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * EquipmentAction
 *
 * version 1.0
 *
 * @create 2018-07-04 13:29
 *
 * @copyright huxiaolei1997@gmail.com
 */
@Controller
@Scope("prototype")
public class EquipmentAction extends ActionSupport{

    @Autowired
    private EquipmentService equipmentService;

    private List<Equipment> equipmentList;

    private Equipment equipment;

    private Pager<Equipment> equipmentPager;

    // 设备主键
    private int equipment_id;

    // 页号
    private Integer page_num;

    // 批量删除的设备id
    private String batch_equipment_id;

    public String getBatch_equipment_id() {
        return batch_equipment_id;
    }

    public void setBatch_equipment_id(String batch_equipment_id) {
        this.batch_equipment_id = batch_equipment_id;
    }

    public Integer getPage_num() {
        return page_num;
    }

    public void setPage_num(Integer page_num) {
        this.page_num = page_num;
    }

    public int getEquipment_id() {
        return equipment_id;
    }

    public void setEquipment_id(int equipment_id) {
        this.equipment_id = equipment_id;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public List<Equipment> getEquipmentList() {
        return equipmentList;
    }

    public void setEquipmentList(List<Equipment> equipmentList) {
        this.equipmentList = equipmentList;
    }

    public Pager<Equipment> getEquipmentPager() {
        return equipmentPager;
    }

    public void setEquipmentPager(Pager<Equipment> equipmentPager) {
        this.equipmentPager = equipmentPager;
    }

    public String showEquipment() {
        //equipmentList = equipmentService.getEquipmentList(page_num);
        equipmentPager = equipmentService.getEquipmentList(page_num);
        System.out.println("equipmentPager : " + equipmentPager.toString() + "page_num : " + page_num);
        return "equipment_list";
    }

    public String updateEquipment() {
        equipment = equipmentService.getEquipmentById(equipment_id);
        System.out.println("equipment : " + equipment.toString());
        return "update_equipment";
        //equipment = equipmentService
    }

    public String updateEquipmentById() {
        equipmentService.updateEquipmentDesc(equipment);
        //equipmentList = equipmentService.getEquipmentList(Constant.default_page_num);
        equipmentPager = equipmentService.getEquipmentList(page_num);
        System.out.println("update_equipment : " + equipment.toString());
        return "equipment_update_success";
    }

    public String deleteEquipmentById() {
        equipmentService.deleteEquipmentById(equipment_id);
        equipmentPager = equipmentService.getEquipmentList(page_num);
        return "equipment_delete_success";
    }

    public String deleteEquipmentBatch() {
        System.out.println("batch_equipment_id : " + batch_equipment_id);
        String[] ids = batch_equipment_id.trim().split(" ");
        equipmentService.deleteEquipmentByIdBatch(ids);
        batch_equipment_id = "success";
        return "equipment_delete_batch_success";
    }
}