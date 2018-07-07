package com.jiudao.rest.serviceImpl;

import com.jiudao.rest.constant.Constant;
import com.jiudao.rest.mapper.EquipmentMapper;
import com.jiudao.rest.model.Equipment;
import com.jiudao.rest.model.Pager;
import com.jiudao.rest.service.EquipmentService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * EquipmentServiceImpl
 *
 * version 1.0
 *
 * @create 2018-07-04 13:19
 *
 * @copyright huxiaolei1997@gmail.com
 */
@Service
public class EquipmentServiceImpl implements EquipmentService {

    @Autowired
    private EquipmentMapper equipmentMapper;

    // 日志
    private static final Logger logger = Logger.getLogger(EquipmentServiceImpl.class);

    /**
     * 增加一个设备
     *
     * @param equipment
     */
    @Override
    public void addEquipment(Equipment equipment) {
        equipmentMapper.addEquipment(equipment);
    }

    /**
     * 根据设备主键删除设备
     *
     * @param equipment_id
     */
    @Override
    public void deleteEquipmentById(int equipment_id) {
        equipmentMapper.deleteEquipmentById(equipment_id);
    }

    /**
     * 批量删除设备
     *
     * @param ids
     */
    @Override
    public void deleteEquipmentByIdBatch(String[] ids) {
        int length = ids.length;
        for (int i = 0; i < length; i++) {
            equipmentMapper.deleteEquipmentById(Integer.valueOf(ids[i]));
        }
    }

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
    public Pager<Equipment> getEquipmentList(Integer page_num) {
        // 如果请求的页号小于1
        Integer current_page = page_num;
        if (null == current_page || current_page < 1) {
            current_page = 1;
        }
        // 计算起始行数
        int start_page = Constant.default_page_size * (current_page - 1);
        // 获取总记录数
        int total_record = equipmentMapper.getEquipmentTotalRecord();
        // 计算总页数
        int total_page = total_record / Constant.default_page_size + 1;

        if (total_record % Constant.default_page_size == 0 && total_record != 0) {
            total_page = total_record / Constant.default_page_size;
        }

        if (total_record == 0) {
            total_page = 1;
        }

        // 如果请求的页号大于总页号，那么返回的数据是最后一页的数据
        if (current_page > total_page) {
            current_page = total_page;
        }

        List<Equipment> equipmentList = equipmentMapper.getEquipmentList(start_page, Constant.default_page_size);
        Pager<Equipment> equipmentPager = new Pager<>(current_page, total_record, total_page, Constant.default_page_size, equipmentList);
        return equipmentPager;
    }

    /**
     * 获取设备list（不分页）
     *
     * @return
     */
    @Override
    public List<Equipment> getEquipmentLists() {
        List<Equipment> equipmentList = equipmentMapper.getEquipmentLists();
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
