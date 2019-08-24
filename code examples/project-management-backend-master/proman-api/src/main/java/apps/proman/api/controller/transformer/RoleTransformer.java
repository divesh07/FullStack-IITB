package apps.proman.api.controller.transformer;

import java.util.List;
import java.util.stream.Collectors;

import apps.proman.api.model.PermissionsType;
import apps.proman.api.model.RoleDetailsType;
import apps.proman.api.model.RoleType;
import apps.proman.service.user.entity.RoleEntity;
import apps.proman.service.user.entity.RolePermissionEntity;

public final class RoleTransformer {

    private RoleTransformer(){}

    public static RoleType toRoleType(final RoleEntity roleEntity) {
        if(roleEntity == null) {
            return null;
        }
        return new RoleType().id(roleEntity.getUuid()).name(roleEntity.getName());
    }

    public static RoleDetailsType toRoleDetailsType(RoleEntity roleEntity) {
        if(roleEntity == null) {
            return null;
        }
        return new RoleDetailsType()
                .id(roleEntity.getUuid())
                .name(roleEntity.getName())
                .permissions(toPermissionsType(roleEntity.getPermissions()));
    }

    private static List<PermissionsType> toPermissionsType(List<RolePermissionEntity> permissions) {
        return permissions.stream().map(rolePermissionEntity -> {
            return new PermissionsType().id(rolePermissionEntity.getPermissionEntity().getUuid()).name(rolePermissionEntity.getPermissionEntity().getName());
        }).collect(Collectors.toList());
    }

}