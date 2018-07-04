package com.struts.mapper;

import com.struts.model.Equipment;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * EquipmentMapper
 *
 * version 1.0
 *
 * @create 2018-07-04 10:44
 *
 * @copyright huxiaolei1997@gmail.com
 */
public interface EquipmentMapper {

    // 更新设备的描述
    @Update("update equipment set `desc` = #{equipment.desc} where `id` = #{equipment.id}")
    void updateEquipment(@Param("equipment") Equipment equipment);

    // 获取所有的设备
    @Transactional(readOnly = true)
    @Select("select `id`, `code`, `desc` from equipment")
    List<Equipment> getEquipmentList();

    // 根据id获取相应的设备信息
    @Transactional(readOnly = true)
    @Select("select `id`, `code`, `desc` from equipment where `id` = #{id}")
    Equipment getEquipmentById(@Param("id") int id);
}
