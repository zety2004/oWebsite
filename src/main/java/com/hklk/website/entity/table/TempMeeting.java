package com.hklk.website.entity.table;

import com.hklk.website.util.JsonUtil;

import java.io.Serializable;
import java.util.Date;

public class TempMeeting implements Serializable {
    private Integer id;

    private String schoolName;

    private String principalName;

    private String principalPhone;

    private String chooseType;

    private Date createTime;

    private String personOne;

    private String personTwo;

    private String personThree;

    private String personFour;

    private String phoneOne;

    private String phoneTwo;

    private String phoneThree;

    private String phoneFour;

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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getPersonOne() {
        return personOne;
    }

    public void setPersonOne(String personOne) {
        this.personOne = personOne == null ? null : personOne.trim();
    }

    public String getPersonTwo() {
        return personTwo;
    }

    public void setPersonTwo(String personTwo) {
        this.personTwo = personTwo == null ? null : personTwo.trim();
    }

    public String getPersonThree() {
        return personThree;
    }

    public void setPersonThree(String personThree) {
        this.personThree = personThree == null ? null : personThree.trim();
    }

    public String getPersonFour() {
        return personFour;
    }

    public void setPersonFour(String personFour) {
        this.personFour = personFour == null ? null : personFour.trim();
    }

    public String getPhoneOne() {
        return phoneOne;
    }

    public void setPhoneOne(String phoneOne) {
        this.phoneOne = phoneOne == null ? null : phoneOne.trim();
    }

    public String getPhoneTwo() {
        return phoneTwo;
    }

    public void setPhoneTwo(String phoneTwo) {
        this.phoneTwo = phoneTwo == null ? null : phoneTwo.trim();
    }

    public String getPhoneThree() {
        return phoneThree;
    }

    public void setPhoneThree(String phoneThree) {
        this.phoneThree = phoneThree == null ? null : phoneThree.trim();
    }

    public String getPhoneFour() {
        return phoneFour;
    }

    public void setPhoneFour(String phoneFour) {
        this.phoneFour = phoneFour == null ? null : phoneFour.trim();
    }

    public static void main(String[] args) {
        System.out.println(JsonUtil.toJson(new TempMeeting()));
    }
}