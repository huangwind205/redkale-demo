/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.redkale.demo.user;

import org.redkale.demo.base.*;

/**
 *
 * @author zhangjx
 */
public class UserPwdBean extends BaseBean {

    private String sessionid;

    private String randomcode = "";

    private String oldpwd;

    private String newpwd;

    public String getSessionid() {
        return sessionid;
    }

    public void setSessionid(String sessionid) {
        this.sessionid = sessionid;
    }

    public String getOldpwd() {
        return oldpwd;
    }

    public void setOldpwd(String oldpwd) {
        this.oldpwd = oldpwd;
    }

    public String getNewpwd() {
        return newpwd;
    }

    public void setNewpwd(String newpwd) {
        this.newpwd = newpwd;
    }

    public String getRandomcode() {
        return randomcode;
    }

    public void setRandomcode(String randomcode) {
        this.randomcode = randomcode;
    }

}
