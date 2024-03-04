package cn.shuchan.module.pay.service.channelaccount;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import cn.shuchan.module.pay.controller.admin.channelaccount.vo.*;
import cn.shuchan.module.pay.dal.dataobject.channelaccount.ChannelAccountDO;
import cn.shuchan.framework.common.pojo.PageResult;
import cn.shuchan.framework.common.pojo.PageParam;
import cn.shuchan.framework.common.util.object.BeanUtils;

import cn.shuchan.module.pay.dal.mysql.channelaccount.ChannelAccountMapper;

import static cn.shuchan.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.shuchan.module.pay.enums.ErrorCodeConstants.*;

/**
 * 支付渠道账户 Service 实现类
 *
 * @author 支付系统system
 */
@Service
@Validated
public class ChannelAccountServiceImpl implements ChannelAccountService {

    @Resource
    private ChannelAccountMapper channelAccountMapper;

    @Override
    public Integer createChannelAccount(ChannelAccountSaveReqVO createReqVO) {
        // 插入
        ChannelAccountDO channelAccount = BeanUtils.toBean(createReqVO, ChannelAccountDO.class);
        channelAccountMapper.insert(channelAccount);
        // 返回
        return channelAccount.getId();
    }

    @Override
    public void updateChannelAccount(ChannelAccountSaveReqVO updateReqVO) {
        // 校验存在
        validateChannelAccountExists(updateReqVO.getId());
        // 更新
        ChannelAccountDO updateObj = BeanUtils.toBean(updateReqVO, ChannelAccountDO.class);
        channelAccountMapper.updateById(updateObj);
    }

    @Override
    public void deleteChannelAccount(Integer id) {
        // 校验存在
        validateChannelAccountExists(id);
        // 删除
        channelAccountMapper.deleteById(id);
    }

    private void validateChannelAccountExists(Integer id) {
        if (channelAccountMapper.selectById(id) == null) {
            throw exception(CHANNEL_ACCOUNT_NOT_EXISTS);
        }
    }

    @Override
    public ChannelAccountDO getChannelAccount(Integer id) {
        return channelAccountMapper.selectById(id);
    }

    @Override
    public PageResult<ChannelAccountDO> getChannelAccountPage(ChannelAccountPageReqVO pageReqVO) {
        return channelAccountMapper.selectPage(pageReqVO);
    }

}