package com.lianqiang.badnews.module.live.bean;

/**
 * Describe:
 *
 * @author lianqiang on 2017/5/31.
 */

public class User {
    /**
     * state : 1
     * result : {"user_id":"temp_news_205b0816-f7b8-483a-8a46-0b2eeae71b6d"}
     */

    private int state;
    private ResultBean result;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * user_id : temp_news_205b0816-f7b8-483a-8a46-0b2eeae71b6d
         */

        private String user_id;

        public String getUser_id() {
            return user_id;
        }

        public void setUser_id(String user_id) {
            this.user_id = user_id;
        }
    }
}
