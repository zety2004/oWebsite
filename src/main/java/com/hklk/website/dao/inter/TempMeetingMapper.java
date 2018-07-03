package com.hklk.website.dao.inter;

import com.hklk.website.entity.table.TempMeeting;

public interface TempMeetingMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TempMeeting record);

    int insertSelective(TempMeeting record);

    TempMeeting selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TempMeeting record);

    int updateByPrimaryKey(TempMeeting record);

    TempMeeting selectByUuid(String uuid);
}