/*
this is a page controller
 */
var displayPage  = 6


function dumpEXCEL(){

    /* 反馈请求的url地址 */
    var currentPage = $("#currentPage").val()
    var cnmaster = $.trim($("#cnmasterID").val())

    if(cnmaster == '任意'){
        cnmaster = undefined
    }

    var serverid = $.trim($('#serveridID').val())
    console.log(".............")
    if(serverid=='任意'|(serverid=='')|(serverid==null)){
        serverid = undefined
    }

    var gamename = $('#gamenameID').val()
    var followerNumber = $('#followerNumberID').val()
    if(followerNumber == '所有'){
        followerNumber = undefined
    }

    var startLossDays = $("#startLossDaysID").val()

    if(startLossDays == "0"){
        startLossDays =  undefined
    }else{
        startLossDays = Number(startLossDays)
    }


    var endLossDays = $("#endLossDaysID").val()

    if(endLossDays == "inf"){
        endLossDays = undefined
    }else{
        endLossDays = Number(endLossDays)
    }



    var recallDate = $('#recallDateID').val()
    var recallDateString = ""
    if(recallDate == "请选择时间"){
        recallDateString = getDefaultDateString()
    }else{
        recallDateString = $('#recallDateID').val()
    }

    var dataArray = String(recallDateString).split('至')
    var startRecallDate =  $.trim(dataArray[0])
    var endRecallDate = $.trim(dataArray[1])

    var interposeDate = $('#interposeDateID').val()
    var interposeDateString = ""
    if(interposeDate == "请选择时间"){
        interposeDateString = getDefaultDateString()
    }else{
        interposeDateString = $('#interposeDateID').val()
    }

    var dataArray = String(interposeDateString).split('至')
    var startInterposeDate = $.trim(dataArray[0])
    var endInterposeDate = $.trim(dataArray[1])


    var lossDate = $('#lossDateID').val()
    var lossDateString = ""
    if(lossDate == "请选择时间"){
        lossDateString = getDefaultDateString()
    }else{
        lossDateString = $('#lossDateID').val()
    }

    var dataArray = String(lossDateString).split('至')
    var startLossDate = $.trim(dataArray[0])
    var endLossDate = $.trim(dataArray[1])


    var level= $('#levelID').val()
    var interposeStatus= Number($('#isInterposeID').val())
    var status= $('#statusID').val()

    // var isRecall= $('#isRecallID').val()
    // var isLoss= $('#isLossID').val()
    var hasSystemSendGift= $('#hasSystemSendGiftID').val()
    var hasManualSendGift= $('#hasManualSendGiftID').val()

    var form = $("<form accept-charset='UTF-8'></form>")
//     var type="Content-Type"
//     var typeT="application/json;charset=utf-8"
//    form.prop(type,typeT)
    Document.charset="utf-8";
    form.prop("method","POST")
   // form.prop("ContentType","utf-8")
    form.prop("action","/ds/dumpexcel")
    form.append($("<input></input>").prop("name","cnmaster").prop("type","hide").prop("value",cnmaster))
    form.append($("<input></input>").prop("name","serverid").prop("type","hide").prop("value",serverid))
    form.append($("<input></input>").prop("name","startLossDays").prop("type","hide").prop("value",startLossDays))
    form.append($("<input></input>").prop("name","endLossDays").prop("type","hide").prop("value",endLossDays))
    form.append($("<input></input>").prop("name","gamename").prop("type","hide").prop("value",gamename))
    form.append($("<input></input>").prop("name","followerNumber").prop("type","hide").prop("value",followerNumber))
    form.append($("<input></input>").prop("name","status").prop("type","hide").prop("value",status))
    form.append($("<input></input>").prop("name","startRecallDate").prop("type","hide").prop("value",startRecallDate))
    form.append($("<input></input>").prop("name","endRecallDate").prop("type","hide").prop("value",endRecallDate))
    form.append($("<input></input>").prop("name","startLossDate").prop("type","hide").prop("value",startLossDate))
    form.append($("<input></input>").prop("name","endLossDate").prop("type","hide").prop("value",endLossDate))
    form.append($("<input></input>").prop("name","startInterposeDate").prop("type","hide").prop("value",startInterposeDate))
    form.append($("<input></input>").prop("name","endInterposeDate").prop("type","hide").prop("value",endInterposeDate))
    form.append($("<input></input>").prop("name","level").prop("type","hide").prop("value",level))
    form.append($("<input></input>").prop("name","interposeStatus").prop("type","hide").prop("value",interposeStatus))
    form.append($("<input></input>").prop("name","hasManualSendGift").prop("type","hide").prop("value",hasManualSendGift))
    form.appendTo("body").submit().remove()

}
function getDefaultDateString(){
	var today = new Date()
	var year = today.getFullYear()
	var month = today.getMonth() + 1
	var date = today.getDate()
	var endDateString = "" + year + "-" + month + "-" + date
	var startDateString = "1970-01-01"
	var dateString = startDateString + " 至 " + endDateString
	return dateString
}
function getJsonParameter(){
    /* 反馈请求的url地址 */
    var currentPage = $("#currentPage").val()
    var cnmaster = $.trim($("#cnmasterID").val())

    if(cnmaster == '任意'||cnmaster==''||cnmaster==undefined){
        cnmaster = undefined
    }

    var serverid = $.trim($('#serveridID').val())
    console.log(".............")
    console.log("2"+serverid)
    if(serverid=='任意'||serverid=='""'||serverid==undefined){
        serverid = undefined
        console.log(serverid)
    }
    
    serverid = Number(serverid)



    var gamename = $('#gamenameID').val()
    var followerNumber = $('#followerNumberID').val()
    if(followerNumber == '所有'){
        followerNumber = undefined
    }

    var startLossDays = $("#startLossDaysID").val()

    if(startLossDays == "0"){
        startLossDays =  undefined
    }else{
        startLossDays = Number(startLossDays)
    }


    var endLossDays = $("#endLossDaysID").val()

    if(endLossDays == "inf"){
        endLossDays = undefined
    }else{
        endLossDays = Number(endLossDays)
    }



    var recallDate = $('#recallDateID').val()
    var recallDateString = ""
    if(recallDate == "请选择时间"){
        recallDateString = getDefaultDateString()
	}else{
        recallDateString = $('#recallDateID').val()
    }

    var dataArray = String(recallDateString).split('至')
    var startRecallDate =  $.trim(dataArray[0])
    var endRecallDate = $.trim(dataArray[1])

    var interposeDate = $('#interposeDateID').val()
    var interposeDateString = ""
    if(interposeDate == "请选择时间"){
        interposeDateString = getDefaultDateString()
    }else{
        interposeDateString = $('#interposeDateID').val()
    }

    var dataArray = String(interposeDateString).split('至')
    var startInterposeDate = $.trim(dataArray[0])
    var endInterposeDate = $.trim(dataArray[1])


    var lossDate = $('#lossDateID').val()
    var lossDateString = ""
    if(lossDate == "请选择时间"){
        lossDateString = getDefaultDateString()
    }else{
        lossDateString = $('#lossDateID').val()
    }

    var dataArray = String(lossDateString).split('至')
    var startLossDate = $.trim(dataArray[0])
    var endLossDate = $.trim(dataArray[1])


    var level= $('#levelID').val()
    var interposeStatus= Number($('#isInterposeID').val())
    var status= $('#statusID').val()

    // var isRecall= $('#isRecallID').val()
    // var isLoss= $('#isLossID').val()
    var hasSystemSendGift= $('#hasSystemSendGiftID').val()
    var hasManualSendGift= $('#hasManualSendGiftID').val()
    var result ={
        cnmaster:cnmaster,
        serverid:serverid,
        startLossDays:startLossDays,
        endLossDays:endLossDays,
        selectPage:currentPage,
        gamename:gamename,
        followerNumber:followerNumber,
        status:status,
        startRecallDate:startRecallDate,
        endRecallDate:endRecallDate,
        startLossDate:startLossDate,
        endLossDate:endLossDate,
        startInterposeDate:startInterposeDate,
        endInterposeDate:endInterposeDate,
        level:level,
        interposeStatus:interposeStatus,
        // isRecall:isRecall,
        // isLoss:isLoss,
        // hasSystemSendGift:hasSystemSendGift,
        hasManualSendGift:hasManualSendGift
    }
    return result
}


