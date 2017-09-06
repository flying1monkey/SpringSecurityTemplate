package edu.berliner.springsecuritytemplate.models;

import javax.persistence.*;
import java.util.Collection;
import java.util.ArrayList;

@Entity
public class SecurityRole
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long secRoleId;

    @Column(unique = true)
    private String secRoleName;

    @ManyToMany(mappedBy = "secRoles")
    private Collection<SecurityUser> secUsers;

    public SecurityRole()
    {
        this.secUsers=new ArrayList<SecurityUser>();
    }

    public void addSecUser(SecurityUser secUser)
    {
        this.secUsers.add(secUser);
    }

    public long getSecRoleId()
    {
        return secRoleId;
    }

    public void setSecRoleId(long secRoleId)
    {
        this.secRoleId = secRoleId;
    }

    public String getSecRoleName()
    {
        return secRoleName;
    }

    public void setSecRoleName(String secRoleName)
    {
        this.secRoleName = secRoleName;
    }

    public Collection<SecurityUser> getSecUsers()
    {
        return secUsers;
    }

    public void setSecUsers(Collection<SecurityUser> secUsers)
    {
        this.secUsers = secUsers;
    }
}
