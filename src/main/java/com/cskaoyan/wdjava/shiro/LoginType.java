package com.cskaoyan.wdjava.shiro;

/**
 * 登陆类型 stone
 * 预先保留了teacher类型的登陆
 * 当前只有学生和管理员
 */
public enum LoginType {
    STUDENT("Student"), ADMIN("Admin"), TEACHER("Teacher");

    private String type;

    private LoginType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return this.type.toString();
    }
}

