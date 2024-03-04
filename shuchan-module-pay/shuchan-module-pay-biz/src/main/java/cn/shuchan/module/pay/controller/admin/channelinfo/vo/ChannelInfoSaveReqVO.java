package cn.shuchan.module.pay.controller.admin.channelinfo.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import javax.validation.constraints.*;

@Schema(description = "管理后台 - 支付渠道新增/修改 Request VO")
@Data
public class ChannelInfoSaveReqVO {

    @Schema(description = "渠道号", requiredMode = Schema.RequiredMode.REQUIRED, example = "tets")
    private String channelNo;

    @Schema(description = "渠道名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "李四")
    @NotEmpty(message = "渠道名称不能为空")
    private String channelName;

    @Schema(description = "代收下单地址", requiredMode = Schema.RequiredMode.REQUIRED, example = "https://www.iocoder.cn")
    @NotEmpty(message = "代收下单地址不能为空")
    private String reorderUrl;

    @Schema(description = "代收订单状态查询地址", requiredMode = Schema.RequiredMode.REQUIRED, example = "https://www.iocoder.cn")
    @NotEmpty(message = "代收订单状态查询地址不能为空")
    private String reorderStatusUrl;

    @Schema(description = "代付下单地址", requiredMode = Schema.RequiredMode.REQUIRED, example = "https://www.iocoder.cn")
    @NotEmpty(message = "代付下单地址不能为空")
    private String payorderUrl;

    @Schema(description = "代付订单状态查询地址", requiredMode = Schema.RequiredMode.REQUIRED, example = "https://www.iocoder.cn")
    @NotEmpty(message = "代付订单状态查询地址不能为空")
    private String payorderStatusUrl;

    @Schema(description = "状态1：停用，0：启用", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "状态1：停用，0：启用不能为空")
    private Integer status;

    @Schema(description = "备注", example = "你说的对")
    private String remark;

    @Schema(description = "渠道费率，单位：百分比", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "渠道费率，单位：百分比不能为空")
    private Double feeRate;

}