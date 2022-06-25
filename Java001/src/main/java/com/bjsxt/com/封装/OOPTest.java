package com.bjsxt.com.封装;

public class OOPTest {

    public static void main(String[] args) {
        OOPTool tool = new OOPTool();
        tool.brand = "Apple";
        tool.address = "America";
        tool.size = "128G";
        tool.playVideo("https://www.baidu.com");

        OptmisticObj obj =  new OptmisticObj();
        obj.school = "中山大学";

    }

}
