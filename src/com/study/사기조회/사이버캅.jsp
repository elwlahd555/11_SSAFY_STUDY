<html lang="ko"><head>
    



<link rel="shortcut icon" href="/favicon.ico">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, width=device-width">
<title>경찰청 사이버수사국</title>
<!--[if lt IE 9]>
<script src="../../mobile/js/html5shiv.js"></script>
<![endif]-->
<link rel="stylesheet" href="/mobile/css/design2.css">
<link rel="stylesheet" href="/mobile/css/design.main2.css">
<link rel="stylesheet" href="/mobile/css/sub_jg.css">
<!-- 
<link rel='stylesheet' media='screen and (max-width: 320px)' href='../mobile/css//narrow.css' type="text/mobile/css"/>
<link rel='stylesheet' media='screen and (min-width: 321px) and (max-width: 480px)' href='../mobile/css/narrow2.css' type="text/mobile/css"/>
<link rel='stylesheet' media='screen and (min-width: 481px) and (max-width: 699px)' href='../mobile/css/medium.css' type="text/mobile/css"/>
<link rel='stylesheet' media='screen and (min-width: 700px) and (max-width: 768px)' href='../mobile/css/medium_pad.css' type="text/mobile/css"/>
<link rel='stylesheet' media='screen and (min-width: 769px) and (max-width: 959px)' href='../mobile/css/wide.css' type="text/mobile/css"/>

 -->
<script src="/mobile/js/jquery1.7.0.js"></script>
<script src="/mobile/js/maintouch.js"></script><!-- 이거임 . 옮겨놓음 -->
<script src="/mobile/js/jquery.event.drag-1.5.min.js"></script>
<script src="/mobile/js/jquery.touchSlider.js"></script>
<script src="/mobile/js/design.js"></script>
<script src="/mobile/js/design.main.js"></script>

<script>
var uri 	= "/mobile/tm/sub/sub_02.jsp"
  ;

function mobile_chk(){
 var user_device = navigator.userAgent.toLowerCase();
 var mobile_device = new Array('iphone','ipad', 'firefox', 'android');

 for(var i=0;i<mobile_device.length;i++){
  if(user_device.indexOf(mobile_device[i]) != -1) return true;
 }
 return false;
}
if(mobile_chk()){
 window.addEventListener('load', function(){
    setTimeout(scrollTo,0,0,1)
},false);
}
</script>

<script type="text/javascript" src="https://wcs.naver.net/wcslog.js"></script>
<script type="text/javascript"> if(!wcs_add) var wcs_add = {}; wcs_add["wa"] = "10766336ef0eba4"; wcs_do(); </script> 



</head>
<body>
<section id="container">
    
<!-- 메뉴 부분 -->
    <div class="pos_nav">
        <a href="#nav" class="btn_nav"><img src="/mobile/images/site/btn_menu.png" alt="메뉴열림"></a>
    </div>
    <nav id="nav">
        <h1>사이버수사국 메뉴</h1>
        <ul class="navmenu">
            
            <li class="nvparam1"><a href="https://ecrm.cyber.go.kr/mbl/index.tigger" target="_blank">사이버범죄신고/상담</a>
            </li>
            
            <li class="nvparam2"><a href="https://42edu.cyber.go.kr/mbl/index.tigger" target="_blank">사이버 예방교육 신청</a>
            </li>
            
            <li class="nvparam3"><a href="/mobile/tm/sub/sub_02.jsp" class="on">사이버사기 의심전화·계좌번호 조회</a>
            </li>
                
            <li class="nvparam4"><a href="/mobile/tm/boardList.do?board_id=warning&amp;page=1">피해경보발령</a>
            </li>
            
            <li class="nvparam5"><a href="/mobile/tm/sub/sub_03.jsp">예방수칙</a>
            </li>
            
            <li class="nvparam6"><a href="/mobile/tm/mobMovieList.do?category=M1">예방홍보물</a>
            </li>
        </ul>
    </nav>
    <!-- 메뉴부분 -->
    <div class="blank_blank"></div>
    <section id="contents">
        
        

        <header>
            <h1><a href="/mobile/index.jsp"><img src="/mobile/images/site/logo.jpg" alt="경찰청사이버수사국"></a></h1>
        </header>
        <script>
            //Display the current menu
            var navCurrentParam1 = 3;    //1depth
            var navCurrentParam2 = 1;    //2depth
            var navCurrentParam3 = 0;    //3depth
        </script>
        <!--main-->
        <div class="loc_line">
            <h3>사이버사기 피해 신고여부</h3>
        </div>
        <section id="sub">

            <div class="cont_in">
               	<!-- 사이버사기피해 신고여부확인 -->
<!--        			<iframe id="remote_iframe_4" name="remote_iframe_4" class="gadgets-gadget" src="http://www.net-durumi.go.kr/shows/ccias/frame/cyberbureau/side_4.jsp" frameborder="no" scrolling="no" allowtransparency="true" height="250" width="100%"></iframe> -->
                <!-- //사이버사기피해 신고여부확인 -->
                
			    <div class="reserch_box">
			        <p class="line_01">
			            <label for="field1"><input id="field1" name="field" type="radio" value="H" checked="checked"> 전화번호</label>
			            <label for="field2"><input id="field2" name="field" type="radio" value="A"> 계좌번호</label>
			        </p>
			        <p class="line_02">
			            <input type="text" name="keyword" class="in_box" value="">
			            <span class="btn_type2" id="getXmlSearch"><button>조회</button></span>
			            </p><p class="fraud_box" id="search_result"><span id="search_load">최근 3개월 동안 3회 이상 경찰에 신고 접수된 번호들과 비교합니다.</span></p>
			        <p></p>
			    </div>
			    <script type="text/javascript">
			
			        $(function() {
				        $(document).ready(function() {
				        	var status = ""
				        	  ;
				        	if (status != "") {
				        		$("#search_result").html(status);
				        	}
				        });
			        	
			            $("#getXmlSearch").live('click', function() {
			                if ( checkValidationXml() ) {
			                    $('#search_load').show();
			                    callAjaxData("4");
			                }
			            });
			        });
			
			        function checkValidationXml() {
			            if(! $(':input[name = "keyword"]').val()){
			                alert('번호를 입력해주세요.');
			                $("input[name = 'keyword']").focus();
			                return false;
			            }
			            return true;
			        }
			
			        function callAjaxData(accessType)
			        {
			            var $field 		= $(':radio[name="field"]:checked').val()
			              , $keyword 	= $(':input[name = "keyword"]').val()
			              , cybercopUrl = "https://net-durumi.cyber.go.kr/getMessage.do"
			              ;
			            
			            $.ajax({
			                type: "POST"
			                ,url: cybercopUrl
			                ,dataType : "jsonp"
			                ,jsonp : "callback"
			                ,data : "fieldType="+$field+"&keyword="+$keyword+"&accessType="+accessType
			                ,contentType : "application/x-www-form-urlencoded; charset=utf-8"
			                ,error : function (request, status, error){}
			                ,success: function(response, status, request) {
			                	$("#search_result").html(response["message"]);
			                }
			                ,beforeSend : function() {
			                    $("#search_result").html("신고 여부를 확인 중입니다.");
			                }
			                ,complete : function() {}
			            });
			        }
			    </script>
                
                <!-- <p><img src="/mobile/images/site/sub_net.png" alt="넷 두루미"/></p> --> 
            </div><!--//cont_in -->



        </section>
        

        <footer>
            <address>Copyright ⓒ 2014 사이버수사국 All rights reserved</address>
        </footer>
    </section>
    <!--/contents-->
</section>

</body></html>