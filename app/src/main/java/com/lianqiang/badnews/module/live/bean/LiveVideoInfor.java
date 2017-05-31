package com.lianqiang.badnews.module.live.bean;

import java.util.List;

/**
 * Describe:直播视频信息
 *
 * @author lianqiang on 2017/5/30.
 */

public class LiveVideoInfor {


    /**
     * state : 1
     * msg : success
     * result : {"video":{"video_id":4731,"state":0,"room_id":10351,"title":"【女神艺述室】明代皇家水陆画的前世今生","user_id":1167312,"like_num":16000,"total_num":293911,"user_img":"http://dingyue.nosdn.127.net/XwbkRz4O37BWhu1fLfDZAM2eZsWONzYJryXBA8pzkPyHF1495158613264.jpg","user_nickname":"女神艺述室","confirm":0,"weight":50,"tid":"T1484642152798","intro":"为了更好的发挥宗教文化艺术在促进社会发展中的积极作用，推动传承与发展，此次\u201c明代皇家水陆画临创的艺术实践与东方文艺复兴学术研讨会\u201d探讨明代皇家水陆画艺术的传承和保护在新时代背景下的学术意义和具体措施。以宗教艺术为载体，更直观的弘扬和传播善德理念，有助于更好的构筑和谐社会。","img_url":"","cover_url":"","start_time":1495953040000,"now_time":1496200753009,"end_time":1495966011000,"app_url":"","web_url":"http://live163.nosdn.127.net/store/101664/luobo_push_57014_1495953003908_101664_101664_20170528143040_20170528180651_1.mp4","live_id":57014,"direction":1,"is_host":"0","hosts":[{"ursid":"mencyz_94@163.com","nickName":"Sunny和小太阳","userId":2025303,"avatar":"http://mobilepics.nosdn.127.net/TUaL582HwLF2WD503R12c5bp7mk0I6s0512791375"}],"sublive_info":[],"had_video_host":0,"anchor_accid":"096a19f24c384d79b1655723ba121559","realTotal_num":35411}}
     */

    private int state;
    private String msg;
    private ResultBean result;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * video : {"video_id":4731,"state":0,"room_id":10351,"title":"【女神艺述室】明代皇家水陆画的前世今生","user_id":1167312,"like_num":16000,"total_num":293911,"user_img":"http://dingyue.nosdn.127.net/XwbkRz4O37BWhu1fLfDZAM2eZsWONzYJryXBA8pzkPyHF1495158613264.jpg","user_nickname":"女神艺述室","confirm":0,"weight":50,"tid":"T1484642152798","intro":"为了更好的发挥宗教文化艺术在促进社会发展中的积极作用，推动传承与发展，此次\u201c明代皇家水陆画临创的艺术实践与东方文艺复兴学术研讨会\u201d探讨明代皇家水陆画艺术的传承和保护在新时代背景下的学术意义和具体措施。以宗教艺术为载体，更直观的弘扬和传播善德理念，有助于更好的构筑和谐社会。","img_url":"","cover_url":"","start_time":1495953040000,"now_time":1496200753009,"end_time":1495966011000,"app_url":"","web_url":"http://live163.nosdn.127.net/store/101664/luobo_push_57014_1495953003908_101664_101664_20170528143040_20170528180651_1.mp4","live_id":57014,"direction":1,"is_host":"0","hosts":[{"ursid":"mencyz_94@163.com","nickName":"Sunny和小太阳","userId":2025303,"avatar":"http://mobilepics.nosdn.127.net/TUaL582HwLF2WD503R12c5bp7mk0I6s0512791375"}],"sublive_info":[],"had_video_host":0,"anchor_accid":"096a19f24c384d79b1655723ba121559","realTotal_num":35411}
         */

        private VideoBean video;

        public VideoBean getVideo() {
            return video;
        }

        public void setVideo(VideoBean video) {
            this.video = video;
        }

        public static class VideoBean {
            /**
             * video_id : 4731
             * state : 0
             * room_id : 10351
             * title : 【女神艺述室】明代皇家水陆画的前世今生
             * user_id : 1167312
             * like_num : 16000
             * total_num : 293911
             * user_img : http://dingyue.nosdn.127.net/XwbkRz4O37BWhu1fLfDZAM2eZsWONzYJryXBA8pzkPyHF1495158613264.jpg
             * user_nickname : 女神艺述室
             * confirm : 0
             * weight : 50
             * tid : T1484642152798
             * intro : 为了更好的发挥宗教文化艺术在促进社会发展中的积极作用，推动传承与发展，此次“明代皇家水陆画临创的艺术实践与东方文艺复兴学术研讨会”探讨明代皇家水陆画艺术的传承和保护在新时代背景下的学术意义和具体措施。以宗教艺术为载体，更直观的弘扬和传播善德理念，有助于更好的构筑和谐社会。
             * img_url :
             * cover_url :
             * start_time : 1495953040000
             * now_time : 1496200753009
             * end_time : 1495966011000
             * app_url :
             * web_url : http://live163.nosdn.127.net/store/101664/luobo_push_57014_1495953003908_101664_101664_20170528143040_20170528180651_1.mp4
             * live_id : 57014
             * direction : 1
             * is_host : 0
             * hosts : [{"ursid":"mencyz_94@163.com","nickName":"Sunny和小太阳","userId":2025303,"avatar":"http://mobilepics.nosdn.127.net/TUaL582HwLF2WD503R12c5bp7mk0I6s0512791375"}]
             * sublive_info : []
             * had_video_host : 0
             * anchor_accid : 096a19f24c384d79b1655723ba121559
             * realTotal_num : 35411
             */

