function doFirst(){
	 document.getElementById("theForm").onsubmit=setEvent;	
	 //submit時,執行function calculate
	 //window.onload=load("Load!!!");
	 load("Load!!!");
}
function setEvent(){
	var events = ['click','select','contextmenu','resize','scroll'];
	for(var i=0;i<events.length;i++){
		var checkEvent = document.getElementById(events[i]);
		if(checkEvent.checked){
			window.addEventListener(events[i],report,false);
		}else{
			window.removeEventListener(events[i],report,false);
		}
	}
	
	document.getElementById('output').value = '';
	
	return false;
}
function load(data){
	alert(data);
}
function report(e){
//	alert(e.target.nodeName+' / '+e.type);
	var message = e.target.nodeName+' : '+e.type + '\n';
	document.getElementById('output').value += message;
}

window.addEventListener('load',doFirst,false);