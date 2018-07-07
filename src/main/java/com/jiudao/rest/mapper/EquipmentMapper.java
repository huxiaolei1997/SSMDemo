package com.jiudao.rest.mapper;

import com.jiudao.rest.model.Equipment;
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

    /**
     * 增加一个设备
     *
     * @param equipment
     */
    @Insert("insert into equipment(`code`, `desc`) values(#{equipment.code}, #{equipment.desc})")
    void addEquipment(@Param("equipment") Equipment equipment);

    /**
     * 根据设备 id 删除设备
     *
     * @param equipment_id
     */
    @Delete("delete from equipment where id = #{equipment_id}")
    void deleteEquipmentById(@Param("equipment_id") int equipment_id);

    /**
     * 更新设备的描述
     *
     * @param equipment
     */
    @Update("update equipment set `desc` = #{equipment.desc} where `id` = #{equipment.id}")
    void updateEquipment(@Param("equipment") Equipment equipment);

    /**
     * 获取所有的设备（不分页）
     *
     * @return
     */
    @Transactional(readOnly = true)
    @Select("select `id`, `code`, `desc` from equipment order by id desc")
    List<Equipment> getEquipmentLists();

    /**
     * 获取所有的设备（分页）
     *
     * @param start_page
     * @param page_size
     * @return
     */
    @Transactional(readOnly = true)
    @Select("select `id`, `code`, `desc` from equipment order by id desc limit #{start_page}, #{page_size}")
    List<Equipment> getEquipmentList(@Param("start_page") int start_page, @Param("page_size") int page_size);

    /**
     * 根据 id 获取相应的设备信息
     *
     * @param id
     * @return
     */
    @Transactional(readOnly = true)
    @Select("select `id`, `code`, `desc` from equipment where `id` = #{id}")
    Equipment getEquipmentById(@Param("id") int id);

    /**
     * 获取总记录数
     *
     * @return
     */
    @Transactional(readOnly = true)
    @Select("select count(id) from equipment")
    int getEquipmentTotalRecord();
}
