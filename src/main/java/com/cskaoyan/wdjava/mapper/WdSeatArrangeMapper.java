/**
 * User: zsquirrel
 * Date: 2019-07-23
 * Time: 18:01
 */
package com.cskaoyan.wdjava.mapper;

import com.cskaoyan.wdjava.bean.WdSeatArrange;

import java.util.List;

public interface WdSeatArrangeMapper {
    List<WdSeatArrange> selectSeatArrangeById(int id);
}
