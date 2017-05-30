package com.lianqiang.badnews.module.news.bean;

import java.util.List;

/**
 * TODO 新闻详情
 * Created by lianqiang on 2017/5/17.
 */

public class NewsDetail {

    /**
     * body : 今天（17日）上午7时30分左右，广州市海珠区桥南新街一7岁男孩上学途中被砍，已送往医院救治。据目击者透露，男孩右手腕被砍，另有餐馆老板说，行凶者把断肢带走了。
     * spinfo : [{"ref":"<!--SPINFO#0-->","spcontent":"<br/><a href=\"http://news.163.com/17/0511/20/CK6C3EKI0001875O.html\">男子性侵10名儿童包括亲儿子 受害者父母替其求情<\/a><br/>近日，据《新西兰先驱报》报道，新西兰法官在给一名性侵者量刑时。","sptype":"推荐"}]
     * ydbaike : []
     * replyCount : 16183
     * link : []
     * img : [{"ref":"<!--IMG#0-->","pixel":"640*426","alt":"","src":"http://cms-bucket.nosdn.127.net/b14b0d0b64e149cdb81664942cd9fe7120170517120232.jpeg"},{"ref":"<!--IMG#1-->","pixel":"640*426","alt":"事发现场","src":"http://cms-bucket.nosdn.127.net/580937652ac64d8386df1339e58308a320170517120233.jpeg"},{"ref":"<!--IMG#2-->","pixel":"640*426","alt":"警方仍在现场寻找断肢。南都记者 梁炜培 摄","src":"http://cms-bucket.nosdn.127.net/f3ccdad395ea45f9a3d37c284fff1a9c20170517120234.jpeg"},{"ref":"<!--IMG#3-->","pixel":"600*447","alt":"","src":"http://cms-bucket.nosdn.127.net/cd4b96e5c4604f01b3a8316c25c13c5b20170517120234.jpeg"}]
     * votes : []
     * shareLink : https://c.m.163.com/news/a/CKKTH0NF0001899N.html?spss=newsapp&spsw=1
     * digest :
     * topiclist_news : [{"hasCover":false,"subnum":"0","alias":"yaowentuisong","tname":"要闻推送","ename":"pushliebiao","tid":"T1350294190231","cid":"C1350294152567"},{"hasCover":false,"subnum":"3.2万","alias":"Top News","tname":"头条","ename":"androidnews","tid":"T1348647909107","cid":"C1348646712614"},{"hasCover":false,"subnum":"超过1000万","alias":"Top News","tname":"头条","ename":"iosnews","tid":"T1348647853363","cid":"C1348646712614"},{"hasCover":false,"subnum":"10.9万","alias":"yaowenspecial","tname":"要闻","ename":"yaowenspecial","tid":"T1467284926140","cid":"C1348647991705"},{"hasCover":false,"subnum":"0","alias":"todayNews2","tname":"今日要闻","ename":"todayNews2","tid":"T1429173762551","cid":"C1350294152567"},{"hasCover":false,"subnum":"0","alias":"newsToday1","tname":"今日要闻","ename":"newsToday1","tid":"T1429173683626","cid":"C1350294152567"},{"hasCover":false,"subnum":"100","alias":"Region","tname":"社会","ename":"shehui","tid":"T1348648037603","cid":"C1348647991705"},{"hasCover":false,"subnum":"0","alias":"androidpush","tname":"push列表（android）","ename":"androidpush","tid":"T1371543208049","cid":"C1350294152567"}]
     * dkeys : 医院,断肢,上学路上,警方
     * ec : 徐萌_MN7485
     * topiclist : []
     * docid : CKKTH0NF0001899N
     * sourceinfo : {"alias":"换一种方式，南都在现场。","tname":"南方都市报","ename":"nfdsb","tid":"T1374537849029","topic_icons":"http://dingyue.nosdn.127.net/K3PzMyZWftXEeU8b5D5L8lx1UfiussvHdNt5k4HpTDm3J1490322827003.jpg"}
     * picnews : true
     * title : 7岁男孩上学路上被推倒砍断手 行凶者将断肢带走
     * tid :
     * template : manual
     * threadVote : 453
     * threadAgainst : 1
     * boboList : []
     * category : 社会
     * replyBoard : news2_bbs
     * source : 南方都市报
     * hasNext : false
     * voicecomment : off
     * relative_sys : [{"id":"CK3QU0FO04178D6J","title":"就刚刚！广东惠州街头上演警匪大战 现场开了枪","source":"惠州大件事","imgsrc":"http://cms-bucket.nosdn.127.net/09ef5e532d7742e49b27ec3ca94c82f120170510204947.png","docID":"CK3QU0FO04178D6J","from":"HZ","type":"doc","ptime":"2017-05-10 20:50:06","href":""},{"id":"CK5A8ME50525CCLU","title":"东莞：男子酒驾遇车祸 口角之争引发血案","source":"东莞广播电视台","imgsrc":"http://dingyue.nosdn.127.net/eOsolLKjjPaoRXVqzZJ0aDbMrxryDiwi6tiSp78CfNBMA1494470223713.jpg","docID":"CK5A8ME50525CCLU","from":"HZ","type":"doc","ptime":"2017-05-11 10:37:22","href":""},{"id":"CKJAVBAG9001VBAH","title":"家长档口忙生意 3岁男童1公里外溺水身亡","source":"南都自媒体平台","imgsrc":"http://crawl.nosdn.127.net/nbotreplaceimg/bc4e413e0404ea8b386b4334d5ba150d/ebd20b14047fc50800e11eb4d423b0a3.jpg","docID":"CKJAVBAG9001VBAH","from":"HZ","type":"doc","ptime":"2017-05-16 20:59:00","href":""}]
     * book : []
     * ptime : 2017-05-17 12:02:32
     */

