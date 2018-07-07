package com.jiudao.rest.action;

import com.jiudao.rest.serviceImpl.EquipmentServiceImpl;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.jiudao.rest.model.Equipment;
import com.jiudao.rest.service.EquipmentService;
import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * EquipmentController
 *
 * version 1.0
 *
 * @create 2018-07-05 16:16
 *
 * @copyright huxiaolei1997@gmail.com
 */
@Results(@Result(name="success"
        , type="redirectAction"
        , params = {"actionName" , "equipment"}))
@Controller
@Scope("prototype")
public class EquipmentController extends ActionSupport implements ModelDriven<Equipment> {
    // Rest URL请求的 ID 值
    private int id;
    // 设备实体（这里的实例名必须是 model ，不然getModel()这个方法会取不到 model 的值），如果要在页面上访问实体类的属性，则
    // 必须实现这个属性的get方法
    private Equipment model = new Equipment();
    // 设备分页对象
    //private Pager<Equipment> equipmentPager;

    // 设备list
    private List<Equipment> list;

    // 设备service
    @Autowired
    private EquipmentService equipmentService;

    // 日志
    private static final Logger logger = Logger.getLogger(EquipmentController.class);

    @Override
    public Equipment getModel() {
        return model;
    }

    public List<Equipment> getList() {
        return list;
    }

    /**
     * 设置设备ID
     */
    public void setId(int id) {
        this.id = id;
        // 如果设备ID大于0，取得设备实体
        if (id > 0) {
            this.model = equipmentService.getEquipmentById(id);
        }
    }

    /**
     * 取得设备ID
     *
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     * 功能：首页
     * 调用：GET /equipment
     * 返回：equipment-index.jsp
     * @return
     */
    public HttpHeaders index() {
        //equipmentPager = equipmentService.getEquipmentList(null);
        list = equipmentService.getEquipmentLists();
        logger.debug("list = " + list.toString());
        return new DefaultHttpHeaders("index").disableCaching();
    }

    /**
     * 功能： 新增一个设备
     * 调用： GET /equipment/new
     * 返回：equipment-editNew.jsp
     */
    public String editNew() {
        model = new Equipment();
        return "editNew";
    }

    /**
     * 功能： 保存新增设备
     * 调用： POST /equipment
     * 返回：equipment-index.jsp
     * @return
     */
    public HttpHeaders create() {
        equipmentService.addEquipment(model);
        return new DefaultHttpHeaders("success").setLocationId(model.getId());
    }

    /**
     * 功能： 显示用户信息明细，返回show的ftl
     * 调用：GET /equipment/1
     * 返回：equipment-show.jsp
     * @return
     */
    public HttpHeaders show() {
        return new DefaultHttpHeaders("show");
    }

    /**
     * 功能：编辑用户
     * 调用：GET /equipment/1/edit
     * 返回：equipment-edit.jsp
     * @return
     */
    public String edit() {
        return "edit";
    }

    /**
     * 功能： 更新用户信息
     * 调用：PUT /equipment/1
     * 返回 equipment-index.jsp
     * @return
     */
    public String update() {
        equipmentService.updateEquipmentDesc(model);
        //addActionMessage("update equipment successed.");
        return "success";
    }

    /**
     * 功能：删除用户
     * 调用：DELETE /equipment/1
     * 返回 equipment-index.jsp
     * @return
     */
    public String destroy() {
        equipmentService.deleteEquipmentById(id);
        //addActionMessage("delete equipment successed.");
        return "success";
    }

    // GET /equipment/1/deleteConfirm
    public String deleteConfirm() {
        return "deleteConfirm";
    }
}
