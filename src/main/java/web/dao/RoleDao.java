package web.dao;

import web.model.Role;
import java.util.List;

public interface RoleDao {

    List<Role> getListRoles();

    void addRole(Role role);

    Role getById(int id);

    Role getByName(String name);
}