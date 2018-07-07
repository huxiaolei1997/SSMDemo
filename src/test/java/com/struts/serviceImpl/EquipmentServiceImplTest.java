package com.struts.serviceImpl;

import com.jiudao.rest.service.EquipmentService;
import com.jiudao.rest.serviceImpl.EquipmentServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EquipmentServiceImplTest {

    @Test
    public void getEquipmentList() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("springconfig/applicationContext.xml");
        //EquipmentMapper equipmentMapper = applicationContext.getBean(EquipmentMapper.class);
        EquipmentService equipmentService = applicationContext.getBean(EquipmentServiceImpl.class);
        System.out.println(equipmentService.getEquipmentList(null).toString());
    }
}