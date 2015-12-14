/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */





$(document).scroll(function () {
    //console.log($(window).scrollTop());
    //if ($(window).scrollTop() + $(window).height() == $(document).height()) {
    // Reached page bottom. Call the ajax function or any other foo here.

    //}
});


//var id = $("plusone").closest("div").attr("id");
$(document).ready(function () {

    $("button").click(function () {

        var buttonNo = $(this).attr('id');

        if (buttonNo) {
            var inputData = {'photoid': buttonNo};

            $.ajax({
                url: 'updatePhoto',
                method: 'post',
                data: inputData,
                success: function (data) {
                    //$("#bodyContent").append(data);
                    //$("#loadButton").html(defaultBtnText);

                    //console.log($("#"+buttonNo+"-p").textContent);
                    $("#" + buttonNo + "-p").html(parseInt($("#" + buttonNo + "-p").html()) + 1);

                }
            });
        }
    });

    $("input").keyup(function (e) {
        
        var thisinput = $(this);
        if (e.keyCode == 13) {
            var id = $(this).attr('name');
            var message = $(this).val();
            var inputData = {'photoid': id, 'comment':message};

            $.ajax({
                url: 'updateMessage',
                method: 'post',
                data: inputData,
                success: function (data) {
                    //$("#bodyContent").append(data);
                    //$("#loadButton").html(defaultBtnText);

                    //console.log($("#"+buttonNo+"-p").textContent);
                    //$("#" + buttonNo + "-p").html(parseInt($("#" + buttonNo + "-p").html()) + 1);
                    //console.log(inputData);
                    
                    thisinput.parent().before('<li class="list-group-item"> You:' + message+ '</li>');
                }
            });
        }
    });
});
