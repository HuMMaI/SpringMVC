$("#add-btn").click(function () {
    var name = $("#participantName").val();
    var email = $("#participantEmail").val();
    var level = $("#participantLevel").val();
    var primarySkill = $("#participantPrimarySkill").val();
    var coverId = $("#cover-id").val();

    if (name == '' || email == '' || level == '' || primarySkill == '') {
        alert("Please, fill all fields!");
    } else {
        var participant = {
            name,
            email,
            level,
            primarySkill,
            coverId
        }

        $.post("api/add", participant)
            .done(function (data, textStatus, xhr) {
                if (xhr.status == 200) {
                    window.location = window.origin + "/BookClub/"
                } else {
                    alert("Error");
                }
            });
    }
});


$("#cover-file").change(function (){
    var fd = new FormData();
    var file = $('#cover-file')[0].files[0];

    if(file === undefined){
        return;
    }

    fd.append('coverFile', file);
    $.ajax({
        url: '/BookClub/participant-cover-files/upload',
        type: 'post',
        data: fd,
        contentType: false,
        processData: false,
        success: function (coverId) {
            $("#participant-cover")
                .attr("src", "/BookClub/participant-cover-files/download/" + coverId);
            $("#cover-id").val(coverId)
        },
    });
});