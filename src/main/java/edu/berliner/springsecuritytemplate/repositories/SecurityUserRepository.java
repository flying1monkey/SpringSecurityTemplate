package edu.berliner.springsecuritytemplate.repositories;

import edu.berliner.springsecuritytemplate.models.SecurityUser;
import org.springframework.data.repository.CrudRepository;

public interface SecurityUserRepository extends CrudRepository<SecurityUser,Long>
{
    SecurityUser findByUsername(String username);

}
