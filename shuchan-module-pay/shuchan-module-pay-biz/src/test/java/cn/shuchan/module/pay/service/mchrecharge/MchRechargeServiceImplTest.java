package cn.shuchan.module.pay.service.mchrecharge;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.annotation.Resource;

import cn.shuchan.framework.test.core.ut.BaseDbUnitTest;

import cn.shuchan.module.pay.controller.admin.mchrecharge.vo.*;
import cn.shuchan.module.pay.dal.dataobject.mchrecharge.MchRechargeDO;
import cn.shuchan.module.pay.dal.mysql.mchrecharge.MchRechargeMapper;
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
 * {@link MchRechargeServiceImpl} 的单元测试类
 *
 * @author 支付系统system
 */
@Import(MchRechargeServiceImpl.class)
public class MchRechargeServiceImplTest extends BaseDbUnitTest {

    @Resource
    private MchRechargeServiceImpl mchRechargeService;

    @Resource
    private MchRechargeMapper mchRechargeMapper;

    @Test
    public void testCreateMchRecharge_success() {
        // 准备参数
        MchRechargeSaveReqVO createReqVO = randomPojo(MchRechargeSaveReqVO.class).setId(null);

        // 调用
        Long mchRechargeId = mchRechargeService.createMchRecharge(createReqVO);
        // 断言
        assertNotNull(mchRechargeId);
        // 校验记录的属性是否正确
        MchRechargeDO mchRecharge = mchRechargeMapper.selectById(mchRechargeId);
        assertPojoEquals(createReqVO, mchRecharge, "id");
    }

    @Test
    public void testUpdateMchRecharge_success() {
        // mock 数据
        MchRechargeDO dbMchRecharge = randomPojo(MchRechargeDO.class);
        mchRechargeMapper.insert(dbMchRecharge);// @Sql: 先插入出一条存在的数据
        // 准备参数
        MchRechargeSaveReqVO updateReqVO = randomPojo(MchRechargeSaveReqVO.class, o -> {
            o.setId(dbMchRecharge.getId()); // 设置更新的 ID
        });

        // 调用
        mchRechargeService.updateMchRecharge(updateReqVO);
        // 校验是否更新正确
        MchRechargeDO mchRecharge = mchRechargeMapper.selectById(updateReqVO.getId()); // 获取最新的
        assertPojoEquals(updateReqVO, mchRecharge);
    }

    @Test
    public void testUpdateMchRecharge_notExists() {
        // 准备参数
        MchRechargeSaveReqVO updateReqVO = randomPojo(MchRechargeSaveReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> mchRechargeService.updateMchRecharge(updateReqVO), MCH_RECHARGE_NOT_EXISTS);
    }

    @Test
    public void testDeleteMchRecharge_success() {
        // mock 数据
        MchRechargeDO dbMchRecharge = randomPojo(MchRechargeDO.class);
        mchRechargeMapper.insert(dbMchRecharge);// @Sql: 先插入出一条存在的数据
        // 准备参数
        Long id = dbMchRecharge.getId();

        // 调用
        mchRechargeService.deleteMchRecharge(id);
       // 校验数据不存在了
       assertNull(mchRechargeMapper.selectById(id));
    }

    @Test
    public void testDeleteMchRecharge_notExists() {
        // 准备参数
        Long id = randomLongId();

        // 调用, 并断言异常
        assertServiceException(() -> mchRechargeService.deleteMchRecharge(id), MCH_RECHARGE_NOT_EXISTS);
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetMchRechargePage() {
       // mock 数据
       MchRechargeDO dbMchRecharge = randomPojo(MchRechargeDO.class, o -> { // 等会查询到
           o.setMchNo(null);
           o.setMchName(null);
           o.setCreateTime(null);
       });
       mchRechargeMapper.insert(dbMchRecharge);
       // 测试 mchNo 不匹配
       mchRechargeMapper.insert(cloneIgnoreId(dbMchRecharge, o -> o.setMchNo(null)));
       // 测试 mchName 不匹配
       mchRechargeMapper.insert(cloneIgnoreId(dbMchRecharge, o -> o.setMchName(null)));
       // 测试 createTime 不匹配
       mchRechargeMapper.insert(cloneIgnoreId(dbMchRecharge, o -> o.setCreateTime(null)));
       // 准备参数
       MchRechargePageReqVO reqVO = new MchRechargePageReqVO();
       reqVO.setMchNo(null);
       reqVO.setMchName(null);
       reqVO.setCreateTime(buildBetweenTime(2023, 2, 1, 2023, 2, 28));

       // 调用
       PageResult<MchRechargeDO> pageResult = mchRechargeService.getMchRechargePage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbMchRecharge, pageResult.getList().get(0));
    }

}