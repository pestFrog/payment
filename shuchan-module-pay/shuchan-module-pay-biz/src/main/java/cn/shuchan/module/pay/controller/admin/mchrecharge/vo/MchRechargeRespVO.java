package cn.shuchan.module.pay.controller.admin.mchrecharge.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import java.util.*;
import java.math.BigDecimal;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;
import com.alibaba.excel.annotation.*;

@Schema(description = "管理后台 - 商户充值记录 Response VO")
@Data
@ExcelIgnoreUnannotated
public class MchRechargeRespVO {

    @Schema(description = "商户编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "qweq")
    @ExcelProperty("商户编号")
    private String mchNo;

    @Schema(description = "商户名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "哈哈")
    @ExcelProperty("商户名称")
    private String mchName;

    @Schema(description = "可用金额", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("可用金额")
    private BigDecimal availAmt;

    @Schema(description = "充值金额", requiredMode = Schema.RequiredMode.REQUIRED, example = "3000")
    @ExcelProperty("充值金额")
    private BigDecimal rechargeAmt;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}
