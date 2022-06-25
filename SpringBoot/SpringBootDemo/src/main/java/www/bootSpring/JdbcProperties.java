package www.bootSpring;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * ConfigurationProperties 从 application配置文件中读取配置项
 * prefix 表示 配置项的前缀
 * 配置项中的类变量名必须要与前缀时候的配置项名称保持 松散绑定（相同）；
 */
@ConfigurationProperties(prefix = "jdbc")
public class JdbcProperties {

    private String driver;
    private String url;
    private String username;
    private String password;

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
