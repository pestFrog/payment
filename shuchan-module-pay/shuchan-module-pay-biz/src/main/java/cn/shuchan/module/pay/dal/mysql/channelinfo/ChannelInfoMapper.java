package cn.shuchan.module.pay.dal.mysql.channelinfo;

import java.util.*;

import cn.shuchan.framework.common.pojo.PageResult;
import cn.shuchan.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.shuchan.framework.mybatis.core.mapper.BaseMapperX;
import cn.shuchan.module.pay.dal.dataobject.channelinfo.ChannelInfoDO;
import org.apache.ibatis.annotations.Mapper;
import cn.shuchan.module.pay.controller.admin.channelinfo.vo.*;

/**
 * 支付渠道 Mapper
 *
 * @author 支付系统system
 */
@Mapper
public interface ChannelInfoMapper extends BaseMapperX<ChannelInfoDO> {

    default PageResult<ChannelInfoDO> selectPage(ChannelInfoPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ChannelInfoDO>()
                .eqIfPresent(ChannelInfoDO::getChannelNo, reqVO.getChannelNo())
                .likeIfPresent(ChannelInfoDO::getChannelName, reqVO.getChannelName())
                .eqIfPresent(ChannelInfoDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(ChannelInfoDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(ChannelInfoDO::getCreateTime));
    }

}
