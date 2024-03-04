package cn.shuchan.module.pay.controller.admin.merchant.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jdk.nashorn.internal.ir.annotations.Ignore;
import lombok.*;
import java.util.*;
import java.util.*;
import java.math.BigDecimal;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;
import com.alibaba.excel.annotation.*;
import cn.shuchan.framework.excel.core.annotations.DictFormat;
import cn.shuchan.framework.excel.core.convert.DictConvert;

@Schema(description = "管理后台 - 商户 Response VO")
@Data
@ExcelIgnoreUnannotated
public class MerchantRespVO {

    @Schema(description = "商户ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "12312")
    @ExcelProperty("商户ID")
    private String merchantId;

    @Schema(description = "商户名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "上上")
    @ExcelProperty("商户名称")
    private String name;

    @Schema(description = "联系人姓名", requiredMode = Schema.RequiredMode.REQUIRED, example = "李四")
    @ExcelProperty("联系人姓名")
    private String contactName;

    @Schema(description = "联系人手机号", requiredMode = Schema.RequiredMode.REQUIRED, example = "123")
    @ExcelProperty("联系人手机号")
    private String contactTel;

    @Schema(description = "联系人邮箱", requiredMode = Schema.RequiredMode.REQUIRED, example = "123@123")
    @ExcelProperty("联系人邮箱")
    private String contactEmail;

    @Schema(description = "商户服务器IP", requiredMode = Schema.RequiredMode.REQUIRED, example = "192.168.0.1")
    @ExcelProperty("商户服务器IP")
    private String serverIp;

    @Schema(description = "可用金额", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("可用金额")
    private BigDecimal availAmt;

    @Schema(description = "冻结", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("冻结")
    private BigDecimal frozenAmt;

    @Schema(description = "商户状态: 0-停用, 1-正常", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @ExcelProperty(value = "商户状态: 0-停用, 1-正常", converter = DictConvert.class)
    @DictFormat("common_status") // TODO 代码优化：建议设置到对应的 DictTypeConstants 枚举类中
    private Integer status;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

    @Schema(description = "商户加密Key")
    @Ignore
    private String encryptionKey;

    @Schema(description = "商户私钥")
    @Ignore
    private String privateKey;

    @Schema(description = "商户公钥")
    @Ignore
    private String publicKey;

    @Schema(description = "平台公钥")
    @Ignore
    private String platformPublicKey;

}
