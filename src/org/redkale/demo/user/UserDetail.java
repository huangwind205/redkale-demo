/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.redkale.demo.user;

import javax.persistence.*;

import org.redkale.convert.*;
import org.redkale.demo.base.*;
import org.redkale.util.*;

/**
 *
 * @author zhangjx
 */
@AutoLoad
@Cacheable
@LogLevel("FINER")
public class UserDetail extends UserInfo {

    private static final Reproduce<UserInfo, UserDetail> reproduce = Reproduce.create(UserInfo.class, UserDetail.class);

    public static final short REGTYPE_EMAIL = 10; //邮箱注册

    public static final short REGTYPE_MOBILE = 20; //手机注册

    public static final short REGTYPE_WEIXIN = 30;  //微信注册

    public static final short REGTYPE_QQOPEN = 40; //QQ注册

    private long updatetime;  //修改时间

    private String remark = ""; //备注

    @Column(updatable = false)
    private short regtype;  //注册类型

    @Column(updatable = false)
    private long createtime; //注册时间

    @Column(updatable = false)
    private String regagent = "";//注册终端

    @Column(updatable = false)
    private String regaddr = "";//注册IP

    @Override
    public int hashCode() {
        return this.userid;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        return (this.userid != ((UserDetail) obj).userid);
    }

    public UserInfo createUserInfo() {
        return reproduce.copy(new UserInfo(), this);
    }

    public void digestPassword(String passwordmd5) {
        if (passwordmd5 == null || passwordmd5.isEmpty()) {
            this.password = "";
            return;
        }
        byte[] bytes = ("REDKALE-" + password.trim()).getBytes();
        synchronized (sha1) {
            bytes = sha1.digest(bytes);
        }
        this.password = new String(Utility.binToHex(bytes));
    }

    @Override
    public String getMobile() {
        return mobile;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String getWxunionid() {
        return wxunionid;
    }

    @ConvertColumn(ignore = true, type = ConvertType.JSON)
    public short getRegtype() {
        return regtype;
    }

    public void setRegtype(short regtype) {
        this.regtype = regtype;
    }

    @ConvertColumn(ignore = true, type = ConvertType.JSON)
    public long getCreatetime() {
        return createtime;
    }

    public void setCreatetime(long createtime) {
        this.createtime = createtime;
    }

    @ConvertColumn(ignore = true, type = ConvertType.JSON)
    public long getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(long updatetime) {
        this.updatetime = updatetime;
    }

    @ConvertColumn(ignore = true, type = ConvertType.JSON)
    public String getRegagent() {
        return regagent;
    }

    public void setRegagent(String regagent) {
        this.regagent = regagent;
    }

    @ConvertColumn(ignore = true, type = ConvertType.JSON)
    public String getRegaddr() {
        return regaddr;
    }

    public void setRegaddr(String regaddr) {
        this.regaddr = regaddr;
    }

    @ConvertColumn(ignore = true, type = ConvertType.JSON)
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}
