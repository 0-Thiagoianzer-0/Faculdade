<?php
    include('include/conexao.php');
	include_once('include/valida_sessoes.php'); 
	$codigo_servico = $_GET['id'];
?>

<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Dados Serviço</title>
        <meta charset="utf-8">
		<link rel='stylesheet' type='text/css' media='screen' href='css/cabecalho.css'>
        <script src="js/jquery-1.7.min.js"></script>
		<link rel="stylesheet" type='text/css' media='screen' href="css/bootstrap.css">
		<link rel="stylesheet" type='text/css' media='screen' href="css/tabela_anexo.css">
        <script src="js/jquery.easing.1.3.js"></script>
        <script src="js/testa_navegador.js"></script>
		<script src="js/dropdown.js"></script>
		<script src="js/atende/atende.js"></script>
		<script src="js/atende/atualiza_tabela_anexo.js"></script>
		<script>
			function mostrarAnexo(){
				if(document.getElementById("chkMostrarAnexo").checked == "1"){
					document.getElementById("divAnexo").style.display = "block";
					atualiza_tabela_anexo(<?php echo $codigo_servico; ?>);
				}else{
					document.getElementById("divAnexo").style.display = "none";
				}
			}
		</script>
    </head>
    
    <body>
        <?php
            $PaginaAtual = "Protocolos";
            include "include/cabecalho.php";
        ?>
		<div class="container" style="background-color: white; border-radius: 15px; width: 1200px;">
			<div class="form-row" style="margin-top: 20px;">
				<div class="form-group col-md-10" style="margin-top: 10px;">
					<h3>Dados Serviço</h3>
				</div>
			</div>
			<form id="formDadosServico" name="formDadosServico" method="POST">
				<?php
					$sql = "SELECT se.codigo_servico, pe.nome_razao_social, se.prazo, se.valor, se.descricao ";
					$sql .= "FROM servico se ";
					$sql .= "INNER JOIN pessoa pe ON pe.codigo_pessoa = se.codigo_pessoa ";
					$sql .= "WHERE se.codigo_servico = $codigo_servico ";
					$consulta = pg_query($sql);
					$dados = pg_fetch_array($consulta);
					//RETORNOS
					$codigo_servico = $dados['codigo_servico'];
					$pessoa = $dados['nome_razao_social'];
					$prazo = $dados['prazo'];
					$valor = $dados['valor'];
					$descricao = $dados['descricao'];
				?>
				<label><b>Código: </b><?php echo $codigo_servico; ?></label><br />
				<label><b>Cliente: </b><?php echo $pessoa; ?></label><br />
				<label><b>Prazo: </b><?php echo $prazo; ?></label><br />
				<label><b>Valor: </b><?php echo $valor; ?></label><br />
				<label><b>Descrição: </b><?php echo $descricao; ?></label><br />
				
				<div class="form-row">
					<div class="form-group col-md-4" style="margin-top: 10px;">
						<div id="aviso" style="color: red;"></div>
					</div>
				</div>
				<div class="form-row">
					<div class="form-group col-sm-1" style="margin-top: 10px;">
						<button type="button" class="btn btn-warning btn-sm btn-block" onClick="atendeservico(<?php echo $codigo_servico; ?>);">
							Atender</button>
					</div>
					<div class="form-group col-sm-1" style="margin-top: 10px;">
						<button type="button" class="btn btn-success btn-sm btn-block" onClick="concluiservico(<?php echo $codigo_servico; ?>);">
							Concluir</button>
					</div>
					<div class="form-group col-sm-1" style="margin-top: 10px;">
						<button type="button" class="btn btn-danger btn-sm btn-block" onClick="cancelaservico(<?php echo $codigo_servico; ?>);">
							Cancelar</button>
					</div>
				</div>
				<div class="form-row">
					<div class="form-group col-md-12" style="margin-top: 10px;">
						<div class="form-check">
							<input type="checkbox" class="form-check-input" id="chkMostrarAnexo" onClick="mostrarAnexo();">
							<label class="form-check-label">Mostrar Anexo(s)</label>
						</div>
					</div>
					<div class="form-group col-md-12" style="margin-top: 10px; display: none;" id="divAnexo">
						<div id="tabela_anexos" style="color:gray;"></div>
						<div id="div_carregando" style="margin-left: 38%">
							<img id="carregando" src="images/carregando.gif"/>
							Carregando informações, aguarde...
						</div>
					</div>
				</div>
			</form>
		</div>
	</body>
</html>