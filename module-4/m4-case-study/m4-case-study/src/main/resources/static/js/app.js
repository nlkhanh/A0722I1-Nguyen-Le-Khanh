function activeNavItem(pageName) {
    $("#header .nav-link").each(function () {
        if ($(this).hasClass("active")) {
            $(this).removeClass("active");
        }
    })
    $("#" + pageName).addClass("active");
}

$(".sidebar .nav-item").hover(function () {
    $(this).addClass("border-bottom border-secondary")
}, function () {
    $(this).removeClass("border-bottom border-secondary")
})

function activePage(currentPage, totalPages) {
    $("#page-link-" + currentPage).addClass("active");
    if (currentPage == 0) {
        $(".page-link-previous").addClass("disabled")
    }

    if (currentPage == (totalPages - 1)) {
        $(".page-link-next").addClass("disabled")
    }
}

function setFacilityTypeForm(facilityTypeId) {
    if (facilityTypeId === undefined) {
        facilityTypeId = $("#facilityType").val();
    }

    if (facilityTypeId == null || facilityTypeId == 1) {
        $(".villa").show();
        $(".house").show();
        $(".room").hide();
    } else if (facilityTypeId == 2) {
        $(".villa").hide()
        $(".house").show();
        $(".room").hide();
    } else if (facilityTypeId == 3) {
        $(".villa").hide()
        $(".house").hide();
        $(".room").show();
    }
}

function submitFacilityForm() {
    if ($("#facilityType").val() == 1) {
        $(".room input").val("");
    } else if ($("#facilityType").val() == 2) {
        $(".room input").val("");
        $("#only-villa input").val("");
    } else if ($("#facilityType").val() == 3) {
        $(".villa input").val("");
    }
}

function checkAllRow() {
    if ($("#delete-all-ids").prop("checked")) {
        $(".delete-ids").prop("checked", true);
    } else {
        $(".delete-ids").prop("checked", false);
    }
}

function showDeleteConfirmModal() {
    let modalBody = "Bạn muốn xóa các đổi tượng: ";
    let deleteNameList = [];
    $(".delete-ids").each(function () {
        if ($(this).prop("checked")) {
            deleteNameList.push($(this).data("name"));
        }
    })
    if (deleteNameList.length === 0) {
        modalBody = "Bạn chưa chọn đối tượng để xóa!"
        $("#delete-submit").hide();
    } else {
        modalBody += deleteNameList.join(", ");
        $("#delete-submit").show();
    }
    $("#modal-delete .modal-body").html(modalBody);
}

function deleteSubmit(navNameApi) {
    $("#delete-submit").click(function () {
        let deleteIds = getDeleteIds();
        $.ajax({
            async: false,
            url: "/api/" + navNameApi,
            method: "DELETE",
            contentType: "application/json",
            data: JSON.stringify(deleteIds),
            success: function () {
                let navName = "";
                switch (navNameApi) {
                    case "facilities":
                        navName = "facility";
                        getFacilities();
                        break;
                    case "customers":
                        navName = "customer";
                        getCustomers();
                        break;
                    case "employees":
                        navName = "employee";
                        getEmployees();
                        break;
                    case "contracts":
                        navName = "contract";
                        getContractDtos();
                        break;
                }
                $(".btn-hide-modal").click();
                showToast(true, "Certain " + navName + " has removed.");
                $("#delete-all-ids").prop("checked", false);
            }
        })
    });
}

function getDeleteIds() {
    let deleteIds = [];
    $(".delete-ids").each(function () {
        if ($(this).prop("checked")) {
            deleteIds.push($(this).val());
        }
    })
    return deleteIds;
}

function getFacilities(page, size, sort, search) {
    $.ajax({
        url: "/api/facilities",
        method: "GET",
        data: {
            "page": page,
            "size": size,
            "sort": sort,
            "search": search
        },
        success: function (data) {
            setFacilities(data.content, data.number, data.size);
            setPagination(data.number, data.totalPages, search, "facility");
        }
    })
}

