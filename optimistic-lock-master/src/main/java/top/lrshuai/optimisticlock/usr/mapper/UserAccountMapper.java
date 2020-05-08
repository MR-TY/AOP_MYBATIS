package top.lrshuai.optimisticlock.usr.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import top.lrshuai.optimisticlock.usr.entity.UserAccount;

@Component
public interface UserAccountMapper {
    public boolean updateAccount(UserAccount userAccount) throws Exception;
    public UserAccount getUserAccountByUserId(Long userId) throws Exception;
    public void insertUserAccount(@Param("userAccount") UserAccount userAccount);
}
