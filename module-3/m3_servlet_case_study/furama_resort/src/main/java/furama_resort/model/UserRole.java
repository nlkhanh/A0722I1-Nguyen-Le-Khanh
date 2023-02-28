package furama_resort.model;

public class UserRole {
    private String username;
    private int roleId;

    public UserRole() {
    }

    public UserRole(String username, int roleId) {
        this.username = username;
        this.roleId = roleId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }
}
