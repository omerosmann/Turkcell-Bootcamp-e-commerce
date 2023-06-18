package e.commerce.ecommerce.business.concretes;



import e.commerce.ecommerce.business.abstracts.RoleService;
import e.commerce.ecommerce.business.dto.requests.creates.CreateRoleRequest;
import e.commerce.ecommerce.business.dto.requests.updates.UpdateRoleRequest;
import e.commerce.ecommerce.business.dto.responses.creates.CreateRoleResponse;
import e.commerce.ecommerce.business.dto.responses.gets.Role.GetAllRolesResponse;
import e.commerce.ecommerce.business.dto.responses.gets.Role.GetRoleResponse;
import e.commerce.ecommerce.business.dto.responses.updates.UpdateRoleResponse;
import e.commerce.ecommerce.entities.Role;
import e.commerce.ecommerce.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoleManager implements RoleService {
    private final RoleRepository roleRepository;
    private final ModelMapper modelMapper;
    @Override
    public List<GetAllRolesResponse> getAll() {
        List<Role> roles = roleRepository.findAll();
        List<GetAllRolesResponse> getAllRolesResponses = roles
                .stream()
                .map(role -> modelMapper.map(role, GetAllRolesResponse.class))
                .collect(Collectors.toList());

        return getAllRolesResponses;
    }

    @Override
    public GetRoleResponse getById(int id) {
        Role role = roleRepository.findById(id).orElseThrow();
        GetRoleResponse getRoleResponse = modelMapper.map(role, GetRoleResponse.class);

        return getRoleResponse;
    }

    @Override
    public CreateRoleResponse add(CreateRoleRequest createRoleRequest) {
        Role role = modelMapper.map(createRoleRequest, Role.class);
        role.setId(0);
        roleRepository.save(role);

        CreateRoleResponse updateRoleResponse = modelMapper.map(role, CreateRoleResponse.class);

        return updateRoleResponse;
    }

    @Override
    public UpdateRoleResponse update(UpdateRoleRequest updateRoleRequest) {
        Role role = modelMapper.map(updateRoleRequest, Role.class);
        role.setId(0);
        roleRepository.save(role);

        UpdateRoleResponse updateRoleResponse = modelMapper.map(role, UpdateRoleResponse.class);

        return updateRoleResponse;
    }

    @Override
    public void delete(int id) {
        roleRepository.deleteById(id);
    }
}
