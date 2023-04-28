function Tasks() {
    console.log("In Tasks constructor");
}

$(document).ready(function() {

    $.ajax({
        url: "http://localhost:8101"
    }).then(function(data, status, jqxhr) {
        console.log("Hello from script");
    })
});

Tasks.prototype.initialize = function() {
    console.log("In initialize");
    alert("Initialize");
}

Tasks.prototype.processState = function(obj) {
	var msg = $(obj).val();
	console.log("Message from input box: " + msg)
	
	$("#stateOutId").val(msg);
}

Tasks.prototype.trimZeroes = function(obj) {
	var popval = $(obj).val();
	var count = 0;
	
	for (let i = popval.length - 1; i>=0; i--) {
		if (popval[i] == '0') {
			count = count + 1;
		} else {
			break;
		}
	}
	
	$("#popOutId").val(popval.substring(0, popval.length - count));
}

tasks = new Tasks();
