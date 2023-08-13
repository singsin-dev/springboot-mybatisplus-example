package com.leo.mybatisplus.service;


import com.leo.mybatisplus.model.PeopleDto;
import com.leo.mybatisplus.service.impl.PeopleServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class PeopleServiceImplTest {
    
    
    private PeopleServiceImpl peopleService;
    
    @BeforeEach
    void setUp(){
        peopleService = new PeopleServiceImpl();
    }
    
    
    
    /**
     * 查询所有信息
     */
    @Test
    public void select() {
        List<PeopleDto> list = peopleService.list();
        list.forEach(System.out::println);
    }


    /**
     * 根据ID查询单条数据
     */
    @Test
    public void selectById() {

        PeopleDto byId = peopleService.getById(1);
        System.out.println("byId = " + byId);

    }

    /**
     * ID批量查询
     * 数组
     */
    @Test
    public void selectListByIds() {
        peopleService.listByIds(Arrays.asList(1,2,4,5));
    }

    /**
     * 
     */
    @Test
    public void selectByMap() {
        List<Map<String, Object>> maps = peopleService.listMaps();
        System.out.println("maps = " + maps);
    }
    
    
    

}