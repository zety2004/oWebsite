package com.hklk.website.service.impl;

import com.hklk.website.dao.inter.TempMeetingMapper;
import com.hklk.website.entity.table.TempMeeting;
import com.hklk.website.service.TempMeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class TempMeetingServiceImpl implements TempMeetingService {

    @Autowired
    TempMeetingMapper tempMeetingMapper;



    @Override
    public int insertTempMeeting(TempMeeting record) {

        tempMeetingMapper.insertSelective(record);
        return 1;
    }

    @Override
    public TempMeeting selectByUuid(String uuid) {
        return tempMeetingMapper.selectByUuid(uuid);
    }

    @Override
    public List<Map<String, Object>> queryMeeting() {
        return tempMeetingMapper.queryMeeting();
    }
}
