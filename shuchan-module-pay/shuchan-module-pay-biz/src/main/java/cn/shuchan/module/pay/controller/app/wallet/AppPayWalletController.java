package cn.shuchan.module.pay.controller.app.wallet;

import cn.shuchan.framework.common.enums.UserTypeEnum;
import cn.shuchan.framework.common.pojo.CommonResult;
import cn.shuchan.framework.security.core.annotations.PreAuthenticated;
import cn.shuchan.module.pay.controller.app.wallet.vo.wallet.AppPayWalletRespVO;
import cn.shuchan.module.pay.convert.wallet.PayWalletConvert;
import cn.shuchan.module.pay.dal.dataobject.wallet.PayWalletDO;
import cn.shuchan.module.pay.service.wallet.PayWalletService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import static cn.shuchan.framework.common.pojo.CommonResult.success;
import static cn.shuchan.framework.security.core.util.SecurityFrameworkUtils.getLoginUserId;

/**
 * @author jason
 */
@Tag(name = "用户 APP - 钱包")
@RestController
@RequestMapping("/pay/wallet")
@Validated
@Slf4j
public class AppPayWalletController {

    @Resource
    private PayWalletService payWalletService;

    @GetMapping("/get")
    @Operation(summary = "获取钱包")
    @PreAuthenticated
    public CommonResult<AppPayWalletRespVO> getPayWallet() {
        PayWalletDO wallet = payWalletService.getOrCreateWallet(getLoginUserId(), UserTypeEnum.MEMBER.getValue());
        return success(PayWalletConvert.INSTANCE.convert(wallet));
    }

}
