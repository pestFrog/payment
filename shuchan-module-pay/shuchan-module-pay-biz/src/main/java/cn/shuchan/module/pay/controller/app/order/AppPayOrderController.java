package cn.shuchan.module.pay.controller.app.order;

import cn.shuchan.framework.common.pojo.CommonResult;
import cn.shuchan.framework.pay.core.enums.channel.PayChannelEnum;
import cn.shuchan.module.pay.controller.admin.order.vo.PayOrderRespVO;
import cn.shuchan.module.pay.controller.admin.order.vo.PayOrderSubmitRespVO;
import cn.shuchan.module.pay.controller.app.order.vo.AppPayOrderSubmitReqVO;
import cn.shuchan.module.pay.controller.app.order.vo.AppPayOrderSubmitRespVO;
import cn.shuchan.module.pay.convert.order.PayOrderConvert;
import cn.shuchan.module.pay.framework.pay.core.WalletPayClient;
import cn.shuchan.module.pay.service.order.PayOrderService;
import com.google.common.collect.Maps;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import java.util.Map;
import java.util.Objects;

import static cn.shuchan.framework.common.pojo.CommonResult.success;
import static cn.shuchan.framework.common.util.servlet.ServletUtils.getClientIP;
import static cn.shuchan.framework.web.core.util.WebFrameworkUtils.getLoginUserId;
import static cn.shuchan.framework.web.core.util.WebFrameworkUtils.getLoginUserType;

@Tag(name = "用户 APP - 支付订单")
@RestController
@RequestMapping("/pay/order")
@Validated
@Slf4j
public class AppPayOrderController {

    @Resource
    private PayOrderService payOrderService;

    // TODO 芋艿：临时 demo，技术打样。
    @GetMapping("/get")
    @Operation(summary = "获得支付订单")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    public CommonResult<PayOrderRespVO> getOrder(@RequestParam("id") Long id) {
        return success(PayOrderConvert.INSTANCE.convert(payOrderService.getOrder(id)));
    }

    @PostMapping("/submit")
    @Operation(summary = "提交支付订单")
    public CommonResult<AppPayOrderSubmitRespVO> submitPayOrder(@RequestBody AppPayOrderSubmitReqVO reqVO) {
        // 1. 钱包支付事，需要额外传 user_id 和 user_type
        if (Objects.equals(reqVO.getChannelCode(), PayChannelEnum.WALLET.getCode())) {
            Map<String, String> channelExtras = reqVO.getChannelExtras() == null ?
                    Maps.newHashMapWithExpectedSize(2) : reqVO.getChannelExtras();
            channelExtras.put(WalletPayClient.USER_ID_KEY, String.valueOf(getLoginUserId()));
            channelExtras.put(WalletPayClient.USER_TYPE_KEY, String.valueOf(getLoginUserType()));
            reqVO.setChannelExtras(channelExtras);
        }

        // 2. 提交支付
        PayOrderSubmitRespVO respVO = payOrderService.submitOrder(reqVO, getClientIP());
        return success(PayOrderConvert.INSTANCE.convert3(respVO));
    }

}
