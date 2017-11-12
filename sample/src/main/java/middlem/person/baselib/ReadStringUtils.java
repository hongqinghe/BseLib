package middlem.person.baselib;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

/***********************************************
 * <P> desc:
 * <P> Author: gongtong
 * <P> Date: 2017/11/9 10:17
 ***********************************************/

public class ReadStringUtils {
    /**
     * format 类型
     */
    private static final int TYPE_FORMAT = 0x1;
    /**
     * format 类型
     */
    private static final int TYPE_NO_FORMAT = 0x3;
    /**
     * 相同字符串
     */
    private static final int TYPE_SAME = 0x2;
    /**
     * android 源文件集合
     */
    private static Map<String, String> androidList;
    /**
     * ios源文件
     */
    private static Map<String, String> iosList;
    /**
     * 暂存文件集合
     */
    private static Map<String, String> tempList;
    /**
     * 比较后的存在相同文件的集合
     */
    private static Map<String, String> androidPareList;
    /**
     * 字符串中带format的集合
     */
    private static Map<String, String> formatList;
    /**
     * 不带format的集合
     */
    private static Map<String, String> noFormatList;
    /**
     * 相同String文件且不带format的文件集合
     */
    private static final String FILE_SAME_PATH = "/Users/hehongqing/Android/middlem/BaseLib/sample/src/main/assets/androidStrings.xml";
    /**
     * android String文件路径(源文件)
     */
    private static final String FILE_ANDROID_SOURCE_PATH = "/Users/hehongqing/Android/middlem/BaseLib/sample/src/main/assets/strings.xml";
    /**
     * ios String文件路径*（源文件）
     */
    private static final String FILE_IOS_SOURCE_PATH = "/Users/hehongqing/Android/middlem/BaseLib/sample/src/main/assets/ios.txt";
    /**
     * 两端不相同的String
     */
    private static final String FILE_COMPARE_PATH = "/Users/hehongqing/Android/middlem/BaseLib/sample/src/main/assets/compare.txt";
    /**
     * 最终生成Ios.txt格式的路径(不带format的String)
     */
    private static final String FILE_IOS_NO_FORMAT_TEXT_PATH = "/Users/hehongqing/Android/middlem/BaseLib/sample/src/main/assets/iosNoFormatString.txt";
    /**
     * 最终生成Ios.txt格式的路径(带format的String)
     */
    private static final String FILE_IOS_FORMAT_TEXT_PATH = "/Users/hehongqing/Android/middlem/BaseLib/sample/src/main/assets/iosFormatString.txt";
    /**
     * android端的format string 文件路径
     */
    private static final String FILE_FORMAT_PATH = "/Users/hehongqing/Android/middlem/BaseLib/sample/src/main/assets/androidFormatString.xml";
    /**
     * android  no format String 文件路径
     */
    private static final String FILE_ANDROID_NO_FORMAT_PATH = "/Users/hehongqing/Android/middlem/BaseLib/sample/src/main/assets/androidNoFormat.xml";

    public static void main(String[] args) {
        androidList = new LinkedHashMap<>();
        iosList = new LinkedHashMap<>();
        tempList = new LinkedHashMap<>();
        androidPareList = new LinkedHashMap<>();
        formatList = new LinkedHashMap<>();
        noFormatList = new LinkedHashMap<>();
        getString();
    }

    public static void getString() {

        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = documentBuilderFactory.newDocumentBuilder();
            File file = new File(FILE_ANDROID_SOURCE_PATH);
            Document document = builder.parse(file);
            Element root = document.getDocumentElement();
            NodeList childNodes = root.getChildNodes();
            System.out.println("开始读取android源文件");
            for (int j = 0; j < childNodes.getLength(); j++) {
                Node subNode = childNodes.item(j);
                if ("string".equals(subNode.getNodeName())) {
                    // key
                    String key = subNode.getAttributes().getNamedItem("name")
                            .getNodeValue();
                    // value
                    String value = subNode.getTextContent();
                    if (value.contains("%")) {
                        System.out.println("android_format的文件"+1);
                        formatList.put(key, value);
                    } else {
                        noFormatList.put(key, value);
                        System.out.println("android_no_format的文件"+1);
                    }
                    androidList.put(key, value);
                }
            }
            System.out.println("读取android源文件成功，大小为："+androidList.size());
            System.out.println("读取android源文件成功，并且含有format文件的string有"+ formatList.size());
            System.out.println("读取android源文件成功，并且不含有format文件的string有"+ noFormatList.size());
            System.out.println("android 源文件读结束");
            iosTextReader();
            toSaveAndroidString(noFormatList, TYPE_NO_FORMAT);
            toSaveAndroidString(formatList, TYPE_FORMAT);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }

