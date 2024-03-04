package cn.shuchan.module.pay.dal.mysql.mchrecharge;

import java.util.*;

import cn.shuchan.framework.common.pojo.PageResult;
import cn.shuchan.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.shuchan.framework.mybatis.core.mapper.BaseMapperX;
import cn.shuchan.module.pay.dal.dataobject.mchrecharge.MchRechargeDO;
import org.apache.ibatis.annotations.Mapper;
import cn.shuchan.module.pay.controller.admin.mchrecharge.vo.*;

/**
 * 商户充值记录 Mapper
 *
 * @author 支付系统system
 */
@Mapper
public interface MchRechargeMapper extends BaseMapperX<MchRechargeDO> {

    default PageResult<MchRechargeDO> selectPage(MchRechargePageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<MchRechargeDO>()
                .eqIfPresent(MchRechargeDO::getMchNo, reqVO.getMchNo())
                .likeIfPresent(MchRechargeDO::getMchName, reqVO.getMchName())
                .betweenIfPresent(MchRechargeDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(MchRechargeDO::getId));
    }

}