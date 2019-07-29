/**
 * User: zsquirrel
 * Date: 2019-07-23
 * Time: 15:04
 */
package com.cskaoyan.wdjava.service.impl;

import com.cskaoyan.wdjava.bean.WdRoomSeat;
import com.cskaoyan.wdjava.bean.WdSeatArrange;
import com.cskaoyan.wdjava.bean.WdTerm;
import com.cskaoyan.wdjava.mapper.WdRoomSeatMapper;
import com.cskaoyan.wdjava.mapper.WdSeatArrangeMapper;
import com.cskaoyan.wdjava.mapper.WdTermMapper;
import com.cskaoyan.wdjava.service.WdTermService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class WdTermServiceImpl implements WdTermService {

    @Autowired
    WdTermMapper wdTermMapper;

    @Autowired
    WdRoomSeatMapper wdRoomSeatMapper;

    @Autowired
    WdSeatArrangeMapper wdSeatArrangeMapper;



    @Override
    public List<WdTerm> queryCurrentTerms(Integer deleted) {
        return wdTermMapper.queryCurrentTerms(deleted);

    }

    @Override
    public Map<String, Object> selectSeatArrange(int id) {
        //先查询出当前期所在教室的座位情况,id值为当前期的编号id
        List<WdRoomSeat> roomSeats = wdRoomSeatMapper.selectRoomSeats(id);
        //查询当前期学生的所有座次情况
        List<WdSeatArrange> seatArranges = wdSeatArrangeMapper.selectSeatArrangeById(id);
        Map<String,Object> map = new HashMap<>();
        map.put("positionMessage",roomSeats);
        map.put("studentList",seatArranges);
        return map;
    }
}
