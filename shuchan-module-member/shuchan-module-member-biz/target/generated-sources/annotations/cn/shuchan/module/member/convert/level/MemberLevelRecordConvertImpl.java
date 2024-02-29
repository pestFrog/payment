package cn.shuchan.module.member.convert.level;

import cn.shuchan.framework.common.pojo.PageResult;
import cn.shuchan.module.member.controller.admin.level.vo.record.MemberLevelRecordRespVO;
import cn.shuchan.module.member.dal.dataobject.level.MemberLevelRecordDO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-28T20:02:59+0800",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 1.8.0_401 (Oracle Corporation)"
)
public class MemberLevelRecordConvertImpl implements MemberLevelRecordConvert {

    @Override
    public MemberLevelRecordRespVO convert(MemberLevelRecordDO bean) {
        if ( bean == null ) {
            return null;
        }

        MemberLevelRecordRespVO memberLevelRecordRespVO = new MemberLevelRecordRespVO();

        memberLevelRecordRespVO.setUserId( bean.getUserId() );
        memberLevelRecordRespVO.setLevelId( bean.getLevelId() );
        memberLevelRecordRespVO.setLevel( bean.getLevel() );
        memberLevelRecordRespVO.setDiscountPercent( bean.getDiscountPercent() );
        memberLevelRecordRespVO.setExperience( bean.getExperience() );
        memberLevelRecordRespVO.setUserExperience( bean.getUserExperience() );
        memberLevelRecordRespVO.setRemark( bean.getRemark() );
        memberLevelRecordRespVO.setDescription( bean.getDescription() );
        memberLevelRecordRespVO.setId( bean.getId() );
        memberLevelRecordRespVO.setCreateTime( bean.getCreateTime() );

        return memberLevelRecordRespVO;
    }

    @Override
    public List<MemberLevelRecordRespVO> convertList(List<MemberLevelRecordDO> list) {
        if ( list == null ) {
            return null;
        }

        List<MemberLevelRecordRespVO> list1 = new ArrayList<MemberLevelRecordRespVO>( list.size() );
        for ( MemberLevelRecordDO memberLevelRecordDO : list ) {
            list1.add( convert( memberLevelRecordDO ) );
        }

        return list1;
    }

    @Override
    public PageResult<MemberLevelRecordRespVO> convertPage(PageResult<MemberLevelRecordDO> page) {
        if ( page == null ) {
            return null;
        }

        PageResult<MemberLevelRecordRespVO> pageResult = new PageResult<MemberLevelRecordRespVO>();

        pageResult.setList( convertList( page.getList() ) );
        pageResult.setTotal( page.getTotal() );

        return pageResult;
    }
}
