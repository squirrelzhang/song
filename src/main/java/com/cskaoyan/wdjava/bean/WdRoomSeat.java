/**
 * User: zsquirrel
 * Date: 2019-07-23
 * Time: 11:45
 */
package com.cskaoyan.wdjava.bean;

public class WdRoomSeat {

    private Integer id;

    private String roomNo;

    private Integer positionId;

    private Integer row;

    private Integer column;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
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
}
