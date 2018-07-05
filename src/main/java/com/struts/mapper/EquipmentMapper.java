package com.struts.mapper;

import com.struts.model.Equipment;
import org.apache.ibatis.annotations.*;
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

    // 增加一个设备
    @Insert("insert into equipment(code, desc) values(#{equipment.code}, #{equipment.desc})")
    void addEquipment(@Param("equipment") Equipment equipment);

    // 根据设备 id 删除设备
    @Delete("delete from equipment where id = #{equipment_id}")
    void deleteEquipmentById(@Param("equipment_id") int equipment_id);

    // 更新设备的描述
    @Update("update equipment set `desc` = #{equipment.desc} where `id` = #{equipment.id}")
    void updateEquipment(@Param("equipment") Equipment equipment);

    // 获取所有的设备
    @Transactional(readOnly = true)
    @Select("select `id`, `code`, `desc` from equipment limit #{start_page}, #{page_size}")
    List<Equipment> getEquipmentList(@Param("start_page") int start_page, @Param("page_size") int page_size);

    // 根据 id 获取相应的设备信息
    @Transactional(readOnly = true)
    @Select("select `id`, `code`, `desc` from equipment where `id` = #{id}")
    Equipment getEquipmentById(@Param("id") int id);

    // 获取总记录数
    @Transactional(readOnly = true)
    @Select("select count(id) from equipment")
    int getEquipmentTotalRecord();
}
