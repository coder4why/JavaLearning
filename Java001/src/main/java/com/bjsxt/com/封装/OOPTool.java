package com.bjsxt.com.封装;

//封装一个工具类
/**
 * Java中的访问控制符：
 *      private：当前类访问
 *      default：当前类、同一个包package可访问 （默认）
 *      protected：当前类、同一个包Package、子类可访问
 *      public：当前类、同一个包Package、子类、所有类可访问
 */
public class OOPTool {
    String address;
    private String name;
    protected String brand;
    public String size;
    public boolean apple;

    public void setApple(boolean apple){
        this.apple = apple;
    }
    //boolean类型的getter是is开头，其他类型是get开头
    public boolean isApple(){
        return this.apple;
    }

    public String getName(){
        return this.name;
    }

    public void playVideo(String videoUrl){
        System.out.println(videoUrl);
    }
    public static void main(String[] args) {
        OOPTool tool = new OOPTool();
        tool.name = "iPhone6s plus";
    }

}

//未使用修饰符的class只能在当前package类内被访问；
class OptmisticObj  {
    String name;
    protected String school;
    void say(){
    }

}