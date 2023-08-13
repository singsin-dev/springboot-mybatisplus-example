package com.leo.mybatisplus.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResponseStatusEnum {

    FAIL(500L,"失败"),
    SUCCESS(200L,"成功");
    
    private final long code;
    private final String msg;

}
