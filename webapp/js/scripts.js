$(".answerWrite input[type=submit]").click(addAnswer);

function addAnswer(e) {
    e.preventDefault();
    var queryString = $(".submit-write").serialize();   // 해당 form 내용을 한 번에 전송 가능한 데이터로 만들기 위함

    $.ajax({
        type: 'post',
        url: '/api/qna/addAnswer',
        data: queryString,  // 서버로 전송할 데이터
        dataType: 'json',   // 응답받을 데이터 타입
        error: onError,
        success: onSuccess,
    });
}

function onSuccess(json, status) {
    var answerTemplate = $("#answerTemplate").html();
    // console.log(json);
    var template = answerTemplate.format(json.answer.author, new Date(json.answer.createdDate), json.answer.contents, json.answer.answerId, json.answer.answerId);
    $(".qna-comment-kuit-article-comments").append(template);
    var countOfAnswer = document.getElementsByTagName("strong").item(0);
    let number = parseInt(countOfAnswer.innerText, 10);
    number += 1;
    countOfAnswer.textContent = number.toString();
}

function onError(xhr, status) {
    alert("error");
}

String.prototype.format = function () {
    var args = arguments;
    return this.replace(/{(\d+)}/g, function (match, number) {
        return typeof args[number] != 'undefined'
            ? args[number]
            : match
            ;
    });
};