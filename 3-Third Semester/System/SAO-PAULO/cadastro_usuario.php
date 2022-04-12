<?php 
    include('include/conexao.php');
	include_once('include/valida_sessoes.php'); 
?>

<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Cadastro de Usuario</title>
        <meta charset="utf-8">
		<link rel='stylesheet' type='text/css' media='screen' href='css/cabecalho.css'>
        <script src="js/jquery-1.7.min.js"></script>
        <script src="js/jquery.easing.1.3.js"></script>
        <script src="js/testa_navegador.js"></script>
		<script src="js/dropdown.js"></script>
        <script src="js/usuario/salva_altera_usuario.js"></script>
        <script src="js/usuario/monta_select_usuario.js"></script>
        <script src="js/usuario/busca_usuarioAjax.js"></script>
		<script src="js/usuario/limpa_usuario.js"></script>
		<script src="js/valida_email.js"></script>
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
				<h3>Cadastro de Usuario</h3>
			</div>
			<form id="formUsuario" name="formUsuario" method="POST">
				<div class="form-row">
					<div class="form-group col-md-1" style="margin-top: 10px;">
						<label>Código:</label>
						<input 
							type="text"
							class="form-control"
							id="txtCodigoUsuario"
							style="text-transform:uppercase;"
							value="<?php
										$sql = "SELECT MAX(codigo_usuario) FROM usuario";
										$resultado = pg_query($conexao, $sql);
										$registro = pg_fetch_row($resultado);
										$txtCodigoUsuario = $registro[0] + 1;
										echo ($txtCodigoUsuario);
									?>"
							disabled
						/>
					</div>
					<div class="form-group col-md-1" style="margin-top: 3.5%; margin-left: 9%;" id="divBotao">
						<input 
							type="button" 
							onclick="mostrarCombo();lista_usuario();"
							style="background-color: transparent; border: transparent; 
							background-image: url(images/alterar.png); width: 40px; height: 36px;
							cursor: pointer; margin-left: 136px;"
						/>
					</div>
				</div>
				<div class="form-row">
					<div class="form-group col-md-4" style="margin-top: 10px; display: none;" id="divBuscar">
						<label>Busca Usuario:</label>
						<select 
							class="form-control" 
							id="cmbUsuario"
							onchange="busca_usuarioAjax();"
							onkeyup="busca_usuarioAjax();"
							onkeydown="busca_usuarioAjax();">
							<option value="">Selecione...</option>
						</select>
					</div>
				</div>
				<div class="form-row">
                    <div class="form-group col-md-4" style="margin-top: 10px;">
                        <label>Pessoa:</label>
                        <select class="form-control" id="cmbPessoa">
                            <option value="">Selecione...</option>
                            <?php
                                $sql = "SELECT * FROM pessoa ";
                                $sql .= "ORDER BY nome_razao_social";
                                $resultado = pg_query($conexao, $sql);
                                $linha = pg_num_rows($resultado);
                                for ($cont=0; $cont<$linha; $cont++) {
                                    $registro = pg_fetch_row($resultado);
                                    echo "<option value = $registro[0] > $registro[2]</option>";
                                }
                            ?>
                        </select>
                    </div>
				</div>
				<div class="form-row">
					<div class="form-group col-md-4" style="margin-top: 10px;">
						<label>E-mail:</label>
						<input
							type="text"
							class="form-control"
							id="txtEmail"
							maxlength="100"
						/>
					</div>
				</div>
				<div class="form-row">
					<div class="form-group col-md-4" style="margin-top: 10px;">
						<label>Senha:</label>
						<input
							type="password"
							class="form-control"
							id="txtSenha"
							maxlength="10"
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
						<button type="button" class="btn btn-success btn-md btn-block" onClick="salvausuario();">Salvar</button>
					</div>
				</div>
			</form>
        </div>
        <div class="col-md-12" style="color:black; margin-top: 9%; margin-bottom:15px; text-align: center;">
            <?php include('include/rodape.php') ?>
        </div>
    </body>
</html>