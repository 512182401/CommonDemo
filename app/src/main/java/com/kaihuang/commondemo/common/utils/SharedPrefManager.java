package com.kaihuang.commondemo.common.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Base64;


import com.kaihuang.commondemo.App;
import com.kaihuang.commondemo.entry.User;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;


public class SharedPrefManager {

    private String lock = "lock";
    private static final String SHAREPRE_FILE_NAME = "user";
    private static final String VOICEVAULE = "voiceVaule";
    private static final String ACCVALUE = "accvalue";
    private static SharedPrefManager instance;
    private static SharedPreferences mShpr;//

    private static final String USER_Object = "user";
    private static final String BANANA_Object = "banana";//banana轮播图


    /**
     * 我的
     */
    private static final String SETTING_Object = "setting";//设置
    private static final String Language_Object = "language";//语言设置
    private static final String BlackList_Object = "blacklist";//黑名单

    private static final String ISALARM_Object = "isalarm";//表示设置闹钟
    private static final String GROUPALL_Object = "groupall";//表示设置闹钟
    private static final String SERVICECRED_Object = "servicescred";//服务凭证


    //是否更新app的日期
    public static final String IS_UP_APP = "is_upapp";


    /**
     * 是否第一次启动App
     */
    public static final String IS_EXECUTE_FIRST = "is_execute_first";

    // 保存字段名称 end

    private SharedPrefManager() {
        mShpr = App.app.getSharedPreferences(SHAREPRE_FILE_NAME,
                Context.MODE_PRIVATE);
    }

    /**
     * 单例模式，返回SharedPrefManager的静态实例；
     *
     * @return
     */
    public static SharedPrefManager getInstance() {
        if (instance == null) {
            instance = new SharedPrefManager();
        }
        return instance;
    }

    /**
     * 清除缓存
     */
    public void clearAllData() {
        synchronized (lock) {
            mShpr.edit().clear().commit();
        }
    }




    /**
     * 保存用户信息到本地
     *
     * @param user
     */
    public void saveUserToLocal(User user) {
        setObject(USER_Object, user);

        LogUtils.sysout("保存user数据，为了自动登录");
    }

    //
    public User getUserFromLocal() {

        LogUtils.sysout("请求登录数据");
        return getObject(USER_Object, User.class);
    }

//    private static final String MYNOMEWORKS_Object = "myhomeWorks";//我的作品

    /**
     * 保存黑名单
     */
    public void cacheApiBlackList(String json) {
        synchronized (lock) {
            mShpr.edit().putString(BlackList_Object, json).commit();
        }
    }

    public String getCacheApiBlackList() {
        synchronized (lock) {
            return mShpr.getString(BlackList_Object, "");
        }
    }

    /**
     * 保存语言设置
     */
    public void cacheApiLanguage(String json) {
        synchronized (lock) {
            mShpr.edit().putString(Language_Object, json).commit();
        }
    }

    public String getCacheApiLanguage() {
        synchronized (lock) {
            return mShpr.getString(Language_Object, "language");
//            return mShpr.getString( Language_Object, "zh_TW" );
        }
    }


    /**
     * 保存app检测的时间
     */
    public void cacheApiupapp(String json) {
        synchronized (lock) {
            mShpr.edit().putString(IS_UP_APP, json).commit();
        }
    }

    public String getCacheApiupapp() {
        synchronized (lock) {
            return mShpr.getString(IS_UP_APP, "");
        }
    }


    /**
     * 轮播图
     */
    public void cacheApioriginBanner(String json) {
        synchronized (lock) {
            mShpr.edit().putString(BANANA_Object, json).commit();
        }
    }

    public String getCacheApioriginBanner() {
        synchronized (lock) {
            return mShpr.getString(BANANA_Object, "");
        }
    }


    /**
     * @return true标识App第一次启动；需要显示引导图界面；false则相反
     */
    public boolean isExecuteFirst() {
        return mShpr.getBoolean(IS_EXECUTE_FIRST, true);
    }

    public void setExecuteFirst(boolean value) {
        mShpr.edit().putBoolean(IS_EXECUTE_FIRST, value).commit();
    }


    /**
     * 针对复杂类型存储<对象>
     */
    public void setObject(String key, Object object) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(baos);
            out.writeObject(object);
            String objectVal = new String(Base64.encode(baos.toByteArray(),
                    Base64.DEFAULT));
            Editor editor = mShpr.edit();
            editor.putString(key, objectVal);
            editor.commit();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (baos != null) {
                    baos.close();
                }
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @SuppressWarnings("unchecked")
    public <T> T getObject(String key, Class<T> clazz) {
        if (mShpr.contains(key)) {
            String objectVal = mShpr.getString(key, null);
            byte[] buffer = Base64.decode(objectVal, Base64.DEFAULT);
            ByteArrayInputStream bais = new ByteArrayInputStream(buffer);
            ObjectInputStream ois = null;
            try {
                ois = new ObjectInputStream(bais);
                T t = (T) ois.readObject();
                return t;
            } catch (StreamCorruptedException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (bais != null) {
                        bais.close();
                    }
                    if (ois != null) {
                        ois.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

}
