package cn.shuchan.module.pay.service.channelinfo;

import cn.shuchan.framework.common.util.string.StrUtils;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.annotation.Resource;

import cn.shuchan.framework.test.core.ut.BaseDbUnitTest;

import cn.shuchan.module.pay.controller.admin.channelinfo.vo.*;
import cn.shuchan.module.pay.dal.dataobject.channelinfo.ChannelInfoDO;
import cn.shuchan.module.pay.dal.mysql.channelinfo.ChannelInfoMapper;
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
 * {@link ChannelInfoServiceImpl} 的单元测试类
 *
 * @author 支付系统system
 */
@Import(ChannelInfoServiceImpl.class)
public class ChannelInfoServiceImplTest extends BaseDbUnitTest {

    @Resource
    private ChannelInfoServiceImpl channelInfoService;

    @Resource
    private ChannelInfoMapper channelInfoMapper;

    @Test
    public void testCreateChannelInfo_success() {
        // 准备参数
        ChannelInfoSaveReqVO createReqVO = randomPojo(ChannelInfoSaveReqVO.class).setChannelNo(StrUtils.getTransNo(10));

        // 调用
        String channelInfoId = channelInfoService.createChannelInfo(createReqVO);
        // 断言
        assertNotNull(channelInfoId);
        // 校验记录的属性是否正确
        ChannelInfoDO channelInfo = channelInfoMapper.selectById(channelInfoId);
        assertPojoEquals(createReqVO, channelInfo, "id");
    }

    @Test
    public void testUpdateChannelInfo_success() {
        // mock 数据
        ChannelInfoDO dbChannelInfo = randomPojo(ChannelInfoDO.class);
        channelInfoMapper.insert(dbChannelInfo);// @Sql: 先插入出一条存在的数据
        // 准备参数
        ChannelInfoSaveReqVO updateReqVO = randomPojo(ChannelInfoSaveReqVO.class, o -> {
            o.setChannelNo(dbChannelInfo.getChannelNo()); // 设置更新的 ID
        });

        // 调用
        channelInfoService.updateChannelInfo(updateReqVO);
        // 校验是否更新正确
        ChannelInfoDO channelInfo = channelInfoMapper.selectById(updateReqVO.getChannelNo()); // 获取最新的
        assertPojoEquals(updateReqVO, channelInfo);
    }

    @Test
    public void testUpdateChannelInfo_notExists() {
        // 准备参数
        ChannelInfoSaveReqVO updateReqVO = randomPojo(ChannelInfoSaveReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> channelInfoService.updateChannelInfo(updateReqVO), CHANNEL_INFO_NOT_EXISTS);
    }

    @Test
    public void testDeleteChannelInfo_success() {
        // mock 数据
        ChannelInfoDO dbChannelInfo = randomPojo(ChannelInfoDO.class);
        channelInfoMapper.insert(dbChannelInfo);// @Sql: 先插入出一条存在的数据
        // 准备参数
        String id = dbChannelInfo.getChannelNo();

        // 调用
        channelInfoService.deleteChannelInfo(id);
       // 校验数据不存在了
       assertNull(channelInfoMapper.selectById(id));
    }

    @Test
    public void testDeleteChannelInfo_notExists() {
        // 准备参数
        String id = StrUtils.getTransNo(10);

        // 调用, 并断言异常
        assertServiceException(() -> channelInfoService.deleteChannelInfo(id), CHANNEL_INFO_NOT_EXISTS);
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetChannelInfoPage() {
       // mock 数据
       ChannelInfoDO dbChannelInfo = randomPojo(ChannelInfoDO.class, o -> { // 等会查询到
           o.setChannelNo(null);
           o.setChannelName(null);
           o.setStatus(null);
           o.setCreateTime(null);
       });
       channelInfoMapper.insert(dbChannelInfo);
       // 测试 channelNo 不匹配
       channelInfoMapper.insert(cloneIgnoreId(dbChannelInfo, o -> o.setChannelNo(null)));
       // 测试 channelName 不匹配
       channelInfoMapper.insert(cloneIgnoreId(dbChannelInfo, o -> o.setChannelName(null)));
       // 测试 status 不匹配
       channelInfoMapper.insert(cloneIgnoreId(dbChannelInfo, o -> o.setStatus(null)));
       // 测试 createTime 不匹配
       channelInfoMapper.insert(cloneIgnoreId(dbChannelInfo, o -> o.setCreateTime(null)));
       // 准备参数
       ChannelInfoPageReqVO reqVO = new ChannelInfoPageReqVO();
       reqVO.setChannelNo(null);
       reqVO.setChannelName(null);
       reqVO.setStatus(null);
       reqVO.setCreateTime(buildBetweenTime(2023, 2, 1, 2023, 2, 28));

       // 调用
       PageResult<ChannelInfoDO> pageResult = channelInfoService.getChannelInfoPage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbChannelInfo, pageResult.getList().get(0));
    }

}