    private String body;
    private int replyCount;
    private String shareLink;
    private String digest;
    private String dkeys;
    private String ec;
    private String docid;
    private SourceinfoBean sourceinfo;
    private boolean picnews;
    private String title;
    private String tid;
    private String template;
    private int threadVote;
    private int threadAgainst;
    private String category;
    private String replyBoard;
    private String source;
    private boolean hasNext;
    private String voicecomment;
    private String ptime;
    private List<SpinfoBean> spinfo;
    private List<?> ydbaike;
    private List<?> link;
    private List<ImgBean> img;
    private List<?> votes;
    private List<TopiclistNewsBean> topiclist_news;
    private List<?> topiclist;
    private List<?> boboList;
    private List<RelativeSysBean> relative_sys;
    private List<?> book;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getReplyCount() {
        return replyCount;
    }

    public void setReplyCount(int replyCount) {
        this.replyCount = replyCount;
    }

    public String getShareLink() {
        return shareLink;
    }

    public void setShareLink(String shareLink) {
        this.shareLink = shareLink;
    }

    public String getDigest() {
        return digest;
    }

    public void setDigest(String digest) {
        this.digest = digest;
    }

    public String getDkeys() {
        return dkeys;
    }

    public void setDkeys(String dkeys) {
        this.dkeys = dkeys;
    }

    public String getEc() {
        return ec;
    }

    public void setEc(String ec) {
        this.ec = ec;
    }

    public String getDocid() {
        return docid;
    }

    public void setDocid(String docid) {
        this.docid = docid;
    }

    public SourceinfoBean getSourceinfo() {
        return sourceinfo;
    }

    public void setSourceinfo(SourceinfoBean sourceinfo) {
        this.sourceinfo = sourceinfo;
    }

    public boolean isPicnews() {
        return picnews;
    }

