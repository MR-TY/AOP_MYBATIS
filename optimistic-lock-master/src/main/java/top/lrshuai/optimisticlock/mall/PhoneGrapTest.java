package top.lrshuai.optimisticlock.mall;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author tangyu
 * @date 2020-05-18 16:07
 */
public class PhoneGrapTest {

    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3,10,1, TimeUnit.MINUTES,new LinkedBlockingDeque<>(15));
        for (int i=0;i<20;i++){
            threadPoolExecutor.submit(new PhoneGrabTask("name"+i));
        }
        // 关闭这一次的任务
        threadPoolExecutor.shutdown();
    }
}
