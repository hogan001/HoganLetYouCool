package com.hogan.letyoucool.bean;

import java.util.List;

/**
 * 作者: 陈虎
 * 日期: 2016/5/30  16:14
 * 描述: 微信头条数据Bean
 */
public class WXDataBean {

    /**
     * channel : 热点
     * article : [{"title":"知道为什么韩国女组合那么多人喜欢了吧！","url":"http://www.3023.com/3/846548734.html","img":"http://mmbiz.qpic.cn/mmbiz/BHJpRXdB7IaVbdTe5DZYQnLJsO3ZFyXv2PM3DibZEqjyzuNnMf2BxWsHibibVI64tAxBUaGLWduBSueHEPGtMv0Gg/0?wx_fmt=gif","author":"邪恶动态图","time":1464416880},{"title":"什么鬼：库克说1670年的画中出现了iPhone","url":"http://www.3023.com/1/1674304.html","img":"http://mmbiz.qpic.cn/mmbiz/UayyZ2HEs3fTYtnIRcZEXDEjJxh8rEhXktDF39cZYuJyUlmMEQRKQn9XAANZ0bqpMezQHib5Kk82dg4A4RJDSgg/0?wx_fmt=jpeg","author":"威锋网","time":1464521640},{"title":"失去的东西回来了还要吗？","url":"http://www.3023.com/3/178555512.html","img":"http://mmbiz.qpic.cn/mmbiz/AmKPwTIjIFrr19KrgKGP3SF07933eoxV4S2mt7EbMtrT6xJ59ccZdvMRKq3OIzWJ8icZztyb1ibrs1F5R9icrYrFA/640?wx_fmt=jpeg","author":"微小说","time":1464444900},{"title":"她曾是TVB当家花旦，息影后回家相夫教女，如今为求子四处奔波","url":"http://www.3023.com/5/68828948.html","img":"http://mmbiz.qpic.cn/mmbiz/McicXTiaf4y4rS89Xl2ajqjIAfjFfhk8Hy4S9dtpX5eXyORMu84OlYSibQ9YVdHicm1nPKJr9A8rtF8coJia64poLtg/0?wx_fmt=jpeg","author":"鹏讯时代","time":1464434700},{"title":"[经济网脑洞] 轻松游欧洲之巴黎自我宣泄指南 Don't be (pee) shy!","url":"http://www.3023.com/3/005987682.html","img":"http://mmbiz.qpic.cn/mmbiz/Saic95eNqVxZchIES6J8icAjduDrWib6j2rQ149oN6erSwrGR84yiaXxrOj0Q4jZK8icOPj1a9tRMpgVmnQuwkShacw/0?wx_fmt=jpeg","author":"中国经济周刊","time":1464529800},{"title":"古人说：人生逃不过三个三。太精辟了！","url":"http://www.3023.com/3/731408453.html","img":"http://mmbiz.qpic.cn/mmbiz/J9qKTjhD8iaO19aia5rIcPxRPnVSIialemcXciafaTVLuBpXVmDibszAYvpWiafMaJ5ibtLFvHPYzbU8MN0aDNE79ia77A/640?wx_fmt=png","author":"健康情报站","time":1464572160},{"title":"发个笑话给爱打麻将的人，太搞笑了!","url":"http://www.3023.com/3/508641635.html","img":"http://mmbiz.qpic.cn/mmbiz/UmtfIJwcVjxp8PtYzef0Q1ricDiaia4iaf39bf1YHGyxU4u7cGd1XNIrurZQ4sMe6fwERIs3ojNAu5f2mZrXvDqxKg/0?wx_fmt=gif","author":"正爆","time":1464533940},{"title":"你以为他只能在\u201c极挑\u201d里碾压对手？","url":"http://www.3023.com/1/294920241.html","img":"http://mmbiz.qpic.cn/mmbiz/XQXib0VfsI5w1AGBWMdYuLLvynWF9O2nlnttdORMqg0EZeStqTo8nDricppyuHGiaqnujj5w6BXHAxQJLdIs0cMyw/0?wx_fmt=gif","author":"优酷","time":1464527280},{"title":"爆笑 | 美女孩子说话笑死你！","url":"http://www.3023.com/3/780897309.html","img":"http://vpic.video.qq.com/0/b0155g11lko.png","author":"校花也搞笑","time":1464444540},{"title":"她9岁被辱，14岁生子，吸毒被虐，如今却活成了身家亿万的女王！","url":"http://www.3023.com/4/126362660.html","img":"http://mmbiz.qpic.cn/mmbiz/sFiclmt4k8uCoebLARGcypPLJTGoBR9pcVcFWEpOVQor5LKzIjQibalSxMibmLZYmouP49ichlT5cqE1JRV3Rnibeicw/640?wx_fmt=jpeg","author":"八卦娱乐圈","time":1464519300},{"title":"善良的人总是快乐，感恩的人总是知足。","url":"http://www.3023.com/3/536635859.html","img":"http://mmbiz.qpic.cn/mmbiz/BTBlZDBhSfHp3INWlr7Cu2J46YW94jTzQLT4DtsicTKMyDt6q3SdYPaMLCcwPhicvuP4KFc63huxg10sib93e8MIQ/0?","author":"深夜读物","time":1464441600}]
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private String channel;
        /**
         * title : 知道为什么韩国女组合那么多人喜欢了吧！
         * url : http://www.3023.com/3/846548734.html
         * img : http://mmbiz.qpic.cn/mmbiz/BHJpRXdB7IaVbdTe5DZYQnLJsO3ZFyXv2PM3DibZEqjyzuNnMf2BxWsHibibVI64tAxBUaGLWduBSueHEPGtMv0Gg/0?wx_fmt=gif
         * author : 邪恶动态图
         * time : 1464416880
         */

        private List<ArticleBean> article;

        public String getChannel() {
            return channel;
        }

        public void setChannel(String channel) {
            this.channel = channel;
        }

        public List<ArticleBean> getArticle() {
            return article;
        }

        public void setArticle(List<ArticleBean> article) {
            this.article = article;
        }

        public static class ArticleBean {
            private String title;
            private String url;
            private String img;
            private String author;
            private int time;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public String getAuthor() {
                return author;
            }

            public void setAuthor(String author) {
                this.author = author;
            }

            public int getTime() {
                return time;
            }

            public void setTime(int time) {
                this.time = time;
            }
        }
    }
}
