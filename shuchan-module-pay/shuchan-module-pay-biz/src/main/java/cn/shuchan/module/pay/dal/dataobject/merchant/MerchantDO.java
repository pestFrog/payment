package cn.shuchan.module.pay.dal.dataobject.merchant;

import lombok.*;
import java.util.*;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import cn.shuchan.framework.mybatis.core.dataobject.BaseDO;

/**
 * 商户 DO
 *
 * @author 支付系统system
 */
@TableName("pay_merchant")
@KeySequence("pay_merchant_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MerchantDO extends BaseDO {

    /**
     * 商户ID
     */
    @TableId(type = IdType.INPUT)
    private String merchantId;
    /**
     * 商户名称
     */
    private String name;
    /**
     * 联系人姓名
     */
    private String contactName;
    /**
     * 联系人手机号
     */
    private String contactTel;
    /**
     * 联系人邮箱
     */
    private String contactEmail;
    /**
     * 商户服务器IP
     */
    private String serverIp;
    /**
     * 商户加密Key
     */
    private String encryptionKey;
    /**
     * 商户私钥
     */
    private String privateKey;
    /**
     * 商户公钥
     */
    private String publicKey;
    /**
     * 平台公钥
     */
    private String platformPublicKey;
    /**
     * 平台私钥
     */
    private String platformPrivateKey;
    /**
     * 可用金额
     */
    private BigDecimal availAmt;
    /**
     * 冻结
     */
    private BigDecimal frozenAmt;
    /**
     * 商户状态: 0-停用, 1-正常
     *
     * 枚举 {@link TODO common_status 对应的类}
     */
    private Integer status;

}