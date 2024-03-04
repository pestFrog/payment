package cn.shuchan.module.pay.controller.admin.channelinfo.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import java.util.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;
import com.alibaba.excel.annotation.*;
import cn.shuchan.framework.excel.core.annotations.DictFormat;
import cn.shuchan.framework.excel.core.convert.DictConvert;

@Schema(description = "管理后台 - 支付渠道 Response VO")
@Data
@ExcelIgnoreUnannotated
public class ChannelInfoRespVO {

    @Schema(description = "渠道号", requiredMode = Schema.RequiredMode.REQUIRED, example = "tets")
    @ExcelProperty("渠道号")
    private String channelNo;

    @Schema(description = "渠道名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "李四")
    @ExcelProperty("渠道名称")
    private String channelName;

    @Schema(description = "代收下单地址", requiredMode = Schema.RequiredMode.REQUIRED, example = "https://www.iocoder.cn")
    @ExcelProperty("代收下单地址")
    private String reorderUrl;

    @Schema(description = "代收订单状态查询地址", requiredMode = Schema.RequiredMode.REQUIRED, example = "https://www.iocoder.cn")
    @ExcelProperty("代收订单状态查询地址")
    private String reorderStatusUrl;

    @Schema(description = "代付下单地址", requiredMode = Schema.RequiredMode.REQUIRED, example = "https://www.iocoder.cn")
    @ExcelProperty("代付下单地址")
    private String payorderUrl;

    @Schema(description = "代付订单状态查询地址", requiredMode = Schema.RequiredMode.REQUIRED, example = "https://www.iocoder.cn")
    @ExcelProperty("代付订单状态查询地址")
    private String payorderStatusUrl;

    @Schema(description = "状态1：停用，0：启用", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @ExcelProperty(value = "状态1：停用，0：启用", converter = DictConvert.class)
    @DictFormat("common_status") // TODO 代码优化：建议设置到对应的 DictTypeConstants 枚举类中
    private Integer status;

    @Schema(description = "备注", example = "你说的对")
    @ExcelProperty("备注")
    private String remark;

    @Schema(description = "渠道费率，单位：百分比", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("渠道费率，单位：百分比")
    private Double feeRate;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

    @Schema(description = "修改者", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("修改者")
    private String updater;

    @Schema(description = "修改时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("修改时间")
    private LocalDateTime updateTime;

}