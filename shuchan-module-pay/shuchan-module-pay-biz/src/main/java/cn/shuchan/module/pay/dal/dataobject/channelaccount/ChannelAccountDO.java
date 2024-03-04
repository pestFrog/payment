package cn.shuchan.module.pay.dal.dataobject.channelaccount;

import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import cn.shuchan.framework.mybatis.core.dataobject.BaseDO;

/**
 * 支付渠道账户 DO
 *
 * @author 支付系统system
 */
@TableName("pay_channel_account")
@KeySequence("pay_channel_account_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChannelAccountDO extends BaseDO {

    /**
     * id
     */
    @TableId
    private Integer id;
    /**
     * 渠道编号
     */
    private String channelCode;
    /**
     * 渠道名称
     */
    private String channelName;
    /**
     * 渠道分配的商户号
     */
    private String mchNo;
    /**
     * 密钥key
     */
    private String encryKey;
    /**
     * 渠道分配的私钥
     */
    private String mchPrivateKey;
    /**
     * 渠道分配的公钥
     */
    private String mchPublicKey;
    /**
     * 渠道公钥
     */
    private String channelPublicKey;
    /**
     * 状态
     *
     * 枚举 {@link TODO common_status 对应的类}
     */
    private Integer status;

}
