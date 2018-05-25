package com.exception;

/**
 * @author BaoZhou
 * @date 2018/5/22
 */
public class UserNotExistException extends  RuntimeException{
    public UserNotExistException() {
        super("用户不存在");
    }
}
