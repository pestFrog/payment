package cn.shuchan.module.pay.convert.notify;

import cn.shuchan.framework.common.pojo.PageResult;
import cn.shuchan.module.pay.controller.admin.notify.vo.PayNotifyTaskDetailRespVO;
import cn.shuchan.module.pay.controller.admin.notify.vo.PayNotifyTaskRespVO;
import cn.shuchan.module.pay.dal.dataobject.notify.PayNotifyLogDO;
import cn.shuchan.module.pay.dal.dataobject.notify.PayNotifyTaskDO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-28T20:02:51+0800",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 1.8.0_401 (Oracle Corporation)"
)
public class PayNotifyTaskConvertImpl implements PayNotifyTaskConvert {

    @Override
    public PayNotifyTaskRespVO convert(PayNotifyTaskDO bean) {
        if ( bean == null ) {
            return null;
        }

        PayNotifyTaskRespVO payNotifyTaskRespVO = new PayNotifyTaskRespVO();

        payNotifyTaskRespVO.setAppId( bean.getAppId() );
        if ( bean.getType() != null ) {
            payNotifyTaskRespVO.setType( bean.getType().byteValue() );
        }
        payNotifyTaskRespVO.setDataId( bean.getDataId() );
        if ( bean.getStatus() != null ) {
            payNotifyTaskRespVO.setStatus( bean.getStatus().byteValue() );
        }
        payNotifyTaskRespVO.setMerchantOrderId( bean.getMerchantOrderId() );
        payNotifyTaskRespVO.setNextNotifyTime( bean.getNextNotifyTime() );
        payNotifyTaskRespVO.setLastExecuteTime( bean.getLastExecuteTime() );
        if ( bean.getNotifyTimes() != null ) {
            payNotifyTaskRespVO.setNotifyTimes( bean.getNotifyTimes().byteValue() );
        }
        if ( bean.getMaxNotifyTimes() != null ) {
            payNotifyTaskRespVO.setMaxNotifyTimes( bean.getMaxNotifyTimes().byteValue() );
        }
        payNotifyTaskRespVO.setNotifyUrl( bean.getNotifyUrl() );
        payNotifyTaskRespVO.setId( bean.getId() );
        payNotifyTaskRespVO.setCreateTime( bean.getCreateTime() );

        return payNotifyTaskRespVO;
    }

    @Override
    public PageResult<PayNotifyTaskRespVO> convertPage(PageResult<PayNotifyTaskDO> page) {
        if ( page == null ) {
            return null;
        }

        PageResult<PayNotifyTaskRespVO> pageResult = new PageResult<PayNotifyTaskRespVO>();

        pageResult.setList( payNotifyTaskDOListToPayNotifyTaskRespVOList( page.getList() ) );
        pageResult.setTotal( page.getTotal() );

        return pageResult;
    }

    @Override
    public PayNotifyTaskDetailRespVO convert(PayNotifyTaskDO task, List<PayNotifyLogDO> logs) {
        if ( task == null && logs == null ) {
            return null;
        }

        PayNotifyTaskDetailRespVO payNotifyTaskDetailRespVO = new PayNotifyTaskDetailRespVO();

        if ( task != null ) {
            payNotifyTaskDetailRespVO.setAppId( task.getAppId() );
            if ( task.getType() != null ) {
                payNotifyTaskDetailRespVO.setType( task.getType().byteValue() );
            }
            payNotifyTaskDetailRespVO.setDataId( task.getDataId() );
            if ( task.getStatus() != null ) {
                payNotifyTaskDetailRespVO.setStatus( task.getStatus().byteValue() );
            }
            payNotifyTaskDetailRespVO.setMerchantOrderId( task.getMerchantOrderId() );
            payNotifyTaskDetailRespVO.setNextNotifyTime( task.getNextNotifyTime() );
            payNotifyTaskDetailRespVO.setLastExecuteTime( task.getLastExecuteTime() );
            if ( task.getNotifyTimes() != null ) {
                payNotifyTaskDetailRespVO.setNotifyTimes( task.getNotifyTimes().byteValue() );
            }
            if ( task.getMaxNotifyTimes() != null ) {
                payNotifyTaskDetailRespVO.setMaxNotifyTimes( task.getMaxNotifyTimes().byteValue() );
            }
            payNotifyTaskDetailRespVO.setNotifyUrl( task.getNotifyUrl() );
            payNotifyTaskDetailRespVO.setId( task.getId() );
            payNotifyTaskDetailRespVO.setCreateTime( task.getCreateTime() );
            payNotifyTaskDetailRespVO.setUpdateTime( task.getUpdateTime() );
        }
        payNotifyTaskDetailRespVO.setLogs( payNotifyLogDOListToLogList( logs ) );

        return payNotifyTaskDetailRespVO;
    }

    protected List<PayNotifyTaskRespVO> payNotifyTaskDOListToPayNotifyTaskRespVOList(List<PayNotifyTaskDO> list) {
        if ( list == null ) {
            return null;
        }

        List<PayNotifyTaskRespVO> list1 = new ArrayList<PayNotifyTaskRespVO>( list.size() );
        for ( PayNotifyTaskDO payNotifyTaskDO : list ) {
            list1.add( convert( payNotifyTaskDO ) );
        }

        return list1;
    }

    protected PayNotifyTaskDetailRespVO.Log payNotifyLogDOToLog(PayNotifyLogDO payNotifyLogDO) {
        if ( payNotifyLogDO == null ) {
            return null;
        }

        PayNotifyTaskDetailRespVO.Log log = new PayNotifyTaskDetailRespVO.Log();

        log.setId( payNotifyLogDO.getId() );
        if ( payNotifyLogDO.getStatus() != null ) {
            log.setStatus( payNotifyLogDO.getStatus().byteValue() );
        }
        if ( payNotifyLogDO.getNotifyTimes() != null ) {
            log.setNotifyTimes( payNotifyLogDO.getNotifyTimes().byteValue() );
        }
        log.setResponse( payNotifyLogDO.getResponse() );
        log.setCreateTime( payNotifyLogDO.getCreateTime() );

        return log;
    }

    protected List<PayNotifyTaskDetailRespVO.Log> payNotifyLogDOListToLogList(List<PayNotifyLogDO> list) {
        if ( list == null ) {
            return null;
        }

        List<PayNotifyTaskDetailRespVO.Log> list1 = new ArrayList<PayNotifyTaskDetailRespVO.Log>( list.size() );
        for ( PayNotifyLogDO payNotifyLogDO : list ) {
            list1.add( payNotifyLogDOToLog( payNotifyLogDO ) );
        }

        return list1;
    }
}
