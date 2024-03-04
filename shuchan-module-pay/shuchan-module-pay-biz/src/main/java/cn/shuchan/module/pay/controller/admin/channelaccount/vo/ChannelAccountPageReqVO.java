package cn.shuchan.module.pay.controller.admin.channelaccount.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.shuchan.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

import static cn.shuchan.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 支付渠道账户分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ChannelAccountPageReqVO extends PageParam {

    @Schema(description = "渠道编号", example = "123")
    private String channelCode;

    @Schema(description = "渠道名称", example = "fuyou")
    private String channelName;

    @Schema(description = "渠道分配的商户号", example = "123")
    private String mchNo;

    @Schema(description = "密钥key")
    private String encryKey;

    @Schema(description = "渠道分配的私钥")
    private String mchPrivateKey;

    @Schema(description = "渠道分配的公钥")
    private String mchPublicKey;

    @Schema(description = "渠道公钥")
    private String channelPublicKey;

    @Schema(description = "状态", example = "0")
    private Integer status;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}
