/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/javascript.js to edit this template
 */


function deleteRestaurant(path, id) {
    if (confirm("Muốn xóa không") === true) {
        fetch(path, {
            method: "delete"
        }).then(res => {
            if (res.status === 204) {
                location.reload();
            } else {
                alert("Bug rồi ba");
            }
        });
    }
}

function textChange() {
    return fetch("http://localhost:8080/SpringFoodPlacesWeb/api/admin/users/roleId/2", {
        method: "get"
    }).then(res => {
        return res.json();
    }).then(data => {
        var u = data;
        console.log(u);
        return u;
    });
}

$(document).ready(async function () {
    const user = await textChange();
    $("#search_userId").on("keyup focus", function () {
        $("#suggest").show();
        let h = "";
        let t = $("#search_userId").val();
        console.log(user[0].username);


        for (let d of user)
            if (d.firstname !== null || d.lastname !== null) {
                if (d.firstname.search(t) >= 0 || d.lastname.search(t) >= 0)
                    h += `<option><a id=${d.userId} href="javascript:;">${d.firstname} - ${d.lastname}</a></option>`;
            }

        $("#suggest").html(h);
    });

    $("#suggest").on("click", "a", function () {

        let t = $(this).text();
        $("#search_userId").val(t);
        let id = $(this).attr("id");

        console.log(id);
//        $("#load_userId_js").html(id);
        $("#load_userId_js").val(id);
        $("#suggest").html("");
        $("#suggest").hide();
    });
});

function getPicture() {
    const dropContainer = document.getElementById("dropcontainer");
    const fileInput = document.getElementById("file");

    dropContainer.addEventListener("dragover", (e) => {
        // prevent default to allow drop
        e.preventDefault();
    }, false);

    dropContainer.addEventListener("dragenter", () => {
        dropContainer.classList.add("drag-active");
    });

    dropContainer.addEventListener("dragleave", () => {
        dropContainer.classList.remove("drag-active");
    });

    dropContainer.addEventListener("drop", (e) => {
        e.preventDefault();
        dropContainer.classList.remove("drag-active");
        fileInput.files = e.dataTransfer.files;
    });
}

$(document).ready(getPicture());

