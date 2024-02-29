package cn.shuchan.module.member.dal.mysql.level;

import cn.shuchan.framework.common.pojo.PageResult;
import cn.shuchan.framework.mybatis.core.mapper.BaseMapperX;
import cn.shuchan.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.shuchan.module.member.controller.admin.level.vo.record.MemberLevelRecordPageReqVO;
import cn.shuchan.module.member.dal.dataobject.level.MemberLevelRecordDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员等级记录 Mapper
 *
 * @author owen
 */
@Mapper
public interface MemberLevelRecordMapper extends BaseMapperX<MemberLevelRecordDO> {

    default PageResult<MemberLevelRecordDO> selectPage(MemberLevelRecordPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<MemberLevelRecordDO>()
                .eqIfPresent(MemberLevelRecordDO::getUserId, reqVO.getUserId())
                .eqIfPresent(MemberLevelRecordDO::getLevelId, reqVO.getLevelId())
                .betweenIfPresent(MemberLevelRecordDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(MemberLevelRecordDO::getId));
    }

}