function setFacilities(facilities, page, size) {
    let content = "";
    if (facilities.length == 0) {
        $("#btn-delete-confirm").hide();
    } else {
        $("#btn-delete-confirm").show();
        for (let i = 0; i < facilities.length; i++) {
            content += setFacility(facilities[i], i, page, size)
        }
    }
    $(".list-table-body").html(content);
}

function setFacility(facility, index, page, size) {
    for (let p in facility) {
        if (facility[p] == null) {
            facility[p] = "";
        }
    }

    return `<tr>
                <td><input type="checkbox" name="delete-ids" class="delete-ids" value="${facility.id}"></td>
                <th scope="row">${((index + 1) + page * size)}</th>
                <td><a href="/furama-resort/facility/${facility.id}/edit">${facility.name}</a></td>
                <td>${facility.facilityType.name}</td>
                <td>${facility.area}</td>
                <td>${facility.cost}</td>
                <td>${facility.maxPeople}</td>
                <td>${facility.rentType.name}</td>
                <td>${facility.standardRoom}</td>
                <td>${facility.descriptionOtherConvenience}</td>
                <td>${facility.poolArea}</td>
                <td>${facility.numberOfFloors}</td>
                <td>${facility.facilityFree}</td>
            </tr>`;
}

function setPagination(number, totalPages, search, navName) {
    let content = "";
    if (search === undefined) {
        search = "";
    }

    if (totalPages === 0) {
        $(".pagination").hide();
    } else {
        $(".pagination").show();
        content += `<li class="page-item"><a class="page-link page-link-previous"
                                     href="/furama-resort/${navName}?page=${number - 1}&search=${search}">Cũ hơn</a>
            </li>`;
        for (let page = 1; page <= totalPages; page++) {
            content += setPaginationItem(page, search, navName);
        }
        content += `<li class="page-item"><a class="page-link page-link-next"
                                     href="/furama-resort/${navName}?page=${number + 1}&search=${search}">Mới hơn</a>
            </li>`;
        $(".pagination").html(content);
        activePage(number, totalPages);
    }
}

function setPaginationItem(page, search, navName) {
    return `<li class="page-item">
                    <a id="page-link-${page - 1}" class="page-link"
                       href="/furama-resort/${navName}?page=${page - 1}&search=${search}">${page}</a>
                </li>`;
}

function showToast(isMessageExist, message) {
    if (message == null) {
        message = "";
    }
    let toastLive = $("#liveToast");
    let toastBootstrap = bootstrap.Toast.getOrCreateInstance(toastLive, {animation: true, autohide: true, delay: 3000})
    if (isMessageExist) {
        $(".toast-body").html(message);
        toastBootstrap.show();
    }
}

function search(navName) {
    $("#btn-search").click(function () {
        let search = $("#search-input").val();
        switch (navName) {
            case "facility":
                getFacilities(0, 5, "id", search);
                break;
            case "customer":
                getCustomers(0, 5, "id", search);
                break;
            case "contract":
                getContractDtos(0, 5, "id", search);
                break;
        }
    })
}

function getCustomers(page, size, sort, search) {
    $.ajax({
        url: "/api/customers",
        method: "GET",
        data: {
            "page": page,
            "size": size,
            "sort": sort,
            "search": search
        },
        success: function (data) {
            setCustomers(data.content, data.number, data.size);
            setPagination(data.number, data.totalPages, search, "customer");
        },
        error: function () {
            console.log("error");
        }
    })
}

function setCustomers(customers, page, size) {
    let content = "";
    if (customers.length == 0) {
        $("#btn-delete-confirm").hide();
    } else {
        $("#btn-delete-confirm").show();
        for (let i = 0; i < customers.length; i++) {
            content += setCustomer(customers[i], i, page, size)
        }
    }
    $(".list-table-body").html(content);
}

