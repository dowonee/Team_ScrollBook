# ![header](https://capsule-render.vercel.app/api?type=waving&color=auto&height=300&section=header&text=SCROLLBOOK&fontSize=90)
---

<p align="center"><a href="https://imgbb.com/"><img src="https://i.ibb.co/PtxMtW9/5.jpg" alt="5" border="0"></a></p>

## ⚡ 프로젝트 계획
> 다양한 사용자들이 사진, 동영상을 올리고 볼 수 있는 소셜 네트워크 서비스
> 테이블 간 관계설정을 다양하게 경험할 수 있다고 생각해 SNS을 선정해 프로젝트를 기획했습니다.


---      
</br>


## ⚡ 프로젝트 기간
> 2021.07.18 - 2021.07.30


---      
</br>



## ⚡개발환경
* System : Window 10
* Language : Java(JDK - 15), JSP, Html5, CSS, JS
* Tools : Github
* Development Tools : Eclipse IDE, eXERD
* DBMS : Oracle DB XE 11g
* WAS : Tomcat 9.0


---      
</br>



## ⚡ 맡은 기능구현

* 메인화면  

><a href="https://imgbb.com/"><img src="https://i.ibb.co/xq7mQZ3/28.png" alt="28" border="0"></a>

* 좋아요 기능
><a href="https://imgbb.com/"><img src="https://i.ibb.co/w7xcSPc/29.png" alt="29" border="0"></a>


```
	var chImg = true;
	function changeColor() {
		var like = document.querySelector(".like");
		var cnt = document.querySelector(".post_likes");
		var full = '<i class="fas fa-heart fa-lg"></i>';
		var nfull = '<i class="far fa-heart fa-lg"></i>';
		var cnt1 = '<span>좋아요&nbsp2522개</span>';
		var cnt0 = '<span>좋아요&nbsp2521개</span>';
		if (chImg) {
			like.innerHTML = full;
			cnt.innerHTML = cnt1;
		} else {
			like.innerHTML = nfull;
			cnt.innerHTML = cnt0;
		}

		chImg = !chImg;
		console.log(chImg);
	}
  	function dblclick() {
		changeColor();
	}
```

* 게시글 공유 기능
><a href="https://imgbb.com/"><img src="https://i.ibb.co/ByjXnRQ/30.png" alt="30" border="0"></a>
<a href="https://imgbb.com/"><img src="https://i.ibb.co/XL4Zth8/31.png" alt="31" border="0"></a>
<a href="https://imgbb.com/"><img src="https://i.ibb.co/0MSCpfY/32.png" alt="32" border="0"></a>

```
	function showPopup() {
		if (!confirm("해당 게시물을 SNS로 공유하시겠습니까? 취소를 누르면 URL이 복사됩니다.")) {
			var url = '';
			var textarea = document.createElement("textarea");
			document.body.appendChild(textarea);
			url = window.document.location.href;
			textarea.value = window.location.href;
			textarea.select();
			document.execCommand("copy");
			document.body.removeChild(textarea);
			alert("URL이 복사되었습니다.")
			return false;
		}
		window.open("popup.jsp", "팝업테스트",
				"width=260, height=160, top=10, left=10");
	}
```

```
function Sharefb(){
	window.open(
	  'https://www.facebook.com/sharer/sharer.php?u=' + encodeURIComponent('http://203.216.179.152:7080/scrollBook/main.jsp')
	);
}
function Sharett(){
	var sendText = "scrollBook";
	var sendUrl = "http://203.216.179.152:7080/scrollBook/main.jsp";
	window.open("https://twitter.com/intent/tweet?text=" + sendText + "&url=" + sendUrl);
	
}
Kakao.init('e132a3811afb598bd7dd12e4683143bc');
function Sharekk(){
	var sh_title = "scrollBook";
	var sh_desc = "5조의 scrollBook"; 
		Kakao.Link.sendDefault({ 
		objectType: 'feed',
			content: { 
			title: sh_title, 
			description: sh_desc, 
			imageUrl: "https://ifh.cc/g/3JWKOt.png", 
			link: { mobileWebUrl: "http://203.216.179.152:7080/scrollBook/main.jsp", 
					webUrl: "http://203.216.179.152:7080/scrollBook/main.jsp" 
					} 
				}, 
		});
}
```

* 검색 기능
><a href="https://imgbb.com/"><img src="https://i.ibb.co/44wQ4zq/33.png" alt="33" border="0"></a>

```
function fillSearchResult( autocomplete ) {
   autocomplete.innerHTML = "";
   var searchResults = ["#튤립" , "#개발", "#코딩"];
   for (var i=0; i < searchResults.length; i++) {
      autocomplete.innerHTML += "<div onclick='selectData(this);'>" + searchResults[i] + "</div>";
   }
}
function selectData(that) {
    var searchKeyword = document.getElementById("searchKeyword");
    searchKeyword.value = that.innerText;
    
    var autocomplete = document.getElementById("autocomplete");
    autocomplete.style.display="none";
}
```



---      
</br>



## ⚡ ISSUES
<details markdown="1">
<summary>펼치기</summary>

<a href="https://ibb.co/vhfgGFx"><img src="https://i.ibb.co/ZSvtPj6/34.png" alt="34" border="0"></a>

</details>
