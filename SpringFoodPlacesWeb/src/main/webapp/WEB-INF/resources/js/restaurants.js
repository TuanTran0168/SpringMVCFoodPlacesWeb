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
//var user_list;
//$(document).ready(function textChange() {
//
//    var user_list;
////    let colors = ['gold', 'yellow', 'orange', 'pink', 'brown', 'c'];
//    fetch("http://localhost:8080/SpringFoodPlacesWeb/api/admin/users/", {
//        method: "get"
//    }).then(res => {
//        return res.json();
//    }).then(data => {
//        console.log("1");
//        console.log(data);
//        user_list = data;
//        console.log("2");
//        console.log(user_list);
//
//        $("#search_userId").on("keyup focus", function () {
//            let t = $(this).val();
//            let h = "";
//            console.log("4");
//            console.log(user_list);
//            for (let c of user_list)
//                if (c.indexOf(t) >= 0)
//                    h += `<option><a href="javascript:;">${c}</a></option>`;
//            $("#suggest").html(h);
//        });
//
//    });
//
//
//
//
////    setTimeout(() => {
////        console.log("nnn");
////        $("#search_userId").on("keyup focus", function () {
////            let t = $(this).val();
////            let h = "";
////            console.log("4");
////            console.log(user_list);
////            for (let c of user_list)
////                if (c.indexOf(t) >= 0)
////                    h += `<option><a href="javascript:;">${c.username}</a></option>`;
////            $("#suggest").html(h);
////        });
////    }, 1000);
//
//    console.log("OKE");
//
//    console.log("3");
//    console.log(user_list);
//
//});



//$(document).ready(function textChange() {
//    let colors = ['gold', 'yellow', 'orange', 'pink', 'brown', 'c'];
//    $("#search_userId").on("keyup focus", function () {
//        let t = $(this).val();
//        let h = "";
//        for (let c of colors)
//            if (c.indexOf(t) >= 0)
//                h += `<option><a href="javascript:;">${c}</a></option>`;
//        $("#suggest").html(h);
//    });
//
//}); 

//$(document).ready(function textChange() {
//    var u;
//    fetch("http://localhost:8080/SpringFoodPlacesWeb/api/admin/users/", {
//        method: "get"
//    }).then(res => {
//        return res.json();
//    }).then(data => {
//        u = data;
//        console.log(u);
//    });
//    searchAndLoadData_users(u);
//    console.log(u);
//});
//
//function searchAndLoadData_users(data) {
//    $("#search_userId").on("keyup focus", function () {
//        let h = "";
//        let t = $("#search_userId").val();
//        for (let d of data)
//            if (d.indexOf(t) >= 0)
//                h += `<li><a href="javascript:;">${d.username}</a></li>`;
//        $("#suggest").html(h);
//    });
//}

function textChange() {
    return fetch("http://localhost:8080/SpringFoodPlacesWeb/api/admin/users/2", {
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
                    h += `<li ><a id=${d.userId} href="javascript:;">${d.firstname} - ${d.lastname}</a></li>`;
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