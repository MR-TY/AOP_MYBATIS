package top.lrshuai.optimisticlock;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.lrshuai.optimisticlock.usr.dto.TransferDTO;
import top.lrshuai.optimisticlock.usr.entity.UserAccount;
import top.lrshuai.optimisticlock.usr.mapper.UserAccountMapper;
import top.lrshuai.optimisticlock.usr.service.IUserAccountService;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OptimisticLockApplicationTests {

    @Autowired
    private UserAccountMapper userAccountMapper;

    @Autowired
    private IUserAccountService userAccountService;

    @Test
    public void contextLoads() throws Exception {
        UserAccount userAccount = userAccountMapper.getUserAccountByUserId(1l);
        System.out.println(userAccount.toString());
        System.out.println(userAccount.getBalance());
    }

    @Test
    public void test() throws Exception {
        TransferDTO dto = new TransferDTO();
        dto.setFromUserId(1l);
        dto.setToUserId(2l);
        dto.setAmount(BigDecimal.ONE);
        userAccountService.transfter(dto);
    }

    @Test
    public void testInsert(){
        UserAccount userAccount = new UserAccount();
        userAccount.setBalance(new BigDecimal(2000));
        userAccount.setModifyBy(4L);
        userAccount.setVersion(1L);
        userAccount.setUserId(1003L);
        userAccountMapper.insertUserAccount(userAccount);
    }
}
