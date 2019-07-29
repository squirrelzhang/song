/**
 * User: zsquirrel
 * Date: 2019-07-23
 * Time: 11:48
 */
package com.cskaoyan.wdjava.bean;

public class WdSeatArrange {

    private Integer id;

    private Integer sid;

    private Integer positionId;

    private Integer row;

    private Integer column;

    /**
     * 学生的姓名
     * */
    private String name;


    /**
     * 学生的头像
     * */
    private String imgUrl;

    /**
     *
     *学生的组号
     * */
    private Integer group;

    /**
     *
     * 是否是组长，0表示不是，1表示是
     * */
    private Integer isLeader;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Integer getPositionId() {
        return positionId;
    }

    public void setPositionId(Integer positionId) {
        this.positionId = positionId;
    }

    public Integer getRow() {
        return row;
    }

    public void setRow(Integer row) {
        this.row = row;
    }

    public Integer getColumn() {
        return column;
    }

    public void setColumn(Integer column) {
        this.column = column;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Integer getGroup() {
        return group;
    }

    public void setGroup(Integer group) {
        this.group = group;
    }

    public Integer getIsLeader() {
        return isLeader;
    }

    public void setIsLeader(Integer isLeader) {
        this.isLeader = isLeader;
    }
}
