package com.lianqiang.badnews.module.news.bean;

import java.io.Serializable;
import java.util.List;

/**
 * TODO 新闻列表
 * Created by lianqiang on 2017/5/17.
 */

public class NewsList implements Serializable{

    /**
     * postid : PHOT24QS7000100A
     * hasCover : false
     * hasHead : 1
     * replyCount : 10763
     * hasImg : 1
     * digest :
     * hasIcon : false
     * docid : 9IG74V5H00963VRO_CKKQKS0OcaoruiupdateDoc
     * title : 辽宁丹东600吨单体"玉石王"深锁山中
     * order : 1
     * priority : 354
     * lmodify : 2017-05-17 13:22:33
     * boardid : photoview_bbs
     * ads : [{"title":"郑州一道路被称\"天屎之路\" 鸟粪如雨","skipID":"00AP0001|2255741","tag":"photoset","imgsrc":"http://cms-bucket.nosdn.127.net/347e9ecbd0c64324a2177d5cda5bb7d220170517103202.jpeg","subtitle":"","skipType":"photoset","url":"00AP0001|2255741"}]
     * photosetID : 00AP0001|2255751
     * imgsum : 4
     * topic_background : http://img2.cache.netease.com/m/newsapp/reading/cover1/C1348646712614.jpg
     * template : normal1
     * votecount : 9912
     * skipID : 00AP0001|2255751
     * alias : Top News
     * skipType : photoset
     * cid : C1348646712614
     * hasAD : 1
     * imgextra : [{"imgsrc":"http://cms-bucket.nosdn.127.net/17e8d4d9bc504bc2817cc6ab1f21bdb820170517111143.jpeg"},{"imgsrc":"http://cms-bucket.nosdn.127.net/dc64c503876c4f0f9ae81c537445ef0620170517111143.jpeg"}]
     * source : 中新网
     * ename : androidnews
     * tname : 头条
     * imgsrc : http://cms-bucket.nosdn.127.net/04a1773efc6a43eb8ce42f12e137069020170517111146.png
     * ptime : 2017-05-17 11:12:12
     */

    private String postid;
    private boolean hasCover;
    private int hasHead;
    private int replyCount;
    private int hasImg;
    private String digest;
    private boolean hasIcon;
    private String docid;
    private String title;
    private int order;
    private int priority;
    private String lmodify;
    private String boardid;
    private String photosetID;
    private int imgsum;
    private String topic_background;
    private String template;
    private int votecount;
    private String skipID;
    private String alias;
    private String skipType;
    private String cid;
    private int hasAD;
    private String source;
    private String ename;
    private String tname;
    private String imgsrc;
    private String ptime;
    private List<AdsBean> ads;
    private List<ImgextraBean> imgextra;

    public String getPostid() {
        return postid;
    }

    public void setPostid(String postid) {
        this.postid = postid;
    }

    public boolean isHasCover() {
        return hasCover;
    }

    public void setHasCover(boolean hasCover) {
        this.hasCover = hasCover;
    }

    public int getHasHead() {
        return hasHead;
    }

    public void setHasHead(int hasHead) {
        this.hasHead = hasHead;
    }

    public int getReplyCount() {
        return replyCount;
    }

    public void setReplyCount(int replyCount) {
        this.replyCount = replyCount;
    }

    public int getHasImg() {
        return hasImg;
    }

    public void setHasImg(int hasImg) {
        this.hasImg = hasImg;
    }

    public String getDigest() {
        return digest;
    }

    public void setDigest(String digest) {
        this.digest = digest;
    }

    public boolean isHasIcon() {
        return hasIcon;
    }

    public void setHasIcon(boolean hasIcon) {
        this.hasIcon = hasIcon;
    }

    public String getDocid() {
        return docid;
    }

    public void setDocid(String docid) {
        this.docid = docid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getLmodify() {
        return lmodify;
    }

    public void setLmodify(String lmodify) {
        this.lmodify = lmodify;
    }

    public String getBoardid() {
        return boardid;
    }

    public void setBoardid(String boardid) {
        this.boardid = boardid;
    }

    public String getPhotosetID() {
        return photosetID;
    }

    public void setPhotosetID(String photosetID) {
        this.photosetID = photosetID;
    }

    public int getImgsum() {
        return imgsum;
    }

    public void setImgsum(int imgsum) {
        this.imgsum = imgsum;
    }

    public String getTopic_background() {
        return topic_background;
    }

    public void setTopic_background(String topic_background) {
        this.topic_background = topic_background;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public int getVotecount() {
        return votecount;
    }

    public void setVotecount(int votecount) {
        this.votecount = votecount;
    }

    public String getSkipID() {
        return skipID;
    }

    public void setSkipID(String skipID) {
        this.skipID = skipID;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getSkipType() {
        return skipType;
    }

    public void setSkipType(String skipType) {
        this.skipType = skipType;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public int getHasAD() {
        return hasAD;
    }

    public void setHasAD(int hasAD) {
        this.hasAD = hasAD;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getImgsrc() {
        return imgsrc;
    }

    public void setImgsrc(String imgsrc) {
        this.imgsrc = imgsrc;
    }

    public String getPtime() {
        return ptime;
    }

    public void setPtime(String ptime) {
        this.ptime = ptime;
    }

    public List<AdsBean> getAds() {
        return ads;
    }

    public void setAds(List<AdsBean> ads) {
        this.ads = ads;
    }

    public List<ImgextraBean> getImgextra() {
        return imgextra;
    }

    public void setImgextra(List<ImgextraBean> imgextra) {
        this.imgextra = imgextra;
    }

    public static class AdsBean {
        /**
         * title : 郑州一道路被称"天屎之路" 鸟粪如雨
         * skipID : 00AP0001|2255741
         * tag : photoset
         * imgsrc : http://cms-bucket.nosdn.127.net/347e9ecbd0c64324a2177d5cda5bb7d220170517103202.jpeg
         * subtitle :
         * skipType : photoset
         * url : 00AP0001|2255741
         */

        private String title;
        private String skipID;
        private String tag;
        private String imgsrc;
        private String subtitle;
        private String skipType;
        private String url;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getSkipID() {
            return skipID;
        }

        public void setSkipID(String skipID) {
            this.skipID = skipID;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getImgsrc() {
            return imgsrc;
        }

        public void setImgsrc(String imgsrc) {
            this.imgsrc = imgsrc;
        }

        public String getSubtitle() {
            return subtitle;
        }

        public void setSubtitle(String subtitle) {
            this.subtitle = subtitle;
        }

        public String getSkipType() {
            return skipType;
        }

        public void setSkipType(String skipType) {
            this.skipType = skipType;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    public static class ImgextraBean {
        /**
         * imgsrc : http://cms-bucket.nosdn.127.net/17e8d4d9bc504bc2817cc6ab1f21bdb820170517111143.jpeg
         */

        private String imgsrc;

        public String getImgsrc() {
            return imgsrc;
        }

        public void setImgsrc(String imgsrc) {
            this.imgsrc = imgsrc;
        }
    }
}
