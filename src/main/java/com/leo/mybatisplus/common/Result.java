package com.leo.mybatisplus.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Xiexingxie
 * @date 2023/4/23 下午 05:54
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> {
    
    private long code;
    private boolean success;
    private String msg;
    private T data;

    /**
     * 返回成功消息类
     * @return
     * @param <T>
     */
    public static<T> Result<T> ok(){
        return ok(ResponseStatusEnum.SUCCESS.getCode(),true,ResponseStatusEnum.SUCCESS.getMsg(),null);
    }
    
    /**
     * 返回成功消息类
     * @param data
     * @return
     * @param <T>
     */
    public static<T> Result<T> ok(T data){
        return ok(ResponseStatusEnum.SUCCESS.getCode(),true,ResponseStatusEnum.SUCCESS.getMsg(),data);
    }
    
    /**
     * 返回成功消息类
     * @param msg
     * @param data
     * @return
     * @param <T>
     */
    public static<T> Result<T> ok(String msg, T data){
        return ok(ResponseStatusEnum.SUCCESS.getCode(),true,msg,data);
    }


    /**
     * 返回失败消息类
     * @return
     * @param <T>
     */
    public static<T> Result<T> fail(){
        return ok(ResponseStatusEnum.FAIL.getCode(),false,ResponseStatusEnum.FAIL.getMsg(),null);
    }

    /**
     * 返回失败消息类
     * @return
     * @param <T>
     */
    public static<T> Result<T> fail(T data){
        return ok(ResponseStatusEnum.FAIL.getCode(),false,ResponseStatusEnum.FAIL.getMsg(),data);
    }

    /**
     * 返回失败消息类
     * @return
     * @param <T>
     */
    public static<T> Result<T> fail(String msg,T data){
        return ok(ResponseStatusEnum.FAIL.getCode(),false,msg,data);
    }
    
    
    
    private static<T> Result<T> ok(long code,boolean success,String msg,T data){
        return new Result<>(code,success,msg,data);
    }

    private static<T> Result<T> fail(long code,boolean success,String msg,T data){
        return new Result<>(code,success,msg,data);
    }
    
    
}