function setCustomer(customer, index, page, size) {
    for (let p in customer) {
        if (customer[p] == null) {
            customer[p] = "";
        }
    }
    return `<tr>
                <td><input type="checkbox" name="delete-ids" class="delete-ids" value="${customer.id}"></td>
                <th scope="row">${((index + 1) + page * size)}</th>
                <td><a href="/furama-resort/customer/${customer.id}/edit">${customer.name}</a></td>
                <td>${customer.dateOfBirth}</td>
                <td>${customer.gender}</td>
                <td>${customer.idCard}</td>
                <td>${customer.phoneNumber}</td>
                <td>${customer.email}</td>
                <td>${customer.customerType.name}</td>
                <td>${customer.address}</td>
            </tr>`;
}

function getEmployees(page, size, sort, search) {
    $.ajax({
        url: "/api/employees",
        method: "GET",
        data: {
            "page": page,
            "size": size,
            "sort": sort,
            "search": search
        },
        success: function (data) {
            setEmployees(data.content, data.number, data.size);
            setPagination(data.number, data.totalPages, search, "employee");
        }
    })
}

function setEmployees(employees, page, size) {
    let content = "";
    if (employees.length == 0) {
        $("#btn-delete-confirm").hide();
    } else {
        $("#btn-delete-confirm").show();
        for (let i = 0; i < employees.length; i++) {
            content += setEmployee(employees[i], i, page, size)
        }
    }
    $(".list-table-body").html(content);
}

function setEmployee(employee, index, page, size) {
    for (let p in employee) {
        if (employee[p] == null) {
            employee[p] = "";
        }
    }
    return `<tr>
                <td><input type="checkbox" name="delete-ids" data-name="${employee.name}" class="delete-ids" value="${employee.id}"></td>
                <th scope="row">${((index + 1) + page * size)}</th>
                <td>${employee.name}</td>
                <td>${employee.dateOfBirth}</td>
                <td>${employee.idCard}</td>
                <td>${employee.salary}</td>
                <td>${employee.phoneNumber}</td>
                <td>${employee.email}</td>
                <td>${employee.address}</td>
                <td>${employee.division.name}</td>
                <td>${employee.position.name}</td>
                <td>${employee.educationDegree.name}</td>
                <td>
                        <button onclick="showUpdateEmployeeModal(${employee.id})" type="button" class="btn btn-outline-info btn-update-employee" data-bs-toggle="modal"
                            data-bs-target="#modal-create-update-employee">
                            Chỉnh sửa
                        </button>
                </td>
            </tr>`;
}

function getContractDtos(page, size, sort, search) {
    $.ajax({
        url: "/api/contracts",
        method: "GET",
        data: {
            "page": page,
            "size": size,
            "sort": sort,
            "search": search
        },
        success: function (data) {
            setContracts(data.content, data.number, data.size);
            setPagination(data.number, data.totalPages, search, "contract");
        }
    })
}

function setContracts(contractDtos, page, size) {
    let content = "";
    if (contractDtos.length === 0) {
        $("#btn-delete-confirm").hide();
    } else {
        $("#btn-delete-confirm").show();
        for (let i = 0; i < contractDtos.length; i++) {
            content += setContract(contractDtos[i], i, page, size)
        }
    }
    $(".list-table-body").html(content);
}

function setContract(contractDto, index, page, size) {
    for (let p in contractDto) {
        if (contractDto[p] == null) {
            contractDto[p] = "";
        }
    }

    return `<tr>
                <th scope="row">${((index + 1) + page * size)}</th>
                <td>${contractDto.facility.name}</td>
                <td>${contractDto.customer.name}</td>
                <td>${contractDto.startDate}</td>
                <td>${contractDto.endDate}</td>
                <td>${contractDto.deposit}</td>
                <td id="totalMonel">${contractDto.totalMoney}</td>
                <td>
                    <button onClick="showCreateContractDetailModal([[${contractDto.id}]])" type="button"
                            class="btn-create-contract-detail btn btn-primary me-2" data-bs-toggle="modal"
                            data-bs-target="#modal-create-contract-detail">
                        +
                    </button>
                    <button onClick="showContractDetailModal([[${contractDto.id}]])" type="button"
                            class="btn-show-contract-detail btn btn-primary" data-bs-toggle="modal"
                            data-bs-target="#modal-show-contract-detail">
                        Danh sách các Dịch vụ đi kèm
                    </button>
                </td>
            </tr>`;
}

