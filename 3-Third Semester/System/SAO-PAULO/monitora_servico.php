<?php 
	include('include/conexao.php');
	include_once('include/valida_sessoes.php'); 
?>

<!DOCTYPE html>
<html lang="en">
	<head>
		<title>Monitorar Serviços</title>
		<meta charset="utf-8">
		<link rel="shortcut icon" href="images/icon.ico"/>
		<link rel="stylesheet" type="text/css" media="screen" href="css/cabecalho.css">
		<link rel="stylesheet" type="text/css" media="screen" href="css/filtros_visualizar.css">
		<script src="js/jquery-1.7.min.js"></script>
		<link rel="stylesheet" type='text/css' media='screen' href="css/bootstrap.css">
		<link rel='stylesheet' type='text/css' media='screen' href='css/tabela_monitora.css'>
		<script src="js/jquery.easing.1.3.js"></script>
		<script src="js/testa_navegador.js"></script>
		<script src="js/dropdown.js"></script>
		<script src="js/monitora/filtros.js"></script>
		<script src="js/monitora/atualiza_tabela_protocolo.js"></script>
	</head>
	<body onload="atualiza_tabela_servico();">
		<?php
			$PaginaAtual = "Protocolos";
			include "include/cabecalho.php";
		?>
		<div class="container" style="background-color: white; border-radius: 15px; width: 1200px;">
			<div style="margin-top: 20px;">
				<h3>Monitorar Serviços</h3>
			</div>
			<form id="formVisualizarServico" name="formVisualizarServico" method="POST">
				<div class="form-row">
                    <div class="form-group col-md-4" style="margin-top: 10px;">
                        <label>Usuário:</label>
                        <select class="form-control" id="cmbUsuario" onChange="atualiza_tabela_servico();">
                            <option value="">Selecione...</option>
                            <?php
                                $sql = "SELECT us.codigo_usuario, pe.nome_razao_social FROM usuario us ";
								$sql .= "INNER JOIN pessoa pe ON pe.codigo_pessoa = us.codigo_pessoa ";
                                $sql .= "ORDER BY pe.nome_razao_social";
                                $resultado = pg_query($conexao, $sql);
                                $linha = pg_num_rows($resultado);
                                for ($cont=0; $cont<$linha; $cont++){
                                    $registro = pg_fetch_row($resultado);
                                    echo "<option value = $registro[0] > $registro[1]</option>";
                                }
                            ?>
                        </select>
                    </div>
                    <div class="form-group col-md-2" style="margin-top: 10px;">
                        <label>Data Inicial:</label>
						<input
							type="date"
							class="form-control"
							id="txtDataInicial"
							maxlength="10"
							value=""
							onChange="atualiza_tabela_servico();"
						/>
                    </div>
                    <div class="form-group col-md-2" style="margin-top: 10px;">
                        <label>Data Final:</label>
						<input
							type="date"
							class="form-control"
							id="txtDataFinal"
							maxlength="10"
							value=""
							onChange="atualiza_tabela_servico();"
						/>
                    </div>
                    <div class="form-group col-md-4" style="margin-top: 10px;">
                        <label>Classificar:</label>
                        <select class="form-control" id="cmbClassificar" onChange="atualiza_tabela_servico();">
                            <option value="0">Código</option>
							<option value="1">Usuario</option>
							<option value="2">Cliente</option>
							<option value="3">Prazo</option>
							<option value="4">Situação</option>
                        </select>
                    </div>
				</div>
				<div class="form-row">
					<div class="form-group col-md-12" style="margin-top: 10px;">
						<table id="inputs">
							<tr>
								<td>
									<input class="checkbox"
										   id="chkTodos"
										   type="checkbox"
										   checked="true"
										   onchange="check_todos(); atualiza_tabela_servico();"
									/>
								</td>
								<td colspan="2">
									<label style="height: 20px;min-height:0px;">
										Todos&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
									</label>
								</td>
								<td>
									<input class="checkbox"
										   id="chkPendente"
										   type="checkbox"
										   checked="true"
										   onChange="atualiza_tabela_servico();"
									/>
								</td>
								<td>
									<div class="checkbox_cores" style="background-color: #AAAAAA; margin-top: -5px;"></div>
								</td>
								<td>
									<label style="height: 20px;min-height:0px;">
										Pendentes&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
									</label>
								</td>
								<td>
									<input class="checkbox"
										   id="chkAtendimento"
										   type="checkbox"
										   checked="true"
										   onChange="atualiza_tabela_servico();"
									/>
								</td>
								<td>
									<div class="checkbox_cores" style="background-color: #FFD700; margin-top: -5px;"></div>
								</td>
								<td>
									<label style="height: 20px;min-height:0px;">
										Em Atendimento&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
									</label>
								</td>
								<td>
									<input class="checkbox"
										   id="chkConcluido"
										   type="checkbox"
										   checked="true"
										   onChange="atualiza_tabela_servico();"
									/>
								</td>
								<td>
									<div class="checkbox_cores" style="background-color: #008000; margin-top: -5px;"></div>
								</td>
								<td>
									<label style="height: 20px;min-height:0px;">
										Concluídos&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
									</label>
								</td>
								<td>
									<input class="checkbox"
										   id="chkAtrasado"
										   type="checkbox"
										   checked="true"
										   onChange="atualiza_tabela_servico();"
									/>
								</td>
								<td>
									<div class="checkbox_cores" style="background-color: #FF0000; margin-top: -5px;"></div>
								</td>
								<td>
									<label style="height: 20px;min-height:0px;">
										Atrasados&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
									</label>
								</td>
								<td>
									<input class="checkbox"
										   id="chkCancelado"
										   type="checkbox"
										   checked="true"
										   onChange="atualiza_tabela_servico();"
									/>
								</td>
								<td>
									<div class="checkbox_cores" style="background-color: #FFA500; margin-top: -5px;"></div>
								</td>
								<td>
									<label style="height: 20px;min-height:0px;">Cancelados</label>
								</td>
							</tr>
						</table> <!--TABELA DOS FILTROS-->
					</div>
				</div>
				<div class="form-row">
					<div class="form-group col-md-12" style="margin-top: 10px;">
						<div id="tabela_servicos" style="color:gray;"></div>
						<div id="div_carregando" style="margin-left: 35%">
							<img id="carregando" src="images/carregando.gif"/><br/>
							Carregando informações, aguarde...
						</div>
					</div>
				</div>
			</form>
		</div>
        <div class="col-md-12" style="color:black; margin-top: 4%; margin-bottom:15px; text-align: center;">
            <?php include('include/rodape.php') ?>
        </div>
	</body>
</html>