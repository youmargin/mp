package com.app.mp.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.time.LocalDateTime;

@TableName("user")
public class User {
    @TableId
    private Long id;
    @TableField("name") //指定数据库中字段名
    private String name;
    private Integer age;
    private String email;
    private Long managerId;
    private LocalDateTime createTime;

    @TableField(exist = false)
    private transient String memoInfo;  // 数据库中没有对应的字段 transient

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getManagerId() {
        return managerId;
    }

    public void setManagerId(Long managerId) {
        this.managerId = managerId;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public String getMemoInfo() {
        return memoInfo;
    }

    public void setMemoInfo(String memoInfo) {
        this.memoInfo = memoInfo;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", managerId=" + managerId +
                ", createTime=" + createTime +
                ", memoInfo='" + memoInfo + '\'' +
                '}';
    }
}
