package main.java.info.aoye.TestAnnotation;

public class AnnotationA extends TestBase{
    @Override //内置注解，标记当前方法覆盖父类方法
    public void methodA() {
        super.methodA();
        System.out.println("Override annotation,覆盖父类中的方法");
    }

    @Deprecated  //内置注解，标记当前方法即将被废弃，不推荐使用。
    public void methodB(){
        System.out.println("Deprecated annotation,标记当前方法即将被废弃，不推荐使用");
    }

    // todo  @SuppressWarnings How to use this annotation ?
}