// 插入数据使用的东西
function processData(data){

    var mapping = {
        '1':'gamename',
        '2':'lossDays',
        '3':'lossDate',
        '4':'recallDate',
        '5':'cnmaster',
        '6':'level',
        '7':'serverid',
        '8':'interposeDate',
        '9':'interposeStatus',
        '10':'recallMoney',
        '11':'status',
        // '12':'hasSystemSendGift',
        '12':'hasManualSendGift',
        '13':'followerNumber',
        '15':'visitHistory'
    }


    var jsonData = data
    var sourceData = jsonData.data
    var totalCount = jsonData.totalCount
    var totalPage = jsonData.totalPage

    $("#totalPage").val(totalPage)


    $("li > a.totalPage").text("共 " + String(totalPage) + " 页")


    // 数据的长度，用来隐藏某些单元
    $('table > tbody >  tr.trSelected').each(function(ind,obj){
        $(obj).addClass("hidden")
    })


    var len = sourceData.length
    $('table > tbody >  tr.trSelected').each(function(ind,obj){
        var tempData = sourceData[ind]
        if(ind > len -1){
            return
        }
        $(obj).removeClass("hidden")
        $(obj).children('td').each(function(indTD, objectTD){

            if( indTD == 13 ){
                return
            }
            var key = String(indTD + 1)
            var value = mapping[key]

            if(tempData[value] == "1970-01-01"){
                $(objectTD).text("")
            }else{
                var tdContent = tempData[value]
                $(objectTD).text(tdContent)
            }

        })
    })

    $("#totalPage").val(totalPage)

    $("#progressBar").width("100%")
    $('#myModal').modal('hide')

    $("#totalPage").trigger("propertychange")

}


