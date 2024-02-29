package cn.shuchan.module.pay.convert.wallet;

import cn.shuchan.framework.common.pojo.PageResult;
import cn.shuchan.module.pay.controller.admin.wallet.vo.rechargepackage.WalletRechargePackageCreateReqVO;
import cn.shuchan.module.pay.controller.admin.wallet.vo.rechargepackage.WalletRechargePackageRespVO;
import cn.shuchan.module.pay.controller.admin.wallet.vo.rechargepackage.WalletRechargePackageUpdateReqVO;
import cn.shuchan.module.pay.dal.dataobject.wallet.PayWalletRechargePackageDO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-28T20:02:51+0800",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 1.8.0_401 (Oracle Corporation)"
)
public class PayWalletRechargePackageConvertImpl implements PayWalletRechargePackageConvert {

    @Override
    public PayWalletRechargePackageDO convert(WalletRechargePackageCreateReqVO bean) {
        if ( bean == null ) {
            return null;
        }

        PayWalletRechargePackageDO payWalletRechargePackageDO = new PayWalletRechargePackageDO();

        payWalletRechargePackageDO.setName( bean.getName() );
        payWalletRechargePackageDO.setPayPrice( bean.getPayPrice() );
        payWalletRechargePackageDO.setBonusPrice( bean.getBonusPrice() );
        if ( bean.getStatus() != null ) {
            payWalletRechargePackageDO.setStatus( bean.getStatus().intValue() );
        }

        return payWalletRechargePackageDO;
    }

    @Override
    public PayWalletRechargePackageDO convert(WalletRechargePackageUpdateReqVO bean) {
        if ( bean == null ) {
            return null;
        }

        PayWalletRechargePackageDO payWalletRechargePackageDO = new PayWalletRechargePackageDO();

        payWalletRechargePackageDO.setId( bean.getId() );
        payWalletRechargePackageDO.setName( bean.getName() );
        payWalletRechargePackageDO.setPayPrice( bean.getPayPrice() );
        payWalletRechargePackageDO.setBonusPrice( bean.getBonusPrice() );
        if ( bean.getStatus() != null ) {
            payWalletRechargePackageDO.setStatus( bean.getStatus().intValue() );
        }

        return payWalletRechargePackageDO;
    }

    @Override
    public WalletRechargePackageRespVO convert(PayWalletRechargePackageDO bean) {
        if ( bean == null ) {
            return null;
        }

        WalletRechargePackageRespVO walletRechargePackageRespVO = new WalletRechargePackageRespVO();

        walletRechargePackageRespVO.setName( bean.getName() );
        walletRechargePackageRespVO.setPayPrice( bean.getPayPrice() );
        walletRechargePackageRespVO.setBonusPrice( bean.getBonusPrice() );
        if ( bean.getStatus() != null ) {
            walletRechargePackageRespVO.setStatus( bean.getStatus().byteValue() );
        }
        walletRechargePackageRespVO.setId( bean.getId() );
        walletRechargePackageRespVO.setCreateTime( bean.getCreateTime() );

        return walletRechargePackageRespVO;
    }

    @Override
    public List<WalletRechargePackageRespVO> convertList(List<PayWalletRechargePackageDO> list) {
        if ( list == null ) {
            return null;
        }

        List<WalletRechargePackageRespVO> list1 = new ArrayList<WalletRechargePackageRespVO>( list.size() );
        for ( PayWalletRechargePackageDO payWalletRechargePackageDO : list ) {
            list1.add( convert( payWalletRechargePackageDO ) );
        }

        return list1;
    }

    @Override
    public PageResult<WalletRechargePackageRespVO> convertPage(PageResult<PayWalletRechargePackageDO> page) {
        if ( page == null ) {
            return null;
        }

        PageResult<WalletRechargePackageRespVO> pageResult = new PageResult<WalletRechargePackageRespVO>();

        pageResult.setList( convertList( page.getList() ) );
        pageResult.setTotal( page.getTotal() );

        return pageResult;
    }
}
