package com.btea.result;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author: TwentyFiveBTea
 * @Date: 2024/05/17 19:43
 * @Description: 封装统一响应体
 */
@Data
public class R implements Serializable {
    // 返回码
    private int code;
    // 返回信息
    private String msg;

    // 返回数据
    private List<Map<String, Object>> data = new ArrayList<>();

    private R() {
    }

    public static R ok() {
        R r = new R();
        r.setCode(200);
        r.setMsg("操作成功");
        return r;
    }

    public static R token(String token) {
        R r = new R();
        r.setCode(200);
        r.setMsg(token);
        return r;
    }

    public static R tokenIsExpired() {
        R r = new R();
        r.setCode(ResultCodeEnum.UNAUTHORIZED.getCode());
        r.setMsg(ResultCodeEnum.UNAUTHORIZED.getMsg());
        return r;
    }

    public static R data(List<Map<String, Object>> data) {
        R r = new R();
        r.setCode(200);
        r.setData(data);
        return r;
    }

    public static R notLoggedIn() {
        R r = new R();
        r.setCode(ResultCodeEnum.FORBIDDEN.getCode());
        r.setMsg(ResultCodeEnum.FORBIDDEN.getMsg());
        return r;
    }

    public static R noFindUser() {
        R r = new R();
        r.setCode(ResultCodeEnum.FORBIDDEN.getCode());
        r.setMsg(ResultCodeEnum.USERNOTEXIST.getMsg());
        return r;
    }

    public static R serverError() {
        R r = new R();
        r.setCode(ResultCodeEnum.SERVERERROR.getCode());
        r.setMsg(ResultCodeEnum.SERVERERROR.getMsg());
        return r;
    }

    public static R unprocessableEntity(List<Map<String, Object>> data) {
        R r = new R();
        r.setCode(ResultCodeEnum.UNPROCESSABLEENTITY.getCode());
        r.setMsg(ResultCodeEnum.UNPROCESSABLEENTITY.getMsg());
        r.setData(data);
        return r;
    }

}
