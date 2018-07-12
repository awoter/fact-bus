package com.woter.fact.bus.facede;

import com.google.common.eventbus.EventBus;
import com.woter.fact.bus.adpter.EventAdapter;
import com.woter.fact.bus.event.BaseEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @author woterF
 * @date 2017-6-29 上午11:18:14
 * @version
 */
public class EventBusFacade {

    private static final Logger logger = LoggerFactory.getLogger(EventBusFacade.class);

    private final static EventBus eventBus = new EventBus();

    private final static Executor executor = Executors.newCachedThreadPool();

    public static void post(BaseEvent event) {
        execute(event);
    }

    /***
     * 同步执行
     * @param event
     *
     * @author woter
     * @date 2017-7-6 上午8:47:42
     * @version
     */
    public static void execute(BaseEvent event) {
        if (event == null) {
            return;
        }
        eventBus.post(event);
    }

    /**
     * 异步提交
     * @param event
     *
     * @author woter
     * @date 2017-7-6 上午8:47:30
     * @version
     */
    public static void submit(final BaseEvent event) {
        if (event == null) {
            return;
        }
        executor.execute(new Runnable() {
            public void run() {
                eventBus.post(event);
            }
        });
    }

    /**
     * 注册event handler
     * @param handler
     *
     * @author woter
     * @date 2017-7-6 上午11:47:30
     * @version
     */
    public static void register(EventAdapter<? extends BaseEvent> handler) {
        if (handler == null) {
            return;
        }
        eventBus.register(handler);
        logger.info("Registered eventAdapter class: {}", handler.getClass());
    }


    public static void unregister(EventAdapter<? extends BaseEvent> handler) {
        if (handler == null) {
            return;
        }
        eventBus.unregister(handler);
        logger.info("Unregisted eventAdapter class: {}", handler.getClass());
    }

}
