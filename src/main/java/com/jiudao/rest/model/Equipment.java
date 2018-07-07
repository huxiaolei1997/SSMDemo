package com.jiudao.rest.model;

/**
 * Equipment
 *
 * version 1.0
 *
 * @create 2018-07-04 10:22
 *
 * @email huxiaolei1997@gmail.com
 */
public class Equipment {
    private int id;
    private int code;
    private String desc;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "{" +
                "id: " + id +
                ", code: " + code +
                ", desc: \"" + desc +
                "\"}";
    }
}
