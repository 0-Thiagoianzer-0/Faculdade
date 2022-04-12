function valida_ie(ie){
	estado = document.getElementById('cmbEstado').value;
	ie = ie.replace(/[^0-9]/g,'');
	
	switch(estado){
		//ACRE
		case "AC":
			if(ie.length != 13)
				return false;
			var b = 4, soma = 0;
			for(var i=0; i<=10; i++){
				soma += parseInt(ie.charAt(i)) * b;
				--b;
				if(b == 1)
					b = 9;
			}
			dig = 11 - (soma % 11);
			if(dig >= 10)
				dig = 0;
			if(dig != parseInt(ie.charAt(11)))
				return false;
			b = 5;
			soma = 0;
			for(var i=0; i<=11; i++){
				soma += parseInt(ie.charAt(i)) * b;
				--b;
				if(b == 1)
					b = 9;
			}
			dig = 11 - (soma % 11);
			if (dig >= 10)
				dig = 0;
			return(dig == parseInt(ie.charAt(12)));
		break;
		
		//ALAGOAS
		case "AL":
			if(ie.length != 9)
				return false;
			var b = 9, soma = 0;
			for(var i=0; i<=7; i++){
				soma += parseInt(ie.charAt(i)) * b;
				--b;
			}
			soma *= 10;
			dig = soma - (Math.floor(soma / 11) * 11);
			if(dig == 10) 
				dig = 0;
			return(dig == parseInt(ie.charAt(8)));
		break;
		
		//AMAPÁ
		case "AP":
			if(ie.length != 9)
				return false;
			if(ie.substring(0,2) != "03")
				return false;
			var p = 0, d = 0, i = ie.substring(1,8);
			if((i >= 3000001) && (i <= 3017000)){
				p =5;
				d = 0;
			}else if((i >= 3017001) && (i <= 3019022)){
				p = 9;
				d = 1;
			}
			b = 9;
			soma = p;
			for(var i=0; i<=7; i++){
				soma += parseInt(ie.charAt(i)) * b;
				b--;
			}
			dig = 11 - (soma % 11);
			if(dig == 10){
				dig = 0;
			}else if(dig == 11){
				dig = d;
			}
			return (dig == parseInt(ie.charAt(8)));
		break;
		
		//AMAZONAS
		case "AM":
			if(ie.length != 9)
				return false;
			var b = 9, soma = 0;
			for(var i=0; i<=7; i++){
				soma += parseInt(ie.charAt(i)) * b;
				b--;
			}
			if(soma < 11){
				dig = 11 - soma;
			}else{
				i = soma % 11;
				if (i <= 1){
					dig = 0;
				}else{
					dig = 11 - i;
				}
			}
			return(dig == parseInt(ie.charAt(8)));
		break;
		
		//BAHIA
		case "BA":
			if(ie.length == 8){
				die = ie.substring(0, 8);
				var nro = new Array(8);
				var dig = -1;
				for(var i=0; i<=7; i++)
					nro[i] = parseInt(die.charAt(i));
				var NumMod = 0;
				if(String(nro[0]).match(/[0123458]/)){
					NumMod = 10;
				}else{
					NumMod = 11;
				}
				b = 7;
				soma = 0;
				for(i=0; i<=5; i++){
					soma += nro[i] * b;
					b--;
				}
				i = soma % NumMod;
				if(NumMod == 10){
					if(i == 0){ 
						dig = 0;
					}else{
						dig = NumMod - i;
					}
				}else{
					if(i <= 1){
						dig = 0;
					}else{
						dig = NumMod - i;
					}
				}
				resultado = (dig == nro[7]);
				if(!resultado)
					return false;
				b = 8;
				soma = 0;
				for (i=0; i<=5; i++){
					soma += nro[i] * b;
					b--;
				}
				soma += nro[7] * 2;
				i = soma % NumMod;
				if(NumMod == 10){
					if(i == 0){
						dig = 0;
					}else{
						dig = NumMod - i;
					}
				}else{
					if(i <= 1){
						dig = 0;
					}else{
						dig = NumMod - i;
					}
				}
				return (dig == nro[6]);
			}
			if(ie.length == 9){
				die = ie.substring(0, 9);
				var nro = new Array(9);
				var dig = -1;
				for(var i=0; i<=8; i++)
					nro[i] = parseInt(die.charAt(i));
				var NumMod = 0;
				if(String(nro[0]).match(/[0123458]/)){
					NumMod = 10;
				}else{
					NumMod = 11;
				}
				b = 8;
				soma = 0;
				for(i=0; i<=6; i++){
					soma += nro[i] * b;
					b--;
				}
				i = soma % NumMod;
				if(NumMod == 10){
					if(i == 0){
						dig = 0;
					}else{
						dig = NumMod - i;
					}
				}else{
					if(i <= 1){
						dig = 0;
					}else{
						dig = NumMod - i;
					}
				}
				resultado = (dig == nro[8]);
				if(!resultado)
					return false;
				b = 9;
				soma = 0;
				for (i=0; i<=6; i++){
					soma += nro[i] * b;
					b--;
				}
				soma += nro[8] * 2;
				i = soma % NumMod;
				if(NumMod == 10){
					if(i == 0){
						dig = 0;
					}else{
						dig = NumMod - i;
					}
				}else{
					if(i <= 1){
						dig = 0;
					}else{
						dig = NumMod - i;
					}
				}
				return (dig == nro[7]);
			}
			return false;
		break;

		//CEARÁ
		case "CE":
			if(ie.length != 9)
				return false;
			die = ie;
			var nro = Array(9);
			for(var i=0; i<=8; i++)
				nro[i] = parseInt(die[i]);
			b = 9;
			soma = 0;
			for(i=0; i<=7; i++){
				soma += nro[i] * b;
				b--;
			}
			dig = 11 - (soma % 11);
			if (dig >= 10)
				dig = 0;
			return (dig == nro[8]);
		break;
		
		//DISTRITO FEDERAL
		case "DF":
			if(ie.length != 13)
				return false;
			var nro = new Array(13);
			for(var i=0; i<=12; i++)
				nro[i] = parseInt(ie.charAt(i));
			b = 4;
			soma = 0;
			for(i=0; i<=10; i++){
				soma += nro[i] * b;
				b--;
				if(b == 1)
					b = 9;
			}
			dig = 11 - (soma % 11);
			if(dig >= 10)
				dig = 0;
			if(dig != nro[11])
				return false;  
			b = 5;
			soma = 0;
			for(i=0; i<=11; i++){
				soma += nro[ i ] * b;
				b--;
				if(b == 1)
					b = 9;
			}
			dig = 11 - (soma % 11);
			if(dig >= 10)
				dig = 0;
			return(dig == nro[12]);
		break;

		//ESPÍRITO SANTO
		case "ES":
			if(ie.length != 9)
				return false;
			var nro = new Array(9);
			for(var i=0; i<=8; i++)
				nro[i] = parseInt(ie.charAt(i));
			b = 9;
			soma = 0;
			for(i=0; i<=7; i++){
				soma += nro[i] * b;
				b--;
			}
			i = soma % 11;
			if(i < 2){
				dig = 0;
			}else{
				dig = 11 - i;
			}
			return(dig == nro[8]);
		break;
		
		//GOIÁS
		case "GO":
			if(ie.length != 9)
				return false;
			s = ie.substring(0, 2);
			if((s == '10') || (s == '11') || (s == '15')){
				var nro = new Array(9);
				for(var i=0; i<=8; i++)
					nro[i] = parseInt(ie.charAt(i));
					n = parseInt(ie.substring(0, 7));
				if(n = 11094402){
					if((nro[8] == 0) || (nro[8] == 1))
						return true;
				}
				b = 9;
				soma = 0;
				for (i=0; i<=7; i++){
					soma += nro[i] * b;
					b--;
				}
				i = soma % 11;
				if(i == 0)
					dig = 0;
				else{
					if (i == 1){
						if((n >= 10103105) && (n <= 10119997))
							dig = 1;
						else
							dig = 0;
					}else
						dig = 11 - i;
				}
				return (dig == nro[8]);
			}
			return false;
		break;
		
		//MARANHÃO
		case "MA":
			if(ie.length != 9)
				return false;
			if( ie.substring(0, 2) != "12" )
				return false;
			var nro = new Array(9);
			for(var i=0; i<=8; i++)
				nro[i] = parseInt(ie.charAt(i));
			b = 9;
			soma = 0;
			for(i=0; i<=7; i++){
				soma += nro[i] * b;
				b--;
			}
			i = soma % 11;
			if(i <= 1) { dig = 0; } else { dig = 11 - i; }
				return (dig == nro[8]);
		break;
		
		//MINAS GERAIS
		case "MG":
			if(ie.length != 13)
				return false;
			dig1 = ie.substring(11, 12);
			dig2 = ie.substring(12, 13);
			inscC = ie.substring(0, 3) + '0' + ie.substring(3, 11);
			insc = inscC.split('');
			npos = 11;
			i = 1;
			ptotal = 0;
			psoma = 0;
			while(npos >= 0){
				i++;
				psoma = parseInt(insc[npos]) * i;
				if(psoma >= 10)
					psoma -= 9;
					ptotal += psoma;
				if(i == 2)
					i = 0;
					npos--;
			}
			nresto = ptotal % 10;
			if(nresto == 0)
				nresto = 10;
				nresto = 10 - nresto;
			if(nresto != parseInt(dig1))
				return false;
			npos = 11;
			i = 1;
			ptotal = 0;
			is=ie.split('');
			while(npos >= 0){
				i++;
				if(i == 12)
					i = 2;
					ptotal += parseInt(is[npos]) * i;
				npos--;
			}
			nresto = ptotal % 11;
			if((nresto == 0) || (nresto == 1))
				nresto = 11;
				nresto = 11 - nresto;  
			return (nresto == parseInt(dig2));
		break;
		
		//MATO GROSSO
		case "MT":
			if(ie.length != 11)
				return false;
			die = ie;
			var nro = new Array(11);
			for(var i=0; i<=10; i++)
				nro[i] = parseInt(die[i]);
			b = 3;
			soma = 0;
			for(i=0; i<=9; i++){
				soma += nro[i] * b;
				b--;
				if(b == 1)
					b = 9;
			}
			i = soma % 11;
			if(i <= 1){
				dig = 0;
			}else{
				dig = 11 - i;
			}
			return (dig == nro[10]);
		break;
		
		//MATO GROSSO DO SUL
		case "MS":
			if(ie.length != 9)
				return false;
			if(ie.substring(0,2) != "28")
				return false;
			var nro = new Array(9);
			for(var i=0; i<=8; i++)
				nro[i] = parseInt(ie.charAt(i));
			b = 9;
			soma = 0;
			for(i=0; i<=7; i++){
				soma += nro[i] * b;
				b--;
			}
			i = soma % 11;
			if(i <= 1){
				dig = 0;
			}else{
				dig = 11 - i;
			}
			return (dig == nro[8]);
		break;
		
		//PARÁ
		case "PA":
			if(ie.length != 9)
				return false;
			if(ie.substring(0, 2) != '15')
				return false;
			var nro = new Array(9);
			for(var i=0; i<=8; i++)
			nro[i] = parseInt(ie.charAt(i));
			b = 9;
			soma = 0;
			for(i=0; i<=7; i++){
				soma += nro[i] * b;
				b--;
			}
			i = soma % 11;
			if(i <= 1)
				dig = 0;
			else
				dig = 11 - i;
			return (dig == nro[8]);
		break;
		
		//PARAÍBA
		case "PB":
			if(ie.length != 9)
				return false;
			var nro = new Array(9);
			for(var i=0; i<=8; i++)
				nro[i] = parseInt(ie.charAt(i));
			b = 9;
			soma = 0;
			for(i=0; i<=7; i++){
				soma += nro[i] * b;
				b--;  
			}
			i = soma % 11;
			if(i <= 1)
				dig = 0;
			else
				dig = 11 - i;
			return (dig == nro[8]);
		break;
		
		//PARANÁ
		case "PR":
			if(ie.length != 10)
				return false;
			var nro = new Array(10);
			for(var i=0; i<=9; i++)
				nro[i] = parseInt(ie.charAt(i));
			b = 3;
			soma = 0;
			for(i=0; i<=7; i++){
				soma += nro[i] * b;
				b--;
				if(b == 1)
					b = 7;
			}
			i = soma % 11;
			if(i <= 1)
				dig = 0;
			else
				dig = 11 - i;
			if(dig != nro[8])
				return false;
			b = 4;
			soma = 0;
			for(i=0; i<=8; i++){
				soma += nro[i] * b;
				b--;
				if(b == 1)
					b = 7;
			}
			i = soma % 11;
			if(i <= 1)
				dig = 0;
			else
				dig = 11 - i;
			return (dig == nro[9]);
		break;
		
		//PERNAMBUCO
		case "PE":
			if(ie.length == 14){
				var nro = new Array(14);
				for(var i=0; i<=13; i++)
					nro[i] = parseInt(ie.charAt(i));
				b = 5;
				soma = 0;
				for(i=0; i<=12; i++){
					soma += nro[i] * b;
					b--;
					if(b == 0)
						b = 9;
				}
				dig = 11 - (soma % 11);
				if(dig > 9)
					dig = dig - 10;
				return (dig == nro[13]);
			}
			if(ie.length == 9){ 
				var nro = new Array(9);
				for(var i=0; i<=8; i++)
					nro[i] = parseInt(ie.charAt(i));
				b = 8;
				soma = 0;
				for(i=0; i<=6; i++){
					soma += nro[i] * b;
					b--;
				}
				i = soma % 11;
				if(i <= 1){
					dig = 0;
				}else{
					dig = 11 - i;
				}
				if(dig != nro[7])
					return false;
				b = 9;
				soma = 0;
				for(i=0; i<=7; i++){
					soma += nro[i] * b;
					b--;
				}
				i = soma % 11;
				if(i <= 1){
					dig = 0;
				}else{
					dig = 11 - i;
				}
				return (dig == nro[8]);
			}
			return false;
		break;
		
		//PIAUÍ
		case "PI":   
			if(ie.length != 9)
				return false;
			var nro = new Array(9);
			for(var i=0; i<=8; i++)
				nro[i] = parseInt(ie.charAt(i));
			b = 9;
			soma = 0;
			for(i=0; i<=7; i++){
				soma += nro[i] * b;
				b--;
			}
			i = soma % 11;
			if(i <= 1){
				dig = 0;
			}else{
				dig = 11 - i;
			}
			return (dig == nro[8]);
		break;
		
		//RIO DE JANEIRO
		case "RJ":
			if(ie.length != 8)
				return false;
			var nro = new Array(8);
			for(var i=0; i<=7; i++)
				nro[i] = parseInt(ie.charAt(i));
			b = 2;
			soma = 0;
			for(i=0; i<=6; i++){
				soma += nro[i] * b;
				b--;
				if (b == 1)
					b = 7;
			}
			i = soma % 11;
			if(i <= 1){
				dig = 0;
			}else{
				dig = 11 - i;
			}
			return (dig == nro[7]);
		break;
		
		//RIO GRANDE DO NORTE
		case "RN":
			if(ie.substring(0, 2) != '20')
				return false;
			if(ie.length == 9){
				var nro = new Array(9);
				for(var i=0; i<=8; i++)
					nro[i] = parseInt(ie.charAt(i));
				b = 9;
				soma = 0;
				for(i=0; i<=7; i++){
					soma += nro[i] * b;
					b--;
				}
				soma *= 10;
				dig = soma % 11;
				if(dig == 10)
					dig = 0;
				return (dig == nro[8]);
			}
			if(ie.length == 10){
				var nro = new Array(10);
				for(var i=0; i<=9; i++)
					nro[i] = parseInt(ie.charAt(i));
				b = 10;
				soma = 0;
				for(i=0; i<=8; i++){
					soma += nro[i] * b;
					b--;
				}
				soma *= 10;
				dig = soma % 11;
				if(dig == 10)
					dig = 0;
				return (dig == nro[9]);
			}
			return false;
		break;
		
		//RIO GRANDE DO SUL
		case "RS":
			if(ie.length != 10)
				return false;
			var nro = new Array(10);
			for(var i=0; i<=9; i++)
				nro[i] = parseInt(ie.charAt(i));
			b = 2;
			soma = 0;
			for(i=0; i<=8; i++){
				soma += nro[i] * b;
				b--;
				if (b == 1)
					b = 9;
			}
			dig = 11 - (soma % 11);
			if(dig >= 10)
				dig = 0;
			return (dig == nro[9]);
		break;
		
		//RONDÔNIA
		case "RO":
			if(ie.length != 14)
				return false;
			var nro = new Array(14);
			b=6;
			soma=0;
			for(var i=0; i <= 12; i++){
				nro[i] = parseInt(ie.charAt(i));
				soma += nro[i] * b;
				b--;
				if (b == 1)
					b = 9;
			}
			dig = 11 - ( soma % 11);
			if(dig >= 10)
				dig = dig - 10;
			return (dig == parseInt(ie.charAt(13)));
		break;
		
		//RORAIMA
		case "RR":
			if(ie.length != 9)
				return false;
			if(ie.substring(0,2) != "24")
				return false;
			var nro = new Array(9);
			for(var i=0; i<=8; i++)
				nro[i] = parseInt(ie.charAt(i));
			var soma = 0;
			var n = 0;
			for(i=0; i<=7; i++)
				soma += nro[ i ] * ++n;
				dig = soma % 9;
			return (dig == nro[8]);
		break;
		
		//SANTA CATARINA
		case "SC":
			if(ie.length != 9)
				return false;
			var nro = new Array(9);
			for(var i=0; i<=8; i++)
				nro[i] = parseInt(ie.charAt(i));
			b = 9;
			soma = 0;
			for(i=0; i<=7; i++){
				soma += nro[i] * b;
				b--;
			}
			i = soma % 11;
			if(i <= 1)
				dig = 0;
			else
				dig = 11 - i;
			return (dig == nro[8]);
		break;
		
		//SÃO PAULO
		case "SP":
			if(ie.length != 12)
				return false;
			var nro = new Array(12);
			for(var i=0; i<=11; i++)
				nro[i] = parseInt(ie.charAt(i));
			soma = (nro[0] * 1) + (nro[1] * 3) + (nro[2] * 4) + (nro[3] * 5) + (nro[4] * 6) + (nro[5] * 7) + (nro[6] * 8) + (nro[7] * 10);
			dig = soma % 11;
			if(dig >= 10)
				dig = 0;
			if(dig != nro[8])
				return false;
			soma = (nro[0] * 3) + (nro[1] * 2) + (nro[2] * 10) + (nro[3] * 9) + (nro[4] * 8) + (nro[5] * 7) + (nro[6] * 6)  + (nro[7] * 5) + (nro[8] * 4) + (nro[9] * 3) + (nro[10] * 2);
			dig = soma % 11;
			if(dig >= 10)
				dig = 0;
			return (dig == nro[11]);
		break;
		
		//SERGIPE
		case "SE":
			if(ie.length != 9)
				return false;
			var nro = new Array(9);
			for(var i=0; i<=8; i++)
				nro[i] = parseInt(ie.charAt(i));
			b = 9;
			soma = 0;
			for(i=0; i<=7; i++){
				soma += nro[i] * b;
				b--;
			}
			dig = 11 - (soma % 11);
			if(dig >= 10)
				dig = 0;
			return (dig == nro[8]);
		break;
		
		//TOCANTINS
		case "TO":
			if(ie.length != 11)
				return false;
			s = ie.substring(2,4);
			if((s != "01") && (s != "02") && (s != "03") && (s != "99")) 
				return false;
			var nro = new Array(11);
			b=9;
			soma=0;
			for(var i=0; i<=9; i++){
				nro[i] = parseInt(ie.charAt(i));
				if( i != 2 && i != 3){
					soma += nro[i] * b;
					b--;
				}
			}
			resto = soma % 11;
			if( resto < 2 ){
				dig = 0;
			}else{
				dig = 11 - resto;
			}
			return (dig == parseInt(ie.charAt(10)));
		break;
		
		//DEFAULT
		default:
			return false;		
	}
}

