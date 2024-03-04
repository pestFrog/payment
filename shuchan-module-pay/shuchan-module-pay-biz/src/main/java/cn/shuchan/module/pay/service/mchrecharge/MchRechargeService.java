package cn.shuchan.module.pay.service.mchrecharge;

import java.io.InputStream;
import java.util.*;
import javax.validation.*;

import cn.hutool.core.io.IoUtil;
import cn.shuchan.module.pay.controller.admin.mchrecharge.vo.*;
import cn.shuchan.module.pay.dal.dataobject.mchrecharge.MchRechargeDO;
import cn.shuchan.framework.common.pojo.PageResult;
import cn.shuchan.framework.common.pojo.PageParam;

/**
 * 商户充值记录 Service 接口
 *
 * @author 支付系统system
 */
public interface MchRechargeService {

    /**
     * 创建商户充值记录
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createMchRecharge(@Valid MchRechargeSaveReqVO createReqVO);

    /**
     * 更新商户充值记录
     *
     * @param updateReqVO 更新信息
     */
    void updateMchRecharge(@Valid MchRechargeSaveReqVO updateReqVO);

    /**
     * 删除商户充值记录
     *
     * @param id 编号
     */
    void deleteMchRecharge(Long id);

    /**
     * 获得商户充值记录
     *
     * @param id 编号
     * @return 商户充值记录
     */
    MchRechargeDO getMchRecharge(Long id);

    /**
     * 获得商户充值记录分页
     *
     * @param pageReqVO 分页查询
     * @return 商户充值记录分页
     */
    PageResult<MchRechargeDO> getMchRechargePage(MchRechargePageReqVO pageReqVO);

    String getVoucher(InputStream file);

}
