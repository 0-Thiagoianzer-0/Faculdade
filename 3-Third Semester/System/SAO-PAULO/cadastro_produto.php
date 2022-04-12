<?php 
    include('include/conexao.php');
	include_once('include/valida_sessoes.php'); 
?>

<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Cadastro de Produto</title>
        <meta charset="utf-8">
		<link rel='stylesheet' type='text/css' media='screen' href='css/cabecalho.css'>
        <script src="js/jquery-1.7.min.js"></script>
        <script src="js/jquery.easing.1.3.js"></script>
        <script src="js/testa_navegador.js"></script>
		<script src="js/dropdown.js"></script>
        <script src="js/produto/salva_altera_produto.js"></script>
        <script src="js/produto/monta_select_produto.js"></script>
        <script src="js/produto/busca_produtoAjax.js"></script>
		<script src="js/produto/limpa_produto.js"></script>
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
				<h3>Cadastro de Produto</h3>
			</div>
			<form id="formProduto" name="formProduto" method="POST">
				<div class="form-row">
					<div class="form-group col-md-1" style="margin-top: 10px;">
						<label>Código:</label>
						<input 
							type="text"
							class="form-control"
							id="txtCodigoProduto"
							style="text-transform:uppercase;"
							value="<?php
										$sql = "SELECT MAX(codigo_produto) FROM produto";
										$resultado = pg_query($conexao, $sql);
										$registro = pg_fetch_row($resultado);
										$txtCodigoProduto = $registro[0] + 1;
										echo ($txtCodigoProduto);
									?>"
							disabled
						/>
					</div>
					<div class="form-group col-md-1" style="margin-top: 3.5%; margin-left: 9%;" id="divBotao">
						<input 
							type="button" 
							onclick="mostrarCombo();lista_produto();"
							style="background-color: transparent; border: transparent; 
							background-image: url(images/alterar.png); width: 40px; height: 36px;
							cursor: pointer; margin-left: 136px;"
						/>
					</div>
				</div>
				<div class="form-row">
					<div class="form-group col-md-4" style="margin-top: 10px; display: none;" id="divBuscar">
						<label>Busca Produto:</label>
						<select 
							class="form-control" 
							id="cmbProduto"
							onchange="busca_produtoAjax();"
							onkeyup="busca_produtoAjax();"
							onkeydown="busca_produtoAjax();">
							<option value="">Selecione...</option>
						</select>
					</div>
				</div>
				<div class="form-row">
					<div class="form-group col-md-4" style="margin-top: 10px;">
						<label>Nome:</label>
						<input
							type="text"
							class="form-control"
							id="txtNome"
							style="text-transform:uppercase"
							maxlength="100"
						/>
					</div>
				</div>
				<div class="form-row">
                    <div class="form-group col-md-4" style="margin-top: 10px;">
                        <label>Tipo Produto:</label>
                        <select class="form-control" id="cmbTipoProduto">
                            <option value="">Selecione...</option>
                            <?php
                                $sql = "SELECT * FROM tipo_produto ";
                                $sql .= "ORDER BY nome";
                                $resultado = pg_query($conexao, $sql);
                                $linha = pg_num_rows($resultado);
                                for ($cont=0; $cont<$linha; $cont++) {
                                    $registro = pg_fetch_row($resultado);
                                    echo "<option value = $registro[0] > $registro[1]</option>";
                                }
                            ?>
                        </select>
                    </div>
				</div>
				<div class="form-row">
					<div class="form-group col-md-4" style="margin-top: 10px;">
						<label>Cor:</label>
						<input
							type="text"
							class="form-control"
							id="txtCor"
							style="text-transform:uppercase"
							maxlength="50"
						/>
					</div>
				</div>
				<div class="form-row">
					<div class="form-group col-md-4" style="margin-top: 10px;">
						<label>Espessura:</label>&nbsp<span style="color:red;">*Valor em milímetro(mm)</span>
						<input
							type="number"
							class="form-control"
							id="txtEspessura"
							maxlength="2"
							min="0"
							max="20"
						/>
					</div>
				</div>
				<div class="form-row">
                    <div class="form-group col-md-4" style="margin-top: 10px;">
                        <label>Observação:</label>
                        <textarea
                            class="form-control"
                            id="txtObservacao"
                            style="height:70px; text-transform:uppercase; resize: none;"
                            class="input-form"
                            maxlength="300"
                            >
                        </textarea>
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
						<button type="button" class="btn btn-success btn-md btn-block" onClick="salvaproduto();">Salvar</button>
					</div>
				</div>
			</form>
        </div>
        <div class="col-md-12" style="color:black; margin-top: 9%; margin-bottom:15px; text-align: center;">
            <?php include('include/rodape.php') ?>
        </div>
    </body>
</html>