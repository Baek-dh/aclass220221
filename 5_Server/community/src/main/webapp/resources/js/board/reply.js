// 댓글 목록 조회(AJAX)
function selectReplyList(){
    
    // contextPath, boardNo, memberNo 전역 변수 사용
    $.ajax({
        url : contextPath + "/reply/selectReplyList",
        data : {"boardNo" : boardNo},
        type : "GET",
        dataType : "JSON", // JSON 형태의 문자열 응답 데이터를 JS 객체로 자동 변환
        success : function(rList){
            // rList : 반환 받은 댓글 목록 
            
            console.log(rList);

        },
        error : function(){
            console.log("에러 발생");
        }

    });

}