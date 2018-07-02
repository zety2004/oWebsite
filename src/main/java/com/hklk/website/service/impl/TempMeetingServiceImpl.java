package com.hklk.website.service.impl;

import com.hklk.website.dao.inter.TempMeetingMapper;
import com.hklk.website.entity.table.TempMeeting;
import com.hklk.website.service.TempMeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TempMeetingServiceImpl implements TempMeetingService {

    @Autowired
    TempMeetingMapper tempMeetingMapper;



    @Override
    public int insertTempMeeting(TempMeeting record) {

        tempMeetingMapper.insertSelective(record);
        return 1;
    }

}
