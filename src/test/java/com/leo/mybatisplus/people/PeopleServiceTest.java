package com.leo.mybatisplus.people;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.leo.mybatisplus.mapper.PeopleMapper;
import com.leo.mybatisplus.model.PeopleDto;
import com.leo.mybatisplus.service.PeopleService;
import com.leo.mybatisplus.service.impl.PeopleServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * @author leo thomas
 * @date 2023/7/29 下午 05:32
 */

public class PeopleServiceTest {

    @InjectMocks
    @Spy
    private PeopleServiceImpl underTest;
    
    @Mock
    private PeopleMapper peopleMapper;
    private AutoCloseable autoCloseable;

    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }
    
    @Test
    public void itShouldCheckIfExistsPeople() {

        String email = "nixgnixeix@gmail.com";
        
        PeopleDto people = new PeopleDto();
        people.setUserId(null);
        people.setUserName("周大侠");
        people.setName("哈哈");
        people.setEmail(email);
        people.setPassword("123");
        people.setIsAdmin("no");
        people.setDepartmentId(1);
        people.setPosition("oh");
        
        underTest.save(people);

        LambdaQueryWrapper<PeopleDto> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(PeopleDto::getEmail,email);

        PeopleDto one = underTest.getOne(lambdaQueryWrapper);
        
        assertThat(one.getEmail()).isEqualTo(email);


    }
    
}
