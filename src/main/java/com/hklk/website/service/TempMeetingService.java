package com.hklk.website.service;

import com.hklk.website.entity.table.TempMeeting;

public interface TempMeetingService {
    int insertTempMeeting(TempMeeting record);
    TempMeeting selectByUuid(String uuid);
}
