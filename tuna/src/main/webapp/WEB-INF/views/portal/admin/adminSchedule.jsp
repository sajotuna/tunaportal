<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="path" value="${pageContext.request.contextPath }/resources" />
<!DOCTYPE html>
<html>
<head>
 <meta name="viewport"
        content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <link href='https://cdn.jsdelivr.net/npm/fullcalendar@5.8.0/main.min.css' rel='stylesheet' />
    <script src='https://cdn.jsdelivr.net/npm/fullcalendar@5.8.0/main.min.js'></script>    
    <script src='https://cdn.jsdelivr.net/npm/fullcalendar@5.8.0/locales-all.min.js'></script>
    <link rel="stylesheet" id="css-main" href="/01 - ${path}/assets/css/oneui.min.css">
	
<meta charset="UTF-8">
<title>adminSchedule</title>
<style>
        /* body 스타일 */
        html,
        body {
            overflow: hidden;
            font-family: Arial, Helvetica Neue, Helvetica, sans-serif;
            font-size: 14px;
        }

        .fc-header-toolbar {
            padding-top: 1em;
            padding-left: 1em;
            padding-right: 1em;
        }
    </style>
</head>

<body style="padding:30px;">
     <!-- title start -->
        <div class="content content-boxed">
                <h3 class="fw-bold">학사일정 관리</h3>

                <div class="block block-rounded">
                <!-- calendar 태그 -->
            <div id='calendar-container'>
                <div id='calendar'></div>
            </div>
        </div>
  
        </div>
</body>


<script>
    (function () {
        $(function () {
            // calendar element 취득
            var calendarEl = $('#calendar')[0];
            // full-calendar 생성하기
            var calendar = new FullCalendar.Calendar(calendarEl, {
                height: '700px', // calendar 높이 설정
                expandRows: true, // 화면에 맞게 높이 재설정
                slotMinTime: '08:00', // Day 캘린더에서 시작 시간
                slotMaxTime: '20:00', // Day 캘린더에서 종료 시간
                // 해더에 표시할 툴바
                headerToolbar: {
                    left: '',
                    center: 'title',
                    right: 'prev,next'
                },
                initialView: 'dayGridMonth', // 초기 로드 될때 보이는 캘린더 화면(기본 설정: 달)
                // 초기 날짜 설정 (설정하지 않으면 오늘 날짜가 보인다.)
                editable: true, // 수정 가능?
                selectable: true, // 달력 일자 드래그 설정가능
                nowIndicator: true, // 현재 시간 마크
                dayMaxEvents: true, // 이벤트가 오버되면 높이 제한 (+ 몇 개식으로 표현)
                locale: 'ko', // 한국어 설정
                eventAdd: function (obj) { // 이벤트가 추가되면 발생하는 이벤트
                    console.log(obj);
                },
                eventChange: function (obj) { // 이벤트가 수정되면 발생하는 이벤트
                    console.log(obj);
                },
                eventRemove: function (obj) { // 이벤트가 삭제되면 발생하는 이벤트
                    console.log(obj);
                },
                select: function (arg) { // 캘린더에서 드래그로 이벤트를 생성할 수 있다.
                    var title = prompt('일정을 입력해주세요.');
                    if (title) {
                        calendar.addEvent({
                            title: title,
                            start: arg.start,
                            end: arg.end,
                            allDay: arg.allDay
                        })
                    }
                    calendar.unselect()
                },
                // 이벤트 
                events: [{
                        title: '개교기념일',
                        start: '2022-07-01',
                    },
                    {
                        title: '수강신청',
                        start: '2022-07-07',
                        end: '2022-07-10'
                    },
                    {
                        groupId: 999,
                        title: '과제제출',
                        start: '2022-07-13T16:00:00'
                    },
                ]
            });
            // 캘린더 랜더링
            calendar.render();
        });
    })();
</script>
<script src="${path}/assets/js/oneui.app.min.js"></script>
</html>