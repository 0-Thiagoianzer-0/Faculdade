<?php 
    session_start();
    
    if(isset($_SESSION["codigo_usuario"]))
        $codigo_usuario = $_SESSION["codigo_usuario"];
    if(isset($_SESSION["nome_pessoa"]))
        $nome_pessoa = $_SESSION["nome_pessoa"];
    if(isset($_SESSION["email"]))
        $email = $_SESSION["email"];
    if(isset($_SESSION["senha"]))
        $senha = $_SESSION["senha"];
    
    $codigo_usuario = addslashes($_SESSION['codigo_usuario']);
    $nome_pessoa = addslashes($_SESSION["nome_pessoa"]);  
    $email = addslashes($_SESSION['email']); 
    $senha = addslashes($_SESSION['senha']);
	
    if(!(empty($email) OR empty($senha) OR empty($codigo_usuario))){
        include_once('conexao.php');
        $resultado = pg_query("SELECT * FROM usuario WHERE email='$email'");
        if(pg_num_rows($resultado)==1){
            if($senha != pg_result($resultado,0,"senha")){
                unset($_SESSION['codigo_usuario']);
                unset($_SESSION['nome_pessoa']);
                unset($_SESSION['email']);
                unset($_SESSION['senha']);
                echo "Você não efetuou o login!";
                exit;
            }
        }else{
            unset($_SESSION['codigo_usuario']);
            unset($_SESSION['nome_pessoa']);
            unset($_SESSION['email']);
            unset($_SESSION['senha']);
            echo "Você não efetuou o login!";
            exit;  
        }
    }else{
		header("location: login.php");
		exit;
	}
?>