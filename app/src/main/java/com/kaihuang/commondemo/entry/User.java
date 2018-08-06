package com.kaihuang.commondemo.entry;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


/**
 * 用户实体类
 *
 * @author admin
 *         方式一：Code-->Generate
 *         <p>
 *         方式二：通过快捷键Alt+Insert
 */
public class User implements Serializable {


    /**
     * protocolPassFlag : 1
     * engineerAuditStatus : 2
     * serviceLatitude : null
     * toKen : FlwaTexElNX6NHPZ8Cq+hA4Wd0gJKYdCPrtMrRw8QNu4dQi5SO+/aTUdA9/1EZ6bzDYts9pgN3o=
     * customerPhone : null
     * userType : 3
     * balance : 0
     * authority : null
     * pushId : null
     * nikeName : 188****6590
     * userId : 728
     * userName : 18899776590
     * merchantName : 优服网科技
     * sessionKey : d64e885e75484c68a5a2e2f3cef53a74
     * operateStatus : 1
     * customerName : null
     * identityType : 1
     * defaultPassword : true
     * serviceCity : 长治市
     * lastLoginDate : 1526519845000
     * servicePro : 山西省
     * payNotify : 1
     * idApprovStatus : 2
     * headImg : null
     * email : null
     * openStatus : 1
     * serviceDist : 郊　区
     * serviceLongitude : null
     * merchantNo : 00000000
     * uBalance : 0
     */

    private String protocolPassFlag;
    private String engineerAuditStatus;
    private String serviceLatitude;
    private String toKen;
    private String customerPhone;
    private String userType;
    private String balance;
    private String authority;
    private String pushId;
    private String nikeName;
    private String userId;
    private String userName;
    private String merchantName;
    private String sessionKey;
    private String operateStatus;
    private String customerName;
    private String identityType;
    private boolean defaultPassword;
    private String serviceCity;
    private long lastLoginDate;
    private String servicePro;
    private String payNotify;
    private String idApprovStatus;
    private String headImg;
    private String email;
    private String openStatus;
    private String serviceDist;
    private String serviceLongitude;
    private String merchantNo;
    private String uBalance;
    private String realName;
    private String mobile;
    private String photoUrl;
    private String sysUserType;
    private String serviceAddress;
    private String workType;
    private String acceptRange;
    private String identityCheckReason;//身份审核不通过原因：

    public static User objectFromData(String str) {

        return new Gson().fromJson(str, User.class);
    }

    public static User objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(key), User.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<User> arrayUserFromData(String str) {

        Type listType = new TypeToken<ArrayList<User>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public static List<User> arrayUserFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<User>>() {
            }.getType();

            return new Gson().fromJson(jsonObject.getString(key), listType);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return new ArrayList();


    }


    public String getWorkType() {
        return workType;
    }

    public void setWorkType(String workType) {
        this.workType = workType;
    }

    public String getAcceptRange() {
        return acceptRange;
    }

    public void setAcceptRange(String acceptRange) {
        this.acceptRange = acceptRange;
    }

    public String getServiceAddress() {
        return serviceAddress;
    }

    public void setServiceAddress(String serviceAddress) {
        this.serviceAddress = serviceAddress;
    }

    public String getIdentityCheckReason() {
        return identityCheckReason;
    }

    public void setIdentityCheckReason(String identityCheckReason) {
        this.identityCheckReason = identityCheckReason;
    }

    public String getProtocolPassFlag() {
        return protocolPassFlag;
    }

    public void setProtocolPassFlag(String protocolPassFlag) {
        this.protocolPassFlag = protocolPassFlag;
    }

    public String getEngineerAuditStatus() {
        return engineerAuditStatus;
    }

    public void setEngineerAuditStatus(String engineerAuditStatus) {
        this.engineerAuditStatus = engineerAuditStatus;
    }

    public String getuBalance() {
        return uBalance;
    }

    public void setuBalance(String uBalance) {
        this.uBalance = uBalance;
    }

    public String getSysUserType() {
        return sysUserType;
    }

    public void setSysUserType(String sysUserType) {
        this.sysUserType = sysUserType;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getServiceLatitude() {
        return serviceLatitude;
    }

    public void setServiceLatitude(String serviceLatitude) {
        this.serviceLatitude = serviceLatitude;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getToKen() {
        return toKen;
    }

    public void setToKen(String toKen) {
        this.toKen = toKen;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public String getPushId() {
        return pushId;
    }

    public void setPushId(String pushId) {
        this.pushId = pushId;
    }

    public String getNikeName() {
        return nikeName;
    }

    public void setNikeName(String nikeName) {
        this.nikeName = nikeName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public String getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }

    public String getOperateStatus() {
        return operateStatus;
    }

    public void setOperateStatus(String operateStatus) {
        this.operateStatus = operateStatus;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getIdentityType() {
        return identityType;
    }

    public void setIdentityType(String identityType) {
        this.identityType = identityType;
    }

    public boolean isDefaultPassword() {
        return defaultPassword;
    }

    public void setDefaultPassword(boolean defaultPassword) {
        this.defaultPassword = defaultPassword;
    }

    public String getServiceCity() {
        return serviceCity;
    }

    public void setServiceCity(String serviceCity) {
        this.serviceCity = serviceCity;
    }

    public long getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(long lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public String getServicePro() {
        return servicePro;
    }

    public void setServicePro(String servicePro) {
        this.servicePro = servicePro;
    }

    public String getPayNotify() {
        return payNotify;
    }

    public void setPayNotify(String payNotify) {
        this.payNotify = payNotify;
    }

    public String getIdApprovStatus() {
        return idApprovStatus;
    }

    public void setIdApprovStatus(String idApprovStatus) {
        this.idApprovStatus = idApprovStatus;
    }

    public String getHeadImg() {
        if (headImg != null && !headImg.equals("")) {

        } else {
            headImg = "http://youfu.oss-cn-shenzhen.aliyuncs.com/APP_images/head/%E9%BB%98%E8%AE%A4%E5%A4%B4%E5%83%8F@3x.png";
        }
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOpenStatus() {
        return openStatus;
    }

    public void setOpenStatus(String openStatus) {
        this.openStatus = openStatus;
    }

    public String getServiceDist() {
        return serviceDist;
    }

    public void setServiceDist(String serviceDist) {
        this.serviceDist = serviceDist;
    }

    public String getServiceLongitude() {
        return serviceLongitude;
    }

    public void setServiceLongitude(String serviceLongitude) {
        this.serviceLongitude = serviceLongitude;
    }

    public String getMerchantNo() {
        return merchantNo;
    }

    public void setMerchantNo(String merchantNo) {
        this.merchantNo = merchantNo;
    }

    public String getUBalance() {
        return uBalance;
    }

    public void setUBalance(String uBalance) {
        this.uBalance = uBalance;
    }
}
