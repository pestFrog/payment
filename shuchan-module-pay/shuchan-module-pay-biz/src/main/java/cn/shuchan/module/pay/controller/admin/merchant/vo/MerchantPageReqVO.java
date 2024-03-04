package cn.shuchan.module.pay.controller.admin.merchant.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.shuchan.framework.common.pojo.PageParam;
import java.math.BigDecimal;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

import static cn.shuchan.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 商户分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MerchantPageReqVO extends PageParam {

    @Schema(description = "商户ID", example = "12312")
    private String merchantId;

    @Schema(description = "商户名称", example = "上上")
    private String name;

    @Schema(description = "联系人姓名", example = "李四")
    private String contactName;

    @Schema(description = "联系人手机号", example = "123")
    private String contactTel;

    @Schema(description = "联系人邮箱", example = "123@123")
    private String contactEmail;

    @Schema(description = "商户服务器IP", example = "192.168.0.1")
    private String serverIp;

    @Schema(description = "商户状态: 0-停用, 1-正常", example = "1")
    private Integer status;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}