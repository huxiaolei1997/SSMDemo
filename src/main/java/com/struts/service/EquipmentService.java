package com.struts.service;

import com.struts.model.Equipment;
import com.struts.model.Pager;

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
     * 增加一个设备
     *
     * @param equipment
     */
    void addEquipment(Equipment equipment);

    /**
     * 根据设备主键删除设备
     *
     * @param equipment_id
     */
    void deleteEquipmentById(int equipment_id);

    /**
     * 批量删除设备
     *
     * @param ids
     */
    void deleteEquipmentByIdBatch(String[] ids);

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
    Pager<Equipment> getEquipmentList(Integer page_num);

    /**
     * 根据id获取设备信息
     * @param id
     * @return
     */
    Equipment getEquipmentById(int id);
}
