package top.lrshuai.optimisticlock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author tangyu
 * @date 2020/5/11
 */
public class ThreadSTest {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i=0;i<20;i++){
            int i1 = i;
            try {
                Thread.sleep(i1*1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            executorService.execute(() -> System.out.println("线程名称11：" + Thread.currentThread().getName() + "，执行" + i1));
        }
    }
}
