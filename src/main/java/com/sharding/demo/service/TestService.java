package com.sharding.demo.service;

import com.sharding.demo.bean.Detail;
import com.sharding.demo.bean.TransFlow;

import java.util.Map;

/**
 * Created by Ginant on 2018/11/5.
 */
public interface TestService {


    TransFlow selectTransFlowByUsrId(Map<String,Object> map);

    Detail selectDetailByDetailId(Map<String,Object> map);

    int insertTransFlow(Map<String,Object> map);

    int insertDetail(Map<String,Object> map);


    String testTransaction(Integer usrId1, Integer usrId2);
}
