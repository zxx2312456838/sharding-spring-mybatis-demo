package com.sharding.demo.controller;

import com.sharding.demo.bean.Detail;
import com.sharding.demo.bean.TransFlow;
import com.sharding.demo.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.naming.Name;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ginant on 2018/11/5.
 */
@Controller
public class TestController {

    @Resource(name = "testService")
    TestService testService;


    @RequestMapping("/selectTransFlowByTxn")
    @ResponseBody
    public String selectTransFlowByUsrId(Integer transId,Long txn,Integer usrId){
    //http://localhost:8080/sharding-spring-mybatis-demo/selectTransFlowByTxn?txn=2&transId=110011&usrId=1
        Map<String ,Object> map = new HashMap<>();
        map.put("txn",txn);
        map.put("transId",transId);
        map.put("usrId",usrId);
        TransFlow transFlow = testService.selectTransFlowByUsrId(map);
        if (transFlow != null) {
            return transFlow.toString();
        } else {
            String str = "没查到";
            return str.toString();
        }
    }

    @RequestMapping(value = "selectDetailByDetailId")
    @ResponseBody
    public String selectDetailByDetailId(Integer detailId,Integer usrId){
    //http://localhost:8080/sharding-spring-mybatis-demo/selectDetailByDetailId?detailId=22&usrId=1
        Map<String ,Object> map = new HashMap<>();
        map.put("detailId", detailId);
        map.put("usrId", usrId);
        map.put("detailJs","2003");
        Detail detail = testService.selectDetailByDetailId(map);
        if (detail != null) {
            return detail.toString();
        } else {
            String str = "没查到";
            return str;
        }
    }

    @RequestMapping("insertTransFlow")
    @ResponseBody
    public String insertTransFlow(Integer transId,Integer usrId){
        Map<String ,Object> map = new HashMap<>();
        map.put("transId",transId);
        map.put("usrId",usrId );
        map.put("status","01" );
        map.put("txn",9009L );
        map.put("billNumber",9009 );
        int i = testService.insertTransFlow(map);
        return i+"";
    }

    @RequestMapping("insertDetail")
    @ResponseBody
    public String insertDetail(Integer detailId,Integer usrId){
        Map<String ,Object> map = new HashMap<>();
        map.put("detailId", detailId);
        map.put("detailJs", "detailJs000");
        map.put("usrId", usrId);
        int i = testService.insertDetail(map);
        return i+"";
    }

    /**
     * 测试事务
     *
     * 根据usrId分库
     * usrId1=1&usrId2=1   保证分到同一个库，其他数据写死的
     *
     * @param usrId1
     * @param usrId2
     * @return
     */
    //http://localhost:8080/sharding-spring-mybatis-demo/testTransaction?usrId1=1&usrId2=1
    @RequestMapping("testTransaction")
    @ResponseBody
    public String testTransaction(Integer usrId1,Integer usrId2){

        String i = testService.testTransaction(usrId1,usrId2);
        return i;
    }



}
