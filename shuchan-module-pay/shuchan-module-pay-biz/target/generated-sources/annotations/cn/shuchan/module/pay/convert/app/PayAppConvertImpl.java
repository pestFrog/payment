package cn.shuchan.module.pay.convert.app;

import cn.shuchan.framework.common.pojo.PageResult;
import cn.shuchan.module.pay.controller.admin.app.vo.PayAppCreateReqVO;
import cn.shuchan.module.pay.controller.admin.app.vo.PayAppPageItemRespVO;
import cn.shuchan.module.pay.controller.admin.app.vo.PayAppRespVO;
import cn.shuchan.module.pay.controller.admin.app.vo.PayAppUpdateReqVO;
import cn.shuchan.module.pay.dal.dataobject.app.PayAppDO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-28T20:02:51+0800",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 1.8.0_401 (Oracle Corporation)"
)
public class PayAppConvertImpl implements PayAppConvert {

    @Override
    public PayAppPageItemRespVO pageConvert(PayAppDO bean) {
        if ( bean == null ) {
            return null;
        }

        PayAppPageItemRespVO payAppPageItemRespVO = new PayAppPageItemRespVO();

        payAppPageItemRespVO.setName( bean.getName() );
        payAppPageItemRespVO.setStatus( bean.getStatus() );
        payAppPageItemRespVO.setRemark( bean.getRemark() );
        payAppPageItemRespVO.setOrderNotifyUrl( bean.getOrderNotifyUrl() );
        payAppPageItemRespVO.setRefundNotifyUrl( bean.getRefundNotifyUrl() );
        payAppPageItemRespVO.setId( bean.getId() );
        payAppPageItemRespVO.setCreateTime( bean.getCreateTime() );

        return payAppPageItemRespVO;
    }

    @Override
    public PayAppDO convert(PayAppCreateReqVO bean) {
        if ( bean == null ) {
            return null;
        }

        PayAppDO.PayAppDOBuilder payAppDO = PayAppDO.builder();

        payAppDO.name( bean.getName() );
        payAppDO.status( bean.getStatus() );
        payAppDO.remark( bean.getRemark() );
        payAppDO.orderNotifyUrl( bean.getOrderNotifyUrl() );
        payAppDO.refundNotifyUrl( bean.getRefundNotifyUrl() );

        return payAppDO.build();
    }

    @Override
    public PayAppDO convert(PayAppUpdateReqVO bean) {
        if ( bean == null ) {
            return null;
        }

        PayAppDO.PayAppDOBuilder payAppDO = PayAppDO.builder();

        payAppDO.id( bean.getId() );
        payAppDO.name( bean.getName() );
        payAppDO.status( bean.getStatus() );
        payAppDO.remark( bean.getRemark() );
        payAppDO.orderNotifyUrl( bean.getOrderNotifyUrl() );
        payAppDO.refundNotifyUrl( bean.getRefundNotifyUrl() );

        return payAppDO.build();
    }

    @Override
    public PayAppRespVO convert(PayAppDO bean) {
        if ( bean == null ) {
            return null;
        }

        PayAppRespVO payAppRespVO = new PayAppRespVO();

        payAppRespVO.setName( bean.getName() );
        payAppRespVO.setStatus( bean.getStatus() );
        payAppRespVO.setRemark( bean.getRemark() );
        payAppRespVO.setOrderNotifyUrl( bean.getOrderNotifyUrl() );
        payAppRespVO.setRefundNotifyUrl( bean.getRefundNotifyUrl() );
        payAppRespVO.setId( bean.getId() );
        payAppRespVO.setCreateTime( bean.getCreateTime() );

        return payAppRespVO;
    }

    @Override
    public List<PayAppRespVO> convertList(List<PayAppDO> list) {
        if ( list == null ) {
            return null;
        }

        List<PayAppRespVO> list1 = new ArrayList<PayAppRespVO>( list.size() );
        for ( PayAppDO payAppDO : list ) {
            list1.add( convert( payAppDO ) );
        }

        return list1;
    }

    @Override
    public PageResult<PayAppPageItemRespVO> convertPage(PageResult<PayAppDO> page) {
        if ( page == null ) {
            return null;
        }

        PageResult<PayAppPageItemRespVO> pageResult = new PageResult<PayAppPageItemRespVO>();

        pageResult.setList( payAppDOListToPayAppPageItemRespVOList( page.getList() ) );
        pageResult.setTotal( page.getTotal() );

        return pageResult;
    }

    protected List<PayAppPageItemRespVO> payAppDOListToPayAppPageItemRespVOList(List<PayAppDO> list) {
        if ( list == null ) {
            return null;
        }

        List<PayAppPageItemRespVO> list1 = new ArrayList<PayAppPageItemRespVO>( list.size() );
        for ( PayAppDO payAppDO : list ) {
            list1.add( pageConvert( payAppDO ) );
        }

        return list1;
    }
}
