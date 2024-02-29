package cn.shuchan.module.pay.dal.mysql.notify;

import cn.shuchan.module.pay.dal.dataobject.notify.PayNotifyLogDO;
import cn.shuchan.framework.mybatis.core.mapper.BaseMapperX;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PayNotifyLogMapper extends BaseMapperX<PayNotifyLogDO> {

    default List<PayNotifyLogDO> selectListByTaskId(Long taskId) {
        return selectList(PayNotifyLogDO::getTaskId, taskId);
    }

}
