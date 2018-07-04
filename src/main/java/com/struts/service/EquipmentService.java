package com.struts.service;

import com.struts.model.Equipment;

import java.util.List;

/**
 * EquipmentService
 * <p>
 * version 1.0
 *
 * @create 2018-07-04 13:18
 * @copyright huxiaolei1997@gmail.com
 */
public interface EquipmentService {

    /**
     * 更新设备描述
     *
     * @param equipment
     */
    void updateEquipmentDesc(Equipment equipment);

    /**
     * 获取设备list
     *
     * @return
     */
    List<Equipment> getEquipmentList();

    /**
     * 根据id获取设备信息
     * @param id
     * @return
     */
    Equipment getEquipmentById(int id);
}
