package cn.shuchan.module.pay.service.merchant;

import java.util.*;
import javax.validation.*;
import cn.shuchan.module.pay.controller.admin.merchant.vo.*;
import cn.shuchan.module.pay.dal.dataobject.merchant.MerchantDO;
import cn.shuchan.framework.common.pojo.PageResult;
import cn.shuchan.framework.common.pojo.PageParam;

/**
 * 商户 Service 接口
 *
 * @author 支付系统system
 */
public interface MerchantService {

    /**
     * 创建商户
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    String createMerchant(@Valid MerchantSaveReqVO createReqVO);

    /**
     * 更新商户
     *
     * @param updateReqVO 更新信息
     */
    void updateMerchant(@Valid MerchantSaveReqVO updateReqVO);

    /**
     * 删除商户
     *
     * @param id 编号
     */
    void deleteMerchant(String id);

    /**
     * 获得商户
     *
     * @param id 编号
     * @return 商户
     */
    MerchantDO getMerchant(String id);

    /**
     * 获得商户分页
     *
     * @param pageReqVO 分页查询
     * @return 商户分页
     */
    PageResult<MerchantDO> getMerchantPage(MerchantPageReqVO pageReqVO);

}