package cn.shuchan.module.pay.dal.dataobject.channelinfo;

import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import cn.shuchan.framework.mybatis.core.dataobject.BaseDO;

/**
 * 支付渠道 DO
 *
 * @author 支付系统system
 */
@TableName("pay_channel_info")
@KeySequence("pay_channel_info_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChannelInfoDO extends BaseDO {

    /**
     * 渠道号
     */
    @TableId(type = IdType.INPUT)
    private String channelNo;
    /**
     * 渠道名称
     */
    private String channelName;
    /**
     * 代收下单地址
     */
    private String reorderUrl;
    /**
     * 代收订单状态查询地址
     */
    private String reorderStatusUrl;
    /**
     * 代付下单地址
     */
    private String payorderUrl;
    /**
     * 代付订单状态查询地址
     */
    private String payorderStatusUrl;
    /**
     * 状态1：停用，0：启用
     *
     * 枚举 {@link TODO common_status 对应的类}
     */
    private Integer status;
    /**
     * 备注
     */
    private String remark;
    /**
     * 渠道费率，单位：百分比
     */
    private Double feeRate;

}