package middlem.person.baselib.daggerdemo;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

/***********************************************
 * <P> desc:
 * <P> Author: gongtong
 * <P> Date: 2017/11/9 10:17
 ***********************************************/

public class ReadStringUtils {

//    private static final String TAG_ANDROID = "android";
//    private static final String TAG_TEXT = "text";
//    private static final String TAG_COMPARE = "compare";
    private static Map<String, String> saveList;
    private static Map<String, String> testList;
    private static Map<String, String> tempList;


    public static void main(String [] args){
        ReadStringUtils readStringUtils=new ReadStringUtils();
        saveList = new LinkedHashMap<>();
        testList = new LinkedHashMap<>();
        tempList = new LinkedHashMap<>();
        getString();
    }
    public static void getString() {

        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
//        documentBuilderFactory.getAttribute("%s");
        try {
//            InputStream is = context.getAssets().open("strings.xml");
            DocumentBuilder builder = documentBuilderFactory.newDocumentBuilder();
            File file=new File("/Users/hehongqing/Android/middlem/BaseLib/sample/src/main/assets/strings.xml");
            Document document = builder.parse(file);              //得到代表整个xml的Document对象
            Element root = document.getDocumentElement();       //得到 "根节点"
            NodeList childNodes = root.getChildNodes();
            for (int j = 0; j < childNodes.getLength(); j++) {
                Node subNode = childNodes.item(j);
                if ("string".equals(subNode.getNodeName())) {
                    // 键
                    String key = subNode.getAttributes().getNamedItem("name")
                            .getNodeValue();
//                    Log.d(TAG_ANDROID, "getString: " + key);
                    // System.out.println(node1.getAttributes().getNamedItem("name").getNodeValue());
                    // 值
                    String value = subNode.getTextContent();
//                    Log.d(TAG_ANDROID, "getString: " + value);
                    saveList.put(key, value);
                }
            }
            textReader();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }

    public static void textReader() {
        FileReader file = null;
        try {
//            InputStream is = context.getAssets().open("test.txt");
            File file2=new File("/Users/hehongqing/Android/middlem/BaseLib/sample/src/main/assets/test.txt");
            FileReader fileReader=new FileReader(file2);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String readLine = bufferedReader.readLine();
            while (readLine!=null) {
//                if (readLine.contains("@")) {
//                    String s1 = readLine.replaceAll("\\d", "");
//                    readLine.substring()
//                    String s2 = s1.replaceAll("@", "");
                    String s3 = readLine.replaceAll("\"", "");
//            Log.d(TAG_TEXT, "===============" + s3);

                    testList.put(s3, s3);
                    readLine = bufferedReader.readLine();
//                }
//                bufferedReader
            }
//            bufferedReader.close();
//            fileReader.close();
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
        tempList = testList;
        for (String s : saveList.keySet()) {
//            Log.d(TAG_COMPARE, "toCompare====key: " + s);
            String value = saveList.get(s);
            String txtValue = testList.get(value);
            if (txtValue != null) {
                tempList.remove(txtValue);
            }
        }
        try {
            File file = new File("/Users/hehongqing/Android/middlem/BaseLib/sample/src/main/assets/compare.txt");
            boolean newFile = file.createNewFile();
//            if (!newFile){
//                Log.d(TAG_COMPARE, "toCompare: 文件创建失败 ");
//            }
            FileOutputStream fileOutputStream=new FileOutputStream(file);
            OutputStreamWriter osw = new OutputStreamWriter(fileOutputStream, "utf-8");
            BufferedWriter bufferedWriter=new BufferedWriter(osw);
            for (String s : tempList.keySet()) {
                tempList.get(s);
                bufferedWriter.write("\""+tempList.get(s)+"\"");
                bufferedWriter.newLine();
            }
            bufferedWriter.flush();
            osw.flush();
            fileOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
