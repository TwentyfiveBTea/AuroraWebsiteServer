package com.btea.result;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: TwentyFiveBTea
 * @Date: 2024/05/17 19:43
 * @Description: 封装统一响应体
 */
@Data
public class R implements Serializable {
    private int code;
    private String msg;
    private String data;

    public R(int code, String msg, String data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public R() {
    }

    public static R ok() {
        return new R(200, "操作成功", null);
    }

    public static R ok(String str) {
        return new R(200, "操作成功", str);
    }

    public static R notLoggedIn() {
        R r = new R();
        r.setCode(ResultCodeEnum.BADREQUEST.getCode());
        r.setMsg("你要先登陆哦~");
        r.setData(String.valueOf(ResultCodeEnum.BADREQUEST));
        return r;
    }

    public static R noFindUser() {
        R r = new R();
        r.setCode(ResultCodeEnum.BADREQUEST.getCode());
        r.setMsg("用户不存在");
        r.setData(String.valueOf(ResultCodeEnum.BADREQUEST));
        return r;
    }

    public static R serverError() {
        R r = new R();
        r.setCode(ResultCodeEnum.SERVERERROR.getCode());
        r.setMsg(ResultCodeEnum.SERVERERROR.getMsg());
        r.setData(String.valueOf(ResultCodeEnum.SERVERERROR));
        return r;
    }

    public static R unprocessableEntity(String data) {
        R r = new R();
        r.setCode(ResultCodeEnum.UNPROCESSABLEENTITY.getCode());
        r.setMsg(ResultCodeEnum.UNPROCESSABLEENTITY.getMsg());
        r.setData(data);
        return r;
    }

}
