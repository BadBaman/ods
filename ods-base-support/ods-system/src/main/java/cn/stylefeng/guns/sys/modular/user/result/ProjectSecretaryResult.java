package cn.stylefeng.guns.sys.modular.user.result;

public class ProjectSecretaryResult {

    private static final long serialVersionUID = 1L;

    /*
     *  项目名称 name
     * */
    private String name;

    /*
     *  邮箱 email
     * */
    private String email;

    /*
     *  电话 phone
     * */
    private String phone;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
