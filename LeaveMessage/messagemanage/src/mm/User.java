package mm;

public class User {
    //private 访问权限：本类内部
    private Integer id;//用户id
    private String name;//用户名
    private String password;//密码
    private int role;//用户类型

    public User() {
        super();
    }

    //获取id
    public Integer getId(){
        return id;
    }
    //设置id
    public void setId(Integer id){
        this.id=id;
    }
    //获取用户名
    public String getName(){
        return name;
    }
    //设置用户名
    public void setName(String name){
        this.name=name;
    }
    //获取密码
    public String getPassword(){
        return password;
    }
    //设置密码
    public void setPassword(String password){
        this.password=password;
    }
    //获取用户类型
    public int getRole(){
        return role;
    }
    //设置用户类型
    public void setRole(int role){
        this.role=role;
    }
}
