<?php 
    include('include/conexao.php');
	include_once('include/valida_sessoes.php'); 
?>

<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Cadastro de Órgão Emissor</title>
        <meta charset="utf-8">
		<link rel='stylesheet' type='text/css' media='screen' href='css/cabecalho.css'>
        <script src="js/jquery-1.7.min.js"></script>
        <script src="js/jquery.easing.1.3.js"></script>
        <script src="js/testa_navegador.js"></script>
		<script src="js/dropdown.js"></script>
        <script src="js/orgao_emissor/salva_altera_orgao_emissor.js"></script>
        <script src="js/orgao_emissor/monta_select_orgao_emissor.js"></script>
        <script src="js/orgao_emissor/busca_orgao_emissorAjax.js"></script>
		<script src="js/orgao_emissor/limpa_orgao_emissor.js"></script>
        <script>
            function mostrarCombo(){
                document.getElementById('divBotao').style.display = 'none';
                document.getElementById('divBuscar').style.display = 'block';
            }
        </script>
    </head>
    
    <body onload="limpar();">
        <?php
            $PaginaAtual = "Cadastro";
            include "include/cabecalho.php";
        ?>
		<link rel="stylesheet" href="css/bootstrap.css">
		<div class="container" style="background-color: white; border-radius: 15px; width: 1200px;">
			<div style="margin-top: 20px;">
				<h3>Cadastro de Órgão Emissor</h3>
			</div>
			<form id="formOrgaoEmissor" name="formOrgaoEmissor" method="POST">
				<div class="form-row">
					<div class="form-group col-md-1" style="margin-top: 10px;">
						<label>Código:</label>
						<input 
							type="text"
							class="form-control"
							id="txtCodigoOrgaoEmissor"
							style="text-transform:uppercase;"
							value="<?php
										$sql = "SELECT MAX(codigo_orgao_emissor) FROM orgao_emissor";
										$resultado = pg_query($conexao, $sql);
										$registro = pg_fetch_row($resultado);
										$txtCodigoOrgaoEmissor = $registro[0] + 1;
										echo ($txtCodigoOrgaoEmissor);
									?>"
							disabled
						/>
					</div>
					<div class="form-group col-md-1" style="margin-top: 3.5%; margin-left: 9%;" id="divBotao">
						<input 
							type="button" 
							onclick="mostrarCombo();lista_orgao_emissor();"
							style="background-color: transparent; border: transparent; 
							background-image: url(images/alterar.png); width: 40px; height: 36px;
							cursor: pointer; margin-left: 136px;"
						/>
					</div>
				</div>
				<div class="form-row">
					<div class="form-group col-md-4" style="margin-top: 10px; display: none;" id="divBuscar">
						<label>Busca Órgão Emissor:</label>
						<select 
							class="form-control" 
							id="cmbOrgaoEmissor"
							onchange="busca_orgao_emissorAjax();"
							onkeyup="busca_orgao_emissorAjax();"
							onkeydown="busca_orgao_emissorAjax();">
							<option value="">Selecione...</option>
						</select>
					</div>
				</div>
				<div class="form-row">
					<div class="form-group col-md-3" style="margin-top: 10px;">
						<label>Nome:</label>
						<input
							type="text"
							class="form-control"
							id="txtNome"
							style="text-transform:uppercase"
							maxlength="100"
						/>
					</div>
					<div class="form-group col-md-1" style="margin-top: 10px;">
						<label>Sigla:</label>
						<input
							type="text"
							class="form-control"
							id="txtSigla"
							style="text-transform:uppercase"
							maxlength="5"
						/>
					</div>
				</div>
				<div class="form-row">
					<div class="form-group col-md-4" style="margin-top: 10px;">
						<div class="form-check">
							<input type="checkbox" class="form-check-input" id="chkAtivo" checked>
							<label class="form-check-label">Ativo</label>
						</div>
					</div>
				</div>
				<div class="form-row">
					<div class="form-group col-md-4" style="margin-top: 10px;">
						<div id="aviso" style="color: red;"></div>
					</div>
				</div>
				<div class="form-row">
					<div class="form-group col-md-2" style="margin-top: 10px;">
						<button type="button" class="btn btn-warning btn-md btn-block" onClick="limpar();">Limpar</button>
					</div>
					<div class="form-group col-md-2" style="margin-top: 10px;">
						<button type="button" class="btn btn-success btn-md btn-block" onClick="salvaorgaoemissor();">Salvar</button>
					</div>
				</div>
			</form>
        </div>
        <div class="col-md-12" style="color:black; margin-top: 9%; margin-bottom:15px; text-align: center;">
            <?php include('include/rodape.php') ?>
        </div>
    </body>
</html>