function setUpDivision() {
    $.ajax({
        url: "/api/employees/divisions",
        type: "GET",
        success: function (data) {
            let content = "";
            for (let i = 0; i < data.length; i++) {
                content += `<option value="${data[i].id}">${data[i].name}</option>`
            }
            $("#division").html(content);
        }
    })
}

function setUpPosition() {
    $.ajax({
        url: "/api/employees/positions",
        type: "GET",
        success: function (data) {
            let content = "";
            for (let i = 0; i < data.length; i++) {
                content += `<option value="${data[i].id}">${data[i].name}</option>`
            }
            $("#position").html(content);
        }
    })
}

function setUpEducationDegree() {
    $.ajax({
        url: "/api/employees/education-degrees",
        type: "GET",
        success: function (data) {
            let content = "";
            for (let i = 0; i < data.length; i++) {
                content += `<option value="${data[i].id}">${data[i].name}</option>`
            }
            $("#educationDegree").html(content);
        }
    })
}

function showCreateEmployeeModal() {
    $("#modal-create-update-employee #modal-label").text('Thêm mới nhân viên');
    $("#modal-create-update-employee #btn-submit").text('Thêm');
    resetEmployeeUpdateForm();
}

function showUpdateEmployeeModal(id) {
    $("#modal-create-update-employee #modal-label").text('Cập nhật nhân viên');
    $("#modal-create-update-employee #btn-submit").text('Cập nhật');
    let employee = getEmployeeById(id);
    setEmployeeUpdateForm(employee);
}

function saveEmployee() {
    let id = $("#id").val();
    let name = $("#name").val();
    let dateOfBirth = $("#dateOfBirth").val();
    let idCard = $("#idCard").val();
    let salary = $("#salary").val();
    let phoneNumber = $("#phoneNumber").val();
    let email = $("#email").val();
    let address = $("#address").val();
    let division = $("#division").val();
    let position = $("#position").val();
    let educationDegree = $("#educationDegree").val();

    let employee = {
        "id": id,
        "name": name,
        "dateOfBirth": dateOfBirth,
        "idCard": idCard,
        "salary": salary,
        "phoneNumber": phoneNumber,
        "email": email,
        "address": address,
        "division": {
            "id": division
        },
        "position": {
            "id": position
        },
        "educationDegree": {
            "id": educationDegree
        }
    }

    if (id === "") {
        addNewEmployee(employee);
    } else {
        updateEmployee(employee);
    }
}

function addNewEmployee(employee) {
    $.ajax({
        url: "/api/employees",
        type: "POST",
        contentType: "application/json",
        dataType: "json",
        data: JSON.stringify(employee),
        success: function () {
            getEmployees();
            $(".btn-hide-modal").click();
            showToast(true, "New employee has created.");
        }
    })
}

function updateEmployee(employee) {
    $.ajax({
        url: "/api/employees",
        type: "PUT",
        contentType: "application/json",
        dataType: "json",
        data: JSON.stringify(employee),
        success: function () {
            getEmployees();
            $(".btn-hide-modal").click();
            showToast(true, "A employee has updated.");
        }
    })
}

function getEmployeeById(id) {
    let employee;
    $.ajax({
        async: false,
        url: "/api/employees/" + id,
        type: "GET",
        success: function (data) {
            employee = data;
        }
    })
    return employee;
}

function setEmployeeUpdateForm(employee) {
    $("#id").val(employee.id);
    $("#name").val(employee.name);
    $("#dateOfBirth").val(employee.dateOfBirth);
    $("#idCard").val(employee.idCard);
    $("#salary").val(employee.salary);
    $("#phoneNumber").val(employee.phoneNumber);
    $("#email").val(employee.email);
    $("#address").val(employee.address);
    $("#division").val(employee.division.id);
    $("#position").val(employee.position.id);
    $("#educationDegree").val(employee.educationDegree.id);
}

