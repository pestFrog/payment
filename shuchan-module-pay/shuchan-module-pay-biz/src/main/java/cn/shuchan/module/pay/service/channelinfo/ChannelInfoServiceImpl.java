package cn.shuchan.module.pay.service.channelinfo;

import cn.shuchan.framework.common.util.string.StrUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import cn.shuchan.module.pay.controller.admin.channelinfo.vo.*;
import cn.shuchan.module.pay.dal.dataobject.channelinfo.ChannelInfoDO;
import cn.shuchan.framework.common.pojo.PageResult;
import cn.shuchan.framework.common.pojo.PageParam;
import cn.shuchan.framework.common.util.object.BeanUtils;

import cn.shuchan.module.pay.dal.mysql.channelinfo.ChannelInfoMapper;

import static cn.shuchan.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.shuchan.module.pay.enums.ErrorCodeConstants.*;

/**
 * 支付渠道 Service 实现类
 *
 * @author 支付系统system
 */
@Service
@Validated
public class ChannelInfoServiceImpl implements ChannelInfoService {

    @Resource
    private ChannelInfoMapper channelInfoMapper;

    @Override
    public String createChannelInfo(ChannelInfoSaveReqVO createReqVO) {
        // 插入
        ChannelInfoDO channelInfo = BeanUtils.toBean(createReqVO, ChannelInfoDO.class);
        channelInfo.setChannelNo(StrUtils.getTransNo(10));
        channelInfoMapper.insert(channelInfo);
        // 返回
        return channelInfo.getChannelNo();
    }

    @Override
    public void updateChannelInfo(ChannelInfoSaveReqVO updateReqVO) {
        // 校验存在
        validateChannelInfoExists(updateReqVO.getChannelNo());
        // 更新
        ChannelInfoDO updateObj = BeanUtils.toBean(updateReqVO, ChannelInfoDO.class);

        channelInfoMapper.updateById(updateObj);
    }

    @Override
    public void deleteChannelInfo(String id) {
        // 校验存在
        validateChannelInfoExists(id);
        // 删除
        channelInfoMapper.deleteById(id);
    }

    private void validateChannelInfoExists(String id) {
        if (channelInfoMapper.selectById(id) == null) {
            throw exception(CHANNEL_INFO_NOT_EXISTS);
        }
    }

    @Override
    public ChannelInfoDO getChannelInfo(String id) {
        return channelInfoMapper.selectById(id);
    }

    @Override
    public PageResult<ChannelInfoDO> getChannelInfoPage(ChannelInfoPageReqVO pageReqVO) {
        return channelInfoMapper.selectPage(pageReqVO);
    }
}
