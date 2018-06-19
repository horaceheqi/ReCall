function submitModal(obj) {
    var newContents=$("textarea[name=newContent]").val();
    var checkOfRadio=$("input[name=hasSendGiftRadio]:checked").val();
    newContents=String(newContents);
    if(newContents=="")
    {
        return
    }
    else
    {
        if(checkOfRadio==1)
        {
            checkOfRadio=1;
        }
        else
        {
            checkOfRadio=0;
        }
        var newTimes=$("#newDate").val();
        var recordCnmaster="空";
        var newinterposeStatus=1;
        var dates;
        var whichButtonValue = Number($('#whichButtonClick').text());

        $("table > tbody > tr.trSelected").each(function (ind,obj) {
            if (ind == whichButtonValue){

                $(obj).children("td").each(function (indexTD,objectTD) {
                    if(indexTD==4){
                        recordCnmaster=$(objectTD).text();
                    }
                    if(indexTD==7){
                        $(objectTD).text(newTimes);
                    }
                    if(indexTD==8){
                        $(objectTD).text(newinterposeStatus);
                    }
                    if(indexTD==11){
                        $(objectTD).text(checkOfRadio);
                    }
                    if(indexTD==14){
                        $(objectTD).text(newContents);
                    }
                })
            }
        });

        //向后台传输数据
        dates=newTimes;
        var queryString={
            cnmaster:recordCnmaster,
            interposeDate:newTimes,
            dt:dates,
            interposeStatus:newinterposeStatus,
            hasManualSendGift:checkOfRadio,
            visitHistory:newContents
        };
        // var queryString = "cnmaster:" + recordCnmaster  +
        //     "interposeData:" + newTimes  +
        //     "interposeStatus:" + newinterposeStatus  +
        //     "visitHistory:" + newContents;

        queryString=JSON.stringify(queryString);
        //添加请求地址
        $.ajax({
            url:'/ds/update',
            contentType:'application/json;charset=utf-8 ',
            data:queryString,
            dataType:"json",
            method:'post',
            success:function () {
            }
        });
        $.ajax({
            url:'/ds/visitInsert',
            contentType:'application/json;charset=utf-8 ',
            data:queryString,
            dataType:"json",
            method:'post',
            success:function () {
            }
        });
        $("#modal-container-1").modal("hide");

        $("input:radio[name='hasSendGiftRadio']").each(function (index,object) {
            if (index == 1) {
                $(object).prop("checked",true);

            }else{
                $(object).removeAttr("checked")
            }
        })

    }
}


$("#modal-container-1").on("hidden.bs.modal",function(){
    $("input:radio[name='hasSendGiftRadio']").each(function (index,object) {
        if (index == 1) {

            $(object).prop("checked",true);

        }else{
            $(object).removeAttr("checked")
        }
    })

});

function checkVistHistory() {
    var getCnmaster="";
    var whichButtonValue2 = Number($('#whichButtonClick').text());

    $("table > tbody > tr.trSelected").each(function (ind,obj) {
        if (ind == whichButtonValue2){
            $(obj).children("td").each(function (indexTD,objectTD) {
                if(indexTD==4){
                    getCnmaster=$(objectTD).text();
                }
            })
        }
    });
    var queryString={
        cnmaster:getCnmaster
    };
    queryString=JSON.stringify(queryString);
    //processData3();
    $.ajax({
        url:'/ds/visitSelect',
        contentType:'application/json;charset=utf-8 ',
        data:queryString,
        dataType:"json",
        method:'post',
        success:function(data){
            processData3(data)
        }
    });
}

//点击关闭历史回访记录时清空Table
$(function () {
    $("#clearTable").click(function () {
        console.log("........1");
        $("table > tbody > tr.trSelected3 ").each(function (ind,obj) {
            $(obj).children('td').each(function (indTD,objTD) {
                console.log("........2");
                $(objTD).text("");
            })
        })
    });
});

function getNowDate() {
    var today=new Date();
    var date;
    var date=today.getFullYear()+"-";
    var mm=today.getMonth()+1;
    if(today.getMonth()>9){
        date+=mm + "-";
    }else
    {
        str+="0"+mm + "-";
    }if(today.getDate()>9){
        date+=today.getDate();
    }else
    {
        date+="0"+today.getDate();
    }
    return date;
}

