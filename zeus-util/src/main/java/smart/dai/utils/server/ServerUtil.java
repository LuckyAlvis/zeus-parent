package smart.dai.utils.server;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;
import smart.dai.utils.common.DateUtil;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class ServerUtil {
    /**
     * @param application
     * @param app
     * @return
     * @throws UnknownHostException
     */
    public static String getAppStartNotifyLog(ConfigurableApplicationContext application, Class<?> app)
            throws UnknownHostException {
        Environment env = application.getEnvironment();
        StringBuilder logBd = new StringBuilder();
        logBd.append(String.format("当前时间: %s\n", DateUtil.getNowString()));
        logBd.append(String.format("%s 启动成功!!!\n", app.getSimpleName()));
        logBd.append("----------------------------------------------------\n");
        logBd.append(String.format("Swagger: http://%s:%s/doc.html\n", InetAddress.getLocalHost().getHostAddress(),
                env.getProperty("server.port")));
        logBd.append("----------------------------------------------------\n");
        return logBd.toString();
    }
}
