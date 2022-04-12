<?php 
    include('include/conexao.php');
	include_once('include/valida_sessoes.php'); 
	unset($_SESSION['ordem_produto']['produto']);
?>

<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Novo Serviço</title>
        <meta charset="utf-8">
		<link rel='stylesheet' type='text/css' media='screen' href='css/cabecalho.css'>
		<link rel='stylesheet' type='text/css' media='screen' href='css/tabela_produto.css'>
		<link rel='stylesheet' type='text/css' media='screen' href='ANEXOS/style.css'>
        <script src="js/jquery-1.7.min.js"></script>
        <script src="js/jquery.easing.1.3.js"></script>
        <script src="js/testa_navegador.js"></script>
		<script src="js/dropdown.js"></script>
		<script src="js/retorna_codigo.js"></script>
		<script src="js/servico/novo_servico/salva_servico.js"></script>
		<script src="js/servico/novo_servico/limpa_servico.js"></script>
		<script src="js/servico/novo_servico/busca_produto.js"></script>
		<script src="js/moeda.js"></script>
        <script>
			function anexo(){
				if(document.getElementById("chkAnexo").checked){
					document.getElementById("divAnexo").style.display = 'block';
				}else{
					document.getElementById("divAnexo").style.display = 'none';
				}
			}
        </script>
    </head>
    
    <body onload="limpar();">
        <?php
            $PaginaAtual = "Cadastro";
            include "include/cabecalho.php";
        ?>
		<link rel="stylesheet" href="css/bootstrap.css">
		<link rel="stylesheet" href="css/glyphicons/css/glyphicons.css">
		<div class="container" style="background-color: white; border-radius: 15px; width: 1200px;">
			<div style="margin-top: 20px;">
				<h3>Novo Serviço</h3>
			</div>
			<form id="formServico" name="formServico" method="POST" action="javascript:void(0);" enctype="multipart/form-data">
				<div class="form-row">
					<div class="form-group col-md-1" style="margin-top: 10px;">
						<label>Código:</label>
						<input 
							type="text"
							class="form-control"
							id="txtCodigoServico"
							style="text-transform:uppercase;"
							onChange="retorna_codigo('servico', 'codigo_servico', 'txtCodigoServico')"
							readonly="true"
							value=""
						/>
					</div>
				</div>
				<div class="form-row">
                    <div class="form-group col-md-4" style="margin-top: 10px;">
                        <label>Cliente:</label>
                        <select class="form-control" id="cmbPessoa">
                            <option value="">Selecione...</option>
                            <?php
                                $sql = "SELECT * FROM pessoa ";
                                $sql .= "ORDER BY nome_razao_social";
                                $resultado = pg_query($conexao, $sql);
                                $linha = pg_num_rows($resultado);
                                for ($cont=0; $cont<$linha; $cont++){
                                    $registro = pg_fetch_row($resultado);
                                    echo "<option value = $registro[0] > $registro[2]</option>";
                                }
                            ?>
                        </select>
                    </div>
				</div>
				<div class="form-row">
                    <div class="form-group col-md-4" style="margin-top: 10px;">
                        <label>Prioridade:</label>
                        <select class="form-control" id="cmbPrioridade">
                            <option value="">Selecione...</option>
                            <?php
                                $sql = "SELECT * FROM servico_prioridade ";
                                $sql .= "ORDER BY nome";
                                $resultado = pg_query($conexao, $sql);
                                $linha = pg_num_rows($resultado);
                                for ($cont=0; $cont<$linha; $cont++){
                                    $registro = pg_fetch_row($resultado);
                                    echo "<option value = $registro[0] > $registro[1]</option>";
                                }
                            ?>
                        </select>
                    </div>
				</div>
				<div class="form-row">
					<div class="col-md-3" style="margin-top: 10px;">
						<label>Produto:</label>
						<select class="form-control" id="cmbProduto">
							<option value="">Selecione...</option>
							<?php
								$sql = "SELECT * FROM produto ";
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
					<div class="col-md-1" style="margin-top: 40px;">
						<button type="button"
								class="btn btn-success btn-md btn-block"
								onclick="inserir_produto();">
							<span class="glyphicon glyphicon-plus"></span>
						</button>
					</div>
				</div>
				<div class="form-row">
					<div class="col-md-4" style="margin-top: 10px;">
						<div id="tabela_produto" style="color:gray"></div>
						<img id="carregando" src="images/carregando.gif" style="margin-left: 50%; display: none;"/>
					</div>
				</div>
				<div class="form-row">
					<div class="form-group col-md-4" style="margin-top: 10px;">
						<label>Prazo:</label>
						<input 
							type="date"
							class="form-control"
							id="txtPrazo"
							min="<?php echo date("Y-m-d"); ?>"
						/>
					</div>
				</div>
				<div class="form-row">
					<div class="form-group col-md-4" style="margin-top: 10px;">
						<label>Valor:</label>
						<input 
							type="text"
							class="form-control"
							id="txtValor"
							onkeyup="this.value = formatReal( getMoney(this.value))"
						/>
					</div>
				</div>
				<div class="form-row">
					<div class="form-group col-md-4" style="margin-top: 10px;">
						<label>Descrição:</label>
						<textarea
							class="form-control"
							id="txtDescricao"
							style="height:100px; text-transform:uppercase; resize: none;"
							class="input-form"
							maxlength="300"
							>
						</textarea>
					</div>
				</div>
				<div class="form-row">
					<div class="form-group col-md-4" style="margin-top: 10px;">
						<div class="form-check">
							<input type="checkbox"
								   class="form-check-input"
								   id="chkAnexo"
								   onClick="anexo();">
							<label class="form-check-label">Anexo</label>
						</div>
					</div>
				</div>
				<div class="form-row" id="divAnexo" style="display: none;">
					<div class="form-group col-md-12">
						<input type="file" id="file" name="file" accept=".pdf,.txt,.png,.jpg">
					</div>
					<button type="submit" style="display: none;" id="enviar">Enviar</button>
					<div class="form-group col-md-12">
						<div id="return"></div>
					</div>
					<div class="form-group col-md-12">
						<div id="progressBar">
							<span></span>
						</div>
					</div>
				</div>
				<script async src="ANEXOS/upload.js"></script>
			</form>
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
					<button type="button" class="btn btn-success btn-md btn-block" onClick="salvaservico();">Salvar</button>
				</div>
			</div>
        </div>
        <div class="col-md-12" style="color:black; margin-top: 9%; margin-bottom:15px; text-align: center;">
            <?php include('include/rodape.php') ?>
        </div>
    </body>
</html>