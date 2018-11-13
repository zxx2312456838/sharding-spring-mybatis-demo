package com.sharding.demo.serviceImpl;

import com.sharding.demo.bean.Detail;
import com.sharding.demo.bean.TransFlow;
import com.sharding.demo.dao.DetailMapper;
import com.sharding.demo.dao.TransFlowMapper;
import com.sharding.demo.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ginant on 2018/11/5.
 */
@Service("testService")
public class TestServiceImpl implements TestService{

    @Autowired
    private DetailMapper detailMapper;

    @Autowired
    private TransFlowMapper transFlowMapper;

    @Override
    public TransFlow selectTransFlowByUsrId(Map<String, Object> map) {

        return transFlowMapper.selectTransFlowByUsrId(map);
    }

    @Override
    public Detail selectDetailByDetailId(Map<String, Object> map) {
        Detail detail = new Detail();
        detail.setUsrId(1);
        detail.setDetailId(2);
        detail.setDetailJs("2002");
//        return detailMapper.selectDetailByDetailId(detail);
        return detailMapper.selectDetailByDetailId(map);
//        return detailMapper.selectDetailByDetailId((Integer)map.get("detailId"));
    }


    @Override
    public int insertTransFlow(Map<String, Object> map) {
        return transFlowMapper.insertTransFlow(map);
    }

    @Override
    public int insertDetail(Map<String, Object> map) {
        return detailMapper.insertDetail(map);
    }

    @Transactional
    @Override
    public String testTransaction(Integer usrId1, Integer usrId2) {

        Map<String ,Object> map = new HashMap<>();
        map.put("detailId", 22);
        map.put("detailJs", "detailJs000");
        map.put("usrId", usrId1);


        Map<String ,Object> map2 = new HashMap<>();
        map2.put("transId",2);
        map2.put("usrId",usrId2 );
        map2.put("status","01" );
        map2.put("txn",9009L );
        map2.put("billNumber",9009 );

//        int i1 = transFlowMapper.insertTransFlow(map2);
        int i = detailMapper.insertDetail(map);
        int i1 = detailMapper.insertDetail(map);

        return i+"--"+i1;
    }
}
