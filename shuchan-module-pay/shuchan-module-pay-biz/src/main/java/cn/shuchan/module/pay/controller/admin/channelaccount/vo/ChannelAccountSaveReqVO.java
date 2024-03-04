package cn.shuchan.module.pay.controller.admin.channelaccount.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import javax.validation.constraints.*;

@Schema(description = "管理后台 - 支付渠道账户新增/修改 Request VO")
@Data
public class ChannelAccountSaveReqVO {

    @Schema(description = "id", requiredMode = Schema.RequiredMode.REQUIRED, example = "27116")
    private Integer id;

    @Schema(description = "渠道编号", example = "123")
    @NotEmpty(message = "渠道编号不能为空")
    private String channelCode;

    @Schema(description = "渠道名称", example = "fuyou")
    @NotEmpty(message = "渠道分名称不能为空")
    private String channelName;

    @Schema(description = "渠道分配的商户号", example = "123")
    @NotEmpty(message = "渠道分配的商户号不能为空")
    private String mchNo;

    @Schema(description = "密钥key")
    @NotEmpty(message = "渠道分配的密钥key不能为空")
    private String encryKey;

    @Schema(description = "渠道分配的私钥", requiredMode = Schema.RequiredMode.REQUIRED)
    private String mchPrivateKey;

    @Schema(description = "渠道分配的公钥", requiredMode = Schema.RequiredMode.REQUIRED)
    private String mchPublicKey;

    @Schema(description = "渠道公钥", requiredMode = Schema.RequiredMode.REQUIRED)
    private String channelPublicKey;

    @Schema(description = "状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "状态不能为空")
    private Integer status;

}
