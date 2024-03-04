package cn.shuchan.module.pay.dal.mysql.channelaccount;

import java.util.*;

import cn.shuchan.framework.common.pojo.PageResult;
import cn.shuchan.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.shuchan.framework.mybatis.core.mapper.BaseMapperX;
import cn.shuchan.module.pay.dal.dataobject.channelaccount.ChannelAccountDO;
import org.apache.ibatis.annotations.Mapper;
import cn.shuchan.module.pay.controller.admin.channelaccount.vo.*;

/**
 * 支付渠道账户 Mapper
 *
 * @author 支付系统system
 */
@Mapper
public interface ChannelAccountMapper extends BaseMapperX<ChannelAccountDO> {

    default PageResult<ChannelAccountDO> selectPage(ChannelAccountPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ChannelAccountDO>()
                .eqIfPresent(ChannelAccountDO::getChannelCode, reqVO.getChannelCode())
                .likeIfPresent(ChannelAccountDO::getChannelName, reqVO.getChannelName())
                .eqIfPresent(ChannelAccountDO::getMchNo, reqVO.getMchNo())
                .eqIfPresent(ChannelAccountDO::getEncryKey, reqVO.getEncryKey())
                .eqIfPresent(ChannelAccountDO::getMchPrivateKey, reqVO.getMchPrivateKey())
                .eqIfPresent(ChannelAccountDO::getMchPublicKey, reqVO.getMchPublicKey())
                .eqIfPresent(ChannelAccountDO::getChannelPublicKey, reqVO.getChannelPublicKey())
                .eqIfPresent(ChannelAccountDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(ChannelAccountDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(ChannelAccountDO::getId));
    }

}
