// General
function activeNavItem(pageName) {
    $("#header .nav-link").each(function () {
        if ($(this).hasClass("active")) {
            $(this).removeClass("active");
        }
    })
    $("#" + pageName).addClass("active");
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

function showDetailModal(id) {
    let project = getProjectById(id);
    let content = `
                    <table>
                        <tr>
                            <td>Id: </td>
                            <td>${project.id}</td>
                        </tr>
                        <tr>
                            <td>Name: </td>
                            <td>${project.name}</td>
                        </tr>
                        <tr>
                            <td>Company: </td>
                            <td>${project.company.name}</td>
                        </tr>
                        <tr>
                            <td>Business: </td>
                            <td>${project.company.business}</td>
                        </tr>
                        <tr>
                            <td>Phone: </td>
                            <td>${project.company.phone}</td>
                        </tr>
                        <tr>
                            <td>Email: </td>
                            <td>${project.company.email}</td>
                        </tr>
                        <tr>
                            <td>Required money: </td>
                            <td>${project.requiredMoney}</td>
                        </tr>
                        <tr>
                            <td>Registry month: </td>
                            <td>${project.registryMonth}</td>
                        </tr>
                        <tr>
                            <td>Register date: </td>
                            <td>${project.registerDate}</td>
                        </tr>
                        <tr>
                            <td>Price: </td>
                            <td>${project.price}</td>
                        </tr>
                    </table>`
    $("#modal-message-body").html(content);
    let modalMessageBootstrap = new bootstrap.Modal('#modal-message');
    modalMessageBootstrap.show();
}

function getProjectById(id) {
    let project;
    $.ajax({
        async: false,
        url: "/api/projects",
        type:"GET",
        data: {"id": id},
        success: function (data) {
            project = data;
        }
    })
    return project;
}

// $(".sidebar .nav-item").hover(function () {
//     $(this).addClass("border-bottom border-secondary")
// }, function () {
//     $(this).removeClass("border-bottom border-secondary")
// })

function activePage(currentPage, totalPages) {
    $("#page-link-" + currentPage).addClass("active");
    if (currentPage == 0) {
        $(".page-link-previous").addClass("disabled")
    }

    if (currentPage == (totalPages - 1)) {
        $(".page-link-next").addClass("disabled")
    }
}
//
// function checkAllRow() {
//     if ($("#delete-all-ids").prop("checked")) {
//         $(".delete-ids").prop("checked", true);
//     } else {
//         $(".delete-ids").prop("checked", false);
//     }
// }
//
// function getDeleteIds() {
//     let deleteIds = [];
//     $(".delete-ids").each(function () {
//         if ($(this).prop("checked")) {
//             deleteIds.push($(this).val());
//         }
//     })
//     return deleteIds;
// }
//
// function showDeleteConfirmModal() {
//     let modalBody = "Bạn muốn xóa các đổi tượng: ";
//     let deleteNameList = [];
//     $(".delete-ids").each(function () {
//         if ($(this).prop("checked")) {
//             deleteNameList.push($(this).data("name"));
//         }
//     })
//     if (deleteNameList.length === 0) {
//         modalBody = "Bạn chưa chọn đối tượng để xóa!"
//         $("#delete-submit").hide();
//     } else {
//         modalBody += deleteNameList.join(", ");
//         $("#delete-submit").show();
//     }
//     $("#modal-delete-body").html(modalBody);
// }
//
// function modalDeleteSubmit(navName) {
//     let deleteIds = getDeleteIds();
//     $.ajax({
//         async: false,
//         url: "/api/" + navName,
//         method: "DELETE",
//         contentType: "application/json",
//         data: JSON.stringify(deleteIds),
//         success: function () {
//             location.reload();
//             showToast(true, "Certain " + navName + " has removed.");
//         }
//     })
// }

//Specific
// function returnBook() {
//     let id = $("#borrowCardId").val();
//     $.ajax({
//         async: false,
//         url: "api/borrow-cards",
//         type: "GET",
//         data: {"id": id},
//         success: function () {
//             location.reload();
//             showToast(true, "Một cuốn sách đã được trả.")
//         }
//     })
// }