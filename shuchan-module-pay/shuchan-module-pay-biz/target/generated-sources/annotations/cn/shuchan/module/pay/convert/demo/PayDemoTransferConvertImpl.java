package cn.shuchan.module.pay.convert.demo;

import cn.shuchan.framework.common.pojo.PageResult;
import cn.shuchan.module.pay.controller.admin.demo.vo.transfer.PayDemoTransferCreateReqVO;
import cn.shuchan.module.pay.controller.admin.demo.vo.transfer.PayDemoTransferRespVO;
import cn.shuchan.module.pay.dal.dataobject.demo.PayDemoTransferDO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-28T20:02:51+0800",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 1.8.0_401 (Oracle Corporation)"
)
public class PayDemoTransferConvertImpl implements PayDemoTransferConvert {

    @Override
    public PayDemoTransferDO convert(PayDemoTransferCreateReqVO bean) {
        if ( bean == null ) {
            return null;
        }

        PayDemoTransferDO payDemoTransferDO = new PayDemoTransferDO();

        payDemoTransferDO.setType( bean.getType() );
        payDemoTransferDO.setPrice( bean.getPrice() );
        payDemoTransferDO.setUserName( bean.getUserName() );
        payDemoTransferDO.setAlipayLogonId( bean.getAlipayLogonId() );
        payDemoTransferDO.setOpenid( bean.getOpenid() );

        return payDemoTransferDO;
    }

    @Override
    public PageResult<PayDemoTransferRespVO> convertPage(PageResult<PayDemoTransferDO> pageResult) {
        if ( pageResult == null ) {
            return null;
        }

        PageResult<PayDemoTransferRespVO> pageResult1 = new PageResult<PayDemoTransferRespVO>();

        pageResult1.setList( payDemoTransferDOListToPayDemoTransferRespVOList( pageResult.getList() ) );
        pageResult1.setTotal( pageResult.getTotal() );

        return pageResult1;
    }

    protected PayDemoTransferRespVO payDemoTransferDOToPayDemoTransferRespVO(PayDemoTransferDO payDemoTransferDO) {
        if ( payDemoTransferDO == null ) {
            return null;
        }

        PayDemoTransferRespVO payDemoTransferRespVO = new PayDemoTransferRespVO();

        payDemoTransferRespVO.setId( payDemoTransferDO.getId() );
        payDemoTransferRespVO.setAppId( payDemoTransferDO.getAppId() );
        payDemoTransferRespVO.setPrice( payDemoTransferDO.getPrice() );
        payDemoTransferRespVO.setType( payDemoTransferDO.getType() );
        payDemoTransferRespVO.setUserName( payDemoTransferDO.getUserName() );
        payDemoTransferRespVO.setAlipayLogonId( payDemoTransferDO.getAlipayLogonId() );
        payDemoTransferRespVO.setOpenid( payDemoTransferDO.getOpenid() );
        payDemoTransferRespVO.setTransferStatus( payDemoTransferDO.getTransferStatus() );
        payDemoTransferRespVO.setPayTransferId( payDemoTransferDO.getPayTransferId() );
        payDemoTransferRespVO.setPayChannelCode( payDemoTransferDO.getPayChannelCode() );
        payDemoTransferRespVO.setTransferTime( payDemoTransferDO.getTransferTime() );

        return payDemoTransferRespVO;
    }

    protected List<PayDemoTransferRespVO> payDemoTransferDOListToPayDemoTransferRespVOList(List<PayDemoTransferDO> list) {
        if ( list == null ) {
            return null;
        }

        List<PayDemoTransferRespVO> list1 = new ArrayList<PayDemoTransferRespVO>( list.size() );
        for ( PayDemoTransferDO payDemoTransferDO : list ) {
            list1.add( payDemoTransferDOToPayDemoTransferRespVO( payDemoTransferDO ) );
        }

        return list1;
    }
}
