package e.commerce.ecommerce.business.abstracts;





import e.commerce.ecommerce.business.dto.requests.creates.CreateRoleRequest;
import e.commerce.ecommerce.business.dto.requests.updates.UpdateRoleRequest;
import e.commerce.ecommerce.business.dto.responses.creates.CreateRoleResponse;
import e.commerce.ecommerce.business.dto.responses.gets.Role.GetAllRolesResponse;
import e.commerce.ecommerce.business.dto.responses.gets.Role.GetRoleResponse;
import e.commerce.ecommerce.business.dto.responses.updates.UpdateRoleResponse;

import java.util.List;

public interface RoleService {
    List<GetAllRolesResponse> getAll();
    GetRoleResponse getById(int id);
    CreateRoleResponse add(CreateRoleRequest createRoleRequest);
    UpdateRoleResponse update(UpdateRoleRequest updateRoleRequest);
    void delete(int id);

}
