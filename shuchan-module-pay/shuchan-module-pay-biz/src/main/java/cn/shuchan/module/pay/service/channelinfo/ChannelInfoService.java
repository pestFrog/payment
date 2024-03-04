package cn.shuchan.module.pay.service.channelinfo;

import java.util.*;
import javax.validation.*;
import cn.shuchan.module.pay.controller.admin.channelinfo.vo.*;
import cn.shuchan.module.pay.dal.dataobject.channelinfo.ChannelInfoDO;
import cn.shuchan.framework.common.pojo.PageResult;
import cn.shuchan.framework.common.pojo.PageParam;

/**
 * 支付渠道 Service 接口
 *
 * @author 支付系统system
 */
public interface ChannelInfoService {

    /**
     * 创建支付渠道
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    String createChannelInfo(@Valid ChannelInfoSaveReqVO createReqVO);

    /**
     * 更新支付渠道
     *
     * @param updateReqVO 更新信息
     */
    void updateChannelInfo(@Valid ChannelInfoSaveReqVO updateReqVO);

    /**
     * 删除支付渠道
     *
     * @param id 编号
     */
    void deleteChannelInfo(String id);

    /**
     * 获得支付渠道
     *
     * @param id 编号
     * @return 支付渠道
     */
    ChannelInfoDO getChannelInfo(String id);

    /**
     * 获得支付渠道分页
     *
     * @param pageReqVO 分页查询
     * @return 支付渠道分页
     */
    PageResult<ChannelInfoDO> getChannelInfoPage(ChannelInfoPageReqVO pageReqVO);

}