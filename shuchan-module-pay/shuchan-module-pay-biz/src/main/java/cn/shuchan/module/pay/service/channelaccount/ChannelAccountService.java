package cn.shuchan.module.pay.service.channelaccount;

import java.util.*;
import javax.validation.*;
import cn.shuchan.module.pay.controller.admin.channelaccount.vo.*;
import cn.shuchan.module.pay.dal.dataobject.channelaccount.ChannelAccountDO;
import cn.shuchan.framework.common.pojo.PageResult;
import cn.shuchan.framework.common.pojo.PageParam;

/**
 * 支付渠道账户 Service 接口
 *
 * @author 支付系统system
 */
public interface ChannelAccountService {

    /**
     * 创建支付渠道账户
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Integer createChannelAccount(@Valid ChannelAccountSaveReqVO createReqVO);

    /**
     * 更新支付渠道账户
     *
     * @param updateReqVO 更新信息
     */
    void updateChannelAccount(@Valid ChannelAccountSaveReqVO updateReqVO);

    /**
     * 删除支付渠道账户
     *
     * @param id 编号
     */
    void deleteChannelAccount(Integer id);

    /**
     * 获得支付渠道账户
     *
     * @param id 编号
     * @return 支付渠道账户
     */
    ChannelAccountDO getChannelAccount(Integer id);

    /**
     * 获得支付渠道账户分页
     *
     * @param pageReqVO 分页查询
     * @return 支付渠道账户分页
     */
    PageResult<ChannelAccountDO> getChannelAccountPage(ChannelAccountPageReqVO pageReqVO);

}