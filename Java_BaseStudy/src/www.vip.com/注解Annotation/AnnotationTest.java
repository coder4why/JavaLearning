package www.vip.com.注解Annotation;

import java.lang.annotation.Target;
/**
 * Java中的注解(Annotation)：
 *    注解不是程序本身，可以对程序作出解释；
 *    可以被其他程序读取(如：编译器等)；
 * 注解(Annotation)的格式：
 *       注解是以"@注释名",在代码中存在的，还可以添加一些参数
 *    值(如：@SuppressWarnings(value="unchecked"))；
 * Annotation在哪里使用？
 *    可以附加在package、class、method、field等上面；
 *    相等于给他们添加了额外的辅助信息，我们可以通过反射机制编程实现对这些元数据的访问；
 */
public class AnnotationTest {
    @Override
    public String toString() { return super.toString(); }
    public static void main(String[] args) {
        System.out.println("你好👋");
    }
}

/**
 *    元注解的作用就是负责注解其他注解；Java定义了4个标准的meta-annotation类型，
 * 他们被用来提供对其他annotation类型作说明；
 *     如： @Target、@Retention、@Decumented、@Inherited;
 */
@Target(value={})
@interface MyAnnotation{



}