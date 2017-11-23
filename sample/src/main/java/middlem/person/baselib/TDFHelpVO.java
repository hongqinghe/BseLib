package middlem.person.baselib;

import java.io.Serializable;

/***********************************************
 * <P>
 * <P> Author: maidong
 * <P> Date: 2017-08-16 上午10:56
 * <P> Copyright  2008 二维火科技
 ***********************************************/

public class TDFHelpVO implements Serializable {
    /**
     * <code>[serialVersionUID]</code>.
     */
    private static final long serialVersionUID = 1L;
    /**
     * <code>标题内容</code>
     */
    private final String title;
    /**
     * <code>文本内容</code>
     */
    private final TDFHelpItem[] helpItems;

    /**
     * <code>视频播放路径</code>
     */
    private final String videoUrl;

    public TDFHelpVO(String title, TDFHelpItem[] helpItems) {
        this.title = title;
        this.helpItems = helpItems;
        this.videoUrl=null;
    }

    public TDFHelpVO(String title, TDFHelpItem[] helpItems, String videoUrl) {
        this.title = title;
        this.helpItems = helpItems;
        this.videoUrl=videoUrl;
    }

    /**
     * 得到标题信息.
     *
     * @return
     */
    public String getTitle() {
        return title;
    }

    /**
     * 得到文本内容
     *
     * @return
     */
    public TDFHelpItem[] getHelpItems() {
        return helpItems;
    }


    /**
     * 视频播放路径.
     *
     * @return
     */
    public String getVideoUrl() {
        return videoUrl;
    }
}
