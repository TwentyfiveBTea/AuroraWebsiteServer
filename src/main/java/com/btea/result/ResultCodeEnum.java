package com.btea.result;

import lombok.Getter;

/**
 * @Author: TwentyFiveBTea
 * @Date: 2024/05/17 18:43
 * @Description: 状态码枚举
 */
@Getter
public enum ResultCodeEnum {
    SUCCESS("true", 200, "操作成功"),
    FORBIDDEN("false", 403, "你要先登陆哦~"),
    USERNOTEXIST("false", 400, "用户不存在"),
    UNPROCESSABLEENTITY("false", 422, "传入数据有误"),
    SERVERERROR("false", 500, "寄咯，后端炸了，请联系相关人员");

    private final String success;
    private final int code;
    private final String msg;

    ResultCodeEnum(String success, int code, String msg) {
        this.success = success;
        this.code = code;
        this.msg = msg;
    }

}
