package com.hklk.website.entity.table;

import java.io.Serializable;

public class TempMeeting implements Serializable {
    private Integer id;

    private String schoolName;

    private String principalName;

    private String principalPhone;

    private String chooseType;

    private String uniqueNum;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName == null ? null : schoolName.trim();
    }

    public String getPrincipalName() {
        return principalName;
    }

    public void setPrincipalName(String principalName) {
        this.principalName = principalName == null ? null : principalName.trim();
    }

    public String getPrincipalPhone() {
        return principalPhone;
    }

    public void setPrincipalPhone(String principalPhone) {
        this.principalPhone = principalPhone == null ? null : principalPhone.trim();
    }

    public String getChooseType() {
        return chooseType;
    }

    public void setChooseType(String chooseType) {
        this.chooseType = chooseType == null ? null : chooseType.trim();
    }

    public String getUniqueNum() {
        return uniqueNum;
    }

    public void setUniqueNum(String uniqueNum) {
        this.uniqueNum = uniqueNum;
    }
}