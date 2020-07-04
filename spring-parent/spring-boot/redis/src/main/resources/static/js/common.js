//通过id值获取DOM节点
function $(id){
	return document.getElementById(id);
}
//通过className获取DOM节点
function byclassName(className){
	//高级浏览器
	if (document.getElementByClassName) {
		return document.getElementByClassName(className);
	}else{
		var 
			aFit 	   = [],
			allTag = document.getElementsByTagName('*');
			for (var i = 0; i < allTag.length; i++) {
				if (allTag[i].className === className) {
					aFit.push(allTag[i]);
				}
			}
		return aFit;
	}
}
//获取节点样式
function getStyle(obj , sAttr){
	if (obj.currentStyle) {
		return obj.currentStyle(sAttr);
	}else{
		return getComputedStyle(obj,null)[sAttr];
	}
}
// 缓冲运动框架
function bufferMove(obj, oTarget, fn) {
	clearInterval(obj.iTimer);

	obj.iTimer = setInterval(function () {
		var bBtn = true; // 假设所有属性运动均已完毕
		for(var sAttr in oTarget) {
			// 读取属性的当前值
			if(sAttr === 'opacity') {
				var iCur = parseInt(getStyle(obj, 'opacity') * 100);
			} else {
				var iCur = parseInt(getStyle(obj, sAttr));
			}
			// 计算速度
			var iSpeed = ( oTarget[sAttr] - iCur ) / 4;
			iSpeed = iSpeed > 0 ? Math.ceil(iSpeed) : Math.floor(iSpeed);

			// 开始更新属性的值
			var iTarget = iCur + iSpeed;
			if(sAttr === 'opacity') {
				obj.style.opacity = iTarget / 100;
				obj.style.filter  = 'alpha(opacity:' + iTarget +')';
			} else {
				obj.style[sAttr] = iTarget + 'px';
			}

			// 判断当前属性是否运动完成
			if(iTarget !== oTarget[sAttr]) {
				bBtn = false;
			}
		}

		// 检测所有属性是否均已完成
		if(bBtn) {
			clearInterval(obj.iTimer);
			// 如果用户传入回调函数则执行
			if(fn) {
				fn();
			}
		}
	}, 50);
}

//轮播图播放方法
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