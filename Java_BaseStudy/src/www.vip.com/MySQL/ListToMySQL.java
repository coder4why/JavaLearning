package www.vip.com.MySQL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * 需求：
 * 1、发送一个Get请求，查询未来15天天气预报；
 * 2、在MySQL中创建天气表WeatherInfo；
 * 3、将本地天气信息写入到MySQL数据库；
 */
class WeatherDay {
    String date;
    String week;
    String wea;
    String tem;
    String tem1;
    String sunset;
    String win_speed;
    WeatherDay(String date, String week, String wea, String tem,
               String tem1, String sunset, String win_speed) {
        this.date = date;
        this.week = week;
        this.wea = wea;
        this.tem = tem;
        this.tem1 = tem1;
        this.sunset = sunset;
        this.win_speed = win_speed;
    }
}

public class ListToMySQL {

    static Object[] objects;
    static {
        try {
            objects = MySQLTool.getMySqlObj();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 请求天气信息：
     */
    private static ArrayList<WeatherDay> requestWeather() throws IOException {

        String urlNameString = "http://www.tianqiapi.com/api?version=v9&appid=23035354&appsecret=8YvlPNrz";
        URL realUrl = new URL(urlNameString);
        // 打开和URL之间的连接
        URLConnection connection = realUrl.openConnection();
        // 建立实际的连接
        connection.connect();
        // 获取所有响应头字段
//        Map<String, List<String>> map = connection.getHeaderFields();
        // 定义 BufferedReader输入流来读取URL的响应
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String len;
        String result = "";
        while ((len = bufferedReader.readLine()) != null) {
            result += len;
        }
//
        Map<String, Object> jsonMap = (Map<String, Object>) JSONObject.parse(result);
        List<Map<String,Object>> data = (List<Map<String,Object>>) jsonMap.get("data");

        ArrayList<WeatherDay> weathers = new ArrayList<>();
//
        for (Map mm:data
             ) {

            String date = JSON.toJSONString(mm.get("date"));
            String week = JSON.toJSONString(mm.get("week"));
            String wea = JSON.toJSONString(mm.get("wea"));

            String tem = JSON.toJSONString(mm.get("tem"));
            String tem1 = JSON.toJSONString(mm.get("tem2"));

            String sunset = JSON.toJSONString(mm.get("sunset"));
            String win_speed = JSON.toJSONString(mm.get("win_speed"));
            WeatherDay weatherDay = new WeatherDay(date,week,wea,tem,tem1,sunset,win_speed);
            weathers.add(weatherDay);
        }

        return weathers;

    }

    /**
     * 创建数据库表格，存储请求的天气信息
     */
    private static void createMySQL() throws Exception {

        long start = System.currentTimeMillis();
        Statement statement = (Statement)(objects[0]);
        //删除已有的表数据，保持数据库只有七天的天气信息：
        String deleteTable = "drop table if exists WeatherInfo;";
        statement.execute(deleteTable);

        String createSQL = "create table if not exists WeatherInfo(" +
                "id int unsigned auto_increment," +
                "date varchar(100) not null," +
                "week varchar(100) not null," +
                "wea varchar(100) not null," +
                "tem varchar(100) not null," +
                "tem1 varchar(100) not null," +
                "sunset varchar(100) not null," +
                "win_speed varchar(100) not null," +
                "primary key(id)" +
                ")engine=InnoDB default charset=utf8;";

        statement.execute(createSQL);

        ArrayList<WeatherDay> weatherDays = requestWeather();
        for (WeatherDay w :
                weatherDays) {
            String insertString = "insert into WeatherInfo(date,week,wea,tem,tem1,sunset,win_speed)" +
                    "values('"+w.date+"','"+w.week+"','"+w.wea+"','"+w.tem+"','"+w.tem1+"','"+w.sunset+"','"+w.win_speed+"')";
            statement.executeUpdate(insertString);
        }

//        statement.close();
//        connection.close();
        long end = System.currentTimeMillis();
        System.out.println("请求耗时："+(end-start)+"ms");
    }

    /**
     * 从数据库中读取天气数据，将信息转化为天气类，存储在数组中；
     */
    private static void readMySQL() throws Exception{

        long start = System.currentTimeMillis();
        Statement statement = (Statement)objects[0];
        Connection connection = (Connection)objects[1];

        String queryString = "select * from WeatherInfo";

        ResultSet resultSet = statement.executeQuery(queryString);
        ArrayList<WeatherDay> weatherDays = new ArrayList<>();
        /** 判断下一行是否有数据 **/
        while (resultSet.next()){
        /**
         * resultSet.getString(1) : 根据数据库列的编号获取数据
         * resultSet.getString("date") ： 根据数据库列的标签（列名）获取数据
         */
            String date = resultSet.getString("date");
            String week = resultSet.getString("week");
            String wea = resultSet.getString("wea");
            String tem = resultSet.getString("tem");
            String tem1 = resultSet.getString("tem1");
            String sunset = resultSet.getString("sunset");
            String win_speed = resultSet.getString("win_speed");
            WeatherDay weatherDay = new WeatherDay(date,week,wea,tem,tem1,sunset,win_speed);
            weatherDays.add(weatherDay);
        }

        for (WeatherDay d:weatherDays
             ) {
            System.out.println(d.week);
        }
        resultSet.close();
        statement.close();
        connection.close();
        long end = System.currentTimeMillis();
        System.out.println("耗时："+(end-start)+"ms");

    }

    public static void main(String[] args) throws Exception {
        createMySQL();
        readMySQL();
    }

}
