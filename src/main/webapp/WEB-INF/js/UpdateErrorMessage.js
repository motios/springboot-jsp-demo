//var endOfLine="%0D%0A"
//var searchStr="+"
//var replaceStr=" "
String.prototype.replaceAll = function(search, replacement) {
    var target = this;
    return target.split(search).join(replacement);
};
function showAlert() {
    var str = "?responseMessage="
    var url = window.location.href
    if(url.indexOf(str)>-1 && url.length > url.indexOf(str)+str.length){
        var messageStr= url.substring(url.indexOf(str)+str.length);
        messageStr = messageStr.replaceAll("+"," ");
        messageStr = messageStr.replaceAll("%0D%0A","");
        alert(messageStr);
    }
}