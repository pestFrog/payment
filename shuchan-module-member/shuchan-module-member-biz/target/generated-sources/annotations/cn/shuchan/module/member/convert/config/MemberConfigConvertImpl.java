package cn.shuchan.module.member.convert.config;

import cn.shuchan.module.member.api.config.dto.MemberConfigRespDTO;
import cn.shuchan.module.member.controller.admin.config.vo.MemberConfigRespVO;
import cn.shuchan.module.member.controller.admin.config.vo.MemberConfigSaveReqVO;
import cn.shuchan.module.member.dal.dataobject.config.MemberConfigDO;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-28T20:02:59+0800",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 1.8.0_401 (Oracle Corporation)"
)
public class MemberConfigConvertImpl implements MemberConfigConvert {

    @Override
    public MemberConfigRespVO convert(MemberConfigDO bean) {
        if ( bean == null ) {
            return null;
        }

        MemberConfigRespVO memberConfigRespVO = new MemberConfigRespVO();

        memberConfigRespVO.setPointTradeDeductEnable( bean.getPointTradeDeductEnable() );
        memberConfigRespVO.setPointTradeDeductUnitPrice( bean.getPointTradeDeductUnitPrice() );
        memberConfigRespVO.setPointTradeDeductMaxPrice( bean.getPointTradeDeductMaxPrice() );
        memberConfigRespVO.setPointTradeGivePoint( bean.getPointTradeGivePoint() );
        memberConfigRespVO.setId( bean.getId() );

        return memberConfigRespVO;
    }

    @Override
    public MemberConfigDO convert(MemberConfigSaveReqVO bean) {
        if ( bean == null ) {
            return null;
        }

        MemberConfigDO.MemberConfigDOBuilder memberConfigDO = MemberConfigDO.builder();

        memberConfigDO.pointTradeDeductEnable( bean.getPointTradeDeductEnable() );
        memberConfigDO.pointTradeDeductUnitPrice( bean.getPointTradeDeductUnitPrice() );
        memberConfigDO.pointTradeDeductMaxPrice( bean.getPointTradeDeductMaxPrice() );
        memberConfigDO.pointTradeGivePoint( bean.getPointTradeGivePoint() );

        return memberConfigDO.build();
    }

    @Override
    public MemberConfigRespDTO convert01(MemberConfigDO config) {
        if ( config == null ) {
            return null;
        }

        MemberConfigRespDTO memberConfigRespDTO = new MemberConfigRespDTO();

        memberConfigRespDTO.setPointTradeDeductEnable( config.getPointTradeDeductEnable() );
        memberConfigRespDTO.setPointTradeDeductUnitPrice( config.getPointTradeDeductUnitPrice() );
        memberConfigRespDTO.setPointTradeDeductMaxPrice( config.getPointTradeDeductMaxPrice() );
        memberConfigRespDTO.setPointTradeGivePoint( config.getPointTradeGivePoint() );

        return memberConfigRespDTO;
    }
}
