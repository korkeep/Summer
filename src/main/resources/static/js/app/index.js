var main = {
    init : function () {
        var _this = this;
        $('#btn-save').on('click', function () {
            _this.save();
        });
        $('#btn-update').on('click', function () {
            _this.update();
        });
        $('#btn-delete').on('click', function () {
            _this.delete();
        });
    },
    save : function () {
        const url = $("#posts-save").attr("action");
        const files = $('#customFile')[0].files[0];
        const formData = new FormData();
        formData.append("files", files);
        formData.append("title",  $('#title').val());
        formData.append("author", $('#author').val());
        formData.append("content", $('#content').val());

        $.ajax({
            url: url,
            type: 'POST',
            data: formData,

            success: function(){
                console.log("success");
                alert('글이 등록되었습니다.');
                window.location.href = '/';
            },
            error: function(error){
                alert(error);
            },
            cache: false,
            contentType: false,
            processData: false
        });
    },
    update : function () {
        var data = {
            title: $('#title').val(),
            content: $('#content').val()
        };
        var id = $('#id').val();
        $.ajax({
            type: 'PUT',
            url: '/api/v1/posts/'+id,
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('글이 수정되었습니다.');
            window.location.href = '/';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },
    delete : function () {
        var id = $('#id').val();
        $.ajax({
            type: 'DELETE',
            url: '/api/v1/posts/'+id,
            dataType: 'json',
            contentType:'application/json; charset=utf-8'
        }).done(function() {
            alert('글이 삭제되었습니다.');
            window.location.href = '/';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    }
};

main.init();