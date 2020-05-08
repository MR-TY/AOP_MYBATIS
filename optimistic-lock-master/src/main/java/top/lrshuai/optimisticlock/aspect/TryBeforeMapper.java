package top.lrshuai.optimisticlock.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author tangyu
 * @date 2020/5/8
 */
@Aspect
@Configuration
public class TryBeforeMapper {

    private static final String CREATOR = "createBy";
    private static final String GMTCREATE = "createTime";
    private static final String MODIFY_TIME = "modifyTime";

    @Pointcut("execution(* top.lrshuai.optimisticlock.usr.mapper..*.insert*(..))")
    public void insertBeforePointCut() {
        // pointcut mark
    }

    @Before("insertBeforePointCut()")
    public void beforeInsert(JoinPoint jp) {
        Object[] args = jp.getArgs();
        if (args != null && args.length > 0) {
            Object argument = args[0];
            // 如果argument是map类型
            if (argument instanceof List) {
                List list = (List) argument;
                list.stream().forEach(c -> {
                    BeanWrapper beanWrapper = new BeanWrapperImpl(c);
                    // 设置创建时间和修改时间
                    if (beanWrapper.isWritableProperty(GMTCREATE)) {
                        beanWrapper.setPropertyValue(GMTCREATE, LocalDateTime.now());
                    }
                    // 设置创建人和修改人
                    if (beanWrapper.isWritableProperty(CREATOR)) {
                        beanWrapper.setPropertyValue(CREATOR, 2L);
                    }
                    if (beanWrapper.isWritableProperty(MODIFY_TIME)) {
                        beanWrapper.setPropertyValue(MODIFY_TIME, LocalDateTime.now());
                    }
                });
            } else {
                BeanWrapper beanWrapper = new BeanWrapperImpl(argument);
                // 设置创建时间和修改时间
                if (beanWrapper.isWritableProperty(GMTCREATE)) {
                    beanWrapper.setPropertyValue(GMTCREATE, LocalDateTime.now());
                }
                // 设置创建人和修改人
                if (beanWrapper.isWritableProperty(CREATOR)) {
                    beanWrapper.setPropertyValue(CREATOR, 2L);
                }
                if (beanWrapper.isWritableProperty(MODIFY_TIME)) {
                    beanWrapper.setPropertyValue(MODIFY_TIME, LocalDateTime.now());
                }
            }
        }
    }
}
