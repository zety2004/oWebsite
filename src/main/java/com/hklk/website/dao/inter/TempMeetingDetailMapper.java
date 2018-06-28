package com.hklk.website.dao.inter;

import com.hklk.website.entity.table.TempMeetingDetail;

public interface TempMeetingDetailMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TempMeetingDetail record);

    int insertSelective(TempMeetingDetail record);

    TempMeetingDetail selectByPrimaryKey(Integer id);
}