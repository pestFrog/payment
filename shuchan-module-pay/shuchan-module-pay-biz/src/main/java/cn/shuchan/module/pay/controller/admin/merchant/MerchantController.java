package cn.shuchan.module.pay.controller.admin.merchant;

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
import static cn.shuchan.framework.common.pojo.CommonResult.success;

import cn.shuchan.framework.excel.core.util.ExcelUtils;

import cn.shuchan.framework.operatelog.core.annotations.OperateLog;
import static cn.shuchan.framework.operatelog.core.enums.OperateTypeEnum.*;

import cn.shuchan.module.pay.controller.admin.merchant.vo.*;
import cn.shuchan.module.pay.dal.dataobject.merchant.MerchantDO;
import cn.shuchan.module.pay.service.merchant.MerchantService;

@Tag(name = "管理后台 - 商户")
@RestController
@RequestMapping("/pay/merchant")
@Validated
public class MerchantController {

    @Resource
    private MerchantService merchantService;

    @PostMapping("/create")
    @Operation(summary = "创建商户")
    @PreAuthorize("@ss.hasPermission('pay:merchant:create')")
    public CommonResult<String> createMerchant(@Valid @RequestBody MerchantSaveReqVO createReqVO) {
        return success(merchantService.createMerchant(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新商户")
    @PreAuthorize("@ss.hasPermission('pay:merchant:update')")
    public CommonResult<Boolean> updateMerchant(@Valid @RequestBody MerchantSaveReqVO updateReqVO) {
        merchantService.updateMerchant(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除商户")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('pay:merchant:delete')")
    public CommonResult<Boolean> deleteMerchant(@RequestParam("id") String id) {
        merchantService.deleteMerchant(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得商户")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('pay:merchant:query')")
    public CommonResult<MerchantRespVO> getMerchant(@RequestParam("id") String id) {
        MerchantDO merchant = merchantService.getMerchant(id);
        return success(BeanUtils.toBean(merchant, MerchantRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得商户分页")
    @PreAuthorize("@ss.hasPermission('pay:merchant:query')")
    public CommonResult<PageResult<MerchantRespVO>> getMerchantPage(@Valid MerchantPageReqVO pageReqVO) {
        PageResult<MerchantDO> pageResult = merchantService.getMerchantPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, MerchantRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出商户 Excel")
    @PreAuthorize("@ss.hasPermission('pay:merchant:export')")
    @OperateLog(type = EXPORT)
    public void exportMerchantExcel(@Valid MerchantPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<MerchantDO> list = merchantService.getMerchantPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "商户.xls", "数据", MerchantRespVO.class,
                        BeanUtils.toBean(list, MerchantRespVO.class));
    }

}