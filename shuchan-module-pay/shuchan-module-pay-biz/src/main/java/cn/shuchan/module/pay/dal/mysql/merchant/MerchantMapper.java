package cn.shuchan.module.pay.dal.mysql.merchant;

import java.util.*;

import cn.shuchan.framework.common.pojo.PageResult;
import cn.shuchan.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.shuchan.framework.mybatis.core.mapper.BaseMapperX;
import cn.shuchan.module.pay.dal.dataobject.merchant.MerchantDO;
import org.apache.ibatis.annotations.Mapper;
import cn.shuchan.module.pay.controller.admin.merchant.vo.*;

/**
 * 商户 Mapper
 *
 * @author 支付系统system
 */
@Mapper
public interface MerchantMapper extends BaseMapperX<MerchantDO> {

    default PageResult<MerchantDO> selectPage(MerchantPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<MerchantDO>()
                .eqIfPresent(MerchantDO::getMerchantId, reqVO.getMerchantId())
                .likeIfPresent(MerchantDO::getName, reqVO.getName())
                .likeIfPresent(MerchantDO::getContactName, reqVO.getContactName())
                .eqIfPresent(MerchantDO::getContactTel, reqVO.getContactTel())
                .eqIfPresent(MerchantDO::getContactEmail, reqVO.getContactEmail())
                .eqIfPresent(MerchantDO::getServerIp, reqVO.getServerIp())
                .eqIfPresent(MerchantDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(MerchantDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(MerchantDO::getMerchantId));
    }

}
