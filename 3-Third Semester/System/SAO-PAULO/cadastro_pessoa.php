<?php 
    include('include/conexao.php');
	include_once('include/valida_sessoes.php'); 
?>

<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Cadastro Pessoa</title>
        <meta charset="utf-8">
		<link rel='stylesheet' type='text/css' media='screen' href='css/cabecalho.css'>
        <script src="js/jquery-1.7.min.js"></script>
        <script src="js/jquery.easing.1.3.js"></script>
        <script src="js/testa_navegador.js"></script>
		<script src="js/dropdown.js"></script>
        <script src="js/pessoa/salva_altera_pessoa.js"></script>
        <script src="js/pessoa/monta_select_pessoa.js"></script>
        <script src="js/pessoa/busca_pessoaAjax.js"></script>
		<script src="js/pessoa/limpar_pessoa.js"></script>
		<script src="js/pessoa/tipo_pessoa.js"></script>
        <script src="js/valida_email.js"></script>
        <script src="js/valida_cpf.js"></script>
        <script src="js/valida_cnpj.js"></script>
        <script src="js/valida_ie.js"></script>
		<script src="js/valida_telefone.js"></script>
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
				<h3>Cadastro de Pessoa</h3>
			</div>
			<form id="formPessoa" name="formPessoa" method="POST">
				<div class="form-row">
					<div class="form-group col-md-1" style="margin-top: 10px;">
						<label>Código:</label>
						<input 
							type="text"
							class="form-control"
							id="txtCodigoPessoa"
							style="text-transform:uppercase;"
							value="<?php
										$sql = "SELECT MAX(codigo_pessoa) FROM pessoa";
										$resultado = pg_query($conexao, $sql);
										$registro = pg_fetch_row($resultado);
										$txtCodigoPessoa = $registro[0] + 1;
										echo ($txtCodigoPessoa);
									?>"
							disabled
						/>
					</div>
					<div class="form-group col-md-1" style="margin-top: 3.5%; margin-left: 9%;" id="divBotao">
						<input 
							type="button" 
							onclick="mostrarCombo();lista_pessoa();"
							style="background-color: transparent; border: transparent; 
							background-image: url(images/alterar.png); width: 40px; height: 36px;
							cursor: pointer; margin-left: 136px;"
						/>
					</div>
					<div class="form-group col-md-6" style="margin-top: 10px; display: none;" id="divBuscar">
						<label>Busca Pessoa:</label>
						<select
							class="form-control" 
							id="cmbPessoa"
							onchange="busca_pessoaAjax();"
							onkeyup="busca_pessoaAjax();"
							onkeydown="busca_pessoaAjax();"
							style="width:292px;">
							<option>Selecione...</option>
						</select>
					</div>
				</div>
				<div class="form-row">
					<div class="form-group col-md-4" style="margin-top: 10px;">
						<label>Tipo Pessoa:</label>
						<input class="form-check-input" type="radio" id="radFisica" name="radPessoa" value="F" onChange="fisica();" onclick="javascript: fisica();" style="margin-left: 10px;" checked>
						<label class="form-check-label" for="feminino" style="margin-left: 25px;">Física</label>
						<input class="form-check-input" type="radio" id="radJuridica" name="radPessoa" value="J" onChange="juridica();" onclick="javascript: juridica();" style="margin-left: 10px;">
						<label class="form-check-label" for="masculino" style="margin-left: 25px;">Jurídica</label>
					</div>
				</div>
				<div class="form-row">
                    <div class="form-group col-md-12" style="margin-top: 10px;">
                        <label>Nome/Razão Social:</label>
                        <input
                            type="text"
                            class="form-control"
                            id="txtNomeRazaoSocial"
                            style="text-transform:uppercase;"
                            maxlength="100"
                        />
                    </div>
				</div>
				<div class="form-row">
                    <div class="form-group col-md-4" style="margin-top: 10px;" id="divCpf">
                        <label>CPF:</label><span style="margin-left: 4px;" id="cpfResponse"></span>
                        <input
                            type="text"
                            class="form-control"
                            id="txtCpf"
                            maxlength="14"
                            onkeyup="cpfCheck(this)"
                            onkeydown="javascript: fMasc( this, mCPF );"
                        />
                    </div>
                    <div class="form-group col-md-4" style="margin-top: 10px; display: none;" id="divCnpj">
                        <label>CNPJ:</label><span style="margin-left: 4px;" id="cnpjResponse"></span>
                        <input
                            type="text"
                            class="form-control"
                            id="txtCnpj"
                            maxlength="18"
                            onkeyup="cnpjCheck(this)"
                            onkeydown="javascript: fMasc( this, mCNPJ );"
                        />
                    </div>
                    <div class="form-group col-md-4" style="margin-top: 10px;" id="divIdentidade">
                        <label>Identidade:</label>
                        <input
                            type="text"
                            class="form-control"
                            id="txtIdentidade"
                            style="text-transform:uppercase;"
                            maxlength="20"
                        />
                    </div>
                    <div class="form-group col-md-4" style="margin-top: 10px;" id="divOrgaoEmissor">
                        <label>Orgão Emissor:</label>
                        <select class="form-control" id="cmbOrgaoEmissor">
                            <option value="">Selecione...</option>
                            <?php
                                $sql = "SELECT * FROM orgao_emissor ";
                                $sql .= "ORDER BY sigla";
                                $resultado = pg_query($conexao, $sql);
                                $linha = pg_num_rows($resultado);
                                for ($cont=0; $cont<$linha; $cont++) {
                                    $registro = pg_fetch_row($resultado);
                                    echo "<option value = $registro[0] > $registro[2] - $registro[1]</option>";
                                }
                            ?>
                        </select>
                    </div>
				</div>
				<div class="form-row">
                    <div class=" form-group col-md-4" style="margin-top: 10px;" id="divTituloEleitor">
                        <label>Titulo de Eleitor:</label>
                        <input
                            type="text"
                            class="form-control"
                            id="txtTituloEleitor"
                            style="text-transform:uppercase;"
                            maxlength="12"
                        />
                    </div>
                    <div class="form-group col-md-4" style="margin-top: 45px;" id="divSexo">
                        <div class="form-check" style="margin-top: 2px;">
							<label>Sexo:</label>
                            <input class="form-check-input" type="radio" id="radFeminino" name="radSexo" value="F" style="margin-left: 10px;">
                            <label class="form-check-label" for="feminino" style="margin-left: 25px;">Feminino</label>
                            <input class="form-check-input" type="radio" id="radMasculino" name="radSexo" value="M" style="margin-left: 10px;">
                            <label class="form-check-label" for="masculino" style="margin-left: 25px;">Masculino</label>
                        </div>
                    </div>
				</div>
				<div class="form-row">
                    <div class="form-group col-md-4" style="margin-top: 10px; display: none;" id="divNomeFantasia">
                        <label>Nome Fantasia:</label>
                        <input
                            type="text"
                            class="form-control"
                            id="txtNomeFantasia"
                            style="text-transform:uppercase"
                            maxlength="100"
                        />
                    </div>
                    <div class="form-group col-md-4" style="margin-top: 10px; display: none;" id="divResponsavel">
                        <label>Nome Responsável:</label>
                        <input
                            type="text"
                            class="form-control"
                            id="txtNomeResponsavel"
                            style="text-transform:uppercase"
                            maxlength="100"
                        />
                    </div>
                    <div class="form-group col-md-4" style="margin-top: 10px; display: none;" id="divEstado">
                        <label>Estado:&nbsp;</label><span style="color:red;">*Válida Inscrição Estadual</span>
                        <select class="form-control" id="cmbEstado" name="cmbEstado" onChange="tamanho()">
                            <option value="">Selecione...</option>
                            <?php
                                $sql = "SELECT * FROM estado ";
                                $sql .= "ORDER BY nome";
                                $resultado = pg_query($conexao, $sql);
                                $linha = pg_num_rows($resultado);
                                for ($cont=0; $cont<$linha; $cont++){
                                    $registro = pg_fetch_row($resultado);
                                    echo "<option value = $registro[0] > $registro[1] - $registro[2]</option>";
                                }
                            ?>
                        </select>
                    </div>
				</div>
				<div class="form-row">
                    <div class="form-group col-md-4" style="margin-top: 10px; display: none;" id="divIe">
                        <label>Inscrição Estadual:</label>
                        <input
                            type="text"
                            class="form-control"
                            id="txtIe"
                            style="text-transform:uppercase"
                            onkeyup="ieCheck(this)"
                            onkeydown="javascript: fMasc( this, mIE );"
                            disabled="true"
                            maxlength="100"
                        />
                    </div>
                    <div class="form-group col-md-4" style="margin-top: 10px; display: none;" id="divIm">
                        <label>Inscrição Municipal:</label>
                        <input
                            type="text"
                            class="form-control"
                            id="txtInscricaoMunicipal"
                            style="text-transform:uppercase"
                            maxlength="20"
                        />
                    </div>
				</div>
				<div class="form-row">
                    <div class="form-group col-md-10" style="margin-top: 10px;">
                        <label>Endereço:</label>
                        <input
                            type="text"
                            class="form-control"
                            id="txtEndereco"
                            style="text-transform:uppercase"
                            maxlength="100"
                        />
                    </div>
                    <div class="form-group col-md-2" style="margin-top: 10px;">
                        <label>Numero:</label>
                        <input
                            type="text"
                            class="form-control"
                            id="txtNumero"
                            style="text-transform:uppercase"
                            maxlength="5"
                        />
                    </div>
				</div>
				<div class="form-row">
                    <div class="form-group col-md-4" style="margin-top: 10px;">
                        <label>Cidade:</label>
                        <select class="form-control" id="cmbCidade">
                            <option value="">Selecione...</option>
                            <?php
                                $sql = "SELECT * FROM cidade ";
                                $sql .= "ORDER BY nome";
                                $resultado = pg_query($conexao, $sql);
                                $linha = pg_num_rows($resultado);
                                for ($cont=0; $cont<$linha; $cont++) {
                                    $registro = pg_fetch_row($resultado);
                                    echo "<option value = $registro[0] > $registro[1]</option>";
                                }
                                pg_close($conexao);
                            ?>
                        </select>
                    </div>
                    <div class="form-group col-md-4" style="margin-top: 10px;">
                        <label>Cep:</label>
                        <input
                            type="text"
                            class="form-control"
                            id="txtCep"
                            style="text-transform:uppercase"
                            maxlength="8"
                        />
                    </div>
                    <div class="form-group col-md-4" style="margin-top: 10px;">
                        <label>Complemento:</label>
                        <input
                            type="text"
                            class="form-control"
                            id="txtComplemento"
                            style="text-transform:uppercase"
                            maxlength="50"
                        />
                    </div>
				</div>
				<div class="form-row">
                    <div class="form-group col-md-4" style="margin-top: 10px;">
                        <label>Bairro:</label>
                        <input
                            type="text"
                            class="form-control"
                            id="txtBairro"
                            style="text-transform:uppercase"
                            maxlength="50"
                        />
                    </div>
                    <div class="form-group col-md-4" style="margin-top: 10px;">
                        <label>Telefone:</label><span style="margin-left: 4px;" id="telefoneResponse"></span>
                        <input
                            type="text"
                            class="form-control"
                            id="txtTelefone"
                            maxlength="15"
                            onkeyup="telCheck(this)"
                            onkeydown="javascript: fMasc( this, mTEL );"
                        />
                    </div>
                    <div class="form-group col-md-4" style="margin-top: 10px;">
                        <label>Telefone Adicional:</label><span style="margin-left: 4px;" id="adicionalResponse"></span>
                        <input
                            type="text"
                            class="form-control"
                            id="txtTelefoneAdicional"
                            maxlength="15"
                            onkeyup="adicionalCheck(this)"
                            onkeydown="javascript: fMasc( this, mTEL );"
                        />
                    </div>
				</div>
				<div class="form-row">
                    <div class="form-group col-md-12" style="margin-top: 10px;">
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
							<input type="checkbox" class="form-check-input" id="chkAtivo" checked="true" />
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
					<div class="form-group col-md-6" style="margin-top: 10px;">
						<button type="button" class="btn btn-warning btn-md btn-block" onClick="limpar();">Limpar</button>
					</div>
					<div class="form-group col-md-6" style="margin-top: 10px;">
						<button type="button" class="btn btn-success btn-md btn-block" onClick="salvapessoa();">Salvar</button>
					</div>
				</div>
			</form>
		</div>
        <div class="col-md-12" style="color:black; margin-top: 9%; margin-bottom:15px; text-align: center;">
            <?php include('include/rodape.php') ?>
        </div>
    </body>
</html>