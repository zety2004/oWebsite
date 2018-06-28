package com.hklk.website.service;

import com.hklk.website.entity.table.TempMeeting;
import com.hklk.website.entity.table.TempMeetingDetail;

import java.util.List;

public interface TempMeetingService {
    int insertTempMeeting(TempMeeting record, List<TempMeetingDetail> tempMeetingDetails);

}
