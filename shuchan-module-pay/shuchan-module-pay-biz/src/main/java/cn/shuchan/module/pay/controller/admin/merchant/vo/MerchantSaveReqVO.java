package cn.shuchan.module.pay.controller.admin.merchant.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;

@Schema(description = "管理后台 - 商户新增/修改 Request VO")
@Data
public class MerchantSaveReqVO {

    @Schema(description = "商户ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "12312")
    private String merchantId;

    @Schema(description = "商户名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "上上")
    @NotEmpty(message = "商户名称不能为空")
    private String name;

    @Schema(description = "联系人姓名", requiredMode = Schema.RequiredMode.REQUIRED, example = "李四")
    @NotEmpty(message = "联系人姓名不能为空")
    private String contactName;

    @Schema(description = "联系人手机号", requiredMode = Schema.RequiredMode.REQUIRED, example = "123")
    @NotEmpty(message = "联系人手机号不能为空")
    private String contactTel;

    @Schema(description = "联系人邮箱", requiredMode = Schema.RequiredMode.REQUIRED, example = "123@123")
    @NotEmpty(message = "联系人邮箱不能为空")
    private String contactEmail;

    @Schema(description = "商户服务器IP", requiredMode = Schema.RequiredMode.REQUIRED, example = "192.168.0.1")
    @NotEmpty(message = "商户服务器IP不能为空")
    private String serverIp;

    @Schema(description = "商户状态: 0-停用, 1-正常", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "商户状态: 0-停用, 1-正常不能为空")
    private Integer status;

}
