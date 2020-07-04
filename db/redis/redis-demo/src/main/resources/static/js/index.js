//跨域请求的回调函数
function cb(data){
		var
			oSearchList = $('searchList'),
			aLi         = oSearchList.getElementsByTagName('li'),
			oContent    = $('content');
			oSearchList.innerHTML = '';
		data.result.forEach(function(v){
			var oLi = document.createElement('li');
				oLi.innerHTML = v[0];
				oSearchList.appendChild(oLi);
		});
		for (var i = 0; i < aLi.length; i++) {
			aLi[i].onclick = function(){
				oContent.value = this.innerHTML;
				oContent.style.color = '#000';
				oSearchList.style.display = 'none';
			}
		}
	}
window.onload = function(){
/*-------------------------------head效果-------------------------------*/
	var 
		oTop 		  = $('top'),
		oClose 	  = $('close'),
		iBgColorSpeed = 10,
		iTimer        = null;
	//给oHeadClose添加onclick事件
	oClose.onclick = function(){
		//设置淡出效果
		clearInterval(iTimer);
		iTimer = setInterval(function(){
			var iCur = parseFloat(getStyle(oTop,'opacity')*100);
		 		iNext = iCur - 5;
			if (iNext <= 0) {
				iNext = 0;
				oTop.style.display = "none";
				clearInterval(iTimer);
			}
			oTop.style.opacity = iNext/100;
			oTop.style.filter = 'alpha(opacity:' + iNext + ')';
		},30);

	}

/*--------------------------定位地址效果--------------------------*/
	var
		oPosition    = $('position'),
		oChangeP     = $('changeP'),
		oLocalP      = $('localP'),
		aPositonList = oChangeP.getElementsByTagName('li');
		//鼠标划入改变地址的文本框出现
		oPosition.onmouseenter = function(){
			oChangeP.style.display = 'block';
		}
		//鼠标划出改变地址的文本框消失
		oPosition.onmouseleave = function(){
			oChangeP.style.display = 'none';
		}
		//给每个地址列表添加onclick事件
		for (var i = 0; i < aPositonList.length; i++) {
			aPositonList[i].onclick = function(){
				oLocalP.innerHTML = '<i class="iconfont icon-map"></i><span>'+ this.innerHTML +'</span>';
				for (var i = 0; i < aPositonList.length; i++) {
					aPositonList[i].className = '';
				}
				this.className = 'thisChoise';
			}
		}

/*----------------------------------------搜索输入框效果--------------------------------*/
	var
		oSearch  = $('search'),
		oSearchList    = $('searchList'),
		oContent = $('content');
	//给输入框一个默认的内容添加onfocus事件和onblur事件
		oContent.onblur = function(){
			oContent.value = '自营3免1';
			oContent.style.color = 'rgb(153, 153, 153)';
		}
		oContent.onfocus = function(){
			oContent.value = '';
			oContent.style.color = 'rgb(51, 51, 51)';
		}
	//异步请求JSONP跨域获取数据
	
	//给输入框添加oninput事件
	oContent.oninput = oContent.onpropetychange = function(){
		if (oContent.value !== '') {
			var oScript = document.createElement('script');
				oScript.src = 'https://suggest.taobao.com/sug?code=utf-8&q='+ this.value +'&_ksTS=1483614919450_1047&callback=cb&k=1&area=c2c&bucketid=5';
				oSearch.appendChild(oScript);
				oSearchList.style.display = 'block';
				oSearch.removeChild(oScript);
		}else{
			oSearchList.innerHTML = '';
			oSearchList.style.display = 'none';

		}
	}
/*------------------------京东新闻列表效果----------------------------*/
	var
		oSales        = $('sales'),
		oAnnouncement = $('announcement'),
		oNewList1     = $('newsList1'),
		oNewList2     = $('newsList2'),
		oNewsBottom   = $('newsBottom');
		oSales.onmouseenter = function(){
			oNewList1.style.display = 'block';
			oNewList2.style.display = 'none';
			bufferMove(oNewsBottom , {left:2});
		}
		oAnnouncement.onmouseenter = function(){
			oNewList2.style.display = 'block';
			oNewList1.style.display = 'none';
			bufferMove(oNewsBottom , {left:40});
		}

/*------------------------------banner图效果----------------------*/
	var
		oBanner  = $('banner'),
		oImglist = $('imgList'),
		oJianTou = $('jianTou'),
		oLeftJ   = $('leftJiantou'),
		ORightJ  = $('rightJiantou'),
		oPoint   = $('point'),
		aPointA  = oPoint.getElementsByTagName('a'),
		iSpeed   = 790,
		iIndex   = 0,
		iBannerT = null;
	//播放方法
	function play(){
		iBannerT = setInterval(function(){
			iIndex++;
			if (iIndex > 7) {
				iIndex = 0;
			}
			bufferMove(oImglist , {left:-iIndex * iSpeed});
			for (var i = 0; i < aPointA.length; i++) {
				aPointA[i].className = '';
			}
			aPointA[iIndex].className = 'active';
		},3000);
	}
	//停止方法
	function stop(){
		clearInterval(iBannerT);
	}
	play();
	//banner图添加onmouseenter和onmouseleave事件
	oBanner.onmouseenter = function(){
		oJianTou.style.display = 'block';
		stop();
	}
	oBanner.onmouseleave = function(){
		oJianTou.style.display = 'none';
		play();
	}
	//给每个圆点添加点击事件
	for (var i = 0; i < aPointA.length; i++) {
		aPointA[i].index = i;
		aPointA[i].onclick = function(){
			bufferMove(oImglist , {left:-this.index * iSpeed});
			for (var i = 0; i < aPointA.length; i++) {
				aPointA[i].className = '';
			}
			this.className = 'active';
			iIndex = this.index;
		}
	}
	//给右箭头添加onclic事件
	ORightJ.onclick = function(){
		iIndex++;
		if (iIndex >= 7) {
			iIndex = 7;
		}
		bufferMove(oImglist , {left:-iIndex * iSpeed});
		for (var i = 0; i < aPointA.length; i++) {
			aPointA[i].className = '';
		}
		aPointA[iIndex].className = 'active';
	}
	//给左箭头添加onclic事件
	oLeftJ.onclick = function(){
		iIndex--;
		if (iIndex <= 0) {
			iIndex = 0;
		}
		bufferMove(oImglist , {left:-iIndex * iSpeed});
		for (var i = 0; i < aPointA.length; i++) {
			aPointA[i].className = '';
		}
		aPointA[iIndex].className = 'active';
	}	
/*----------------------------------------秒杀特效-------------------------------*/
	showTime();
	function addZero(x){
		if (x < 10) {
			return "0" + x;
		}else{
			return x
		}
	}
	function showTime(){
		var	
		   oOuttime = $('outtime'),
		   nowDate  = new Date(),//当前时间
		   endDate  = new Date('2017/02/31 12:00:00'),//结束时间
		   timeSpan = endDate.getTime() - nowDate.getTime(),//时间间隔;
		   iHours   = addZero(Math.floor((timeSpan%86400000)/(3600000))),
		   iMinutes = addZero(Math.floor(((timeSpan % 86400000) % 3600000) / 60000)),
		   iSeconds = addZero(Math.floor(((timeSpan % 86400000) % 3600000 % 60000) / 1000));
		var iCutDown = null;
		oOuttime.innerHTML = '<span>' + iHours + '</span><span class="bg-none">:</span><span>' + iMinutes + '</span><span class="bg-none">:</span><span>' + iSeconds + '</span>' ;
		iSeconds--;
		if (iHours <= 0) {
			clearInterval(iCutDown);
		} 
	}
	iCutDown = setInterval(function(){
		showTime();
	},1000);

/*-----------------------------------登陆界面效果------------------------------*/
	var
		oMask       = $('mask'),
		oMembers    = $('members'),
		oLoginBox   = $('loginBox'),
		oCloseLogin = $('closeLogin'),
		oBtn1 		= $('btn1'),
		oBtn2 		= $('btn2');
		aSaoMa      = byclassName('saoMa');
		aZhangHu    = byclassName('zhangHu');
	//点击会员图标，登陆界面出现
	oMembers.onclick = function(){
		oLoginBox.style.display = 'block';
		oMask.style.display = 'block';
	}
	//点击关闭按钮，登陆界面消失
	oCloseLogin.onclick = function(){
		oLoginBox.style.display = 'none';
		oMask.style.display = 'none';
	}
	//扫码登陆界面出现
	oBtn1.onclick = function(){
		aSaoMa[0].style.display = 'block';
		aZhangHu[0].style.display = 'none';
		oBtn1.className = 'loginactive';
		oBtn2.className = '';
	}
	//账户登陆界面出现
	oBtn2.onclick = function(){
		aSaoMa[0].style.display = 'none';
		aZhangHu[0].style.display = 'block';
		oBtn1.className = '';
		oBtn2.className = 'loginactive';
	}
/*------------------------返回顶部效果--------------------------*/
	var
		oToTop        	 = $('toTop'),
		iToTopSpeed   	 = 100,
		iToTopSpeedTimer = null;
	oToTop.onclick = function(){
		document.documentElement.scrollTop = document.body.scrollTop = 0;
	}
/*------------------------------右侧固定栏效果--------------------*/
	var
		oLoginArea      = $('loginArea'),
		oLogoBtn        = $('logoBtn'),
		oCloseLoginArea = $('closeLoginArea'),
		oLoginAreaLeft  = $('loginAreaLeft'),
		// aLoginAreaLeftLi= oLoginAreaLeft.getElementsByTagName('li'),
		aSpan           = oLoginAreaLeft.getElementsByTagName('span'),
		aI              = oLoginAreaLeft.getElementsByTagName('i'),
		iMoveSpeed      = 10,
		iMoveTimer      = null;
	var oRight = parseInt(getStyle(oLoginArea,'right'));
	//让oLoginArea延迟3秒钟出现
	setTimeout(function(){
		oLoginArea.style.display = 'block';
	} , 2000);
	//有bug  速度一改大 right值就没有界限了
	//点击oLogoBtn时oLoginArea运动出来;
	oLogoBtn.onclick = function(){
		iMoveTimer = setInterval(function(){
			if (oRight === 0) {
				clearInterval(iMoveTimer);
			}else{
				oRight += iMoveSpeed;
			}
			oLoginArea.style.right = oRight + 'px';
		},10);
	}
	//点击oCloseLoginArea时oLoginArea运动回去;	
	oCloseLoginArea.onclick = function(){
		iMoveTimer = setInterval(function(){
			if (oRight === -270) {
				clearInterval(iMoveTimer);
			}else{
				oRight -= iMoveSpeed;
			}
			oLoginArea.style.right = oRight + 'px';
		},10);
	}
	//给每个span添加onmouseenter事件
	for (var i = 0; i < aSpan.length; i++) {
		aSpan[i].index = i;
		aSpan[i].onmouseenter = function(){
			for (var j = 0; j < aI.length; j++) {
				aI[this.index].style.left = 0;
			}
		}
	}
	//给每个span添加onmouseleave事件
	for (var i = 0; i < aSpan.length; i++) {
		aSpan[i].index = i;
		aSpan[i].onmouseleave = function(){
			for (var j = 0; j < aI.length; j++) {
				aI[this.index].style.left = -66 + 'px';
			}
		}
	}
}