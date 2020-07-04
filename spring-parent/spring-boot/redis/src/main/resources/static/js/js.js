$(function(){
    // 二级菜单

    $("#list .left li").hover(function(){
        $(this).find('.caidan').css({display:"block"}).parent().siblings().find('.caidan').css({display:"none"});
    },function(){
        $(this).find('.caidan').css({display:"none"});
    })

    //++++++++++++大轮播效果++++++++++++++++++++
    // 定义全局时间变量
    var timer = null;
    // 定义轮播切换变量
    var num = 0;
    
    // 自动切换
    function dalunbo(){
        // 每执行一次切换变量自增一次
        num++;
        // 判断：如果图片达到最后一个则回流
        if (num==6) {
            num=0;
        };
        // 图片自动切换
        $("#list .center .dalunbo a").eq(num).fadeIn(300).siblings().fadeOut(300);
        $("#list .center .huakuai li").eq(num).css({background:"#B61B1F"}).siblings().css({background:"#3E3E3E"});
    }
    // 设定定时器
    timer = setInterval(dalunbo,5000);

    // +++++++++++++++++++++++鼠标移入停止轮播++++++++++++++++++++++++++
    $("#list .center").mouseover(function(){
        // 清除定时器
        clearInterval(timer);
        // 切换按钮显示
        $("#list .center .anliu").css({display:"block"});
    })
    // 鼠标移除开始轮播
    $("#list .center").mouseout(function(){
        timer = setInterval(dalunbo,5000);
        $("#list .center .anliu").css({display:"none"});
    })

    // +++++++++++++++++++++++手动切换轮播+++++++++++++++++++++++++++++++
    $("#list .center .huakuai li").mouseover(function(){
        num = $(this).index();
        $("#list .center .dalunbo a").eq(num).fadeIn(300).siblings().stop()/*防止多次触发*/.fadeOut(300);
        $("#list .center .huakuai li").eq(num).css({background:"#B61B1F"}).siblings().css({background:"#3E3E3E"});
    })

    // ++++++++++++++++++++++++按钮切换++++++++++++++++++++++++++++++++++

    var c = 0;
  
    // 左按钮
    $("#list .center .anliu_left").click(function(){
        if (c==0) {
            c=1;
            setTimeout(function(){
                c=0;
            },500)
        }else{
            return;
        };
        num--;
        //判断：如果超过则回流。
        if (num==-1) {
            num=5;
        };
        $("#list .center .dalunbo a").eq(num).fadeIn(300).siblings().fadeOut(300);
        $("#list .center .huakuai li").eq(num).css({background:"#B61B1F"}).siblings().css({background:"#3E3E3E"});

    })
    // 右按钮
    $("#list .center .anliu_right").click(function(){
        // 防止多次触发设置
        if (c==0) {
            c=1;
            setTimeout(function(){
                c=0;
            },500)
        }else{
            return;
        };

        num++;
        //判断：如果超过则回流。
        if (num==6) {
            num=0;
        };
        $("#list .center .dalunbo a").eq(num).fadeIn(300).siblings().fadeOut(300);
        $("#list .center .huakuai li").eq(num).css({background:"#B61B1F"}).siblings().css({background:"#3E3E3E"});

    })

    //++++++++++++++++++今日推荐无缝轮播效果+++++++++++++++++++++++++++++++++
    // 鼠标移入点击按钮显示
    $("#today .tui").mouseover(function(){
        $("#today .tui .anliu").css({display:"block"});
    })
    // 鼠标移出点击按钮消失
    $("#today .tui").mouseout(function(){
        $("#today .tui .anliu").css({display:"none"});
    })
    // 右按钮点击滑动效果
    // 左按钮
    var j = 0;
    $("#today .anliu_left").click(function(){
        j--;
        if (j==-1) {
            $(".tuijian").css({left:"-4000px"});
            j=3;
        };
        var left = j*-1000;
        $(".tuijian").animate({left:left+"px"},500);
    })
    // 右按钮点击滑动效果
    $("#today .anliu_right").click(function(){
        j++;
        if (j==5) {
            $(".tuijian").css({left:"0px"});
            j=1;
        };
        var left = j*-1000;
        $(".tuijian").animate({left:left+"px"},500);
    })


    // +++++++++++++++++++++++++楼层选项卡tab切换效果++++++++++++++++++++++++++++++++++++++++++
    $(".head ul li").mouseenter(function(){
        // 移除默认热门class
        $(this).parent().find("li").removeClass("remen");
        // 获得tab下标
        var tab_num = $(this).index();
        // 鼠标移上增加样式，将其他兄弟元素样式复归
        $(this).find("a").css({"border-left":"1px solid #c81623","border-right":"1px solid #c81623","border-top":"3px solid #c81623",background: "#FFF",color: "#c81623","line-height": "30px",position: "relative",left: "-1px",top: "-1px","z-index": 2}).parent('li').siblings().find('a').css({"border-left":"none","border-right":"none","border-top":"none",background: "none",color: "#666","line-height": "34px",position: "relative",left: "0px",top: "0px","z-index": 0});
        // 将页面页显示，其他页隐藏
        $(this).parents(".head").siblings().find(".main").eq(tab_num).css({display:"block"}).siblings().css({display:"none"});
    })




    //电梯效果
    $(window).scroll(function(){
        var t = $(document).scrollTop();
        if (t>=660&&t<=9250) {
            $("#dianti").css({display:"block"});
        }else{
            $("#dianti").css({display:"none"});
        };
        var high = ["1900px","2700px","3500px","4100px","4750px","5550px","6100px","6700px","7300px","8100px","8750px"];
        
        // 点击跳转楼层
        $("#dianti li").click(function(){
            var dt = $(this).index();
            $(this).find(".shuzi").css({color:"#C81623"}).parent().siblings().find('.shuzi').css({color:"#625351"})
            $('html,body').stop().animate({scrollTop: high[dt]}, 1000);
        })
        // 滑动改变颜色
        var j;
        if (t>=1900&&t<2700) {
            j=0;
        }else if (t>=2700&&t<3500) {
            j=1;
        }else if(t>=3500&&t<4100){
            j=2;
        }else if(t>=4100&&t<4750){
            j=3;
        }else if(t>=4750&&t<5550){
            j=4;
        }else if(t>=5550&&t<6100){
            j=5;
        }else if(t>=6100&&t<6700){
            j=6;
        }else if(t>=6700&&t<7300){
            j=7;
        }else if(t>=7300&&t<8100){
            j=8;
        }else if(t>=8100&&t<8750){
            j=9;
        }else if(t>=8750&&t<9250){
            j=10;
        }else{
            j=-1;
        };
        if (j==-1) {
            $("#dianti li").removeClass("active");
        }else{
            $("#dianti li").eq(j).addClass('active').siblings("li").removeClass('active');
            $("#dianti li").eq(j).siblings().find('.shuzi').css({color:"#625351"});
        }
    })

    // 楼成轮播
    $(".lunbo").each(function(){
        var jq_this = $(this);
        var js_this = this;
        js_this.num2 = 0;
        js_this.run = function(){
            js_this.num2++;
            if (js_this.num2==5) {
                js_this.num2=1;
                jq_this.find(".lunbo_pic").css({left:"0px"});
            };
            var w = jq_this.width();
            var l = js_this.num2 * -w;
            jq_this.find(".lunbo_pic").animate({left:l+"px"},500);
            if (js_this.num2==4) {
                jq_this.find(".hk").find("li").eq(0).css({background:"#B61B1F"}).siblings().css({background:"#3E3E3E"});
            }else{
                jq_this.find(".hk").find("li").eq(js_this.num2).css({background:"#B61B1F"}).siblings().css({background:"#3E3E3E"});
            };
        }
        js_this.timer2 = setInterval(js_this.run,3000);
        // 鼠标移入停止轮播
        jq_this.hover(function(){
            clearInterval(js_this.timer2);
        },function(){
            js_this.timer2 = setInterval(js_this.run,3000);
        })
        // 下滑块移动
        jq_this.find(".hk").find("li").mouseover(function(){
            js_this.num2 = $(this).index();
            var w = jq_this.width();
            // alert(js_this.num2);
            var l = js_this.num2 * -w;
            jq_this.find(".lunbo_pic").stop().animate({left:l+"px"},500);
            jq_this.find(".hk").find("li").eq(js_this.num2).css({background:"#B61B1F"}).siblings().css({background:"#3E3E3E"});
        })
        // 点击切换
        // // 左按钮
        jq_this.find('.btl').click(function(){
             if (c==0) {
            c=1;
            setTimeout(function(){
                c=0;
            },500)
            }else{
                return;
            };
            js_this.num2--;
            var w = jq_this.width();
            if (js_this.num2==-1) {
                jq_this.find(".lunbo_pic").css({left:w*-4+'px'});
                js_this.num2 = 3;
            };
            var l = js_this.num2 * -w;
            jq_this.find(".lunbo_pic").animate({left:l+"px"},500);
            jq_this.find(".hk").find("li").eq(js_this.num2).css({background:"#B61B1F"}).siblings().css({background:"#3E3E3E"});
        })
        // 右按钮点击滑动效果
        jq_this.find('.btr').click(function(){
            if (c==0) {
                c=1;
                setTimeout(function(){
                c=0;
                },500)
            }else{
                return;
            };
            js_this.num2++;
            var w = jq_this.width();
            if (js_this.num2==5) {
                js_this.num2 = 1;
                jq_this.find(".lunbo_pic").css({left:'0px'});
            };
            var l = js_this.num2 * -w;
            jq_this.find(".lunbo_pic").animate({left:l+"px"},500);
            if (js_this.num2==4) {
            jq_this.find(".hk").find("li").eq(0).css({background:"#B61B1F"}).siblings().css({background:"#3E3E3E"});
            }else{
            jq_this.find(".hk").find("li").eq(js_this.num2).css({background:"#B61B1F"}).siblings().css({background:"#3E3E3E"});
            }
        })
    })
})



