package cn.shuchan.module.pay.dal.mysql.demo;

import cn.shuchan.framework.common.pojo.PageParam;
import cn.shuchan.framework.common.pojo.PageResult;
import cn.shuchan.framework.mybatis.core.mapper.BaseMapperX;
import cn.shuchan.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.shuchan.module.pay.dal.dataobject.demo.PayDemoTransferDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PayDemoTransferMapper extends BaseMapperX<PayDemoTransferDO> {

    default  PageResult<PayDemoTransferDO> selectPage(PageParam pageParam){
        return selectPage(pageParam, new LambdaQueryWrapperX<PayDemoTransferDO>()
                .orderByDesc(PayDemoTransferDO::getId));
    }
}