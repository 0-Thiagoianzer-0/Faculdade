<?php
    session_start();
    require_once('include/conexao.php');
    $mensagem_erro = "";
    if(isset($_POST['logar'])){
        $email = $_POST['txtEmail'];
        $senha = $_POST['txtSenha'];
		$senha = md5($senha);
        if($email == "" || $email == null){
            $mensagem_erro = "Faltou o login!";
        }else if($senha == "" || $senha == null){
            $mensagem_erro = "Faltou a senha!";
        }else{
			//LOGIN USUÁRIO
			$sql = "SELECT u.codigo_usuario, u.email, u.senha, p.nome_razao_social ";
			$sql .= "FROM usuario u ";
			$sql .= "INNER JOIN pessoa p ON p.codigo_pessoa = u.codigo_pessoa ";
			$sql .= "WHERE u.email = '$email' AND u.senha = '$senha' AND u.ativo = 'true' ";
			
			$query = pg_query($sql);
			$num = pg_num_rows($query);
			$data = pg_fetch_assoc($query);
			
            if($num > 0){
                $_SESSION['codigo_usuario'] = $data['codigo_usuario'];
                $_SESSION['nome_pessoa'] = $data['nome_razao_social'];
                $_SESSION['email'] = $data['email'];
                $_SESSION['senha'] = $data['senha'];
                header("location: index.php");
				exit;
            }else{
                $mensagem_erro = "Login ou senha incorretos!";
            }
        }
    }
?>

<html>
    <head>
		<meta charset="utf-8">
        <title>Login Sistema São Paulo</title>
		<link rel="shortcut icon" href="images/icon.ico"/>
		<link rel="stylesheet" href="css/bootstrap.css">
		<link rel="stylesheet" href="css/glyphicons/css/glyphicons.css">
    </head>

    <body style="background-color: #E6E6E6">
        <div class="container" style="width: 500px; margin-top: 150px;">
            <div class="container" id="login_logar" style="background-color: white; border-radius: 4px; width: 500px;">
                <form enctype="multipart/form-data" method="POST">
					<div class="form-row">
						<div class="form-group col-md-12" style="margin-top: 5px; text-align:left;">
								<div style="font-size: 35px; color: #666666;">Login</div>
								<div style="font-size: 15px; color: #666666;">Acesse sua conta</div>
						</div>
					</div>
					<div class="form-row">
						<div class="form-group col-md-12">
							<input
								type="text"
								class="form-control"
								name="txtEmail"
								id="txtEmail"
								placeholder="Email"
								maxlength="100"
								value="hariel.0371@gmail.com"
							/>
						</div>
					</div>
					<div class="form-row">
						<div class="form-group col-md-12">
                            <input
                                type="password"
                                class="form-control"
                                name="txtSenha"
                                id="txtSenha"
                                placeholder="Senha"
                                maxlength="100"
								value="5351"
                            />
						</div>
					</div>
					<div class="form-row">
                        <div class="form-group col-md-12">
                            <button type="submit" class="btn btn-primary btn-md btn-block" id="logar" name="logar">Acessar
								<span class="glyphicon glyphicon-ok-sign"></span>
							</button>
                        </div>
                    </div>
					<div class="form-row" style="text-align:center; margin-bottom:10px;" id="divErro">
						<div class="form-group col-md-12">
							<?php echo ($mensagem_erro); ?>
						</div>
					</div>
                </form>
            </div>
        </div>
    </body>
</html>