function fMasc(objeto,mascara){
	obj=objeto
    masc=mascara
    setTimeout("fMascEx()",1);
}

function fMascEx() {
    obj.value=masc(obj.value)
}

function mIE(ie){
	estado = document.getElementById('cmbEstado').value;
	switch(estado){
		//ACRE
		case "AC":
			// **.***.***/***-** 17
			ie = ie.replace(/^(\d{2})(\d)/, "$1.$2")
			ie = ie.replace(/^(\d{2})\.(\d{3})(\d)/, "$1.$2.$3")
			ie = ie.replace(/\.(\d{3})(\d)/, ".$1/$2")
			ie = ie.replace(/(\d{3})(\d)/, "$1-$2")
			return ie
		break;
		
		//ALAGOAS
		case "AL":
			// ********* 9
			ie = ie.replace(/\D/g,"")
			return ie
		break;
		
		//AMAPÁ
		case "AP":
			// ********* 9
			ie = ie.replace(/\D/g,"")
			return ie
		break;
		
		//AMAZONAS
		case "AM":
			// **.***.***-* 12
			ie = ie.replace(/\D/g,"")
			ie = ie.replace(/(\d{2})(\d)/,"$1.$2")
			ie = ie.replace(/(\d{3})(\d)/,"$1.$2")
			ie = ie.replace(/(\d{3})(\d{1,1})$/,"$1-$2")
			return ie
		break;
		
		//BAHIA
		case "BA":
			// ******-** 9
			ie = ie.replace(/\D/g,"")
			ie = ie.replace(/(\d{6})(\d{1,2})$/,"$1-$2")
			return ie
		break;
		
		//CEARÁ
		case "CE":
			// ********-* 10
			ie = ie.replace(/\D/g,"")
			ie = ie.replace(/(\d{8})(\d{1,1})$/,"$1-$2")
			return ie
		break;
		
		//DISTRITO FEDERAL
		case "DF":
			// ***********-** 14
			ie = ie.replace(/\D/g,"")
			ie = ie.replace(/(\d{11})(\d{1,2})$/,"$1-$2")
			return ie
		break;
		
		//ESPÍRITO SANTO
		case "ES":
			// ********* 9
			ie = ie.replace(/\D/g,"")
			return ie
		break;
		
		//GOIÁS
		case "GO":
			// **.***.***-* 12
			ie = ie.replace(/\D/g,"")
			ie = ie.replace(/(\d{2})(\d)/,"$1.$2")
			ie = ie.replace(/(\d{3})(\d)/,"$1.$2")
			ie = ie.replace(/(\d{3})(\d{1,1})$/,"$1-$2")
			return ie
		break;
		
		//MARANHÃO
		case "MA":
			// ********* 9
			ie = ie.replace(/\D/g,"")
			return ie
		break;
		
		//MINAS GERAIS
		case "MG":
			// ***.***.***-**** 16
			ie = ie.replace(/\D/g,"")
			ie = ie.replace(/(\d{3})(\d)/,"$1.$2")
			ie = ie.replace(/(\d{3})(\d)/,"$1.$2")
			ie = ie.replace(/(\d{3})(\d{1,4})$/,"$1-$2")
			return ie
		break;
		
		//MATO GROSSO
		case "MT":
			// **********-* 12
			ie = ie.replace(/\D/g,"")
			ie = ie.replace(/(\d{10})(\d{1,1})$/,"$1-$2")
			return ie
		break;
		
		//MATO GROSSO DO SUL
		case "MS":
			// ********* 9
			ie = ie.replace(/\D/g,"")
			return ie
		break;
		
		//PARÁ
		case "PA":
			// **-******-* 11
			ie = ie.replace(/\D/g,"")
			ie = ie.replace(/(\d{2})(\d)/,"$1-$2")
			ie = ie.replace(/(\d{6})(\d{1,1})$/,"$1-$2")
			return ie
		break;
		
		//PARAÍBA
		case "PB":
			// ********-* 10
			ie = ie.replace(/\D/g,"")
			ie = ie.replace(/(\d{8})(\d{1,1})$/,"$1-$2")
			return ie
		break;
		
		//PARANÁ
		case "PR":
			// ********-** 11
			ie = ie.replace(/\D/g,"")
			ie = ie.replace(/(\d{8})(\d{1,2})$/,"$1-$2")
			return ie
		break;
		
		//PERNAMBUCO
		case "PE":
			// **.*.***.*******-* 18
			ie = ie.replace(/^(\d{2})(\d)/, "$1.$2")
			ie = ie.replace(/^(\d{2})\.(\d{1})(\d)/, "$1.$2.$3")
			ie = ie.replace(/\.(\d{3})(\d)/, ".$1/$2")
			ie = ie.replace(/(\d{3})(\d)/, "$1-$2")
			return ie
		break;
		
		//PIAUÍ
		case "PI":   
			// ********* 9
			ie = ie.replace(/\D/g,"")
			return ie
		break;
		
		//RIO DE JANEIRO
		case "RJ":
			// **.***.**-* 11
			ie = ie.replace(/\D/g,"")
			ie = ie.replace(/(\d{2})(\d)/,"$1.$2")
			ie = ie.replace(/(\d{3})(\d)/,"$1.$2")
			ie = ie.replace(/(\d{2})(\d{1,1})$/,"$1-$2")
			return ie
		break;
		
		//RIO GRANDE DO NORTE
		case "RN":
			// **.***.***-* 12
			ie = ie.replace(/\D/g,"")
			ie = ie.replace(/(\d{2})(\d)/,"$1.$2")
			ie = ie.replace(/(\d{3})(\d)/,"$1.$2")
			ie = ie.replace(/(\d{2})(\d{1,1})$/,"$1-$2")
			return ie
		break;
		
		//RIO GRANDE DO SUL
		case "RS":
			// ***/******* 11
			ie = ie.replace(/\D/g,"")
			ie = ie.replace(/(\d{3})(\d{1,7})$/,"$1/$2")
			return ie
		break;
		
		//RONDÔNIA
		case "RO":
			// ***.*****-* 11
			ie = ie.replace(/\D/g,"")
			ie = ie.replace(/(\d{3})(\d)/,"$1.$2")
			ie = ie.replace(/(\d{5})(\d{1,1})$/,"$1-$2")
			return ie
		break;
		
		//RORAIMA
		case "RR":
			// ********-* 10
			ie = ie.replace(/\D/g,"")
			ie = ie.replace(/(\d{8})(\d{1,1})$/,"$1-$2")
			return ie
		break;
		
		//SANTA CATARINA
		case "SC":
			// ***.***.*** 11
			ie = ie.replace(/\D/g,"")
			ie = ie.replace(/(\d{3})(\d)/,"$1.$2")
			ie = ie.replace(/(\d{3})(\d{1,3})$/,"$1.$2")
			return ie
		break;
		
		//SÃO PAULO
		case "SP":
			// ***.***.***.*** 15
			ie = ie.replace(/\D/g,"")
			ie = ie.replace(/(\d{3})(\d)/,"$1.$2")
			ie = ie.replace(/(\d{3})(\d)/,"$1.$2")
			ie = ie.replace(/(\d{3})(\d{1,3})$/,"$1.$2")
			return ie
		break;
		
		//SERGIPE
		case "SE":
			// *********-* 11
			ie = ie.replace(/\D/g,"")
			ie = ie.replace(/(\d{9})(\d{1,1})$/,"$1-$2")
			return ie
		break;
		
		//TOCANTINS
		case "TO":
			// *********** 11
			ie = ie.replace(/\D/g,"")
			return ie
		break;
		
		//DEFAULT
		default:
			return false;		
	}
}

