package cn.shuchan.module.pay.dal.dataobject.mchrecharge;

import lombok.*;
import java.util.*;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import cn.shuchan.framework.mybatis.core.dataobject.BaseDO;

/**
 * 商户充值记录 DO
 *
 * @author 支付系统system
 */
@TableName("pay_mch_recharge")
@KeySequence("pay_mch_recharge_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MchRechargeDO extends BaseDO {

    /**
     * 流水号
     */
    @TableId
    private Long id;
    /**
     * 商户编号
     */
    private String mchNo;
    /**
     * 商户名称
     */
    private String mchName;
    /**
     * 可用金额
     */
    private BigDecimal availAmt;
    /**
     * 充值金额
     */
    private BigDecimal rechargeAmt;

}