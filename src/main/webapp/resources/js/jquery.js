/**
 * 
 */
$(function(){
	// accordion 클래스의 반복문???
	$('.accordion').each(function(){
		let allDt = $(this).find('dt');
		let allDd = $(this).find('dd');
		
		allDd.hide(); // 담아온 모든 dd 를 닫음
		allDd.first().show(); // 담아온 모든 dd 중 첫번째 dd 만 보여주기
		allDt.css({'cursor':'pointer'}); // 모든 dt에다 마우스를 올려두면 손가락 모양으로 바뀜
		// 모든 dt에 더블클릭 이벤트
		allDt.mouseover(function(){
			allDd.hide(); // 담아온 모든 dd 를 닫음
			$(this).next().show(); // 이벤트가 발생했을 때 그 다음요소를 보여줌
			console.log($(this).text()); // 이벤트가 발생했을 때 태그 사이의 글자를 콘솔에 출력
		});
		// 모든 dt에 더블클릭 이벤트 끝
	});
	// accordion 클래스의 반복문??? 끝
});