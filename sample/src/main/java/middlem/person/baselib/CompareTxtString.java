//package middlem.person.baselib;
//
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.IOException;
//
///***********************************************
// * <P> desc:
// * <P> Author: gongtong
// * <P> Date: 2017/11/23 16:44
// ***********************************************/
//
//public class CompareTxtString {
//
//    /**
//     * 相同String文件且不带format的文件集合
//     */
//    private static final String FILE_SAME_PATH = "/Users/hehongqing/Android/middlem/BaseLib/sample/src/main/assets/sameStrings.xml";
//
//
//    /**
//     * 相同String文件且不带format的文件集合
//     */
//    private static final String FILE_STRING_PATH = "/Users/hehongqing/Android/middlem/BaseLib/sample/src/main/assets/sameStrings.xml";
//
//    public static  void main(String[]  args[]){
//
//    }
//
//    /**
//     * 读取ios文件
//     */
//    public static void iosTextReader() {
//        FileReader file = null;
//        try {
//            File file2 = new File(FILE_IOS_SOURCE_PATH);
//            FileReader fileReader = new FileReader(file2);
//            BufferedReader bufferedReader = new BufferedReader(fileReader);
//            String readLine = bufferedReader.readLine();
//            if (readLine != null) {
//                System.out.println("开始读取ios源文件");
//            }
//            while (readLine != null) {
//
//                readLine = bufferedReader.readLine();
//            }
//            System.out.println("读取ios源文件成功，大小为：" + iosList.size());
//            System.out.println("读取ios源文件成功，并且含有format文件的string有" + iosFormatList.size());
//            System.out.println("读取ios源文件成功，并且不含有format文件的string有" + iosNoFormatList.size());
//            System.out.println("ios 源文件读结束"+"\n");
//            bufferedReader.close();
//            fileReader.close();
////              iosRemoveReader();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}
