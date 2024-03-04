package cn.shuchan.module.pay.service.merchant;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.annotation.Resource;

import cn.shuchan.framework.test.core.ut.BaseDbUnitTest;

import cn.shuchan.module.pay.controller.admin.merchant.vo.*;
import cn.shuchan.module.pay.dal.dataobject.merchant.MerchantDO;
import cn.shuchan.module.pay.dal.mysql.merchant.MerchantMapper;
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
 * {@link MerchantServiceImpl} 的单元测试类
 *
 * @author 支付系统system
 */
@Import(MerchantServiceImpl.class)
public class MerchantServiceImplTest extends BaseDbUnitTest {

    @Resource
    private MerchantServiceImpl merchantService;

    @Resource
    private MerchantMapper merchantMapper;

    @Test
    public void testCreateMerchant_success() {
        // 准备参数
        MerchantSaveReqVO createReqVO = randomPojo(MerchantSaveReqVO.class).setId(null);

        // 调用
        String merchantId = merchantService.createMerchant(createReqVO);
        // 断言
        assertNotNull(merchantId);
        // 校验记录的属性是否正确
        MerchantDO merchant = merchantMapper.selectById(merchantId);
        assertPojoEquals(createReqVO, merchant, "id");
    }

    @Test
    public void testUpdateMerchant_success() {
        // mock 数据
        MerchantDO dbMerchant = randomPojo(MerchantDO.class);
        merchantMapper.insert(dbMerchant);// @Sql: 先插入出一条存在的数据
        // 准备参数
        MerchantSaveReqVO updateReqVO = randomPojo(MerchantSaveReqVO.class, o -> {
            o.setId(dbMerchant.getId()); // 设置更新的 ID
        });

        // 调用
        merchantService.updateMerchant(updateReqVO);
        // 校验是否更新正确
        MerchantDO merchant = merchantMapper.selectById(updateReqVO.getId()); // 获取最新的
        assertPojoEquals(updateReqVO, merchant);
    }

    @Test
    public void testUpdateMerchant_notExists() {
        // 准备参数
        MerchantSaveReqVO updateReqVO = randomPojo(MerchantSaveReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> merchantService.updateMerchant(updateReqVO), MERCHANT_NOT_EXISTS);
    }

    @Test
    public void testDeleteMerchant_success() {
        // mock 数据
        MerchantDO dbMerchant = randomPojo(MerchantDO.class);
        merchantMapper.insert(dbMerchant);// @Sql: 先插入出一条存在的数据
        // 准备参数
        String id = dbMerchant.getId();

        // 调用
        merchantService.deleteMerchant(id);
       // 校验数据不存在了
       assertNull(merchantMapper.selectById(id));
    }

    @Test
    public void testDeleteMerchant_notExists() {
        // 准备参数
        String id = randomStringId();

        // 调用, 并断言异常
        assertServiceException(() -> merchantService.deleteMerchant(id), MERCHANT_NOT_EXISTS);
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetMerchantPage() {
       // mock 数据
       MerchantDO dbMerchant = randomPojo(MerchantDO.class, o -> { // 等会查询到
           o.setMerchantId(null);
           o.setName(null);
           o.setContactName(null);
           o.setContactTel(null);
           o.setContactEmail(null);
           o.setServerIp(null);
           o.setStatus(null);
           o.setCreateTime(null);
       });
       merchantMapper.insert(dbMerchant);
       // 测试 merchantId 不匹配
       merchantMapper.insert(cloneIgnoreId(dbMerchant, o -> o.setMerchantId(null)));
       // 测试 name 不匹配
       merchantMapper.insert(cloneIgnoreId(dbMerchant, o -> o.setName(null)));
       // 测试 contactName 不匹配
       merchantMapper.insert(cloneIgnoreId(dbMerchant, o -> o.setContactName(null)));
       // 测试 contactTel 不匹配
       merchantMapper.insert(cloneIgnoreId(dbMerchant, o -> o.setContactTel(null)));
       // 测试 contactEmail 不匹配
       merchantMapper.insert(cloneIgnoreId(dbMerchant, o -> o.setContactEmail(null)));
       // 测试 serverIp 不匹配
       merchantMapper.insert(cloneIgnoreId(dbMerchant, o -> o.setServerIp(null)));
       // 测试 status 不匹配
       merchantMapper.insert(cloneIgnoreId(dbMerchant, o -> o.setStatus(null)));
       // 测试 createTime 不匹配
       merchantMapper.insert(cloneIgnoreId(dbMerchant, o -> o.setCreateTime(null)));
       // 准备参数
       MerchantPageReqVO reqVO = new MerchantPageReqVO();
       reqVO.setMerchantId(null);
       reqVO.setName(null);
       reqVO.setContactName(null);
       reqVO.setContactTel(null);
       reqVO.setContactEmail(null);
       reqVO.setServerIp(null);
       reqVO.setStatus(null);
       reqVO.setCreateTime(buildBetweenTime(2023, 2, 1, 2023, 2, 28));

       // 调用
       PageResult<MerchantDO> pageResult = merchantService.getMerchantPage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbMerchant, pageResult.getList().get(0));
    }

}