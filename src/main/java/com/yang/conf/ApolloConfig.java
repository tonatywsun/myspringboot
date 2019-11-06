package com.yang.conf;

import com.ctrip.framework.apollo.model.ConfigChange;
import com.ctrip.framework.apollo.model.ConfigChangeEvent;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfigChangeListener;
import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.environment.EnvironmentChangeEvent;
import org.springframework.cloud.context.refresh.ContextRefresher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;

/**
 * @Description: 阿波罗配置
 * @Author: tona.sun
 * @Date: 2019/11/01 14:19
 */
@Slf4j
@Configuration
@EnableApolloConfig
public class ApolloConfig implements ApplicationContextAware {
    private ApplicationContext applicationContext = null;
    @Autowired
    private ContextRefresher refresher;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    /**
     * @description : 监听配置中心值变化
     * @author : tona.sun
     * @date : 2019/11/6 18:50
     */
    @ApolloConfigChangeListener
    private void onChange(ConfigChangeEvent changeEvent) {
        log.info("onChange 配置信息变化: 有{}个修改", changeEvent.changedKeys().size());
        changeEvent.changedKeys().stream().forEach(k -> {
            ConfigChange change = changeEvent.getChange(k);
            log.info("key:{}  oldValue:{} -> newValue:{}", k, change.getOldValue(), change.getNewValue());
        });
        applicationContext.publishEvent(new EnvironmentChangeEvent(changeEvent.changedKeys()));
        refresher.refresh();
    }
}
