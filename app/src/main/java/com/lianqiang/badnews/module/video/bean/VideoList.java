package com.lianqiang.badnews.module.video.bean;

/**
 * TODO 视频列表
 * Created by lianqiang on 2017/5/17.
 */

public class VideoList {

    /**
     * sizeSHD : 18600
     * replyCount : 0
     * videosource : 新媒体
     * mp4Hd_url : http://flv2.bn.netease.com/videolib3/1705/17/wfSsZ7403/HD/wfSsZ7403-mobile.mp4
     * title : 《欢乐颂2》杨紫想请应勤吃饭
     * cover : http://vimg2.ws.126.net/image/snapshot/2017/5/9/8/VCJNBM998.jpg
     * videoTopic : {"alias":"一起分享最新的影视资源","tname":"嗨翻全场","ename":"T1492424091274","tid":"T1492424091274","topic_icons":"http://dingyue.nosdn.127.net/LeuOW5=hgFQo3q7XcPZygAQcUwSf0J9FSAjJa99=CdNt01493265521143.jpg"}
     * description :
     * replyid : CJN7BBBC050835RB
     * length : 124
     * m3u8_url : http://flv2.bn.netease.com/videolib3/1705/17/wfSsZ7403/SD/movie_index.m3u8
     * vid : VCJN7BBBC
     * topicName : 观观
     * votecount : 0
     * topicImg : http://vimg2.ws.126.net/image/snapshot/2017/4/7/S/VCHAO0N7S.jpg
     * topicDesc : 分享最新影视资源动态 及时告知广大网友各大影视上映时间 抢先了解影视详情
     * topicSid : VCHAO0N7F
     * replyBoard : video_bbs
     * playCount : 0
     * sectiontitle :
     * mp4_url : http://flv2.bn.netease.com/videolib3/1705/17/wfSsZ7403/SD/wfSsZ7403-mobile.mp4
     * playersize : 1
     * sizeSD : 9300
     * sizeHD : 12400
     * m3u8Hd_url : http://flv2.bn.netease.com/videolib3/1705/17/wfSsZ7403/HD/movie_index.m3u8
     * ptime : 2017-05-17 13:03:39
     */

    private int sizeSHD;
    private int replyCount;
    private String videosource;
    private String mp4Hd_url;
    private String title;
    private String cover;
    private VideoTopicBean videoTopic;
    private String description;
    private String replyid;
    private int length;
    private String m3u8_url;
    private String vid;
    private String topicName;
    private int votecount;
    private String topicImg;
    private String topicDesc;
    private String topicSid;
    private String replyBoard;
    private int playCount;
    private String sectiontitle;
    private String mp4_url;
    private int playersize;
    private int sizeSD;
    private int sizeHD;
    private String m3u8Hd_url;
    private String ptime;

    public int getSizeSHD() {
        return sizeSHD;
    }

    public void setSizeSHD(int sizeSHD) {
        this.sizeSHD = sizeSHD;
    }

    public int getReplyCount() {
        return replyCount;
    }

    public void setReplyCount(int replyCount) {
        this.replyCount = replyCount;
    }

    public String getVideosource() {
        return videosource;
    }

    public void setVideosource(String videosource) {
        this.videosource = videosource;
    }

    public String getMp4Hd_url() {
        return mp4Hd_url;
    }

    public void setMp4Hd_url(String mp4Hd_url) {
        this.mp4Hd_url = mp4Hd_url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public VideoTopicBean getVideoTopic() {
        return videoTopic;
    }

    public void setVideoTopic(VideoTopicBean videoTopic) {
        this.videoTopic = videoTopic;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getReplyid() {
        return replyid;
    }

    public void setReplyid(String replyid) {
        this.replyid = replyid;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getM3u8_url() {
        return m3u8_url;
    }

    public void setM3u8_url(String m3u8_url) {
        this.m3u8_url = m3u8_url;
    }

    public String getVid() {
        return vid;
    }

    public void setVid(String vid) {
        this.vid = vid;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public int getVotecount() {
        return votecount;
    }

    public void setVotecount(int votecount) {
        this.votecount = votecount;
    }

    public String getTopicImg() {
        return topicImg;
    }

    public void setTopicImg(String topicImg) {
        this.topicImg = topicImg;
    }

    public String getTopicDesc() {
        return topicDesc;
    }

    public void setTopicDesc(String topicDesc) {
        this.topicDesc = topicDesc;
    }

    public String getTopicSid() {
        return topicSid;
    }

    public void setTopicSid(String topicSid) {
        this.topicSid = topicSid;
    }

    public String getReplyBoard() {
        return replyBoard;
    }

    public void setReplyBoard(String replyBoard) {
        this.replyBoard = replyBoard;
    }

    public int getPlayCount() {
        return playCount;
    }

    public void setPlayCount(int playCount) {
        this.playCount = playCount;
    }

    public String getSectiontitle() {
        return sectiontitle;
    }

    public void setSectiontitle(String sectiontitle) {
        this.sectiontitle = sectiontitle;
    }

    public String getMp4_url() {
        return mp4_url;
    }

    public void setMp4_url(String mp4_url) {
        this.mp4_url = mp4_url;
    }

    public int getPlayersize() {
        return playersize;
    }

    public void setPlayersize(int playersize) {
        this.playersize = playersize;
    }

    public int getSizeSD() {
        return sizeSD;
    }

    public void setSizeSD(int sizeSD) {
        this.sizeSD = sizeSD;
    }

    public int getSizeHD() {
        return sizeHD;
    }

    public void setSizeHD(int sizeHD) {
        this.sizeHD = sizeHD;
    }

    public String getM3u8Hd_url() {
        return m3u8Hd_url;
    }

    public void setM3u8Hd_url(String m3u8Hd_url) {
        this.m3u8Hd_url = m3u8Hd_url;
    }

    public String getPtime() {
        return ptime;
    }

    public void setPtime(String ptime) {
        this.ptime = ptime;
    }

    public static class VideoTopicBean {
        /**
         * alias : 一起分享最新的影视资源
         * tname : 嗨翻全场
         * ename : T1492424091274
         * tid : T1492424091274
         * topic_icons : http://dingyue.nosdn.127.net/LeuOW5=hgFQo3q7XcPZygAQcUwSf0J9FSAjJa99=CdNt01493265521143.jpg
         */

        private String alias;
        private String tname;
        private String ename;
        private String tid;
        private String topic_icons;

        public String getAlias() {
            return alias;
        }

        public void setAlias(String alias) {
            this.alias = alias;
        }

        public String getTname() {
            return tname;
        }

        public void setTname(String tname) {
            this.tname = tname;
        }

        public String getEname() {
            return ename;
        }

        public void setEname(String ename) {
            this.ename = ename;
        }

        public String getTid() {
            return tid;
        }

        public void setTid(String tid) {
            this.tid = tid;
        }

        public String getTopic_icons() {
            return topic_icons;
        }

        public void setTopic_icons(String topic_icons) {
            this.topic_icons = topic_icons;
        }
    }
}
