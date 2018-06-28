package com.hklk.website.service.impl;

import com.hklk.website.dao.inter.TempMeetingDetailMapper;
import com.hklk.website.dao.inter.TempMeetingMapper;
import com.hklk.website.dao.inter.UserFeedBackMapper;
import com.hklk.website.entity.table.TempMeeting;
import com.hklk.website.entity.table.TempMeetingDetail;
import com.hklk.website.entity.table.UserFeedBack;
import com.hklk.website.service.FeedBackService;
import com.hklk.website.service.TempMeetingService;
import com.hklk.website.util.ToolUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TempMeetingServiceImpl implements TempMeetingService {

    @Autowired
    TempMeetingMapper tempMeetingMapper;

    @Autowired
    TempMeetingDetailMapper tempMeetingDetailMapper;

    @Override
    public int insertTempMeeting(TempMeeting record, List<TempMeetingDetail> tempMeetingDetails) {
        String uniqueNum = ToolUtil.createId();
        record.setUniqueNum(uniqueNum);
        tempMeetingMapper.insertSelective(record);
        TempMeeting tempMeeting = tempMeetingMapper.selectMeetingByUniqueNum(uniqueNum);
        if (tempMeeting != null) {
            for (TempMeetingDetail temp : tempMeetingDetails) {
                temp.setMeetingId(tempMeeting.getId());
                tempMeetingDetailMapper.insertSelective(temp);
            }
        }
        return 1;
    }


}
