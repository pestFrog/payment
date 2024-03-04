package cn.shuchan.module.pay.service.mchrecharge;

import cn.hutool.core.io.IoUtil;
import cn.shuchan.module.infra.api.file.FileApi;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.io.InputStream;
import java.util.*;
import cn.shuchan.module.pay.controller.admin.mchrecharge.vo.*;
import cn.shuchan.module.pay.dal.dataobject.mchrecharge.MchRechargeDO;
import cn.shuchan.framework.common.pojo.PageResult;
import cn.shuchan.framework.common.pojo.PageParam;
import cn.shuchan.framework.common.util.object.BeanUtils;

import cn.shuchan.module.pay.dal.mysql.mchrecharge.MchRechargeMapper;

import static cn.shuchan.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.shuchan.module.pay.enums.ErrorCodeConstants.*;

/**
 * 商户充值记录 Service 实现类
 *
 * @author 支付系统system
 */
@Service
@Validated
public class MchRechargeServiceImpl implements MchRechargeService {

    @Resource
    private MchRechargeMapper mchRechargeMapper;

    @Resource
    private FileApi fileApi;

    @Override
    public Long createMchRecharge(MchRechargeSaveReqVO createReqVO) {
        // 插入
        MchRechargeDO mchRecharge = BeanUtils.toBean(createReqVO, MchRechargeDO.class);
        mchRechargeMapper.insert(mchRecharge);
        // 返回
        return mchRecharge.getId();
    }

    @Override
    public void updateMchRecharge(MchRechargeSaveReqVO updateReqVO) {
        // 校验存在
        validateMchRechargeExists(updateReqVO.getId());
        // 更新
        MchRechargeDO updateObj = BeanUtils.toBean(updateReqVO, MchRechargeDO.class);
        mchRechargeMapper.updateById(updateObj);
    }

    @Override
    public void deleteMchRecharge(Long id) {
        // 校验存在
        validateMchRechargeExists(id);
        // 删除
        mchRechargeMapper.deleteById(id);
    }

    private void validateMchRechargeExists(Long id) {
        if (mchRechargeMapper.selectById(id) == null) {
            throw exception(MCH_RECHARGE_NOT_EXISTS);
        }
    }

    @Override
    public MchRechargeDO getMchRecharge(Long id) {
        return mchRechargeMapper.selectById(id);
    }

    @Override
    public PageResult<MchRechargeDO> getMchRechargePage(MchRechargePageReqVO pageReqVO) {
        return mchRechargeMapper.selectPage(pageReqVO);
    }

    @Override
    public String getVoucher(InputStream file) {
        return fileApi.createFile(IoUtil.readBytes(file));
    }

}
