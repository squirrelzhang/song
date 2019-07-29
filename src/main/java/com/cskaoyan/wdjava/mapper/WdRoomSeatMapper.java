/**
 * User: zsquirrel
 * Date: 2019-07-23
 * Time: 17:24
 */
package com.cskaoyan.wdjava.mapper;

import com.cskaoyan.wdjava.bean.WdRoomSeat;

import java.util.List;

public interface WdRoomSeatMapper {

    List<WdRoomSeat> selectRoomSeats(Integer id);
}
