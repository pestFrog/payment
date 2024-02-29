package cn.shuchan.module.pay.convert.wallet;

import cn.shuchan.module.pay.controller.app.wallet.vo.recharge.AppPayWalletRechargeCreateRespVO;
import cn.shuchan.module.pay.dal.dataobject.wallet.PayWalletRechargeDO;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-28T20:02:51+0800",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 1.8.0_401 (Oracle Corporation)"
)
public class PayWalletRechargeConvertImpl implements PayWalletRechargeConvert {

    @Override
    public PayWalletRechargeDO convert(Long walletId, Integer payPrice, Integer bonusPrice, Long packageId) {
        if ( walletId == null && payPrice == null && bonusPrice == null && packageId == null ) {
            return null;
        }

        PayWalletRechargeDO payWalletRechargeDO = new PayWalletRechargeDO();

        payWalletRechargeDO.setWalletId( walletId );
        payWalletRechargeDO.setPayPrice( payPrice );
        payWalletRechargeDO.setBonusPrice( bonusPrice );
        payWalletRechargeDO.setPackageId( packageId );
        payWalletRechargeDO.setTotalPrice( payPrice + bonusPrice );

        return payWalletRechargeDO;
    }

    @Override
    public AppPayWalletRechargeCreateRespVO convert(PayWalletRechargeDO bean) {
        if ( bean == null ) {
            return null;
        }

        AppPayWalletRechargeCreateRespVO appPayWalletRechargeCreateRespVO = new AppPayWalletRechargeCreateRespVO();

        appPayWalletRechargeCreateRespVO.setId( bean.getId() );
        appPayWalletRechargeCreateRespVO.setPayOrderId( bean.getPayOrderId() );

        return appPayWalletRechargeCreateRespVO;
    }
}
