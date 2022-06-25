
package www.vip.com.网络编程;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * URL:统一资源定位器；
 *
 */
public class URLTest {
    public static void main(String[] args) throws MalformedURLException {

        URL url = new URL(
           "https://www.baidu.com:80/index.html?uname=huxiansheng&age=18#"
        );
        System.out.println("协议："+url.getProtocol());
        System.out.println("域名IP："+url.getHost());
        System.out.println("端口："+url.getPort());
        System.out.println("请求资源1："+url.getFile());
        System.out.println("请求资源2："+url.getPath());

        System.out.println("参数："+url.getQuery());
        System.out.println("锚点："+url.getRef());

    }
}