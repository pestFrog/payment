package cn.shuchan.module.pay.service.channelaccount;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.annotation.Resource;

import cn.shuchan.framework.test.core.ut.BaseDbUnitTest;

import cn.shuchan.module.pay.controller.admin.channelaccount.vo.*;
import cn.shuchan.module.pay.dal.dataobject.channelaccount.ChannelAccountDO;
import cn.shuchan.module.pay.dal.mysql.channelaccount.ChannelAccountMapper;
import cn.shuchan.framework.common.pojo.PageResult;

import javax.annotation.Resource;
import org.springframework.context.annotation.Import;
import java.util.*;
import java.time.LocalDateTime;

import static cn.hutool.core.util.RandomUtil.*;
import static cn.shuchan.module.pay.enums.ErrorCodeConstants.*;
import static cn.shuchan.framework.test.core.util.AssertUtils.*;
import static cn.shuchan.framework.test.core.util.RandomUtils.*;
import static cn.shuchan.framework.common.util.date.LocalDateTimeUtils.*;
import static cn.shuchan.framework.common.util.object.ObjectUtils.*;
import static cn.shuchan.framework.common.util.date.DateUtils.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * {@link ChannelAccountServiceImpl} 的单元测试类
 *
 * @author 支付系统system
 */
@Import(ChannelAccountServiceImpl.class)
public class ChannelAccountServiceImplTest extends BaseDbUnitTest {

    @Resource
    private ChannelAccountServiceImpl channelAccountService;

    @Resource
    private ChannelAccountMapper channelAccountMapper;

    @Test
    public void testCreateChannelAccount_success() {
        // 准备参数
        ChannelAccountSaveReqVO createReqVO = randomPojo(ChannelAccountSaveReqVO.class).setId(null);

        // 调用
        Integer channelAccountId = channelAccountService.createChannelAccount(createReqVO);
        // 断言
        assertNotNull(channelAccountId);
        // 校验记录的属性是否正确
        ChannelAccountDO channelAccount = channelAccountMapper.selectById(channelAccountId);
        assertPojoEquals(createReqVO, channelAccount, "id");
    }

    @Test
    public void testUpdateChannelAccount_success() {
        // mock 数据
        ChannelAccountDO dbChannelAccount = randomPojo(ChannelAccountDO.class);
        channelAccountMapper.insert(dbChannelAccount);// @Sql: 先插入出一条存在的数据
        // 准备参数
        ChannelAccountSaveReqVO updateReqVO = randomPojo(ChannelAccountSaveReqVO.class, o -> {
            o.setId(dbChannelAccount.getId()); // 设置更新的 ID
        });

        // 调用
        channelAccountService.updateChannelAccount(updateReqVO);
        // 校验是否更新正确
        ChannelAccountDO channelAccount = channelAccountMapper.selectById(updateReqVO.getId()); // 获取最新的
        assertPojoEquals(updateReqVO, channelAccount);
    }

    @Test
    public void testUpdateChannelAccount_notExists() {
        // 准备参数
        ChannelAccountSaveReqVO updateReqVO = randomPojo(ChannelAccountSaveReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> channelAccountService.updateChannelAccount(updateReqVO), CHANNEL_ACCOUNT_NOT_EXISTS);
    }

    @Test
    public void testDeleteChannelAccount_success() {
        // mock 数据
        ChannelAccountDO dbChannelAccount = randomPojo(ChannelAccountDO.class);
        channelAccountMapper.insert(dbChannelAccount);// @Sql: 先插入出一条存在的数据
        // 准备参数
        Integer id = dbChannelAccount.getId();

        // 调用
        channelAccountService.deleteChannelAccount(id);
       // 校验数据不存在了
       assertNull(channelAccountMapper.selectById(id));
    }

    @Test
    public void testDeleteChannelAccount_notExists() {
        // 准备参数
        Integer id = randomIntegerId();

        // 调用, 并断言异常
        assertServiceException(() -> channelAccountService.deleteChannelAccount(id), CHANNEL_ACCOUNT_NOT_EXISTS);
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetChannelAccountPage() {
       // mock 数据
       ChannelAccountDO dbChannelAccount = randomPojo(ChannelAccountDO.class, o -> { // 等会查询到
           o.setChannelCode(null);
           o.setChannelName(null);
           o.setMchNo(null);
           o.setKey(null);
           o.setMchPrivateKey(null);
           o.setMchPublicKey(null);
           o.setChannelPublicKey(null);
           o.setStatus(null);
           o.setCreateTime(null);
       });
       channelAccountMapper.insert(dbChannelAccount);
       // 测试 channelCode 不匹配
       channelAccountMapper.insert(cloneIgnoreId(dbChannelAccount, o -> o.setChannelCode(null)));
       // 测试 channelName 不匹配
       channelAccountMapper.insert(cloneIgnoreId(dbChannelAccount, o -> o.setChannelName(null)));
       // 测试 mchNo 不匹配
       channelAccountMapper.insert(cloneIgnoreId(dbChannelAccount, o -> o.setMchNo(null)));
       // 测试 key 不匹配
       channelAccountMapper.insert(cloneIgnoreId(dbChannelAccount, o -> o.setKey(null)));
       // 测试 mchPrivateKey 不匹配
       channelAccountMapper.insert(cloneIgnoreId(dbChannelAccount, o -> o.setMchPrivateKey(null)));
       // 测试 mchPublicKey 不匹配
       channelAccountMapper.insert(cloneIgnoreId(dbChannelAccount, o -> o.setMchPublicKey(null)));
       // 测试 channelPublicKey 不匹配
       channelAccountMapper.insert(cloneIgnoreId(dbChannelAccount, o -> o.setChannelPublicKey(null)));
       // 测试 status 不匹配
       channelAccountMapper.insert(cloneIgnoreId(dbChannelAccount, o -> o.setStatus(null)));
       // 测试 createTime 不匹配
       channelAccountMapper.insert(cloneIgnoreId(dbChannelAccount, o -> o.setCreateTime(null)));
       // 准备参数
       ChannelAccountPageReqVO reqVO = new ChannelAccountPageReqVO();
       reqVO.setChannelCode(null);
       reqVO.setChannelName(null);
       reqVO.setMchNo(null);
       reqVO.setKey(null);
       reqVO.setMchPrivateKey(null);
       reqVO.setMchPublicKey(null);
       reqVO.setChannelPublicKey(null);
       reqVO.setStatus(null);
       reqVO.setCreateTime(buildBetweenTime(2023, 2, 1, 2023, 2, 28));

       // 调用
       PageResult<ChannelAccountDO> pageResult = channelAccountService.getChannelAccountPage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbChannelAccount, pageResult.getList().get(0));
    }

}