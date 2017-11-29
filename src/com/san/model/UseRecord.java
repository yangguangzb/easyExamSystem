package com.san.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UseRecord {
    private int recordId;//积分使用记录
    private int userId;//用户编号
    private  String useType;//积分使用类型
    private int useNumber;//积分使用数目
    private Date useTime;//积分使用使用时间

    public int getRecordId() {
        return recordId;
    }

    public void setRecordId(int recordId) {
        this.recordId = recordId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUseType() {
        return useType;
    }

    public void setUseType(String useType) {
        this.useType = useType;
    }

    public int getUseNumber() {
        return useNumber;
    }

    public void setUseNumber(int useNumber) {
        this.useNumber = useNumber;
    }

    public Date getUseTime() {
        return useTime;
    }

    public void setUseTime(Date useTime) {
        this.useTime = useTime;
    }
}