// 分页点击、提交查询点击的时候需要使用的
function querysubmit(){
    var queryString = getJsonParameter()
    queryString = JSON.stringify(queryString)


    $.ajax({
        url:'/ds/recall',
        contentType:'application/json;charset=utf-8',
        dataType:"json",
        data:queryString,
        type:'post',
        success:function(data){
            processData(data)
        }

    })

}

$('#myModal').on('hidden.bs.modal', function () {
    $("#progressBar").width("0%")
})
$('#myModal').on('shown.bs.modal', function() {
    console.log("模态开始啦。。。。。。。")

    var interFunc = setInterval(function(){
        console.log("不断请求进度")

        $.ajax({
            url:'/ds/probar',
            type:'post',
            dataType:'json',
            contentType:'application/json;charset=utf-8 ',
            success:function(data){
                var progressBarLength = "" + data['probar'] +"%"
                $("#progressBar").width(progressBarLength)
            }
        })


    },100)


    var queryString = getJsonParameter()
    queryString = JSON.stringify(queryString)
    $.ajax({

        url:'/ds/recall',
        type:'post',
        data:queryString,
        dataType:"json",
        contentType:'application/json;charset=utf-8 ',
        success:function(data){
            processData(data)
            clearInterval(interFunc)
            $("#progressBar").width("100%")

        }
    })

});





// 更新所有标签<a>上的数字
function updatePageNumber(startNumber , status){
    console.log("更新超链接上的页码。。。")
    var realIndex = -1
    if (status == 'next'){
        realIndex = 0
    }else if (status == 'previous'){
        realIndex = displayPage - 1
    }
    var totalPage = Number($("#totalPage").val())

    $('a.mainPage').each(function(index, obj){


        $(obj).text(index + startNumber)
        $(obj).parent().removeClass('active')
        $(obj).parent().removeClass('disabled')
        if(index == realIndex){
            $(obj).parent().addClass('active')
        }

        var displayPage = Number($(obj).text())
        if(displayPage > totalPage){
            $(obj).parent().addClass("disabled")
        }
    })
}
//<-------------------------------首页、尾页、下一页、上一页 start --------------------------------------->
// function clickQuery(){
//     $("#currentPage").val(1)
//     updatePageNumber(1,'next')
//     $("#clickQueryButton").trigger("click")
// }
function firstPageClick(){



    $("#currentPage").val(1)
    updatePageNumber(1,'next')
    $("a.mainPage").each(function(index,object){
        $(object).parent().removeClass("disabled")
        $(object).parent().removeAttr("disabled")
    })
    $("a.mainPage").each(function(index,object){
        if(index == 0){
            $(object).trigger("click")
        }
    })

}
/* 点击最后一页 */
function lastPageClick(){
    var totalPage = Number($("#totalPage").val()) - 1

    var shang = parseInt(totalPage  / 5)
    var indexClick = totalPage % 5
    var updateNumberValue = shang * 5 + 1
    updatePageNumber(updateNumberValue ,'next')

    $("a.mainPage").each(function (index,object){
        $(object).parent().removeClass("active")
        if(index == indexClick){
            $(object).trigger("click")
            $(object).parent().addClass("active")
        }
    })



}

