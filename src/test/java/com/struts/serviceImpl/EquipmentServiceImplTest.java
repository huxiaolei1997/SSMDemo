package com.struts.serviceImpl;

import com.struts.mapper.EquipmentMapper;
import com.struts.service.EquipmentService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class EquipmentServiceImplTest {

    @Test
    public void getEquipmentList() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("springconfig/applicationContext.xml");
        //EquipmentMapper equipmentMapper = applicationContext.getBean(EquipmentMapper.class);
        EquipmentService equipmentService = applicationContext.getBean(EquipmentServiceImpl.class);
        System.out.println(equipmentService.getEquipmentList(null).toString());
    }
}