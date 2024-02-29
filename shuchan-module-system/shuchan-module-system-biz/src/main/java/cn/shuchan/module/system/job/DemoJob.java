package cn.shuchan.module.system.job;

import cn.shuchan.framework.quartz.core.handler.JobHandler;
import cn.shuchan.framework.tenant.core.context.TenantContextHolder;
import cn.shuchan.framework.tenant.core.job.TenantJob;
import cn.shuchan.module.system.dal.dataobject.user.AdminUserDO;
import cn.shuchan.module.system.dal.mysql.user.AdminUserMapper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class DemoJob implements JobHandler {

    @Resource
    private AdminUserMapper adminUserMapper;

    @Override
    @TenantJob // 标记多租户
    public String execute(String param) {
        System.out.println("当前租户：" + TenantContextHolder.getTenantId());
        List<AdminUserDO> users = adminUserMapper.selectList();
        return "用户数量：" + users.size();
    }

}
