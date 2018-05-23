package info.aoye.TestAnnotation;

/**
 * 注解的元素在使用时表现为名-值对的形式，并需要置于 @注解类名 声明之后的括号内。如果没有使用括号，代表全部使用默认值。
 */
@DBTable(name = "MEMBER")  //代表数据库表，注解元素name表示表名；
public class Member {
    @SQLString(30) String firstName;
    @SQLString(50) String lastName;
    @SQLInteger int age;  //代表表中的int列，name表示列名
    @SQLString(value = 30, constraints = @Constraints(primaryKey = true)) String handle; //代表表中的String列，注解元素value表示列长度，name表示列名，constraints表示对列的一些约束条件；
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public int getAge() {
        return age;
    }
    public String getHandle() {
        return handle;
    }
    public String toString() {
        return handle;
    }
}
