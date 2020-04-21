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