function tamanho(){
   estado = document.getElementById('cmbEstado').value;
   document.getElementById("txtIe").value="";
   document.getElementById("txtIe").focus();
   document.getElementById("txtIe").disabled = false;
   document.getElementById("ieResponse").innerHTML="";
	switch(estado){
		case "AC":
			document.getElementById("txtIe").maxLength="17";
		break;
		case "AL":
			document.getElementById("txtIe").maxLength="9";
		break;
		case "AP":
			document.getElementById("txtIe").maxLength="9";
		break;
		case "AM":
			document.getElementById("txtIe").maxLength="12";
		break;
		case "BA":
			document.getElementById("txtIe").maxLength="9";
		break;
		case "CE":
			document.getElementById("txtIe").maxLength="10";
		break;
		case "DF":
			document.getElementById("txtIe").maxLength="14";
		break;
		case "ES":
			document.getElementById("txtIe").maxLength="9";
		break;
		case "GO":
			document.getElementById("txtIe").maxLength="12";
		break;
		case "MA":
			document.getElementById("txtIe").maxLength="9";
		break;
		case "MG":
			document.getElementById("txtIe").maxLength="16";
		break;
		case "MT":
			document.getElementById("txtIe").maxLength="12";
		break;
		case "MS":
			document.getElementById("txtIe").maxLength="9";
		break;
		case "PA":
			document.getElementById("txtIe").maxLength="11";
		break;
		case "PB":
			document.getElementById("txtIe").maxLength="10";
		break;
		case "PR":
			document.getElementById("txtIe").maxLength="11";
		break;
		case "PE":
			document.getElementById("txtIe").maxLength="18";
		break;
		case "PI":   
			document.getElementById("txtIe").maxLength="9";
		break;
		case "RJ":
			document.getElementById("txtIe").maxLength="11";
		break;
		case "RN":
			document.getElementById("txtIe").maxLength="12"
		break;
		case "RS":
			document.getElementById("txtIe").maxLength="11";
		break;
		case "RO":
			document.getElementById("txtIe").maxLength="11";
		break;
		case "RR":
			document.getElementById("txtIe").maxLength="10";
		break;
		case "SC":
			document.getElementById("txtIe").maxLength="11";
		break;
		case "SP":
			document.getElementById("txtIe").maxLength="15";
		break;
		case "SE":
			document.getElementById("txtIe").maxLength="11";
		break;
		case "TO":
			document.getElementById("txtIe").maxLength="11";
		break;
		default:
			document.getElementById("txtIe").disabled = true;
			return false;
	}
}

ieCheck = function(el){
    document.getElementById('ieResponse').innerHTML = valida_ie(el.value)?
    '<span style="color:green">V&aacute;lido</span>' : '<span style="color:red">Inv&aacute;lido</span>';
    if(el.value=='') document.getElementById('ieResponse').innerHTML = '';
}