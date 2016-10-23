package com.safou.issueManager.cache;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

public interface ICache extends ApplicationListener<ContextRefreshedEvent> {

    void refresh();

}
