function atualiza_tabela_produto(){
	ajax = IniciaAjax();
	if(ajax){
		ajax.onreadystatechange = function(){
			if(ajax.readyState == 4){
				if(ajax.status == 200){
					document.getElementById("tabela_produto").innerHTML = '';
					var res = ajax.responseText.split("|");
					if(res != ''){
						document.getElementById("tabela_produto").style.display = 'block';
						var html = "";
						html += "<table id='tabelaProduto'>";
						html += "<thead>";
						html += "<tr>";
						html += "<th>Produto</th>";
						html += "<th>Remover</th>";
						html += "</tr>";
						html += "</thead>";
						html += "<tbody>";
						for(var i = 1; i < res.length; i++){
							html += "<tr>";
							html += "<td style='color:black;'>" + res[i + 1] + "</td>";
							html += "<td style='color:black;'>" + res[i + 2] + "</td>";
							html += "<td><a style='float: none;' href= javascript: onClick='remover_produto(" + res[i] + ")';><img src='images/lixeira.png' width='25px' height='25px' /></a></td>";
							i = i + 2;
							html += '</tr>';
						}
						html += "</tbody>";
						html += '</table>';
						document.getElementById("tabela_produto").innerHTML = html;
					}
					document.getElementById("carregando").style.display = "none";
				}else{
					alert(ajax.statusText);
					document.getElementById("carregando").style.display = "none";
				}
			}
		}
		document.getElementById("carregando").style.display = "block";
		
		operacao = 'atualiza_tabela_produto';
		
		dados = 'atualiza_tabela_produto=' + operacao;
		
		ajax.open('POST', 'consulta/busca_produto.php', true);
		ajax.setRequestHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
		ajax.send(dados);
	}
}

function inserir_produto(){
	ajax = IniciaAjax();
	if(ajax){
		ajax.onreadystatechange = function(){
			if(ajax.readyState == 4){
				if(ajax.status == 200){
					setTimeout('atualiza_tabela_produto()', 1000);               
				}else{
					alert(ajax.statusText);
					document.getElementById("carregando").style.display = "none";
				}
			}
		}
		operacao = 'inserir_produto';
		codigo_produto = document.getElementById("cmbProduto").value;
		dados = 'inserir_produto=' + operacao + '&cmbProduto=' + codigo_produto;
		if(codigo_produto == ''){
			document.getElementById("aviso").innerHTML = 'Favor, selecione Produto!';
			document.getElementById("aviso").style.display = 'block';
			setTimeout("document.getElementById('aviso').style.display='none'", 5000);
		}else{
			document.getElementById("carregando").style.display = "block";
			ajax.open('POST', 'consulta/busca_produto.php', true)
			ajax.setRequestHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
			ajax.send(dados);
		}
	}
}

function remover_produto(txtIndiceProduto){
	var confirma = confirm("Deseja remover esse registro?")
	{
		ajax = IniciaAjax();
		if(ajax){
			ajax.onreadystatechange = function(){
				if(ajax.readyState == 4){
					if(ajax.status == 200){
						var res = ajax.responseText.split("|");
						setTimeout('atualiza_tabela_produto()', 1000);
						document.getElementById("carregando").style.display = "block";
					}else{
						alert(ajax.statusText);
						document.getElementById("carregando").style.display = "none";
					}
				}
			}
			operacao = 'remover_produto';
			indice_produto = txtIndiceProduto;
			dados = 'remover_produto=' + operacao + '&txtIndiceProduto=' + indice_produto;
			if(confirma == true){
				ajax.open('POST', 'consulta/busca_produto.php', true);
				ajax.setRequestHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
				ajax.send(dados);
			}
		}
	}
}

function limpar_tabela(){
	ajax = IniciaAjax();
	if(ajax){
		operacao = 'limpar';
		dados = 'limpar=' + operacao;
		ajax.open('POST', 'consulta/busca_produto.php', true);
		ajax.setRequestHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
		ajax.send(dados);
		document.getElementById('tabela_produto').innerHTML = '';
		document.getElementById("carregando").style.display = "none";
	}
}