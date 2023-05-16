// General
function activeNavItem(pageName) {
    $("#header .nav-link").each(function () {
        if ($(this).hasClass("active")) {
            $(this).removeClass("active");
        }
    })
    $("#" + pageName).addClass("active");
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
    $("#modal-delete-body").html(modalBody);
}

function deleteSubmit(navName) {
    $("#delete-submit").click(function () {
        let deleteIds = getDeleteIds();
        $.ajax({
            async: false,
            url: "/api/" + navName,
            method: "DELETE",
            contentType: "application/json",
            data: JSON.stringify(deleteIds),
            success: function () {
                location.reload();
                showToast(true, "Certain " + navName + " has removed.");
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

//Specific

function showMessage(mess) {
        $("#modal-message-body").text(mess);
        $("#show-modal-message").click();
}