    public void setPicnews(boolean picnews) {
        this.picnews = picnews;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public int getThreadVote() {
        return threadVote;
    }

    public void setThreadVote(int threadVote) {
        this.threadVote = threadVote;
    }

    public int getThreadAgainst() {
        return threadAgainst;
    }

    public void setThreadAgainst(int threadAgainst) {
        this.threadAgainst = threadAgainst;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getReplyBoard() {
        return replyBoard;
    }

    public void setReplyBoard(String replyBoard) {
        this.replyBoard = replyBoard;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public boolean isHasNext() {
        return hasNext;
    }

    public void setHasNext(boolean hasNext) {
        this.hasNext = hasNext;
    }

    public String getVoicecomment() {
        return voicecomment;
    }

    public void setVoicecomment(String voicecomment) {
        this.voicecomment = voicecomment;
    }

    public String getPtime() {
        return ptime;
    }

    public void setPtime(String ptime) {
        this.ptime = ptime;
    }

    public List<SpinfoBean> getSpinfo() {
        return spinfo;
    }

    public void setSpinfo(List<SpinfoBean> spinfo) {
        this.spinfo = spinfo;
    }

    public List<?> getYdbaike() {
        return ydbaike;
    }

    public void setYdbaike(List<?> ydbaike) {
        this.ydbaike = ydbaike;
    }

    public List<?> getLink() {
        return link;
    }

    public void setLink(List<?> link) {
        this.link = link;
    }

    public List<ImgBean> getImg() {
        return img;
    }

    public void setImg(List<ImgBean> img) {
        this.img = img;
    }

    public List<?> getVotes() {
        return votes;
    }

    public void setVotes(List<?> votes) {
        this.votes = votes;
    }

    public List<TopiclistNewsBean> getTopiclist_news() {
        return topiclist_news;
    }

    public void setTopiclist_news(List<TopiclistNewsBean> topiclist_news) {
        this.topiclist_news = topiclist_news;
    }

    public List<?> getTopiclist() {
        return topiclist;
    }

    public void setTopiclist(List<?> topiclist) {
        this.topiclist = topiclist;
    }

    public List<?> getBoboList() {
        return boboList;
    }

    public void setBoboList(List<?> boboList) {
        this.boboList = boboList;
    }

    public List<RelativeSysBean> getRelative_sys() {
        return relative_sys;
    }

    public void setRelative_sys(List<RelativeSysBean> relative_sys) {
        this.relative_sys = relative_sys;
    }

    public List<?> getBook() {
        return book;
    }

    public void setBook(List<?> book) {
        this.book = book;
    }

    public static class SourceinfoBean {
        /**
         * alias : 换一种方式，南都在现场。
         * tname : 南方都市报
         * ename : nfdsb
         * tid : T1374537849029
         * topic_icons : http://dingyue.nosdn.127.net/K3PzMyZWftXEeU8b5D5L8lx1UfiussvHdNt5k4HpTDm3J1490322827003.jpg
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

    public static class SpinfoBean {
        /**
         * ref : <!--SPINFO#0-->
         * spcontent : <br/><a href="http://news.163.com/17/0511/20/CK6C3EKI0001875O.html">男子性侵10名儿童包括亲儿子 受害者父母替其求情</a><br/>近日，据《新西兰先驱报》报道，新西兰法官在给一名性侵者量刑时。
         * sptype : 推荐
         */

        private String ref;
        private String spcontent;
        private String sptype;

        public String getRef() {
            return ref;
        }

        public void setRef(String ref) {
            this.ref = ref;
        }

        public String getSpcontent() {
            return spcontent;
        }

        public void setSpcontent(String spcontent) {
            this.spcontent = spcontent;
        }

        public String getSptype() {
            return sptype;
        }

        public void setSptype(String sptype) {
            this.sptype = sptype;
        }
    }

    public static class ImgBean {
        /**
         * ref : <!--IMG#0-->
         * pixel : 640*426
         * alt :
         * src : http://cms-bucket.nosdn.127.net/b14b0d0b64e149cdb81664942cd9fe7120170517120232.jpeg
         */

        private String ref;
        private String pixel;
        private String alt;
        private String src;

        public String getRef() {
            return ref;
        }

        public void setRef(String ref) {
            this.ref = ref;
        }

        public String getPixel() {
            return pixel;
        }

        public void setPixel(String pixel) {
            this.pixel = pixel;
        }

        public String getAlt() {
            return alt;
        }

        public void setAlt(String alt) {
            this.alt = alt;
        }

        public String getSrc() {
            return src;
        }

        public void setSrc(String src) {
            this.src = src;
        }
    }

    public static class TopiclistNewsBean {
        /**
         * hasCover : false
         * subnum : 0
         * alias : yaowentuisong
         * tname : 要闻推送
         * ename : pushliebiao
         * tid : T1350294190231
         * cid : C1350294152567
         */

        private boolean hasCover;
        private String subnum;
        private String alias;
        private String tname;
        private String ename;
        private String tid;
        private String cid;

        public boolean isHasCover() {
            return hasCover;
        }

        public void setHasCover(boolean hasCover) {
            this.hasCover = hasCover;
        }

        public String getSubnum() {
            return subnum;
        }

        public void setSubnum(String subnum) {
            this.subnum = subnum;
        }

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

        public String getCid() {
            return cid;
        }

        public void setCid(String cid) {
            this.cid = cid;
        }
    }

    public static class RelativeSysBean {
        /**
         * id : CK3QU0FO04178D6J
         * title : 就刚刚！广东惠州街头上演警匪大战 现场开了枪
         * source : 惠州大件事
         * imgsrc : http://cms-bucket.nosdn.127.net/09ef5e532d7742e49b27ec3ca94c82f120170510204947.png
         * docID : CK3QU0FO04178D6J
         * from : HZ
         * type : doc
         * ptime : 2017-05-10 20:50:06
         * href :
         */

        private String id;
        private String title;
        private String source;
        private String imgsrc;
        private String docID;
        private String from;
        private String type;
        private String ptime;
        private String href;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getImgsrc() {
            return imgsrc;
        }

        public void setImgsrc(String imgsrc) {
            this.imgsrc = imgsrc;
        }

        public String getDocID() {
            return docID;
        }

        public void setDocID(String docID) {
            this.docID = docID;
        }

        public String getFrom() {
            return from;
        }

        public void setFrom(String from) {
            this.from = from;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getPtime() {
            return ptime;
        }

        public void setPtime(String ptime) {
            this.ptime = ptime;
        }

        public String getHref() {
            return href;
        }

        public void setHref(String href) {
            this.href = href;
        }
    }
}
