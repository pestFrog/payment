package cn.shuchan.module.pay.controller.admin.mchrecharge;

import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Operation;

import javax.validation.constraints.*;
import javax.validation.*;
import javax.servlet.http.*;
import java.util.*;
import java.io.IOException;

import cn.shuchan.framework.common.pojo.PageParam;
import cn.shuchan.framework.common.pojo.PageResult;
import cn.shuchan.framework.common.pojo.CommonResult;
import cn.shuchan.framework.common.util.object.BeanUtils;

import static cn.shuchan.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.shuchan.framework.common.pojo.CommonResult.success;

import cn.shuchan.framework.excel.core.util.ExcelUtils;

import cn.shuchan.framework.operatelog.core.annotations.OperateLog;
import static cn.shuchan.framework.operatelog.core.enums.OperateTypeEnum.*;
import static cn.shuchan.framework.security.core.util.SecurityFrameworkUtils.getLoginUserId;
import static cn.shuchan.module.infra.enums.ErrorCodeConstants.FILE_IS_EMPTY;

import cn.shuchan.module.pay.controller.admin.mchrecharge.vo.*;
import cn.shuchan.module.pay.dal.dataobject.mchrecharge.MchRechargeDO;
import cn.shuchan.module.pay.service.mchrecharge.MchRechargeService;
import org.springframework.web.multipart.MultipartFile;

@Tag(name = "管理后台 - 商户充值记录")
@RestController
@RequestMapping("/pay/mch-recharge")
@Validated
public class MchRechargeController {

    @Resource
    private MchRechargeService mchRechargeService;

    @PostMapping("/create")
    @Operation(summary = "创建商户充值记录")
    @PreAuthorize("@ss.hasPermission('pay:mch-recharge:create')")
    public CommonResult<Long> createMchRecharge(@Valid @RequestBody MchRechargeSaveReqVO createReqVO) throws IOException {
        return success(mchRechargeService.createMchRecharge(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新商户充值记录")
    @PreAuthorize("@ss.hasPermission('pay:mch-recharge:update')")
    public CommonResult<Boolean> updateMchRecharge(@Valid @RequestBody MchRechargeSaveReqVO updateReqVO) throws IOException {
        mchRechargeService.updateMchRecharge(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除商户充值记录")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('pay:mch-recharge:delete')")
    public CommonResult<Boolean> deleteMchRecharge(@RequestParam("id") Long id) {
        mchRechargeService.deleteMchRecharge(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得商户充值记录")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('pay:mch-recharge:query')")
    public CommonResult<MchRechargeRespVO> getMchRecharge(@RequestParam("id") Long id) {
        MchRechargeDO mchRecharge = mchRechargeService.getMchRecharge(id);
        return success(BeanUtils.toBean(mchRecharge, MchRechargeRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得商户充值记录分页")
    @PreAuthorize("@ss.hasPermission('pay:mch-recharge:query')")
    public CommonResult<PageResult<MchRechargeRespVO>> getMchRechargePage(@Valid MchRechargePageReqVO pageReqVO) {
        PageResult<MchRechargeDO> pageResult = mchRechargeService.getMchRechargePage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, MchRechargeRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出商户充值记录 Excel")
    @PreAuthorize("@ss.hasPermission('pay:mch-recharge:export')")
    @OperateLog(type = EXPORT)
    public void exportMchRechargeExcel(@Valid MchRechargePageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<MchRechargeDO> list = mchRechargeService.getMchRechargePage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "商户充值记录.xls", "数据", MchRechargeRespVO.class,
                        BeanUtils.toBean(list, MchRechargeRespVO.class));
    }

    @RequestMapping(value = "/update-voucher",
            method = {RequestMethod.POST, RequestMethod.PUT}) // 解决 uni-app 不支持 Put 上传文件的问题
    @Operation(summary = "上传充值凭证")
    public CommonResult<String> updateVoucher(@RequestParam("file") MultipartFile file) throws Exception {
        if (file.isEmpty()) {
            throw exception(FILE_IS_EMPTY);
        }
        String voucher = mchRechargeService.getVoucher(file.getInputStream());
        return success(voucher);
    }

}