//  下一页点击处理
function nextPage (){

    var index = -1

    $('a.mainPage').each(function(ind,obj){
        var allClass = $(obj).parent().attr('class')
        if (allClass == 'active'){
            index = ind
        }
    })
    $('a.mainPage').each(function(ind,obj){
        if (index == 5 & ind == 5){
            $(obj).trigger('click')
            return
        }
        if (ind == index + 1  ){
            $(obj).trigger('click')
        }
    })

}

// 上一页的点击处理
function previousPage(){

    var index = -1
    $('a.mainPage').each(function(ind,obj){
        var allClass = $(obj).parent().attr('class')
        if (allClass == 'active'){
            index = ind
        }
    })

    $('a.mainPage').each(function(ind,obj){
        if (index == 0 & ind == 0){
            $(obj).trigger('click')
            return
        }
        if (ind == index -1  ){
            $(obj).trigger('click')
        }
    })
}
//<-------------------------------首页、尾页、下一页、上一页 end ---------------------------------------->
function clickQuery(){
    $("#updateStartNumber").val(1)
    $("#currentPage").val(1)

}
// 初始化，给点击链接添加点击事件
function initialize_pages(){

    console.log("初始化进行当中。。。。")


    // 点击模态不会消失
    $("#myModal").modal({
        backdrop: 'static',
        keyboard: false
    })

    // 点击UPDATEPageNumber监听事件
    $('#totalPage').bind('input propertychange', function() {

        var startNumber = Number($("#updateStartNumber").val())
        var method = String($("#myMethod").val())
        if(method=="none")return
        updatePageNumber(startNumber,method)
    });


    $('#nextPage').click(nextPage)
    $('#previousPage').click(previousPage)

    // AJAX处理请求数据
    $("a.mainPage").each(function (index, obj){
        $(obj).click(function (){

            //  状态更新

            var classString = $(obj).parent().attr("class")
            if(typeof(classString) != "undefined"){
                var classArray = classString.split(" ")
                for(var i = 0; i < classArray.length ; i++){
                    if(classArray[i]=="disabled"){
                        return
                    }
                }
            }

            $(obj).addClass('active')

            //  是否要更新页码
            if(index == 0){

                var requestPage = Number($(obj).text())


                if (requestPage == 1) {

                    $("a.mainPage").each(function(index,obj){
                        $(obj).parent().removeClass("active")
                    })
                    $(obj).parent().addClass("active")
                    $("#currentPage").val(1)
                    // updatePageNumber(1,'next')
                    $("#myModal").modal("show")

                    $("#updateStartNumber").val(1)
                    $("#myMethod").val("next")

                    return
                }
                var updateNumber = String(Number($(obj).text()))
                $("#currentPage").val(updateNumber)
                // updatePageNumber(requestPage - displayPage + 1,'previous')
                $("#myModal").modal("show")
                $("#updateStartNumber").val(requestPage - displayPage + 1)
                $("#myMethod").val("previous")
                return

            }else if(index ==  5){

                var totalPage = Number($("#totalPage").val())
                var requestPage = Number($(obj).text())

                if(requestPage > totalPage){
                    return
                }
                var updateNumber = String(Number($(obj).text()))
                $("#currentPage").val(updateNumber)
                // updatePageNumber(requestPage ,'next')
                $("#myModal").modal("show")
                $("#updateStartNumber").val(requestPage)
                $("#myMethod").val("next")
                return
            }


            $('a.mainPage').each(function(index_element,obj){
                $(obj).parent().removeClass('active')
                if(index_element == index){
                    $(obj).parent().addClass('active')
                }
            })
            var updateNumber = String(Number($(obj).text()))


            $("#currentPage").val(updateNumber)
            $("#myMethod").val("none")
            // 是否需要更新

            $("#myModal").modal("show")

        })
    })


}



