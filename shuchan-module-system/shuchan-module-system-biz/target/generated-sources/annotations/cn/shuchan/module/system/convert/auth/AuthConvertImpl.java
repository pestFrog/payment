package cn.shuchan.module.system.convert.auth;

import cn.shuchan.module.system.api.sms.dto.code.SmsCodeSendReqDTO;
import cn.shuchan.module.system.api.sms.dto.code.SmsCodeUseReqDTO;
import cn.shuchan.module.system.api.social.dto.SocialUserBindReqDTO;
import cn.shuchan.module.system.controller.admin.auth.vo.AuthLoginRespVO;
import cn.shuchan.module.system.controller.admin.auth.vo.AuthPermissionInfoRespVO;
import cn.shuchan.module.system.controller.admin.auth.vo.AuthSmsLoginReqVO;
import cn.shuchan.module.system.controller.admin.auth.vo.AuthSmsSendReqVO;
import cn.shuchan.module.system.controller.admin.auth.vo.AuthSocialLoginReqVO;
import cn.shuchan.module.system.dal.dataobject.oauth2.OAuth2AccessTokenDO;
import cn.shuchan.module.system.dal.dataobject.permission.MenuDO;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-27T20:21:04+0800",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 1.8.0_401 (Oracle Corporation)"
)
public class AuthConvertImpl implements AuthConvert {

    @Override
    public AuthLoginRespVO convert(OAuth2AccessTokenDO bean) {
        if ( bean == null ) {
            return null;
        }

        AuthLoginRespVO.AuthLoginRespVOBuilder authLoginRespVO = AuthLoginRespVO.builder();

        authLoginRespVO.userId( bean.getUserId() );
        authLoginRespVO.accessToken( bean.getAccessToken() );
        authLoginRespVO.refreshToken( bean.getRefreshToken() );
        authLoginRespVO.expiresTime( bean.getExpiresTime() );

        return authLoginRespVO.build();
    }

    @Override
    public AuthPermissionInfoRespVO.MenuVO convertTreeNode(MenuDO menu) {
        if ( menu == null ) {
            return null;
        }

        AuthPermissionInfoRespVO.MenuVO.MenuVOBuilder menuVO = AuthPermissionInfoRespVO.MenuVO.builder();

        menuVO.id( menu.getId() );
        menuVO.parentId( menu.getParentId() );
        menuVO.name( menu.getName() );
        menuVO.path( menu.getPath() );
        menuVO.component( menu.getComponent() );
        menuVO.componentName( menu.getComponentName() );
        menuVO.icon( menu.getIcon() );
        menuVO.visible( menu.getVisible() );
        menuVO.keepAlive( menu.getKeepAlive() );
        menuVO.alwaysShow( menu.getAlwaysShow() );

        return menuVO.build();
    }

    @Override
    public SocialUserBindReqDTO convert(Long userId, Integer userType, AuthSocialLoginReqVO reqVO) {
        if ( userId == null && userType == null && reqVO == null ) {
            return null;
        }

        SocialUserBindReqDTO socialUserBindReqDTO = new SocialUserBindReqDTO();

        if ( reqVO != null ) {
            socialUserBindReqDTO.setCode( reqVO.getCode() );
            socialUserBindReqDTO.setState( reqVO.getState() );
        }
        socialUserBindReqDTO.setUserId( userId );
        socialUserBindReqDTO.setUserType( userType );

        return socialUserBindReqDTO;
    }

    @Override
    public SmsCodeSendReqDTO convert(AuthSmsSendReqVO reqVO) {
        if ( reqVO == null ) {
            return null;
        }

        SmsCodeSendReqDTO smsCodeSendReqDTO = new SmsCodeSendReqDTO();

        smsCodeSendReqDTO.setMobile( reqVO.getMobile() );
        smsCodeSendReqDTO.setScene( reqVO.getScene() );

        return smsCodeSendReqDTO;
    }

    @Override
    public SmsCodeUseReqDTO convert(AuthSmsLoginReqVO reqVO, Integer scene, String usedIp) {
        if ( reqVO == null && scene == null && usedIp == null ) {
            return null;
        }

        SmsCodeUseReqDTO smsCodeUseReqDTO = new SmsCodeUseReqDTO();

        if ( reqVO != null ) {
            smsCodeUseReqDTO.setMobile( reqVO.getMobile() );
            smsCodeUseReqDTO.setCode( reqVO.getCode() );
        }
        smsCodeUseReqDTO.setScene( scene );
        smsCodeUseReqDTO.setUsedIp( usedIp );

        return smsCodeUseReqDTO;
    }
}
