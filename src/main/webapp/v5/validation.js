function validateUsername() {
	var username = document.getElementById("user").value;
	if (isEmpty(username)) {
		document.getElementById("error_user").innerHTML = "  �û�������Ϊ�գ�";
	} else {
		loadXMLDoc("user");
	}
}

function validateNull4Username() {
	var username = document.getElementById("user").value;
	if (isEmpty(username)) {
		document.getElementById("error_user").innerHTML = "  �û�������Ϊ�գ�";
		return false;
	}
	return true;
}

function loadXMLDoc(fieldId) {
	var filedValue = document.getElementById(fieldId).value;
	var xmlhttp = new XMLHttpRequest();
	
	xmlhttp.onreadystatechange = function() {
		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
			document.getElementById("error_" + fieldId).innerHTML = xmlhttp.responseText;
		}
	}
	xmlhttp.open("POST", "userparamcheck.do", true);
	// POST��ʱ��������������
	xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xmlhttp.send(fieldId + "=" + filedValue);
}

function validatePassword() {
	var password = document.getElementById("password").value;
	if (isEmpty(password)) {
		document.getElementById("error_password").innerHTML = "  ���벻��Ϊ�գ�";
	} else {
		loadXMLDoc("password");
	}
}

function validateNull4Password() {
	var password = document.getElementById("password").value;
	if (isEmpty(password)) {
		document.getElementById("error_password").innerHTML = "  ���벻��Ϊ�գ�";
		return false;
	}
	return true;
}

function validateEmail() {
	var email = document.getElementById("email").value;
	var reg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
	if (reg.test(email)) {
		document.getElementById("error_email").innerHTML = "OK";
	} else {
		document.getElementById("error_email").innerHTML = "Email���Ϸ���";
	}
}

function validateMobile() {
	var mobile = document.getElementById("mobile").value;
	if (mobile.length != 11) {
		document.getElementById("error_mobile").innerHTML = "�ֻ��Ų��Ϸ���";
	}

	var reg = /^1[3|4|5|8][0-9]\d{4,8}$/;
	if (reg.test(mobile)) {
		document.getElementById("error_mobile").innerHTML = "OK";
	} else {
		document.getElementById("error_mobile").innerHTML = "�ֻ��Ų��Ϸ���";
	}
}

function validateForm() {
	validateUsername();
	validatePassword();
	validateEmail();
	validateMobile();
	
	var username = document.getElementById("error_user").innerHTML;
	var password = document.getElementById("error_password").innerHTML;
	var email = document.getElementById("error_email").innerHTML;
	var mobile = document.getElementById("error_mobile").innerHTML;
	return (username == "OK") && (password == "OK") && (email == "OK") && (mobile == "OK");
}

function validateNull4Form() {
	return validateNull4Username() && validateNull4Password();
}

function isEmpty(value) {
	return value == null || value == "";
}