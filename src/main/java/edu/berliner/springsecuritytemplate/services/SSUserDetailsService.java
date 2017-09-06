package edu.berliner.springsecuritytemplate.services;

import edu.berliner.springsecuritytemplate.models.SecurityRole;
import edu.berliner.springsecuritytemplate.models.SecurityUser;
import edu.berliner.springsecuritytemplate.repositories.SecurityUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

@Transactional
@Service
public class SSUserDetailsService implements UserDetailsService
{
    @Autowired
    private SecurityUserRepository userRepo;

    public SSUserDetailsService(SecurityUserRepository userRepo)
    {
        this.userRepo=userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        try
        {
            SecurityUser user = userRepo.findByUsername(username);
            if(user==null)
            {
                System.out.println("User not found-this message is for debug only");
                return null;
            }
            System.out.println("Username: "+user.toString());
            return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthorities(user));
        }
        catch (Exception e)
        {
            throw new UsernameNotFoundException("Unable to find user");
        }
    }

    private Set<GrantedAuthority> getAuthorities(SecurityUser user)
    {
        Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
        for(SecurityRole role : user.getSecRoles()) {
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.getSecRoleName());
            authorities.add(grantedAuthority);
        }
        System.out.println("user authorities are " + authorities.toString());
        return authorities;
    }
}
