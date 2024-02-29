package cn.shuchan.module.system.convert.social;

import cn.shuchan.module.system.api.social.dto.SocialUserBindReqDTO;
import cn.shuchan.module.system.controller.admin.socail.vo.user.SocialUserBindReqVO;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-27T20:21:04+0800",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 1.8.0_401 (Oracle Corporation)"
)
public class SocialUserConvertImpl implements SocialUserConvert {

    @Override
    public SocialUserBindReqDTO convert(Long userId, Integer userType, SocialUserBindReqVO reqVO) {
        if ( userId == null && userType == null && reqVO == null ) {
            return null;
        }

        SocialUserBindReqDTO socialUserBindReqDTO = new SocialUserBindReqDTO();

        if ( reqVO != null ) {
            socialUserBindReqDTO.setSocialType( reqVO.getType() );
            socialUserBindReqDTO.setCode( reqVO.getCode() );
            socialUserBindReqDTO.setState( reqVO.getState() );
        }
        socialUserBindReqDTO.setUserId( userId );
        socialUserBindReqDTO.setUserType( userType );

        return socialUserBindReqDTO;
    }
}
