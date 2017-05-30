package com.lianqiang.badnews.module.live.bean;

/**
 * Describe:当前直播参与人数
 *
 * @author lianqiang on 2017/5/27.
 */

public class LiveUserCount {
    /**
     * code : 1
     * msg : {"user_count":134291}
     */

    private String code;
    private MsgBean msg;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public MsgBean getMsg() {
        return msg;
    }

    public void setMsg(MsgBean msg) {
        this.msg = msg;
    }

    public static class MsgBean {
        /**
         * user_count : 134291
         */

        private int user_count;

        public int getUser_count() {
            return user_count;
        }

        public void setUser_count(int user_count) {
            this.user_count = user_count;
        }
    }
}
