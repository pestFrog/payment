package cn.shuchan.module.pay.controller.admin.mchrecharge.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;

@Schema(description = "管理后台 - 商户充值记录新增/修改 Request VO")
@Data
public class MchRechargeSaveReqVO {

    @Schema(description = "流水号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1720")
    private Long id;

    @Schema(description = "商户编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "qweq")
    @NotEmpty(message = "商户编号不能为空")
    private String mchNo;

    @Schema(description = "商户名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "哈哈")
    @NotEmpty(message = "商户名称不能为空")
    private String mchName;

    @Schema(description = "充值金额", requiredMode = Schema.RequiredMode.REQUIRED, example = "3000")
    @NotNull(message = "充值金额不能为空")
    @DecimalMin(value="0.00",message = "充值金额不能小于0")
    private BigDecimal rechargeAmt;

}
