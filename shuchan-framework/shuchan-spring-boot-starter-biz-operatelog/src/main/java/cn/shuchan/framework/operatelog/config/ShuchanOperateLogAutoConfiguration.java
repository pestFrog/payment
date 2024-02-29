package cn.shuchan.framework.operatelog.config;

import cn.shuchan.framework.operatelog.core.aop.OperateLogAspect;
import cn.shuchan.framework.operatelog.core.service.OperateLogFrameworkService;
import cn.shuchan.framework.operatelog.core.service.OperateLogFrameworkServiceImpl;
import cn.shuchan.module.system.api.logger.OperateLogApi;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;

@AutoConfiguration
public class ShuchanOperateLogAutoConfiguration {

    @Bean
    public OperateLogAspect operateLogAspect() {
        return new OperateLogAspect();
    }

    @Bean
    public OperateLogFrameworkService operateLogFrameworkService(OperateLogApi operateLogApi) {
        return new OperateLogFrameworkServiceImpl(operateLogApi);
    }

}
