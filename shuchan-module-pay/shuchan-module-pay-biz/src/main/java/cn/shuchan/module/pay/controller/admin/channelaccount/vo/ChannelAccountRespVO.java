package cn.shuchan.module.pay.controller.admin.channelaccount.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import java.util.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;
import com.alibaba.excel.annotation.*;
import cn.shuchan.framework.excel.core.annotations.DictFormat;
import cn.shuchan.framework.excel.core.convert.DictConvert;

@Schema(description = "管理后台 - 支付渠道账户 Response VO")
@Data
@ExcelIgnoreUnannotated
public class ChannelAccountRespVO {

    @Schema(description = "id", requiredMode = Schema.RequiredMode.REQUIRED, example = "27116")
    @ExcelProperty("id")
    private Integer id;

    @Schema(description = "渠道编号", example = "123")
    @ExcelProperty("渠道编号")
    private String channelCode;

    @Schema(description = "渠道名称", example = "fuyou")
    @ExcelProperty("渠道名称")
    private String channelName;

    @Schema(description = "渠道分配的商户号", example = "123")
    @ExcelProperty("渠道分配的商户号")
    private String mchNo;

    @Schema(description = "密钥key")
    @ExcelProperty("密钥key")
    private String encryKey;

    @Schema(description = "渠道分配的私钥", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("渠道分配的私钥")
    private String mchPrivateKey;

    @Schema(description = "渠道分配的公钥", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("渠道分配的公钥")
    private String mchPublicKey;

    @Schema(description = "渠道公钥", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("渠道公钥")
    private String channelPublicKey;

    @Schema(description = "状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @ExcelProperty(value = "状态", converter = DictConvert.class)
    @DictFormat("common_status") // TODO 代码优化：建议设置到对应的 DictTypeConstants 枚举类中
    private Integer status;

    @Schema(description = "创建者", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("创建者")
    private String creator;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

    @Schema(description = "更新者", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("更新者")
    private String updater;

    @Schema(description = "更新时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("更新时间")
    private LocalDateTime updateTime;

}
