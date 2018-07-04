package com.struts.action;

import com.opensymphony.xwork2.ActionSupport;
import com.struts.model.Equipment;
import com.struts.service.EquipmentService;
import org.apache.struts2.ServletActionContext;
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

    // 设备主键
    private int equipment_id;

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

    public String showEquipment() {
        equipmentList = equipmentService.getEquipmentList();
        System.out.println("equipmentList : " + equipmentList.toString());
        return "equipment_list";
    }

    public String updateEquipment() {
        equipment = equipmentService.getEquipmentById(equipment_id);
        System.out.println("equipment : " + equipment.toString());
        return "update_equipment";
        //equipment = equipmentService
    }
}
