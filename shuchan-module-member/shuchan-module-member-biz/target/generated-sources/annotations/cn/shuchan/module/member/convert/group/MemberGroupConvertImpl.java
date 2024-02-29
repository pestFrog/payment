package cn.shuchan.module.member.convert.group;

import cn.shuchan.framework.common.pojo.PageResult;
import cn.shuchan.module.member.controller.admin.group.vo.MemberGroupCreateReqVO;
import cn.shuchan.module.member.controller.admin.group.vo.MemberGroupRespVO;
import cn.shuchan.module.member.controller.admin.group.vo.MemberGroupSimpleRespVO;
import cn.shuchan.module.member.controller.admin.group.vo.MemberGroupUpdateReqVO;
import cn.shuchan.module.member.dal.dataobject.group.MemberGroupDO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-28T20:02:59+0800",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 1.8.0_401 (Oracle Corporation)"
)
public class MemberGroupConvertImpl implements MemberGroupConvert {

    @Override
    public MemberGroupDO convert(MemberGroupCreateReqVO bean) {
        if ( bean == null ) {
            return null;
        }

        MemberGroupDO.MemberGroupDOBuilder memberGroupDO = MemberGroupDO.builder();

        memberGroupDO.name( bean.getName() );
        memberGroupDO.remark( bean.getRemark() );
        memberGroupDO.status( bean.getStatus() );

        return memberGroupDO.build();
    }

    @Override
    public MemberGroupDO convert(MemberGroupUpdateReqVO bean) {
        if ( bean == null ) {
            return null;
        }

        MemberGroupDO.MemberGroupDOBuilder memberGroupDO = MemberGroupDO.builder();

        memberGroupDO.id( bean.getId() );
        memberGroupDO.name( bean.getName() );
        memberGroupDO.remark( bean.getRemark() );
        memberGroupDO.status( bean.getStatus() );

        return memberGroupDO.build();
    }

    @Override
    public MemberGroupRespVO convert(MemberGroupDO bean) {
        if ( bean == null ) {
            return null;
        }

        MemberGroupRespVO memberGroupRespVO = new MemberGroupRespVO();

        memberGroupRespVO.setName( bean.getName() );
        memberGroupRespVO.setRemark( bean.getRemark() );
        memberGroupRespVO.setStatus( bean.getStatus() );
        memberGroupRespVO.setId( bean.getId() );
        memberGroupRespVO.setCreateTime( bean.getCreateTime() );

        return memberGroupRespVO;
    }

    @Override
    public List<MemberGroupRespVO> convertList(List<MemberGroupDO> list) {
        if ( list == null ) {
            return null;
        }

        List<MemberGroupRespVO> list1 = new ArrayList<MemberGroupRespVO>( list.size() );
        for ( MemberGroupDO memberGroupDO : list ) {
            list1.add( convert( memberGroupDO ) );
        }

        return list1;
    }

    @Override
    public PageResult<MemberGroupRespVO> convertPage(PageResult<MemberGroupDO> page) {
        if ( page == null ) {
            return null;
        }

        PageResult<MemberGroupRespVO> pageResult = new PageResult<MemberGroupRespVO>();

        pageResult.setList( convertList( page.getList() ) );
        pageResult.setTotal( page.getTotal() );

        return pageResult;
    }

    @Override
    public List<MemberGroupSimpleRespVO> convertSimpleList(List<MemberGroupDO> list) {
        if ( list == null ) {
            return null;
        }

        List<MemberGroupSimpleRespVO> list1 = new ArrayList<MemberGroupSimpleRespVO>( list.size() );
        for ( MemberGroupDO memberGroupDO : list ) {
            list1.add( memberGroupDOToMemberGroupSimpleRespVO( memberGroupDO ) );
        }

        return list1;
    }

    protected MemberGroupSimpleRespVO memberGroupDOToMemberGroupSimpleRespVO(MemberGroupDO memberGroupDO) {
        if ( memberGroupDO == null ) {
            return null;
        }

        MemberGroupSimpleRespVO memberGroupSimpleRespVO = new MemberGroupSimpleRespVO();

        memberGroupSimpleRespVO.setId( memberGroupDO.getId() );
        memberGroupSimpleRespVO.setName( memberGroupDO.getName() );

        return memberGroupSimpleRespVO;
    }
}
