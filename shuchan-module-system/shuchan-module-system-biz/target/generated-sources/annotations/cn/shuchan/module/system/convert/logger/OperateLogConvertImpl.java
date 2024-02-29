package cn.shuchan.module.system.convert.logger;

import cn.shuchan.module.system.api.logger.dto.OperateLogV2RespDTO;
import cn.shuchan.module.system.dal.dataobject.logger.OperateLogV2DO;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-27T20:21:04+0800",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 1.8.0_401 (Oracle Corporation)"
)
public class OperateLogConvertImpl implements OperateLogConvert {

    @Override
    public OperateLogV2RespDTO convert(OperateLogV2DO operateLogV2DO) {
        if ( operateLogV2DO == null ) {
            return null;
        }

        OperateLogV2RespDTO operateLogV2RespDTO = new OperateLogV2RespDTO();

        operateLogV2RespDTO.setTraceId( operateLogV2DO.getTraceId() );
        operateLogV2RespDTO.setUserId( operateLogV2DO.getUserId() );
        operateLogV2RespDTO.setUserType( operateLogV2DO.getUserType() );
        operateLogV2RespDTO.setType( operateLogV2DO.getType() );
        operateLogV2RespDTO.setSubType( operateLogV2DO.getSubType() );
        operateLogV2RespDTO.setBizId( operateLogV2DO.getBizId() );
        operateLogV2RespDTO.setAction( operateLogV2DO.getAction() );
        operateLogV2RespDTO.setExtra( operateLogV2DO.getExtra() );
        operateLogV2RespDTO.setRequestMethod( operateLogV2DO.getRequestMethod() );
        operateLogV2RespDTO.setRequestUrl( operateLogV2DO.getRequestUrl() );
        operateLogV2RespDTO.setUserIp( operateLogV2DO.getUserIp() );
        operateLogV2RespDTO.setUserAgent( operateLogV2DO.getUserAgent() );
        operateLogV2RespDTO.setCreateTime( operateLogV2DO.getCreateTime() );

        return operateLogV2RespDTO;
    }
}
