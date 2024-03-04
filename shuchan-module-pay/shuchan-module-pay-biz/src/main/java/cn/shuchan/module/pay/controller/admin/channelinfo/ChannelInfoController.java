package cn.shuchan.module.pay.controller.admin.channelinfo;

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

import cn.shuchan.module.pay.controller.admin.channelinfo.vo.*;
import cn.shuchan.module.pay.dal.dataobject.channelinfo.ChannelInfoDO;
import cn.shuchan.module.pay.service.channelinfo.ChannelInfoService;

@Tag(name = "管理后台 - 支付渠道")
@RestController
@RequestMapping("/pay/channel-info")
@Validated
public class ChannelInfoController {

    @Resource
    private ChannelInfoService channelInfoService;

    @PostMapping("/create")
    @Operation(summary = "创建支付渠道")
    @PreAuthorize("@ss.hasPermission('pay:channel-info:create')")
    public CommonResult<String> createChannelInfo(@Valid @RequestBody ChannelInfoSaveReqVO createReqVO) {
        return success(channelInfoService.createChannelInfo(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新支付渠道")
    @PreAuthorize("@ss.hasPermission('pay:channel-info:update')")
    public CommonResult<Boolean> updateChannelInfo(@Valid @RequestBody ChannelInfoSaveReqVO updateReqVO) {
        channelInfoService.updateChannelInfo(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除支付渠道")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('pay:channel-info:delete')")
    public CommonResult<Boolean> deleteChannelInfo(@RequestParam("id") String id) {
        channelInfoService.deleteChannelInfo(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得支付渠道")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('pay:channel-info:query')")
    public CommonResult<ChannelInfoRespVO> getChannelInfo(@RequestParam("id") String id) {
        ChannelInfoDO channelInfo = channelInfoService.getChannelInfo(id);
        return success(BeanUtils.toBean(channelInfo, ChannelInfoRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得支付渠道分页")
    @PreAuthorize("@ss.hasPermission('pay:channel-info:query')")
    public CommonResult<PageResult<ChannelInfoRespVO>> getChannelInfoPage(@Valid ChannelInfoPageReqVO pageReqVO) {
        PageResult<ChannelInfoDO> pageResult = channelInfoService.getChannelInfoPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, ChannelInfoRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出支付渠道 Excel")
    @PreAuthorize("@ss.hasPermission('pay:channel-info:export')")
    @OperateLog(type = EXPORT)
    public void exportChannelInfoExcel(@Valid ChannelInfoPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<ChannelInfoDO> list = channelInfoService.getChannelInfoPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "支付渠道.xls", "数据", ChannelInfoRespVO.class,
                        BeanUtils.toBean(list, ChannelInfoRespVO.class));
    }

}