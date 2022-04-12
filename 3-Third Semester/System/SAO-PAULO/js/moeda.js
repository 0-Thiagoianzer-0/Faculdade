function getMoney(str){
	return parseInt( str.replace(/[\D]+/g,'') );
}

function getFinalMoney(str){
	var Numero = parseInt( str.replace(/[\D]+/g,'') );
	Numero = Numero / 100;
	return Numero;
}
function formatReal(int){
	var tmp = int+'';
	tmp = tmp+'';
	tmp = tmp.replace(/([0-9]{2})$/g, ",$1");
	if( tmp.length == 1 ){
		tmp = "0,0"+tmp;
	}
	if( tmp.length == 3 && tmp != "NaN" ){
		tmp = "0"+tmp;
	}
	if( tmp.length > 6 ){
		tmp = tmp.replace(/([0-9]{3}),([0-9]{2}$)/g, ".$1,$2");
	}
	if( tmp.length > 10 ){
		tmp = tmp.replace(/([0-9]{3}).([0-9]{3}),([0-9]{2})$/g,'.$1.$2,$3');
	}
	if( tmp.length > 14 ){
		tmp = tmp.replace(/([0-9]{3}).([0-9]{3}).([0-9]{3}),([0-9]{2})$/g,'.$1.$2.$3,$4');
	}
	if(tmp == "NaN"){
		tmp = "";
	}
	return tmp;
}