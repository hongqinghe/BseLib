package middlem.person.baselib;

/**
 * Created by maidong on 17-8-16.
 */

import java.io.Serializable;
import static android.text.TextUtils.isEmpty;
import static org.apache.commons.lang3.StringUtils.isBlank;

/***********************************************
 * <P>
 * <P> Author: maidong
 * <P> Date: 2017-08-16 上午10:56
 * <P> Copyright  2008 二维火科技
 ***********************************************/

public class TDFHelpItem implements Serializable {
    /**
     * <code>[serialVersionUID]</code>.
     */
    private static final long serialVersionUID = 1L;
    /**
     * <code>标题内容</code>
     */
    private String title;
    /**
     * <code>文本内容</code>
     */
    private String content;
    /**
     * <code>是否为标题</code>
     */
    private boolean isTitle;


    public TDFHelpItem(String title, String content) {
        this.title = title;
        this.content = ToDBC(content);
    }

    public TDFHelpItem(String str, boolean isTitle) {
        this.isTitle = isTitle;
        if (isTitle) {
            this.title = str;
        } else {
            this.content = ToDBC(isStrEmpty(str) ? "\t" : str);
        }
    }

    /**
     * 判断字符串是否为空
     *
     * @param str
     * @return boolean
     */
    public static boolean isStrEmpty(String str) {
        return isBlank(str) && isEmpty(str);
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
    public String getContent() {
        return content;
    }


    /**
     * 得到文本内容
     *
     * @return
     */
    public boolean isTitle(){
        return this.isTitle;
    }

    // 将textview中的字符全角化。即将所有的数字、字母及标点全部转为全角字符，使它们与汉字同占两个字节，这样就可以避免由于占位导致的排版混乱问题了
    private String ToDBC(String input) {
        if (input.equals("·")) {
            return input;
        }
        char[] c = input.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (c[i] == 12288) {
                c[i] = (char) 32;
                continue;
            }
            if (c[i] > 65280 && c[i] < 65375)
                c[i] = (char) (c[i] - 65248);
        }
        return new String(c);
    }
}
