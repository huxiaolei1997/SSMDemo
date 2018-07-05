package com.struts.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.struts.model.Equipment;
import com.struts.model.Pager;
import com.struts.service.EquipmentService;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * EquipmentRestAction
 *
 * version 1.0
 *
 * @create 2018-07-05 16:16
 *
 * @copyright huxiaolei1997@gmail.com
 */
@Results(@Result(name="success", type = "redirectAction", params = {
        "actionName", "equipment"
}))
public class EquipmentRestAction extends ActionSupport implements ModelDriven<Object> {
    // Rest URL请求的ID值
    private int id;
    // 设备实体
    private Equipment equipment = new Equipment();
    // 设备列表
    private Pager<Equipment> equipmentPager;
    // 设备service
    @Autowired
    private EquipmentService equipmentService;

    @Override
    public Object getModel() {
        return (equipmentPager != null ? equipmentPager : equipment);
    }

    /**
     * 设置设备ID
     */
    public void setId(int id) {
        this.id = id;
        // 如果设备ID大于0，取得设备实体
        if (id > 0) {
            this.equipment = equipmentService.getEquipmentById(id);
        }
    }

    /**
     * 取得设备ID
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     * 功能：首页
     * 调用：GET /equipment
     * 返回：equipment-index.ftl
     * @return
     */
    public HttpHeaders index() {
        equipmentPager = equipmentService.getEquipmentList(null);
        return new DefaultHttpHeaders("index").disableCaching();
    }

    /**
     * 功能： 新增一个设备
     * 调用： GET /equipment/new
     * 返回：equipment-editNew.ftl
     */
    public String editNew() {
        equipment = new Equipment();
        return "editNew";
    }

    /**
     * 功能： 保存新增设备
     * 调用： POST /equipment
     * 返回：equipment-index.jsp
     * @return
     */
    public HttpHeaders create() {
        equipmentService.addEquipment(equipment);
        return new DefaultHttpHeaders(SUCCESS).setLocationId(equipment.getId());
    }

    /**
     * 功能： 显示用户信息明细，返回show的ftl
     * 调用：GET /equipment/1
     * 返回：equipment-show.ftl
     * @return
     */
    public HttpHeaders show() {
        return new DefaultHttpHeaders("show");
    }

    /**
     * 功能：编辑用户
     * 调用：GET /equipment/1/edit
     * 返回：equipment-edit.ftl
     * @return
     */
    public String edit() {
        return "edit";
    }

    /**
     * 功能： 更新用户信息
     * 调用：PUT /equipment/1
     * 返回 equipment-index.ftl
     * @return
     */
    public String update() {
        equipmentService.updateEquipmentDesc(equipment);
        addActionMessage("update equipment successed.");
        return SUCCESS;
    }

    /**
     * 功能：删除用户
     * 调用：DELETE /equipment/1
     * 返回 equipment-index.ftl
     * @return
     */
    public String destroy() {
        equipmentService.deleteEquipmentById(id);
        addActionMessage("delete equipment successed.");
        return SUCCESS;
    }
}
