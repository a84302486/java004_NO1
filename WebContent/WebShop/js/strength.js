	//CharMode函數 
	//測試某個字符是屬於哪一類. 
	function CharMode(iN){ 
	if (iN>=48 && iN <=57) //數字 
	return 1; 
	if (iN>=65 && iN <=90) //大寫字母 
	return 2; 
	if (iN>=97 && iN <=122) //小寫 
	return 4; 
	else 
	return 8; //特殊字符 
	} 
	
	//bitTotal函數 
	//計算出當前密碼當中一共有多少種模式 
	function bitTotal(num){ 
		modes=0; 
		for (i=0;i<4;i++){ 
			if (num & 1){
				modes++;
			} 
			num>>>=1; 
			} 
		return modes; 
	} 
	
	//checkStrong函數 
	//返回密碼的強度級別 
	
	function checkStrong(sPW){ 
		if (sPW.length<=4){
			return 0; //密碼太短 
			}
			Modes=0; 
			for (i=0;i<sPW.length;i++){ 
				//測試每一個字符的類別並統計一共有多少種模式. 
				Modes|=CharMode(sPW.charCodeAt(i)); 
			} 
		
		return bitTotal(Modes); 
	
	} 
	
	//pwStrength函數 
	//當用戶放開鍵盤或密碼輸入框失去焦點時,根據不同的級別顯示不同的級別
	
	function pwStrength(pwd){ 
	if (pwd==null||pwd==''){ 
		var result='';
	} 
	else{ 
		S_level=checkStrong(pwd); 
		switch(S_level) { 
			case 0: 
				var result='密碼強度:危險';
			case 1: 
				var result='密碼強度:普通'; 
				break; 
			case 2: 
				var result='密碼強度:很好'; 
				break; 
			default: 
				var result='密碼強度:安全'; 
		} 
	}
	
	$("#strength").html(result);	
	return; 
	
	}


