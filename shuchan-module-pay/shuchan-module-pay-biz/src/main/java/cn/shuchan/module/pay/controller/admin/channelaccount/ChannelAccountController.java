package cn.shuchan.module.pay.controller.admin.channelaccount;

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

import cn.shuchan.module.pay.controller.admin.channelaccount.vo.*;
import cn.shuchan.module.pay.dal.dataobject.channelaccount.ChannelAccountDO;
import cn.shuchan.module.pay.service.channelaccount.ChannelAccountService;

@Tag(name = "管理后台 - 支付渠道账户")
@RestController
@RequestMapping("/pay/channel-account")
@Validated
public class ChannelAccountController {

    @Resource
    private ChannelAccountService channelAccountService;

    @PostMapping("/create")
    @Operation(summary = "创建支付渠道账户")
    @PreAuthorize("@ss.hasPermission('pay:channel-account:create')")
    public CommonResult<Integer> createChannelAccount(@Valid @RequestBody ChannelAccountSaveReqVO createReqVO) {
        return success(channelAccountService.createChannelAccount(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新支付渠道账户")
    @PreAuthorize("@ss.hasPermission('pay:channel-account:update')")
    public CommonResult<Boolean> updateChannelAccount(@Valid @RequestBody ChannelAccountSaveReqVO updateReqVO) {
        channelAccountService.updateChannelAccount(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除支付渠道账户")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('pay:channel-account:delete')")
    public CommonResult<Boolean> deleteChannelAccount(@RequestParam("id") Integer id) {
        channelAccountService.deleteChannelAccount(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得支付渠道账户")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('pay:channel-account:query')")
    public CommonResult<ChannelAccountRespVO> getChannelAccount(@RequestParam("id") Integer id) {
        ChannelAccountDO channelAccount = channelAccountService.getChannelAccount(id);
        return success(BeanUtils.toBean(channelAccount, ChannelAccountRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得支付渠道账户分页")
    @PreAuthorize("@ss.hasPermission('pay:channel-account:query')")
    public CommonResult<PageResult<ChannelAccountRespVO>> getChannelAccountPage(@Valid ChannelAccountPageReqVO pageReqVO) {
        PageResult<ChannelAccountDO> pageResult = channelAccountService.getChannelAccountPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, ChannelAccountRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出支付渠道账户 Excel")
    @PreAuthorize("@ss.hasPermission('pay:channel-account:export')")
    @OperateLog(type = EXPORT)
    public void exportChannelAccountExcel(@Valid ChannelAccountPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<ChannelAccountDO> list = channelAccountService.getChannelAccountPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "支付渠道账户.xls", "数据", ChannelAccountRespVO.class,
                        BeanUtils.toBean(list, ChannelAccountRespVO.class));
    }

}