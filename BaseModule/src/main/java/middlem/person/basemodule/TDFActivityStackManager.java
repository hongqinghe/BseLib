package middlem.person.basemodule;

import android.app.Activity;

import java.util.ListIterator;
import java.util.Stack;

import middlem.person.utilsmodule.comutils.LogUtils;

/***********************************************
 * <P> dec:  activity 入栈管理类
 * <P> Author: gongtong
 * <P> Date: 17-8-3.
 * <P> Copyright  2008 二维火科技
 ***********************************************/

public class TDFActivityStackManager {
    private static final String TAG="activity_manager";
    private static Stack<Activity> activityStack;
    private static TDFActivityStackManager instance;

    public static TDFActivityStackManager getInstance() {
        if (instance == null) {
            synchronized (TDFActivityStackManager.class) {
                if (instance == null) {
                    instance = new TDFActivityStackManager();
                    activityStack = new Stack<>();
                }
            }
        }
        return instance;
    }

    /**
     * 添加activity入栈
     * @param activity
     */
    public  void addStackActivity(Activity activity) {
        if (activity != null) {
            activityStack.add(activity);
        }
    }

    /**
     * 结束指定activity
     * @param cls
     */
    public void popActivity(Activity cls) {
        try {
            ListIterator<Activity> listIterator = activityStack.listIterator();
            while (listIterator.hasNext()) {
                Activity activity = listIterator.next();
                if (activity.hashCode() ==cls.hashCode()) {
                    listIterator.remove();
                    break;
                }
            }
        } catch (Exception e) {
            LogUtils.e(TAG, e.getMessage());
        }
    }

    /**
     * 销毁除了activity和AppSplash以外的activity
     *
     * @param cls
     */
    // TODO: 2018/4/26 接入登录后删除该方法
    public void finishActivityExcept(Class cls) {
        try {

            ListIterator<Activity> listIterator = activityStack.listIterator();
            while (listIterator.hasNext()) {
                Activity activity = listIterator.next();
                if (activity.getClass().equals(activityStack.firstElement().getClass())||activity.getClass().equals(cls)) {
                    continue;
                }
                listIterator.remove();
                activity.finish();
            }
        } catch (Exception e) {
            LogUtils.e(TAG, e.getMessage());
        }
    }

    /**
     * 销毁除了AppSplash所有的Activity.
     */
    public void finishAllLiveActivity() {
        try {
            ListIterator<Activity> listIterator = activityStack.listIterator();
            while (listIterator.hasNext()) {
                Activity activity = listIterator.next();
                if (!activity.getClass().equals(activityStack.firstElement().getClass())) {
                    listIterator.remove();
                    activity.finish();
                }
            }
        } catch (Exception e) {
            LogUtils.e(TAG, e.getMessage());
        }
    }

    /**
     *  销毁所有的activity
     */
    public void finishAllActivity() {
        try {
            ListIterator<Activity> listIterator = activityStack.listIterator();
            while (listIterator.hasNext()) {
                Activity activity = listIterator.next();
                if (activity != null) {
                    activity.finish();
                }
                listIterator.remove();
            }
        } catch (Exception e) {
            LogUtils.e(TAG, e.getMessage());
        }
    }
    /**
     * 结束栈顶Activity（堆栈中最后一个压入的）
     */
    public void popTopActivity() {
        try {
            Activity activity = activityStack.lastElement();
            popActivity(activity);
        } catch (Exception e) {
            LogUtils.e(TAG, e.getMessage());
        }
    }
}
