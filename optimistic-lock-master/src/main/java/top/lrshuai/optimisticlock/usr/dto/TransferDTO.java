package top.lrshuai.optimisticlock.usr.dto;

import lombok.Data;
import top.lrshuai.optimisticlock.config.annotation.FieldNotNull;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

@Data
public class TransferDTO {
    /**
     * 转账人
     */
    private Long fromUserId;
    /**
     * 给谁转账
     */
    private Long toUserId;

    /**
     * 转账金额
     */
    private BigDecimal amount;

    @NotBlank(message = "字段不能为空")
    private String s;
}
