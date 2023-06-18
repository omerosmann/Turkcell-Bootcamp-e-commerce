package e.commerce.ecommerce.api.controller;

import e.commerce.ecommerce.business.abstracts.RoleService;
import e.commerce.ecommerce.business.dto.requests.creates.CreateRoleRequest;
import e.commerce.ecommerce.business.dto.requests.updates.UpdateRoleRequest;
import e.commerce.ecommerce.business.dto.responses.creates.CreateRoleResponse;
import e.commerce.ecommerce.business.dto.responses.gets.Role.GetAllRolesResponse;
import e.commerce.ecommerce.business.dto.responses.gets.Role.GetRoleResponse;
import e.commerce.ecommerce.business.dto.responses.updates.UpdateRoleResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/roles")
public class RolesController {
    private final RoleService roleService;

    @GetMapping()
    public List<GetAllRolesResponse> findAll(){
        return roleService.getAll();
    }
    @GetMapping("/{id}")
    public GetRoleResponse getById(@PathVariable("id") int id){
        return roleService.getById(id);
    }
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public CreateRoleResponse add(@Valid @RequestBody CreateRoleRequest createRoleRequest){
        return roleService.add(createRoleRequest);
    }
    @PutMapping()
    public UpdateRoleResponse update(@RequestBody UpdateRoleRequest updateRoleRequest){
        return roleService.update(updateRoleRequest);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id){
        roleService.delete(id);
    }
}
