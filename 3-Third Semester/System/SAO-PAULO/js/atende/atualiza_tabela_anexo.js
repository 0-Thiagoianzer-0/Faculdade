function atualiza_tabela_anexo(txtCodigoServico){
	ajax = IniciaAjax();
	if(ajax){
        ajax.onreadystatechange = function(){
            if(ajax.readyState == 4){
                if (ajax.status == 200){
                    document.getElementById("tabela_anexos").innerHTML = '';
                    var res = ajax.responseText.split("|");
					if(res[1]){
						var html = "";
						html += "<table id='tabelaAnexo'>";
						html += "<thead>";
						html += "<tr>";
						html += "<th style='width:30px;'>Código</th>";
						html += "<th style='width:400px;'>Nome</th>";
						html += "<th style='width:50px;'>Extensão</th>";
						html += "<th style='width:200px;'>Data</th>";
						html += "<th style='width:200px;'>Hora</th>";
						html += "<th style='width:60px;'>Download</th>";
						html += "</tr>";
						html += "</thead>";
						html += "<tbody>";
						for(var i = 1; i < res.length; i++){
							html += "<tr style='height: 30px;'>";
							html += "<td style='width: 30px; height: 30px; color:black;'>" + res[i] + "</td>"
							html += "<td style='width: 400px; height: 30px; color:black;'>" + res[i + 1] + "</td>";
							html += "<td style='width: 50px; height: 30px; color:black;'>" + res[i + 2] + "</td>";
							html += "<td style='width: 200px; height: 30px; color:black;'>" + res[i + 3] + "</td>";
							html += "<td style='width: 200px; height: 30px; color:black;'>" + res[i + 4] + "</td>";
							diretorio = res[i + 5];
							html += "<td><a style='float: none;' a href=" + diretorio + " download><img src='images/download.png' width='30px' height='30px' style='padding: 5px' /></a></td>";
							html += "</tr>";
							i = i + 5;
                        }
						html += '</tbody>';
						html += '</table>';
                    }else{
						html = "<div style='margin-left: 4px;margin-top: 10px;'>O Serviço não possuí anexo.</div>";
                    }
                    document.getElementById("tabela_anexos").style.display = 'block';
                    var load = function(){ loading(html) };
                    setTimeout(load, 1000);
                    function loading(html){
                        document.getElementById("div_carregando").style.display = 'none';
                        document.getElementById("tabela_anexos").innerHTML = html;
                    }

                }else{
                    alert(ajax.statusText);
                    document.getElementById("div_carregando").style.display = 'none';
                }
            }
        }
		document.getElementById("tabela_anexos").innerHTML = "";
		document.getElementById("div_carregando").style.display = 'block';
		
		codigo_servico = txtCodigoServico;
		
		//MONTA QUERY STRING
		dados = '&txtCodigoServico=' + codigo_servico;
		
		alert(dados);

		//Faz a requisição e envio pelo metodo POST
		ajax.open('POST', 'consulta/busca_anexo_servico.php', true);
		ajax.setRequestHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
		ajax.send(dados);

    }
}