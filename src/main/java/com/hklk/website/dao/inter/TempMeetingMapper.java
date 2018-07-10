package com.hklk.website.dao.inter;

import com.hklk.website.entity.table.TempMeeting;

import java.util.List;
import java.util.Map;

public interface TempMeetingMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TempMeeting record);

    int insertSelective(TempMeeting record);

    TempMeeting selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TempMeeting record);

    int updateByPrimaryKey(TempMeeting record);

    TempMeeting selectByUuid(String uuid);

    List<Map<String, Object>> callMeeting();

    List<Map<String, Object>> callMeetingDis();
}