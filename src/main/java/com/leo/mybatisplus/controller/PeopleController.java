package com.leo.mybatisplus.controller;

import com.leo.mybatisplus.common.Result;
import com.leo.mybatisplus.consant.ApiConsant;
import com.leo.mybatisplus.model.PeopleDto;
import com.leo.mybatisplus.model.vo.PeopleVO;
import com.leo.mybatisplus.service.PeopleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

/**
 * @author Xiexingxie
 * @date 2023/4/23 下午 05:48
 */

@RestController
@Api(
        value = "leo",
        tags = "人员信息数据接口"
)
@RequestMapping(ApiConsant.APIVERSION + "people")
public class PeopleController {

    private final PeopleService peopleService;

    public PeopleController(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @PostMapping
    @ApiOperation(value = "添加人员信息",notes = "leo")
    public Result selPeopleAll(@RequestBody PeopleDto peopleDto){
        peopleService.save(peopleDto);
        return Result.ok();
    }
    
    @GetMapping
    @ApiOperation(value = "根据ID查询某个人员信息",notes = "leo")
    public Result<PeopleVO> selPeopelByUserId(Integer userId){
        PeopleVO peopleVo = new PeopleVO();
        BeanUtils.copyProperties(
                peopleService.getBaseMapper()
                        .selectById(userId),
                new PeopleVO()
        );
        return Result.ok(peopleVo);
    }
    
    
    
}





