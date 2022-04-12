<?php 
    header('Content-Type: text/html; charset=utf-8');
    $gmtDate = gmdate("D, d M Y H:i:s");
    header("Expires: {$gmtdate} GMT");
    header("Last-Modified: {$gmtDate} GMT");
    header("Cache-Control: no-cache, must-revalidate");
    header("Progma: no-cache");
    include('../../include/conexao.php');
    $usuario = $_POST['usuario'];
    $preenche=0;

    $consulta = pg_query("SELECT * FROM usuario WHERE codigo_usuario=$usuario");
    $y = pg_fetch_array($consulta);
    //RETORNOS
    $preenche .=  "|" . $y['codigo_usuario'];
	$preenche .=  "|" . $y['codigo_pessoa'];
    $preenche .=  "|" . $y['email'];
    $preenche .=  "|" . $y['ativo'];
    
    echo $preenche;
?>