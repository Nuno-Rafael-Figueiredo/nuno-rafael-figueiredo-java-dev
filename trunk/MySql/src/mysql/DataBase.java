package mysql;

import design.Base;
import design.NamingPolicy;

/**
 * Created with IntelliJ IDEA.
 * User: Nuno
 * Date: 05-09-2013
 * Time: 16:36
 * To change this template use File | Settings | File Templates.
 */
public abstract class DataBase extends Base{
    public NamingPolicy[] tableNamingPolicies;

    private String username;
    private String password;

    protected DataBase(NamingPolicy namingPolicy, NamingPolicy... tableNamingPolicies){
        super(namingPolicy);
        this.tableNamingPolicies = tableNamingPolicies;
        MySql.INSTANCE.setDataBase(this);
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