function resetEmployeeUpdateForm() {
    $("#id").val("");
    $("#name").val("");
    $("#dateOfBirth").val("");
    $("#idCard").val("");
    $("#salary").val("");
    $("#phoneNumber").val("");
    $("#email").val("");
    $("#address").val("");
    $("#division").val("");
    $("#position").val("");
    $("#educationDegree").val("");
}

function showCreateContractDetailModal(id) {
    setUpAttachFacilities();
    $("#quantity").val("");
    if (id === undefined) {
        $("#modal-create-contract-detail .btn-submit").hide();
        $("#modal-create-contract-detail .btn-close-modal").hide();
        $("#modal-create-contract-detail .btn-return-create-contract-modal").show();
        return
    }
    $("#modal-create-contract-detail .btn-submit").show();
    $("#modal-create-contract-detail .btn-close-modal").show();
    $("#modal-create-contract-detail .btn-return-create-contract-modal").hide();
    $("#contract").val(id);
}

function showCreateContractModal() {
    setUpCustomer();
    setUpFacility();
    $("#modal-create-update-contract #startDate").val("");
    $("#modal-create-update-contract #endDate").val("");
    $("#modal-create-update-contract #deposit").val("");
    $("#modal-create-update-contract #customer-id").val(1);
    $("#modal-create-update-contract #facility").val(1);
    $("#modal-create-update-contract #totalMoney").val("");
    $("#modal-create-update-contract .list-table-body").html("")
}

function addContract() {
    let startDate = $("#startDate").val();
    let endDate = $("#endDate").val();
    let deposit = $("#deposit").val();
    let customer = $("#customer-id").val();
    let facility = $("#facility").val();
    let contractDto = {
        "startDate": startDate,
        "endDate": endDate,
        "deposit": deposit,
        "customer": {
            "id": customer
        },
        "facility": {
            "id": facility
        },
        "totalMoney": ""
    }

    $.ajax({
        async: false,
        url: "/api/contracts",
        type: "POST",
        contentType: "application/json",
        dataType: "json",
        data: JSON.stringify(contractDto),
        success: function (data) {
            addContractDetails(data.id);
        }
    })
}

function addContractDetails(contractId) {
    let contractDetailRow = $(".contract-detail");
    if (contractDetailRow.length !== 0) {
        let contractDetails = [];
        contractDetailRow.each(function () {
            contractDetails.push({
                "id": "",
                "contract": {"id": contractId},
                "attachFacility": {
                    "id": $(this).data("id")
                },
                "quantity": $(this).children(".quantity").text()
            });
        })
        $.ajax({
            async: false,
            url: "/api/contracts/details",
            type: "POST",
            contentType: "application/json",
            dataType: "json",
            data: JSON.stringify(contractDetails)
        })
    }
    getContractDtos();
    $(".btn-hide-modal").click();
    showToast(true, "New contract has created.");
}

function setUpCustomer() {
    $.ajax({
        async: false,
        url: "/api/customers",
        type: "GET",
        success: function (data) {
            let dataContent = data.content
            let content = "";
            for (let i = 0; i < dataContent.length; i++) {
                content += `<option value="${dataContent[i].id}">${dataContent[i].name}</option>`;
            }
            $("#modal-create-update-contract #customer-id").html(content);
        }
    })
}

function setUpFacility() {
    $.ajax({
        async: false,
        url: "/api/facilities",
        type: "GET",
        success: function (data) {
            let dataContent = data.content
            let content = "";
            for (let i = 0; i < dataContent.length; i++) {
                content += `<option value="${dataContent[i].id}">${dataContent[i].name}</option>`;
            }
            $("#modal-create-update-contract #facility").html(content);
        }
    })
}

function addContractDetail() {
    createContractDetail();
}

