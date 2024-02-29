package cn.shuchan.module.member.convert.level;

import cn.shuchan.framework.common.pojo.PageResult;
import cn.shuchan.module.member.controller.admin.level.vo.experience.MemberExperienceRecordRespVO;
import cn.shuchan.module.member.controller.app.level.vo.experience.AppMemberExperienceRecordRespVO;
import cn.shuchan.module.member.dal.dataobject.level.MemberExperienceRecordDO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-28T20:02:59+0800",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 1.8.0_401 (Oracle Corporation)"
)
public class MemberExperienceRecordConvertImpl implements MemberExperienceRecordConvert {

    @Override
    public MemberExperienceRecordRespVO convert(MemberExperienceRecordDO bean) {
        if ( bean == null ) {
            return null;
        }

        MemberExperienceRecordRespVO memberExperienceRecordRespVO = new MemberExperienceRecordRespVO();

        memberExperienceRecordRespVO.setUserId( bean.getUserId() );
        memberExperienceRecordRespVO.setBizId( bean.getBizId() );
        memberExperienceRecordRespVO.setBizType( bean.getBizType() );
        memberExperienceRecordRespVO.setTitle( bean.getTitle() );
        memberExperienceRecordRespVO.setExperience( bean.getExperience() );
        memberExperienceRecordRespVO.setTotalExperience( bean.getTotalExperience() );
        memberExperienceRecordRespVO.setDescription( bean.getDescription() );
        memberExperienceRecordRespVO.setId( bean.getId() );
        memberExperienceRecordRespVO.setCreateTime( bean.getCreateTime() );

        return memberExperienceRecordRespVO;
    }

    @Override
    public List<MemberExperienceRecordRespVO> convertList(List<MemberExperienceRecordDO> list) {
        if ( list == null ) {
            return null;
        }

        List<MemberExperienceRecordRespVO> list1 = new ArrayList<MemberExperienceRecordRespVO>( list.size() );
        for ( MemberExperienceRecordDO memberExperienceRecordDO : list ) {
            list1.add( convert( memberExperienceRecordDO ) );
        }

        return list1;
    }

    @Override
    public PageResult<MemberExperienceRecordRespVO> convertPage(PageResult<MemberExperienceRecordDO> page) {
        if ( page == null ) {
            return null;
        }

        PageResult<MemberExperienceRecordRespVO> pageResult = new PageResult<MemberExperienceRecordRespVO>();

        pageResult.setList( convertList( page.getList() ) );
        pageResult.setTotal( page.getTotal() );

        return pageResult;
    }

    @Override
    public MemberExperienceRecordDO convert(Long userId, Integer experience, Integer totalExperience, String bizId, Integer bizType, String title, String description) {
        if ( userId == null && experience == null && totalExperience == null && bizId == null && bizType == null && title == null && description == null ) {
            return null;
        }

        MemberExperienceRecordDO.MemberExperienceRecordDOBuilder memberExperienceRecordDO = MemberExperienceRecordDO.builder();

        memberExperienceRecordDO.userId( userId );
        memberExperienceRecordDO.experience( experience );
        memberExperienceRecordDO.totalExperience( totalExperience );
        memberExperienceRecordDO.bizId( bizId );
        memberExperienceRecordDO.bizType( bizType );
        memberExperienceRecordDO.title( title );
        memberExperienceRecordDO.description( description );

        return memberExperienceRecordDO.build();
    }

    @Override
    public PageResult<AppMemberExperienceRecordRespVO> convertPage02(PageResult<MemberExperienceRecordDO> page) {
        if ( page == null ) {
            return null;
        }

        PageResult<AppMemberExperienceRecordRespVO> pageResult = new PageResult<AppMemberExperienceRecordRespVO>();

        pageResult.setList( memberExperienceRecordDOListToAppMemberExperienceRecordRespVOList( page.getList() ) );
        pageResult.setTotal( page.getTotal() );

        return pageResult;
    }

    protected AppMemberExperienceRecordRespVO memberExperienceRecordDOToAppMemberExperienceRecordRespVO(MemberExperienceRecordDO memberExperienceRecordDO) {
        if ( memberExperienceRecordDO == null ) {
            return null;
        }

        AppMemberExperienceRecordRespVO appMemberExperienceRecordRespVO = new AppMemberExperienceRecordRespVO();

        appMemberExperienceRecordRespVO.setTitle( memberExperienceRecordDO.getTitle() );
        appMemberExperienceRecordRespVO.setExperience( memberExperienceRecordDO.getExperience() );
        appMemberExperienceRecordRespVO.setDescription( memberExperienceRecordDO.getDescription() );
        appMemberExperienceRecordRespVO.setCreateTime( memberExperienceRecordDO.getCreateTime() );

        return appMemberExperienceRecordRespVO;
    }

    protected List<AppMemberExperienceRecordRespVO> memberExperienceRecordDOListToAppMemberExperienceRecordRespVOList(List<MemberExperienceRecordDO> list) {
        if ( list == null ) {
            return null;
        }

        List<AppMemberExperienceRecordRespVO> list1 = new ArrayList<AppMemberExperienceRecordRespVO>( list.size() );
        for ( MemberExperienceRecordDO memberExperienceRecordDO : list ) {
            list1.add( memberExperienceRecordDOToAppMemberExperienceRecordRespVO( memberExperienceRecordDO ) );
        }

        return list1;
    }
}
