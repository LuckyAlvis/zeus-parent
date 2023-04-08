package smart.dai.utils;

import club.javafamily.nf.request.FeiShuTextNotifyRequest;
import club.javafamily.nf.service.FeiShuNotifyHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;
import smart.dai.utils.server.ServerUtil;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.net.UnknownHostException;

@Slf4j
@Component
public class FeishuUtil {

    @Resource
    private FeiShuNotifyHandler feiShuNotifyHandler;

    private static FeiShuNotifyHandler staticFeiShuNotifyHandler;

    @PostConstruct
    public void init() {
        staticFeiShuNotifyHandler = this.feiShuNotifyHandler;
    }

    public static void appStartNotify(ConfigurableApplicationContext application, Class<?> app)
            throws UnknownHostException {
        String logContent = ServerUtil.getAppStartNotifyLog(application, app);
        staticFeiShuNotifyHandler.notify(
                FeiShuTextNotifyRequest.of(logContent));
        log.info(logContent);
    }
}
