package com.btea.result;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: TwentyFiveBTea
 * @Date: 2024/05/17 19:43
 * @Description: 封装统一响应体
 */

@Data
public class R implements Serializable {
    private int code;
    private String msg;
    private Object data;

    public R(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public R(){}
    public static R ok() {
        return new R(200, "操作成功", null);
    }

    public static R ok(Object object) {
        return new R(200, "操作成功", object);
    }

    public static R Unauthorized(){
        R r = new R();
        r.setCode(ResultCodeEnum.UNAUTHORIZED.getCode());
        r.setMsg(ResultCodeEnum.UNAUTHORIZED.getMsg());
        r.setData(ResultCodeEnum.UNAUTHORIZED);
        return r;
    }

    public static R serverError(){
        R r = new R();
        r.setCode(ResultCodeEnum.UNAUTHORIZED.getCode());
        r.setMsg(ResultCodeEnum.SERVERERROR.getMsg());
        r.setData(ResultCodeEnum.SERVERERROR);
        return r;
    }

}