            private int video_id;
            private int state;
            private int room_id;
            private String title;
            private int user_id;
            private int like_num;
            private int total_num;
            private String user_img;
            private String user_nickname;
            private int confirm;
            private int weight;
            private String tid;
            private String intro;
            private String img_url;
            private String cover_url;
            private long start_time;
            private long now_time;
            private long end_time;
            private String app_url;
            private String web_url;
            private int live_id;
            private int direction;
            private String is_host;
            private int had_video_host;
            private String anchor_accid;
            private int realTotal_num;
            private List<HostsBean> hosts;
            private List<?> sublive_info;

            public int getVideo_id() {
                return video_id;
            }

            public void setVideo_id(int video_id) {
                this.video_id = video_id;
            }

            public int getState() {
                return state;
            }

            public void setState(int state) {
                this.state = state;
            }

            public int getRoom_id() {
                return room_id;
            }

            public void setRoom_id(int room_id) {
                this.room_id = room_id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public int getUser_id() {
                return user_id;
            }

            public void setUser_id(int user_id) {
                this.user_id = user_id;
            }

            public int getLike_num() {
                return like_num;
            }

            public void setLike_num(int like_num) {
                this.like_num = like_num;
            }

            public int getTotal_num() {
                return total_num;
            }

            public void setTotal_num(int total_num) {
                this.total_num = total_num;
            }

            public String getUser_img() {
                return user_img;
            }

            public void setUser_img(String user_img) {
                this.user_img = user_img;
            }

            public String getUser_nickname() {
                return user_nickname;
            }

            public void setUser_nickname(String user_nickname) {
                this.user_nickname = user_nickname;
            }

            public int getConfirm() {
                return confirm;
            }

            public void setConfirm(int confirm) {
                this.confirm = confirm;
            }

            public int getWeight() {
                return weight;
            }

            public void setWeight(int weight) {
                this.weight = weight;
            }

            public String getTid() {
                return tid;
            }

            public void setTid(String tid) {
                this.tid = tid;
            }

            public String getIntro() {
                return intro;
            }

            public void setIntro(String intro) {
                this.intro = intro;
            }

            public String getImg_url() {
                return img_url;
            }

            public void setImg_url(String img_url) {
                this.img_url = img_url;
            }

            public String getCover_url() {
                return cover_url;
            }

            public void setCover_url(String cover_url) {
                this.cover_url = cover_url;
            }

            public long getStart_time() {
                return start_time;
            }

            public void setStart_time(long start_time) {
                this.start_time = start_time;
            }

            public long getNow_time() {
                return now_time;
            }

            public void setNow_time(long now_time) {
                this.now_time = now_time;
            }

            public long getEnd_time() {
                return end_time;
            }

            public void setEnd_time(long end_time) {
                this.end_time = end_time;
            }

            public String getApp_url() {
                return app_url;
            }

            public void setApp_url(String app_url) {
                this.app_url = app_url;
            }

            public String getWeb_url() {
                return web_url;
            }

            public void setWeb_url(String web_url) {
                this.web_url = web_url;
            }

            public int getLive_id() {
                return live_id;
            }

            public void setLive_id(int live_id) {
                this.live_id = live_id;
            }

            public int getDirection() {
                return direction;
            }

            public void setDirection(int direction) {
                this.direction = direction;
            }

            public String getIs_host() {
                return is_host;
            }

            public void setIs_host(String is_host) {
                this.is_host = is_host;
            }

            public int getHad_video_host() {
                return had_video_host;
            }

            public void setHad_video_host(int had_video_host) {
                this.had_video_host = had_video_host;
            }

            public String getAnchor_accid() {
                return anchor_accid;
            }

            public void setAnchor_accid(String anchor_accid) {
                this.anchor_accid = anchor_accid;
            }

            public int getRealTotal_num() {
                return realTotal_num;
            }

            public void setRealTotal_num(int realTotal_num) {
                this.realTotal_num = realTotal_num;
            }

            public List<HostsBean> getHosts() {
                return hosts;
            }

            public void setHosts(List<HostsBean> hosts) {
                this.hosts = hosts;
            }

            public List<?> getSublive_info() {
                return sublive_info;
            }

            public void setSublive_info(List<?> sublive_info) {
                this.sublive_info = sublive_info;
            }

            public static class HostsBean {
                /**
                 * ursid : mencyz_94@163.com
                 * nickName : Sunny和小太阳
                 * userId : 2025303
                 * avatar : http://mobilepics.nosdn.127.net/TUaL582HwLF2WD503R12c5bp7mk0I6s0512791375
                 */

                private String ursid;
                private String nickName;
                private int userId;
                private String avatar;

                public String getUrsid() {
                    return ursid;
                }

                public void setUrsid(String ursid) {
                    this.ursid = ursid;
                }

                public String getNickName() {
                    return nickName;
                }

                public void setNickName(String nickName) {
                    this.nickName = nickName;
                }

                public int getUserId() {
                    return userId;
                }

                public void setUserId(int userId) {
                    this.userId = userId;
                }

                public String getAvatar() {
                    return avatar;
                }

                public void setAvatar(String avatar) {
                    this.avatar = avatar;
                }
            }
        }
    }
}
