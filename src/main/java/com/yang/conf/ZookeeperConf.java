package com.yang.conf;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.api.CuratorEventType;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description: Zookeeper相关配置
 * @Author: tona.sun
 * @Date: 2019/11/06 17:19
 */
@Configuration
public class ZookeeperConf {
    @Value("${zk.url}")
    private String url;

    @Bean
    public CuratorFramework getCuratorFramework() {
        RetryPolicy rp = new ExponentialBackoffRetry(1000, 3);
        CuratorFramework curatorFramework = CuratorFrameworkFactory.newClient(url, rp);
        curatorFramework.getCuratorListenable().addListener((curatorFramework1, curatorEvent) -> {
            if (CuratorEventType.WATCHED == curatorEvent.getType()) {
                WatchedEvent watchedEvent = curatorEvent.getWatchedEvent();
                Watcher.Event.EventType type = watchedEvent.getType();
                curatorFramework1.checkExists().watched().forPath(watchedEvent.getPath());
            }
        });
        return curatorFramework;
    }
}
