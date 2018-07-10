package com.hklk.website.service;

import com.hklk.website.entity.table.TempMeeting;

import java.util.List;
import java.util.Map;

public interface TempMeetingService {
    int insertTempMeeting(TempMeeting record);

    TempMeeting selectByUuid(String uuid);

    List<Map<String, Object>> queryMeeting();
}
