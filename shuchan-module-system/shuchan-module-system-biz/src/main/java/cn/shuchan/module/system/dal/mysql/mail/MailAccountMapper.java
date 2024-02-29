package cn.shuchan.module.system.dal.mysql.mail;

import cn.shuchan.framework.common.pojo.PageResult;
import cn.shuchan.framework.mybatis.core.mapper.BaseMapperX;
import cn.shuchan.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.shuchan.framework.mybatis.core.query.QueryWrapperX;
import cn.shuchan.module.system.controller.admin.mail.vo.account.MailAccountPageReqVO;
import cn.shuchan.module.system.dal.dataobject.mail.MailAccountDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MailAccountMapper extends BaseMapperX<MailAccountDO> {

    default PageResult<MailAccountDO> selectPage(MailAccountPageReqVO pageReqVO) {
        return selectPage(pageReqVO, new LambdaQueryWrapperX<MailAccountDO>()
                .likeIfPresent(MailAccountDO::getMail, pageReqVO.getMail())
                .likeIfPresent(MailAccountDO::getUsername , pageReqVO.getUsername()));
    }

}
