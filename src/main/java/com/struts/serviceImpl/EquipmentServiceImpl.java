package com.struts.serviceImpl;

import com.struts.mapper.EquipmentMapper;
import com.struts.model.Equipment;
import com.struts.service.EquipmentService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * EquipmentServiceImpl
 * <p>
 * version 1.0
 *
 * @create 2018-07-04 13:19
 * @copyright huxiaolei1997@gmail.com
 */
@Service
public class EquipmentServiceImpl implements EquipmentService {

    @Autowired
    private EquipmentMapper equipmentMapper;

    // 日志
    private static final Logger logger = Logger.getLogger(EquipmentServiceImpl.class);

    /**
     * 更新设备描述
     *
     * @param equipment
     */
    @Override
    public void updateEquipmentDesc(Equipment equipment) {
        logger.info("开始更新设备描述");
        equipmentMapper.updateEquipment(equipment);
        logger.info("设备描述更新成功");
    }

    /**
     * 获取设备list
     *
     * @return
     */
    @Override
    public List<Equipment> getEquipmentList() {
        List<Equipment> equipmentList = equipmentMapper.getEquipmentList();
        return equipmentList;
    }

    /**
     * 根据id获取设备信息
     *
     * @param id
     * @return
     */
    @Override
    public Equipment getEquipmentById(int id) {
        Equipment equipment = equipmentMapper.getEquipmentById(id);
        return equipment;
    }
}
