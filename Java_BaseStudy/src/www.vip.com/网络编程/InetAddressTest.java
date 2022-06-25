package www.vip.com.网络编程;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 为了方便我们获取和操作IP地址，Java提供了IP地址的操作类InetAddress
 *      InetAddress：此类表示Internet协议（IP）地址；
 *      此类的三个方法：
 *          1.static InetAddress getByName(String host)：
 *              确定主机名称的IP地址；主机名称可以是机器名称，也可以是IP地址；
 *          2.String getHostName()：获取此IP地址的主机名；
 *          3.String getHostAddress()： 返回文本显示中的IP地址字符串
 *
 */
public class InetAddressTest {

    public static void main(String[] args) throws UnknownHostException {

        /** 获取name：在命令行输入 hostname 回车； */
        InetAddress inetAddress = InetAddress.getByName("hudeMacBook-Pro.local");
//        InetAddress inetAddress = InetAddress.getByName("10.10.1.63");
        String hostName = inetAddress.getHostName();
        System.out.println("主机名称:"+hostName);
        String hostArrdress = inetAddress.getHostAddress();
        System.out.println("主机IP："+hostArrdress);

        System.out.println("--------------------");
        /** 获取本地主机的IP地址和本机名称*/
        InetAddress address = InetAddress.getLocalHost();
        System.out.println(address.getHostAddress());
        System.out.println(address.getHostName());

        System.out.println("--------------------");

        /** 根据地址（域名DNS），解析地址对应的IP地址和IP地址机器名称 */
        address = InetAddress.getByName("www.baidu.com");
        System.out.println(address.getHostAddress());
        System.out.println(address.getHostName());

    }
}