function returnCreateContractModal() {
    let attachFacilityId = $("#attachFacility").val();
    let attachFacilityName = getAttachFacilityById(attachFacilityId).name;
    let attachFacilityUnit = getAttachFacilityById(attachFacilityId).unit;
    let attachFacilityCost = getAttachFacilityById(attachFacilityId).cost;
    let quantity = $("#quantity").val();
    let price = attachFacilityCost * quantity;
    let content = `<tr class="contract-detail" data-id="${attachFacilityId}">
                                <td>${attachFacilityName}</td>
                                <td>${attachFacilityUnit}</td>
                                <td>${attachFacilityCost}</td>
                                <td class="quantity">${quantity}</td>
                                <td class="price">${price}</td>
                            </tr>`;
    $("#modal-create-update-contract .list-table-body").append(content);
    $("#modal-create-contract-detail .btn-hide-modal").click();
    calTotalMoney();
}

function createContractDetail() {
    let contractId = $("#contract").val();
    let attachFacilityId = $("#attachFacility").val();
    let quantity = $("#quantity").val();
    let contractDetail = {
        "id": "",
        "contract": {
            "id": contractId
        },
        "attachFacility": {
            "id": attachFacilityId
        },
        "quantity": quantity
    }

    $.ajax({
        async: false,
        url: "/api/contracts/detail",
        type: "POST",
        contentType: "application/json",
        dataType: "json",
        data: JSON.stringify(contractDetail),
        success: function () {
            getContractDtos();
            $("#modal-create-contract-detail .btn-hide-modal").click();
            showToast(true, "New contract detail has created.");
        }
    })
}

function showAttachFacilityDetail() {
    let id = $("#attachFacility").val();
    let attachFacilityUnit = getAttachFacilityById(id).unit;
    let attachFacilityCost = getAttachFacilityById(id).cost;
    $("#attachFacilityUnit").val(attachFacilityUnit);
    $("#attachFacilityCost").val(attachFacilityCost);
}

function getAttachFacilityById(id) {
    let attachFacility;
    $.ajax({
        async: false,
        url: "/api/contracts/detail/attach-facility/" + id,
        type: "GET",
        dataType: "json",
        success: function (data) {
            attachFacility = data;
        }
    });
    return attachFacility;
}

function setUpAttachFacilities() {
    $.ajax({
        async: false,
        url: "/api/contracts/detail/attach-facilities",
        type: "GET",
        dataType: "json",
        success: function (data) {
            let content = "";
            for (let i = 0; i < data.length; i++) {
                content += `<option value="${data[i].id}">${data[i].name}</option>`
            }
            $("#attachFacility").html(content).val(data[0].id);
            $("#attachFacilityUnit").val(data[0].unit);
            $("#attachFacilityCost").val(data[0].cost);
        }
    })
}

function showContractDetailModal(id) {
    let contractDetails = getContractDetailsByContractId(id);
    let content = "";
    for (let i = 0; i < contractDetails.length; i++) {
        let price = contractDetails[i].quantity * contractDetails[i].attachFacility.cost;
        content += `<tr><th scope="row">${i + 1}</th>
                    <td>${contractDetails[i].attachFacility.name}</td>
                    <td>${contractDetails[i].attachFacility.unit}</td>
                    <td>${contractDetails[i].attachFacility.cost}</td>
                    <td>${contractDetails[i].quantity}</td>
                    <td>${price}</td></tr>`
    }
    $("#modal-show-contract-detail .list-table-body").html(content)
}

function getContractDetailsByContractId(contractId) {
    let contractDetails;
    $.ajax({
        async: false,
        url: "/api/contracts/detail/" + contractId,
        type: "GET",
        dataType: "json",
        success: function (data) {
            contractDetails = data;
        }
    });
    return contractDetails;
}

function calTotalMoney() {
    let contractDetailRow = $(".contract-detail");
    let price = 0;
    if (contractDetailRow.length !== 0) {
        contractDetailRow.each(function () {
            price += parseFloat($(this).children(".price").text());
        })
    }
    let facilityId = $("#modal-create-update-contract #facility").val();
    let facilityCost = getFacilityById(facilityId).cost;
    $("#modal-create-update-contract #totalMoney").val(facilityCost + price);
}

function getFacilityById(id) {
    let facility;
    $.ajax({
        async: false,
        url: "/api/facilities",
        type: "GET",
        data: {"id": id},
        success: function (data) {
            facility = data
        }
    })
    return facility;
}