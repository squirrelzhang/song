/**
 * User: zsquirrel
 * Date: 2019-07-23
 * Time: 15:04
 */
package com.cskaoyan.wdjava.service;

import com.cskaoyan.wdjava.bean.WdTerm;

import java.util.List;
import java.util.Map;

public interface WdTermService {
    List<WdTerm> queryCurrentTerms(Integer deleted);

    Map<String, Object> selectSeatArrange(int id);
}
