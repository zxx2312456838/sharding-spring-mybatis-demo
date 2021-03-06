package com.sharding.demo.dao;

import com.sharding.demo.bean.TransFlow;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface TransFlowMapper {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trans_flow01
     *
     * @mbg.generated Mon Nov 05 16:16:19 CST 2018
     */
    int insert(TransFlow record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trans_flow01
     *
     * @mbg.generated Mon Nov 05 16:16:19 CST 2018
     */
    int insertSelective(TransFlow record);



    TransFlow selectTransFlowByUsrId(Map<String, Object> map);
//    TransFlow selectTransFlowByUsrId(TransFlow transFlow);

    int insertTransFlow(Map<String, Object> map);

}