function processData2(data) {
    var mapping = {
        '1': 'cnmaster',
        '2': 'roleName',
        '3': 'roleLevel',
        '4': 'roleGroupid',
        '5': 'equipscore',
        '6': 'xfscore',
        '7': 'xlscore',
        '8': 'bsscore',
        '9': 'logonFlag',
        '10': 'cnGuid',
        '11': 'dt'
    };


    $("#show_Detail tr:not(:first)").empty();
    var jsonData=data;
    var sourceData=jsonData.accountsData;
    var length=sourceData.length;
    if(jsonData!=0)
    {
        for(var i=length-1;i>=0;i--)
        {
            var tableLength=$("#show_Detail").length;
            var row=show_Detail.insertRow(tableLength);
            var col=row.insertCell(0);
            var cnamster_0=sourceData[i].cnmaster;
            if(sourceData[i].logonFlag == 1)
            {
                $(col).css("color","red");
            }
            col.innerHTML=cnamster_0;
            var col=row.insertCell(1);
            var roleName_1=sourceData[i].roleName;
            if(sourceData[i].logonFlag == 1)
            {
                $(col).css("color","red");
            }
            col.innerHTML=roleName_1;
            var col=row.insertCell(2);
            var roleLevel_2=sourceData[i].roleLevel;
            if(sourceData[i].logonFlag == 1)
            {
                $(col).css("color","red");
            }
            col.innerHTML=roleLevel_2;
            var col=row.insertCell(3);
            var roleGroupid_3=sourceData[i].roleGroupid;
            if(sourceData[i].logonFlag == 1)
            {
                $(col).css("color","red");
            }
            col.innerHTML=roleGroupid_3;
            var col=row.insertCell(4);
            var equipscore_4=sourceData[i].equipscore;
            if(sourceData[i].logonFlag == 1)
            {
                $(col).css("color","red");
            }
            col.innerHTML=equipscore_4;
            // var col=row.insertCell(4);
            // var xfscore_4=sourceData[i].xfscore;
            // if(sourceData[i].logonFlag == 1)
            // {
            //     $(col).css("color","red");
            // }
            // col.innerHTML=xfscore_4;
            // var col=row.insertCell(5);
            // var xlscore_5=sourceData[i].xlscore;
            // if(sourceData[i].logonFlag == 1)
            // {
            //     $(col).css("color","red");
            // }
            // col.innerHTML=xlscore_5;
            // var col=row.insertCell(6);
            // var bsscore_6=sourceData[i].bsscore;
            // if(sourceData[i].logonFlag == 1)
            // {
            //     $(col).css("color","red");
            // }
            // col.innerHTML=bsscore_6;
            var col=row.insertCell(5);
            var logonFlag_7=sourceData[i].logonFlag;
            if(sourceData[i].logonFlag == 1)
            {
                $(col).css("color","red");
            }
            col.innerHTML=logonFlag_7;
            var col=row.insertCell(6);
            var cnGuid_8=sourceData[i].cnGuid;
            if(logonFlag_7 == 1)
            {
                $(col).css("color","red");
            }
            col.innerHTML=cnGuid_8;

        }
    }


    // //数据长度，用来影藏空单元
    // $('table.sentPackgeClass > tbody > tr.trSelected2').each(function (ind,obj) {
    //
    //     $(obj).addClass("hidden");
    // })
    //
    // $('table.sentPackgeClass > tbody > tr.trSelected2').each(function (ind, obj) {
    //
    //     var tempData = sourceData[ind];
    //     if (ind > length - 1) {
    //         return
    //     }
    //     $(obj).removeClass("hidden");
    //     $(obj).children('td').each(function (indTD, objecTD) {
    //         var key=String(indTD + 1);
    //         var value=mapping[key];
    //         key=Number(key);
    //         var content='unknow';
    //         if((value in tempData) & (key<=5)){
    //             content = tempData[value];
    //         }
    //
    //         else
    //         {
    //             return
    //         }
    //
    //         $(objecTD).text(content);
    //     });
    //
    // });
}