    /**
     * 读取ios文件
     */
    public static void iosTextReader() {
        FileReader file = null;
        try {
            File file2 = new File(FILE_IOS_SOURCE_PATH);
            FileReader fileReader = new FileReader(file2);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String readLine = bufferedReader.readLine();
           if (readLine!=null){
               System.out.println("开始读取ios源文件");
           }
            while (readLine != null) {
               // 去掉引号
                String s3 = readLine.replaceAll("\"", "");
                iosList.put(s3, s3);
                readLine = bufferedReader.readLine();
            }
            bufferedReader.close();
            fileReader.close();
            toCompare();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 字符串比较
     */
    private static void toCompare() {
        tempList = iosList;
        for (String key : androidList.keySet()) {
            String value = androidList.get(key);
            String txtValue = iosList.get(value);
            if (txtValue != null) {
                androidPareList.put(key, value);
                tempList.remove(txtValue);
            }
        }
        try {

            File file = new File(FILE_COMPARE_PATH);
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            OutputStreamWriter osw = new OutputStreamWriter(fileOutputStream, "utf-8");
            BufferedWriter bufferedWriter = new BufferedWriter(osw);
            for (String s : tempList.keySet()) {
                tempList.get(s);
                bufferedWriter.write("\"" + tempList.get(s) + "\"");
                bufferedWriter.newLine();
            }
            bufferedWriter.flush();
            osw.flush();
            fileOutputStream.flush();
            toIosText();
            toSaveAndroidString(androidPareList, TYPE_SAME);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 生成ios输出文档
     */
    private static void toIosText() {
        File file = new File(FILE_IOS_NO_FORMAT_TEXT_PATH);
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(file);

            OutputStreamWriter osw = new OutputStreamWriter(fileOutputStream, "utf-8");
            BufferedWriter bufferedWriter = new BufferedWriter(osw);
            for (String s : tempList.keySet()) {
                tempList.get(s);
                bufferedWriter.write("\"" + tempList.get(s) + "\"" + "               =               " + "\"" + tempList.get(s) + "\"");
                bufferedWriter.newLine();
            }
            bufferedWriter.flush();
            osw.flush();
            fileOutputStream.flush();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 取出指定格式的String文件进行处理
     *
     * @param androidPareList
     */
    private static void toSaveAndroidString(Map<String, String> androidPareList, int type) {
        try {
            File file;
            if (TYPE_FORMAT == type) {
                file = new File(FILE_FORMAT_PATH);
            } else if (TYPE_SAME == type) {
                file = new File(FILE_SAME_PATH);
            } else {
                file = new File(FILE_ANDROID_NO_FORMAT_PATH);
            }
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document document = db.newDocument();
            //创建根元素
            Element element = document.createElement("resources");
            //将根元素添加到document中去
            document.appendChild(element);

            TransformerFactory tff = TransformerFactory.newInstance();
            Transformer tf = tff.newTransformer();
            tf.setOutputProperty(OutputKeys.INDENT, "yes");
            for (String key : androidPareList.keySet()) {
                String value = androidPareList.get(key);
                //创建一个元素，并把它追加到根元素的子元素
                Element student = document.createElement("string");
                element.appendChild(student);
                student.setAttribute("name", key);
                student.setTextContent(value);
                tf.transform(new DOMSource(document), new StreamResult(file));
            }
        } catch (ParserConfigurationException | TransformerException e) {
            e.printStackTrace();
        }
    }
}
