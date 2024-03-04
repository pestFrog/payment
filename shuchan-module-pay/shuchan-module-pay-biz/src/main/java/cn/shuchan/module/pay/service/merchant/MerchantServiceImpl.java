package cn.shuchan.module.pay.service.merchant;

import cn.hutool.core.util.IdUtil;
import cn.shuchan.framework.common.util.encryption.EncryptionUtil;
import cn.shuchan.framework.common.util.string.StrUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.security.KeyPair;
import java.util.UUID;

import cn.shuchan.module.pay.controller.admin.merchant.vo.*;
import cn.shuchan.module.pay.dal.dataobject.merchant.MerchantDO;
import cn.shuchan.framework.common.pojo.PageResult;
import cn.shuchan.framework.common.util.object.BeanUtils;

import cn.shuchan.module.pay.dal.mysql.merchant.MerchantMapper;

import static cn.shuchan.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.shuchan.module.pay.enums.ErrorCodeConstants.*;

/**
 * 商户 Service 实现类
 *
 * @author 支付系统system
 */
@Service
@Validated
public class MerchantServiceImpl implements MerchantService {

    @Resource
    private MerchantMapper merchantMapper;
    @Value("${shuchan.pay.osEncryKey}")
    private String osEncryKey;

    @Override
    public String createMerchant(MerchantSaveReqVO createReqVO) {
        // 插入
        MerchantDO merchant = BeanUtils.toBean(createReqVO, MerchantDO.class);
        merchant.setMerchantId(StrUtils.getTransNo(12));
        //IdUtil.
        try {
            merchant = genkeys(merchant);
        }catch (Exception ignored){
            throw exception(ADD_MERCHANT_ERROR,"创建商户异常，请联系管理员！");
        }
        merchantMapper.insert(merchant);
        // 返回
        return merchant.getMerchantId();
    }

    @Override
    public void updateMerchant(MerchantSaveReqVO updateReqVO) {
        // 校验存在
        validateMerchantExists(updateReqVO.getMerchantId());
        // 更新
        MerchantDO updateObj = BeanUtils.toBean(updateReqVO, MerchantDO.class);
        merchantMapper.updateById(updateObj);
    }

    @Override
    public void deleteMerchant(String id) {
        // 校验存在
        validateMerchantExists(id);
        // 删除
        merchantMapper.deleteById(id);
    }

    private void validateMerchantExists(String id) {
        if (merchantMapper.selectById(id) == null) {
            throw exception(MERCHANT_NOT_EXISTS);
        }
    }

    @Override
    public MerchantDO getMerchant(String id) {
        return merchantMapper.selectById(id);
    }

    @Override
    public PageResult<MerchantDO> getMerchantPage(MerchantPageReqVO pageReqVO) {
        return merchantMapper.selectPage(pageReqVO);
    }

    private MerchantDO genkeys(MerchantDO merchantDO) throws Exception {

        String encryptionKey = EncryptionUtil.generateAesKey();
        KeyPair mKeyPair = EncryptionUtil.generateRSAKeyPair();
        KeyPair pKeyPair = EncryptionUtil.generateRSAKeyPair();
        String mprivateKey =EncryptionUtil.getRSAPrivateKeyString(mKeyPair.getPrivate());
        String mpublicKey = EncryptionUtil.getRSAPublicKeyString(mKeyPair.getPublic());
        String pprivateKey =EncryptionUtil.getRSAPrivateKeyString(pKeyPair.getPrivate());
        String ppublicKey = EncryptionUtil.getRSAPublicKeyString(pKeyPair.getPublic());

        if(mprivateKey == null || mpublicKey == null || pprivateKey == null || ppublicKey == null){
            throw exception(GEN_ENCRYPTION_KEY_ERROR,"生成商户加密串异常");
        }

        merchantDO.setEncryptionKey(EncryptionUtil.aesEncrypt(encryptionKey,osEncryKey));
        merchantDO.setPrivateKey(EncryptionUtil.aesEncrypt(mprivateKey,osEncryKey));
        merchantDO.setPublicKey(EncryptionUtil.aesEncrypt(mpublicKey,osEncryKey));
        merchantDO.setPlatformPrivateKey(EncryptionUtil.aesEncrypt(pprivateKey,osEncryKey));
        merchantDO.setPlatformPublicKey(EncryptionUtil.aesEncrypt(ppublicKey,osEncryKey));
        return merchantDO;
    }

}
