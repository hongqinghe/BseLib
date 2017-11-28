package middlem.person.baselib;

import android.content.Context;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;


/**
 * @author: MaBao
 * @time: 2017-10-24 17:30
 */
public class HelpUtils {
    public static TDFHelpVO getHelpVo(String key){
        TDFHelpVO helpVo = new TDFHelpVO(getHelpName(key), getHelpItems(key));
        return helpVo;
    }

    private static String getHelpName(String key) {
        String name = "";
        Element item = doParse(key);
        if (item != null) {
            name = item.getAttribute("name");
        }

        return name;
    }

    private static TDFHelpItem[] getHelpItems(String key) {
        TDFHelpItem[] helpItems = null;
        Element item = doParse(key);
        if (item != null) {
            String[] value = item.getTextContent().trim().split("\n");
            helpItems = new TDFHelpItem[value.length];
            for (int i = 0; i < value.length; i++) {
                TDFHelpItem helpItem = null;
//                LogUtils.d("Yokey", "value[" + i + "]=" + value[i]);
                if (value[i].contains("<b>") && value[i].contains("</b>")) {
                    helpItem = new TDFHelpItem(getInsideString(value[i], "<b>", "</b>"), true);
                } else {
                    helpItem = new TDFHelpItem(value[i], false);
                }
                helpItems[i] = helpItem;
            }
        }

        return helpItems;
    }

    private static Element doParse(String key) {
        Element element = null;
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            Context context = null;
            InputStream is =context. getAssets().open("SupplyHelpFiles.xml");
            DocumentBuilder builder=factory.newDocumentBuilder();
            Document document = builder.parse(is);              //得到代表整个xml的Document对象
            Element root = document.getDocumentElement();       //得到 "根节点"
            NodeList items = root.getElementsByTagName(key);    //获取根节点的所有items的节点
            element = (Element) items.item(0);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }

        return element;
    }

    private static String getInsideString(String str, String strStart, String strEnd) {
        if (str.indexOf(strStart) < 0) {
            return "";
        }
        if (str.indexOf(strEnd) < 0) {
            return "";
        }

        return str.substring(str.indexOf(strStart) + strStart.length(), str.indexOf(strEnd));
    }
}
