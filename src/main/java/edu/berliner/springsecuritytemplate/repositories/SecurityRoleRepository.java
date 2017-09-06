package edu.berliner.springsecuritytemplate.repositories;

import edu.berliner.springsecuritytemplate.models.SecurityRole;
import org.springframework.data.repository.CrudRepository;

public interface SecurityRoleRepository extends CrudRepository<SecurityRole,Long>
{
}
