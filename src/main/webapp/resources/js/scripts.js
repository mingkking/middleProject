$(function(){
	let topDiv = $('.tabSet'); // 클래스 tabSet 을 가져옴
	let anchors = topDiv.find('ul.tabs > li > a'); // 태그 ul 중 클래스 tabs 의 자식 li들 중 자식 a 들을 찾음
	let panelDivs = topDiv.find('div.panel');
	
	anchors.show(); // 가져온 a 태그들을 화면에 보이게
	panelDivs.hide(); // panelDivs 전부 사라지게
	
	let lastAnchor = anchors.filter('.on'); // a태그들 중 클래스 on 을 가져옴
	console.log(lastAnchor.attr('href')); // 속성 href 값을 가져옴
	console.log($(lastAnchor.attr('href'))); // 속성 href 값을 가져와서 객체로 만듬
	
	let lastPanel = $(lastAnchor.attr('href')); // $(lastAnchor.attr('href')) = #panel1-1 
	lastPanel.show(); // 가져온 #panel1-1 을 보여준다
	
	// a태그들을 클릭했을 때
	anchors.click(function(e){
		e.preventDefault(); // a 태그들 의 고유 이벤트를 막음
		
		let currentAnchor = $(this);
		let currentPanel = $(currentAnchor.attr('href')); // 클릭한 현재 a 태그의 href 값 을 가져옴
		
		lastPanel.hide(); // 마지막 panel을 숨김
		currentPanel.show(); // 현재 panel을 보여줌
		
		lastAnchor.removeClass('on'); // 마지막 a 태그의 클래스 on 을 삭제
		currentAnchor.addClass('on'); // 현재 a 태그의 클래스 on 을 추가
		
		lastAnchor = currentAnchor; // 마지막 a 태그에 현재 a 태그 기억
		lastPanel = currentPanel; // 마지막 panel에 현재 panel 기억
	});
	// a태그들을 클릭했을 때 끝
	 
});