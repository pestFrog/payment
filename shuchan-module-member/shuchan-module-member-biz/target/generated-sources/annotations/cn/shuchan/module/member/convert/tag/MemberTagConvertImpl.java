package cn.shuchan.module.member.convert.tag;

import cn.shuchan.framework.common.pojo.PageResult;
import cn.shuchan.module.member.controller.admin.tag.vo.MemberTagCreateReqVO;
import cn.shuchan.module.member.controller.admin.tag.vo.MemberTagRespVO;
import cn.shuchan.module.member.controller.admin.tag.vo.MemberTagUpdateReqVO;
import cn.shuchan.module.member.dal.dataobject.tag.MemberTagDO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-28T20:02:59+0800",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 1.8.0_401 (Oracle Corporation)"
)
public class MemberTagConvertImpl implements MemberTagConvert {

    @Override
    public MemberTagDO convert(MemberTagCreateReqVO bean) {
        if ( bean == null ) {
            return null;
        }

        MemberTagDO.MemberTagDOBuilder memberTagDO = MemberTagDO.builder();

        memberTagDO.name( bean.getName() );

        return memberTagDO.build();
    }

    @Override
    public MemberTagDO convert(MemberTagUpdateReqVO bean) {
        if ( bean == null ) {
            return null;
        }

        MemberTagDO.MemberTagDOBuilder memberTagDO = MemberTagDO.builder();

        memberTagDO.id( bean.getId() );
        memberTagDO.name( bean.getName() );

        return memberTagDO.build();
    }

    @Override
    public MemberTagRespVO convert(MemberTagDO bean) {
        if ( bean == null ) {
            return null;
        }

        MemberTagRespVO memberTagRespVO = new MemberTagRespVO();

        memberTagRespVO.setName( bean.getName() );
        memberTagRespVO.setId( bean.getId() );
        memberTagRespVO.setCreateTime( bean.getCreateTime() );

        return memberTagRespVO;
    }

    @Override
    public List<MemberTagRespVO> convertList(List<MemberTagDO> list) {
        if ( list == null ) {
            return null;
        }

        List<MemberTagRespVO> list1 = new ArrayList<MemberTagRespVO>( list.size() );
        for ( MemberTagDO memberTagDO : list ) {
            list1.add( convert( memberTagDO ) );
        }

        return list1;
    }

    @Override
    public PageResult<MemberTagRespVO> convertPage(PageResult<MemberTagDO> page) {
        if ( page == null ) {
            return null;
        }

        PageResult<MemberTagRespVO> pageResult = new PageResult<MemberTagRespVO>();

        pageResult.setList( convertList( page.getList() ) );
        pageResult.setTotal( page.getTotal() );

        return pageResult;
    }
}
