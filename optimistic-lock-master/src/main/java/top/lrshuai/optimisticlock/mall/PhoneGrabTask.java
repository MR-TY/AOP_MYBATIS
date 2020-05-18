package top.lrshuai.optimisticlock.mall;

/**
 * @author tangyu
 * @date 2020-05-18 16:01
 */
public class PhoneGrabTask implements Runnable {

    private static int phoneNum = 10;

    private String name;

    public PhoneGrabTask(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.printf("抢单用户名字:"+ name+"线程："+threadName+"参与秒杀任务。。。");
        synchronized (PhoneGrabTask.class){
            if (phoneNum > 0){
                System.out.printf(name+"秒杀成功\n");
                phoneNum--;
            }else {
                System.out.printf(name+"手机已经被抢完。。。");
            }
        }
    }
}
