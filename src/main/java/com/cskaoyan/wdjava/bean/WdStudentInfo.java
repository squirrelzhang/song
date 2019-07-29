package com.cskaoyan.wdjava.bean;

import java.util.Date;

public class WdStudentInfo {
    private Integer id;

    private Integer sn;

    private String stuName;

    private Integer group;

    private Integer isLeader;

    private String password;

    private String idNo;

    private Integer startTermId;

    private Integer currentTermId;

    private String mobile;

    private Integer master;

    private String status;

    private Date birthday;

    private String pic;

    private String gender;

    private String school;

    private String major;

    private Integer graduateYear;

    private String comment;

    private Date addTime;

    private Date updateTime;

    private Integer deleted;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSn() {
        return sn;
    }

    public void setSn(Integer sn) {
        this.sn = sn;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName == null ? null : stuName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo == null ? null : idNo.trim();
    }

    public Integer getStartTermId() {
        return startTermId;
    }

    public void setStartTermId(Integer startTermId) {
        this.startTermId = startTermId;
    }

    public Integer getCurrentTermId() {
        return currentTermId;
    }

    public void setCurrentTermId(Integer currentTermId) {
        this.currentTermId = currentTermId;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public Integer getMaster() {
        return master;
    }

    public void setMaster(Integer master) {
        this.master = master;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic == null ? null : pic.trim();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school == null ? null : school.trim();
    }

    public Integer getGraduateYear() {
        return graduateYear;
    }

    public void setGraduateYear(Integer graduateYear) {
        this.graduateYear = graduateYear;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    public Integer getGroup() {
        return group;
    }

    public void setGroup(Integer group) {
        this.group = group;
    }

    public Integer getIsLeader() {
        return isLeader;
    }

    public void setIsLeader(Integer isLeader) {
        this.isLeader = isLeader;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public WdStudentInfo() {
    }

    public WdStudentInfo(String stuName, Integer startTermId) {
        this.stuName = stuName;
        this.startTermId = startTermId;
        this.deleted = 0;
        this.status = "001";
        Date addTime = new Date();
        this.addTime = addTime;
        this.updateTime = addTime;
        this.currentTermId = startTermId;
    }
}