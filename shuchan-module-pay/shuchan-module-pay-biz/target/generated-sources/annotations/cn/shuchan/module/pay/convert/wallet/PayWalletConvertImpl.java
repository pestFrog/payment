package cn.shuchan.module.pay.convert.wallet;

import cn.shuchan.framework.common.pojo.PageResult;
import cn.shuchan.module.pay.controller.admin.wallet.vo.wallet.PayWalletRespVO;
import cn.shuchan.module.pay.controller.app.wallet.vo.wallet.AppPayWalletRespVO;
import cn.shuchan.module.pay.dal.dataobject.wallet.PayWalletDO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-28T20:02:51+0800",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 1.8.0_401 (Oracle Corporation)"
)
public class PayWalletConvertImpl implements PayWalletConvert {

    @Override
    public AppPayWalletRespVO convert(PayWalletDO bean) {
        if ( bean == null ) {
            return null;
        }

        AppPayWalletRespVO appPayWalletRespVO = new AppPayWalletRespVO();

        appPayWalletRespVO.setBalance( bean.getBalance() );
        appPayWalletRespVO.setTotalExpense( bean.getTotalExpense() );
        appPayWalletRespVO.setTotalRecharge( bean.getTotalRecharge() );

        return appPayWalletRespVO;
    }

    @Override
    public PayWalletRespVO convert02(String nickname, String avatar, PayWalletDO bean) {
        if ( nickname == null && avatar == null && bean == null ) {
            return null;
        }

        PayWalletRespVO payWalletRespVO = new PayWalletRespVO();

        if ( bean != null ) {
            payWalletRespVO.setUserId( bean.getUserId() );
            payWalletRespVO.setUserType( bean.getUserType() );
            payWalletRespVO.setBalance( bean.getBalance() );
            payWalletRespVO.setTotalExpense( bean.getTotalExpense() );
            payWalletRespVO.setTotalRecharge( bean.getTotalRecharge() );
            payWalletRespVO.setFreezePrice( bean.getFreezePrice() );
            payWalletRespVO.setId( bean.getId() );
            payWalletRespVO.setCreateTime( bean.getCreateTime() );
        }
        payWalletRespVO.setNickname( nickname );
        payWalletRespVO.setAvatar( avatar );

        return payWalletRespVO;
    }

    @Override
    public PageResult<PayWalletRespVO> convertPage(PageResult<PayWalletDO> page) {
        if ( page == null ) {
            return null;
        }

        PageResult<PayWalletRespVO> pageResult = new PageResult<PayWalletRespVO>();

        pageResult.setList( payWalletDOListToPayWalletRespVOList( page.getList() ) );
        pageResult.setTotal( page.getTotal() );

        return pageResult;
    }

    protected PayWalletRespVO payWalletDOToPayWalletRespVO(PayWalletDO payWalletDO) {
        if ( payWalletDO == null ) {
            return null;
        }

        PayWalletRespVO payWalletRespVO = new PayWalletRespVO();

        payWalletRespVO.setUserId( payWalletDO.getUserId() );
        payWalletRespVO.setUserType( payWalletDO.getUserType() );
        payWalletRespVO.setBalance( payWalletDO.getBalance() );
        payWalletRespVO.setTotalExpense( payWalletDO.getTotalExpense() );
        payWalletRespVO.setTotalRecharge( payWalletDO.getTotalRecharge() );
        payWalletRespVO.setFreezePrice( payWalletDO.getFreezePrice() );
        payWalletRespVO.setId( payWalletDO.getId() );
        payWalletRespVO.setCreateTime( payWalletDO.getCreateTime() );

        return payWalletRespVO;
    }

    protected List<PayWalletRespVO> payWalletDOListToPayWalletRespVOList(List<PayWalletDO> list) {
        if ( list == null ) {
            return null;
        }

        List<PayWalletRespVO> list1 = new ArrayList<PayWalletRespVO>( list.size() );
        for ( PayWalletDO payWalletDO : list ) {
            list1.add( payWalletDOToPayWalletRespVO( payWalletDO ) );
        }

        return list1;
    }
}
