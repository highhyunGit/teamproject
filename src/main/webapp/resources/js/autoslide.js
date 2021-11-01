var current = 0;
showSlides();

function showSlides(){
	var slides = document.querySelectorAll("#slides > img");
	for(let i=0; i<slides.length; i++) {
		slides[i].style.display = "none";
	}
	current++;
	if(current > slides.length) //현재페이지가 전체 슬라이드 길이보다 커지면 >> 마지막페이지라면
	 current=1;
	slides[current-1].style.display="block";
	setTimeout(showSlides,2500); //2.5초 지나면 바뀜	
}