function processData3(data) {
    var mapping = {
        '1': 'dt',
        '2': 'visitHistory'
    }

    $("#visitHistory1 tr:not(:first)").empty();
    var jsonData=data;
    var sourceData=jsonData.visitData;
    var length=sourceData.length;
    if(jsonData!=0)
    {
        for(var i=length-1;i>=0;i--)
        {
            var tableLength=$("#visitHistory1").length;
            var row=visitHistory1.insertRow(tableLength);
            var col=row.insertCell(0);
            var dates=sourceData[i].dt;
            col.innerHTML=dates;
            var col=row.insertCell(1);
            var visited=sourceData[i].visitHistory;
            col.innerHTML=visited;
        }
    }

    // //数据长度，用来影藏空单元
    // $('table.vistHistory > tbody > tr.trSelected3').each(function (ind,obj) {
    //     $(obj).addClass("hidden");
    // });
    //
    // // var jsonData=JSON.parse(data);
    // // var sourceData=jsonData.data;
    // var jsonData = data;
    // var sourceData = jsonData.visitData;
    // var length = sourceData.length;
    // $('table.vistHistory > tbody > tr.trSelected3').each(function (ind,obj) {
    //     var tempData = sourceData[ind];
    //     if (ind > length - 1) {
    //         return
    //     }
    //     $(obj).removeClass("hidden");
    //     $(obj).children('td').each(function (indTD, objecTD){
    //         var key=String(indTD + 1);
    //         var value=mapping[key];
    //         key=Number(key);
    //         var content='unknow';
    //         if(value in tempData){
    //             content = tempData[value];
    //         }
    //         $(objecTD).text(content);
    //     });
    // });
}


function initialize_button() {
    setInterval(function () {
        $("#newDate").val(getNowDate());
    },1000);

    //监听回访记录按钮
    $("input.visitHistory").each(function(ind, obj){
        console.log("hello click bind")
        $(obj).click(function(object){
            console.log("hello click bind enter inner")
            var updateDate = "无";
            var updateContents = "无";
            $("table > tbody > tr.trSelected").each(function(indTr,objTR){

                if(ind == indTr ) {
                    $(objTR).children('td').each(function (indexTD, objectTD) {
                        if(indexTD == 7){
                            updateDate = $(objectTD).text().trim();
                        }
                        if(indexTD == 14){
                            updateContents = $(objectTD).text().trim();
                        }
                    })
                }
            });

            $("#lastDate").val(updateDate);
            $("textarea.lastContent").val(updateContents);
            $("#whichButtonClick").text(ind)
            $("#radio_2").attr("checked");
        });
    });


    $("td.show_me").each(function(index,object){
        console.log("start triger td click..")
        $(object).click(function(){
            $("#modal-container-2").modal("show")
            getCnmasters=$(object).text();
            var queryString={
                cnmaster:getCnmasters
            }

            queryString=JSON.stringify(queryString)
            $.ajax({
                url:'/ds/recallCn',
                contentType:'application/json;charset=utf-8 ',
                data:queryString,
                dataType:"json",
                method:'post',
                success:function(data){
                    processData2(data)
                }
            });
        })
    })

}


// window.onload=function () {
//     setInterval(function () {
//         $("#newDate").val(getNowDate());
//     },1000);
//
//     //监听回访记录按钮
//     $("input.visitHistory").each(function(ind, obj){
//         console.log("hello click bind")
//         $(obj).click(function(object){
//             console.log("hello click bind enter inner")
//             var updateDate = "无";
//             var updateContents = "无";
//             $("table > tbody > tr.trSelected").each(function(indTr,objTR){
//
//                 if(ind == indTr ) {
//                     $(objTR).children('td').each(function (indexTD, objectTD) {
//                         if(indexTD == 7){
//                             updateDate = $(objectTD).text().trim();
//                         }
//                         if(indexTD == 14){
//                             updateContents = $(objectTD).text().trim();
//                         }
//                     })
//                 }
//             });
//
//             $("#lastDate").val(updateDate);
//             $("textarea.lastContent").val(updateContents);
//             $("#whichButtonClick").text(ind)
//             $("#radio_2").attr("checked");
//         });
//     });
    
    //监听发送礼包按钮
    // $("input.operation").each(function (ind,obj) {
    //     $(obj).click(function (object) {
    //         var getCnmaster="";
    //         $("table > tbody > tr.trSelected").each(function (indTr,objTR) {
    //             if(ind==indTr){
    //                 $(objTR).children('td').each(function (indexTd,objectTD) {
    //                     if(indexTd==4){
    //                         getCnmaster=$(objectTD).text();
    //                     }
    //                 })
    //             }
    //         });
    //         var queryString = {
    //             cnmaster:getCnmaster
    //         };
    //         queryString=JSON.stringify(queryString);
    //         //processData2();
    //         $.ajax({
    //             url:'/ds/recallCn',
    //             contentType:'application/json;charset=utf-8 ',
    //             data:queryString,
    //             dataType:"json",
    //             method:'post',
    //             success:function(data){
    //                 processData2(data)
    //             }
    //         });
    //     });
    // });
// };