package furama_resort.repository;

import furama_resort.model.AttachService;
import furama_resort.model.User;
import furama_resort.model.UserRole;
import furama_resort.model.contract.Contract;
import furama_resort.model.contract.ContractDetail;
import furama_resort.model.person.Customer;
import furama_resort.model.person.Employee;
import furama_resort.model.service_model.Service;
import furama_resort.model.service_model.House;
import furama_resort.model.service_model.Room;
import furama_resort.model.service_model.Villa;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FuramaRepositoryImpl<R> implements IFuramaRepository<R> {
    @Override
    public List<R> getAll(String typeName) {
        List<R> list = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        CallableStatement cStmt = null;
        ResultSet rs = null;
        if (connection != null) {
            try {
                cStmt = connection.prepareCall("{CALL get_all_" + typeName + "()}");
                rs = cStmt.executeQuery();
                while (rs.next()) {
                    list.add(getItem(typeName, rs));
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                try {
                    rs.close();
                    cStmt.close();
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return list;
    }

    @Override
    public List<R> getAllPagination(String typeName, int offset, int limit) {
        List<R> list = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        CallableStatement cStmt = null;
        ResultSet rs = null;
        if (connection != null) {
            try {
                cStmt = connection.prepareCall("{CALL get_all_" + typeName + "_pagination(?, ?)}");
                cStmt.setInt(1, offset);
                cStmt.setInt(2, limit);
                rs = cStmt.executeQuery();
                while (rs.next()) {
                    list.add(getItem(typeName, rs));
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                try {
                    rs.close();
                    cStmt.close();
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return list;
    }

    @Override
    public R getLast(String typeName) {
        R r = null;
        Connection connection = DBConnection.getConnection();
        CallableStatement cStmt = null;
        ResultSet rs = null;
        if (connection != null) {
            try {
                cStmt = connection.prepareCall("{CALL get_" + typeName + "_last()}");
                rs = cStmt.executeQuery();
                while (rs.next()) {
                    r = getItem(typeName, rs);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                try {
                    rs.close();
                    cStmt.close();
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return r;
    }

    @Override
    public List<R> getSearch(String typeName, String search) {
        List<R> list = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        CallableStatement cStmt = null;
        ResultSet rs = null;
        if (connection != null) {
            try {
                cStmt = connection.prepareCall("{CALL get_search_" + typeName + "(?)}");
                cStmt.setString(1, search);
                rs = cStmt.executeQuery();
                while (rs.next()) {
                    list.add(getItem(typeName, rs));
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                try {
                    rs.close();
                    cStmt.close();
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return list;
    }

    @Override
    public List<R> getSearchPagination(String typeName, String search, int offset, int limit) {
        List<R> list = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        CallableStatement cStmt = null;
        ResultSet rs = null;
        if (connection != null) {
            try {
                cStmt = connection.prepareCall("{CALL get_search_" + typeName + "_pagination(?, ?, ?)}");
                cStmt.setString(1, search);
                cStmt.setInt(2, offset);
                cStmt.setInt(3, limit);
                rs = cStmt.executeQuery();
                while (rs.next()) {
                    list.add(getItem(typeName, rs));
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                try {
                    rs.close();
                    cStmt.close();
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return list;
    }

    public R getById(String typeName, int id) {
        R item = null;
        Connection connection = DBConnection.getConnection();
        CallableStatement cStmt = null;
        ResultSet rs = null;
        if (connection != null) {
            try {
                cStmt = connection.prepareCall("{CALL get_" + typeName + "_by_id(?)}");
                cStmt.setInt(1, id);
                rs = cStmt.executeQuery();
                if (rs.next()) {
                    item = getItem(typeName, rs);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                try {
                    rs.close();
                    cStmt.close();
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return item;
    }

    @Override
    public void add(String typeName, R r) throws SQLException {
        Connection connection = DBConnection.getConnection();
        CallableStatement cStmt = null;
        String query = getQueryInsert(typeName);
        if (connection != null) {
            try {
                cStmt = connection.prepareCall(query);
                setCStmtInsert(typeName, cStmt, r);
                cStmt.executeUpdate();
            } finally {
                try {
                    cStmt.close();
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public void delete(String typeName, int id) throws SQLException {
        Connection connection = DBConnection.getConnection();
        CallableStatement cStmt = null;
        if (connection != null) {
            try {
                cStmt = connection.prepareCall("{CALL delete_" + typeName + "(?)}");
                cStmt.setInt(1, id);
                cStmt.executeUpdate();
            } finally {
                try {
                    cStmt.close();
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    @Override
    public void update(String typeName, R r) throws SQLException {
        Connection connection = DBConnection.getConnection();
        CallableStatement cStmt = null;
        String query = getQueryUpdate(typeName);
        if (connection != null) {
            try {
                cStmt = connection.prepareCall(query);
                setCStmtUpdate(typeName, cStmt, r);
                cStmt.executeUpdate();
            } finally {
                try {
                    cStmt.close();
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    private R getItem(String typeName, ResultSet rs) throws SQLException {
        switch (typeName) {
            case "customer":
                return (R) getCustomer(rs);
            case "employee":
                return (R) getEmployee(rs);
            case "service":
                return (R) getService(rs);
            case "user":
                return (R) getUser(rs);
            case "user_role":
                return (R) getUserRole(rs);
            case "contract":
                return (R) getContract(rs);
            case "contract_detail":
                return (R) getContractDetail(rs);
            case "attach_service":
                return (R) getAttachService(rs);
        }
        return null;
    }

    private Customer getCustomer(ResultSet rs) throws SQLException {
        int id = rs.getInt("c_id");
        String name = rs.getString("c_name");
        Date birthday = rs.getDate("c_birthday");
        String idCard = rs.getString("c_id_card");
        String phone = rs.getString("c_phone");
        String email = rs.getString("c_email");
        String address = rs.getString("c_address");
        boolean gender = rs.getBoolean("c_gender");
        int customerTypeId = rs.getInt("c_type_id");
        return new Customer(id, name, birthday, gender, idCard, phone, email, address, customerTypeId);
    }

    private Employee getEmployee(ResultSet rs) throws SQLException {
        int id = rs.getInt("e_id");
        String name = rs.getString("e_name");
        Date birthday = rs.getDate("e_birthday");
        String idCard = rs.getString("e_id_card");
        String phone = rs.getString("e_phone");
        double salary = rs.getDouble("e_salary");
        String email = rs.getString("e_email");
        String address = rs.getString("e_address");
        boolean gender = rs.getBoolean("e_gender");
        int positionId = rs.getInt("p_id");
        int educationDegreeId = rs.getInt("e_degree_id");
        int divisionId = rs.getInt("d_id");
        String username = rs.getString("username");
        return new Employee(id, name, birthday, gender, idCard, phone, email, address, salary, positionId, educationDegreeId, divisionId, username);
    }

    private Service getService(ResultSet rs) throws SQLException {
        int id = rs.getInt("s_id");
        String name = rs.getString("s_name");
        int area = rs.getInt("s_area");
        double cost = rs.getDouble("s_cost");
        int maxPeople = rs.getInt("s_max_people");
        int rentTypeId = rs.getInt("r_type_id");
        int serviceTypeId = rs.getInt("s_type_id");
        String standardRoom = rs.getString("s_standard_room");
        String desOtherConvenience = rs.getString("s_other_convenience");
        double poolArea = rs.getDouble("s_pool_area");
        int numberOfFloors = rs.getInt("s_number_of_floors");
        String freeService = rs.getString("s_free_service");
        switch (serviceTypeId) {
            case 1:
                return new Room(id, name, area, cost, maxPeople, rentTypeId, serviceTypeId, freeService);
            case 2:
                return new House(id, name, area, cost, maxPeople, rentTypeId, serviceTypeId, standardRoom, desOtherConvenience, numberOfFloors);
            default:
                return new Villa(id, name, area, cost, maxPeople, rentTypeId, serviceTypeId, standardRoom, desOtherConvenience, poolArea, numberOfFloors);
        }
    }

    private User getUser(ResultSet rs) throws SQLException {
        String username= rs.getString("username");
        String password= rs.getString("password");
        return new User(username, password);
    }

    private UserRole getUserRole(ResultSet rs) throws SQLException {
        String username = rs.getString("username");
        int roleId = rs.getInt("r_id");
        return new UserRole(username, roleId);
    }

    private Contract getContract(ResultSet rs) throws SQLException {
        int id = rs.getInt("ct_id");
        Date startDate = rs.getDate("ct_start_date");
        Date endDate = rs.getDate("ct_end_date");
        double deposit = rs.getDouble("ct_deposit");
        double totalMoney = rs.getDouble("ct_total_money");
        int employeeId = rs.getInt("e_id");
        int customerId = rs.getInt("c_id");
        int serviceId = rs.getInt("s_id");
        return new Contract(id, startDate, endDate,deposit, totalMoney, employeeId, customerId, serviceId);
    }

    private ContractDetail getContractDetail(ResultSet rs) throws SQLException {
        int id = rs.getInt("ct_detail_id");
        int contractId = rs.getInt("ct_id");
        int attachServiceId = rs.getInt("as_id");
        int quantity = rs.getInt("quantity");
        return new ContractDetail(id, contractId, attachServiceId, quantity);
    }

    private AttachService getAttachService(ResultSet rs) throws SQLException {
        int id = rs.getInt("as_id");
        String name = rs.getString("as_name");
        double cost = rs.getDouble("as_cost");
        String unit = rs.getString("as_unit");
        String status = rs.getString("as_status");
        return new AttachService(id, name, cost, unit, status);
    }

    private String getQueryInsert(String typeName) {
        switch (typeName) {
            case "customer":
                return "{CALL insert_customer(?, ?, ?, ?, ?, ?, ?, ?)}";
            case "employee":
                return "{CALL insert_employee(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
            case "service":
                return "{CALL insert_service(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
            case "user":
                return "{CALL insert_user(?, ?)}";
            case "user_role":
                return "{CALL insert_user_role(?, ?)}";
            case "contract":
                return "{CALL insert_contract(?, ?, ?, ?, ?, ?, ?)}";
            case "contract_detail":
                return "{CALL insert_contract_detail(?, ?, ?)}";
        }
        return null;
    }

    private void setCStmtInsert(String typeName, CallableStatement cStmt, R r) throws SQLException {
        switch (typeName) {
            case "customer":
                setCStmtCustomerInsert(cStmt, (Customer) r);
                break;
            case "employee":
                setCStmtEmployeeInsert(cStmt, (Employee) r);
                break;
            case "service":
                setCStmtServiceInsert(cStmt, (Service) r);
                break;
            case "user":
                setCStmtUserInsert(cStmt, (User) r);
                break;
            case "user_role":
                setCStmtUserRoleInsert(cStmt, (UserRole) r);
                break;
            case "contract":
                setCStmtContractInsert(cStmt, (Contract) r);
                break;
            case "contract_detail":
                setCStmtContractDetailInsert(cStmt, (ContractDetail) r);
                break;
        }
    }

    private void setCStmtCustomerInsert(CallableStatement cStmt, Customer customer) throws SQLException {
        cStmt.setString(1, customer.getName());
        cStmt.setDate(2, customer.getBirthday());
        cStmt.setBoolean(3, customer.isGender());
        cStmt.setString(4, customer.getIdCard());
        cStmt.setString(5, customer.getPhone());
        cStmt.setString(6, customer.getEmail());
        cStmt.setString(7, customer.getAddress());
        cStmt.setInt(8, customer.getCustomerTypeId());
    }

    private void setCStmtEmployeeInsert(CallableStatement cStmt, Employee employee) throws SQLException {
        cStmt.setString(1, employee.getName());
        cStmt.setDate(2, employee.getBirthday());
        cStmt.setBoolean(3, employee.isGender());
        cStmt.setString(4, employee.getIdCard());
        cStmt.setDouble(5, employee.getSalary());
        cStmt.setString(6, employee.getPhone());
        cStmt.setString(7, employee.getEmail());
        cStmt.setString(8, employee.getAddress());
        cStmt.setInt(9, employee.getPositionId());
        cStmt.setInt(10, employee.getEducationDegreeId());
        cStmt.setInt(11, employee.getDivisionId());
        cStmt.setString(12, employee.getUsername());
    }

    private void setCStmtServiceInsert(CallableStatement cStmt, Service service) throws SQLException {
        cStmt.setString(1, service.getName());
        cStmt.setInt(2, service.getArea());
        cStmt.setDouble(3, service.getCost());
        cStmt.setInt(4, service.getMaxPeople());
        cStmt.setInt(10, service.getRentTypeId());
        cStmt.setInt(11, service.getServiceTypeId());

        if (service instanceof Room) {
            Room room = (Room) service;
            cStmt.setString(5, null);
            cStmt.setString(6, null);
            cStmt.setNull(7, 0);
            cStmt.setNull(8, 0);
            cStmt.setString(9, room.getFreeService());
        } else if (service instanceof House) {
            House house = (House) service;
            cStmt.setString(5, house.getStandardRoom());
            cStmt.setString(6, house.getOtherConvenience());
            cStmt.setNull(7, 0);
            cStmt.setInt(8, house.getNumberOfFloors());
            cStmt.setString(9, null);
        } else {
            Villa villa = (Villa) service;
            cStmt.setString(5, villa.getStandardRoom());
            cStmt.setString(6, villa.getOtherConvenience());
            cStmt.setDouble(7, villa.getPoolArea());
            cStmt.setInt(8, villa.getNumberOfFloors());
            cStmt.setString(9, null);
        }
    }

    private void setCStmtUserInsert(CallableStatement cStmt, User user) throws SQLException {
        cStmt.setString(1, user.getUsername());
        cStmt.setString(2, user.getPassword());
    }

    private void setCStmtUserRoleInsert(CallableStatement cStmt, UserRole userRole) throws SQLException {
        cStmt.setString(1, userRole.getUsername());
        cStmt.setInt(2, userRole.getRoleId());
    }

    private void setCStmtContractInsert(CallableStatement cStmt, Contract contract) throws SQLException {
        cStmt.setDate(1, contract.getStartDate());
        cStmt.setDate(2, contract.getEndDate());
        cStmt.setDouble(3, contract.getDeposit());
        cStmt.setDouble(4, contract.getTotalMoney());
        cStmt.setInt(5, contract.getEmployeeId());
        cStmt.setInt(6, contract.getCustomerId());
        cStmt.setInt(7, contract.getServiceId());
    }

    private void setCStmtContractDetailInsert(CallableStatement cStmt, ContractDetail contractDetail) throws SQLException {
        cStmt.setInt(1, contractDetail.getContractId());
        cStmt.setInt(2, contractDetail.getAttachServiceId());
        cStmt.setInt(3, contractDetail.getQuantity());
    }

    private String getQueryUpdate(String typeName) {
        switch (typeName) {
            case "customer":
                return "{CALL update_customer(?, ?, ?, ?, ?, ?, ?, ?, ?)}";
            case "employee":
                return "{CALL update_employee(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
            case "service":
                return "{CALL update_service(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
            case "user_password":
                return "{CALL update_user_password(?, ?)}";
            case "user_role":
                return "{CALL update_user_role(?, ?)}";
            case "contract":
                return "{CALL update_contract(?, ?, ?, ?, ?, ?, ?, ?)}";
            case "contract_detail":
                return "{CALL update_contract_detail(?, ?, ?)}";
        }
        return null;
    }

    private void setCStmtUpdate(String typeName, CallableStatement cStmt, R r) throws SQLException {
        switch (typeName) {
            case "customer":
                setCStmtCustomerUpdate(cStmt, (Customer) r);
                break;
            case "employee":
                setCStmtEmployeeUpdate(cStmt, (Employee) r);
                break;
            case "service":
                setCStmtServiceUpdate(cStmt, (Service) r);
                break;
            case "user_password":
                setCStmtUserPasswordUpdate(cStmt, (User) r);
                break;
            case "user_role":
                setCStmtUserRoleUpdate(cStmt, (UserRole) r);
                break;
            case "contract":
                setCStmtContractUpdate(cStmt, (Contract) r);
                break;
            case "contract_detail":
                setCStmtContractDetailUpdate(cStmt, (ContractDetail) r);
                break;
        }
    }

    private void setCStmtCustomerUpdate(CallableStatement cStmt, Customer customer) throws SQLException {
        cStmt.setInt(1, customer.getId());
        cStmt.setString(2, customer.getName());
        cStmt.setDate(3, customer.getBirthday());
        cStmt.setBoolean(4, customer.isGender());
        cStmt.setString(5, customer.getIdCard());
        cStmt.setString(6, customer.getPhone());
        cStmt.setString(7, customer.getEmail());
        cStmt.setString(8, customer.getAddress());
        cStmt.setInt(9, customer.getCustomerTypeId());
    }

    private void setCStmtEmployeeUpdate(CallableStatement cStmt, Employee employee) throws SQLException {
        cStmt.setInt(1, employee.getId());
        cStmt.setString(2, employee.getName());
        cStmt.setDate(3, employee.getBirthday());
        cStmt.setBoolean(4, employee.isGender());
        cStmt.setString(5, employee.getIdCard());
        cStmt.setDouble(6, employee.getSalary());
        cStmt.setString(7, employee.getPhone());
        cStmt.setString(8, employee.getEmail());
        cStmt.setString(9, employee.getAddress());
        cStmt.setInt(10, employee.getPositionId());
        cStmt.setInt(11, employee.getEducationDegreeId());
        cStmt.setInt(12, employee.getDivisionId());
    }

    private void setCStmtServiceUpdate(CallableStatement cStmt, Service service) throws SQLException {
        cStmt.setInt(1, service.getId());
        cStmt.setString(2, service.getName());
        cStmt.setInt(3, service.getArea());
        cStmt.setDouble(4, service.getCost());
        cStmt.setInt(5, service.getMaxPeople());
        cStmt.setInt(11, service.getRentTypeId());
        cStmt.setInt(12, service.getServiceTypeId());
        if (service instanceof Room) {
            Room room = (Room) service;
            cStmt.setString(6, null);
            cStmt.setString(7, null);
            cStmt.setNull(8, 0);
            cStmt.setNull(9, 0);
            cStmt.setString(10, room.getFreeService());
        } else if (service instanceof House) {
            House house = (House) service;
            cStmt.setString(6, house.getStandardRoom());
            cStmt.setString(7, house.getOtherConvenience());
            cStmt.setNull(8, 0);
            cStmt.setInt(9, house.getNumberOfFloors());
            cStmt.setString(10, null);
        } else {
            Villa villa = (Villa) service;
            cStmt.setString(6, villa.getStandardRoom());
            cStmt.setString(7, villa.getOtherConvenience());
            cStmt.setDouble(8, villa.getPoolArea());
            cStmt.setInt(9, villa.getNumberOfFloors());
            cStmt.setString(10, null);
        }
    }

    private void setCStmtUserPasswordUpdate(CallableStatement cStmt, User user) throws SQLException {
        cStmt.setString(1, user.getUsername());
        cStmt.setString(2, user.getPassword());
    }

    private void setCStmtUserRoleUpdate(CallableStatement cStmt, UserRole userRole) throws SQLException {
        cStmt.setString(1, userRole.getUsername());
        cStmt.setInt(2, userRole.getRoleId());
    }

    private void setCStmtContractUpdate(CallableStatement cStmt, Contract contract) throws SQLException {
        cStmt.setInt(1, contract.getId());
        cStmt.setDate(2, contract.getStartDate());
        cStmt.setDate(3, contract.getEndDate());
        cStmt.setDouble(4, contract.getDeposit());
        cStmt.setDouble(5, contract.getTotalMoney());
        cStmt.setInt(6, contract.getEmployeeId());
        cStmt.setInt(7, contract.getCustomerId());
        cStmt.setInt(8, contract.getServiceId());
    }

    private void setCStmtContractDetailUpdate(CallableStatement cStmt, ContractDetail contractDetail) throws SQLException {
        cStmt.setInt(1, contractDetail.getContractId());
        cStmt.setInt(2, contractDetail.getAttachServiceId());
        cStmt.setInt(3, contractDetail.getQuantity());
    }
}
