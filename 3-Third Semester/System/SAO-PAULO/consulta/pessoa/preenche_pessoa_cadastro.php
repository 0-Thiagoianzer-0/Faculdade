<?php 
    header('Content-Type: text/html; charset=utf-8');
    $gmtDate = gmdate("D, d M Y H:i:s");
    header("Expires: {$gmtdate} GMT");
    header("Last-Modified: {$gmtDate} GMT");
    header("Cache-Control: no-cache, must-revalidate");
    header("Progma: no-cache");
    include('../../include/conexao.php'); 
    $pessoa = $_POST['pessoa'];
    $preenche=0;                

    $consulta = pg_query("SELECT * FROM pessoa WHERE codigo_pessoa=$pessoa");
    $y = pg_fetch_array($consulta);
    //RETORNOS
    $preenche .=  "|" . $y['codigo_pessoa'];
    $preenche .=  "|" . $y['tipo_pessoa'];
    $preenche .=  "|" . $y['nome_razao_social'];
    $preenche .=  "|" . $y['cpf_cnpj'];
    $preenche .=  "|" . $y['identidade'];
    $preenche .=  "|" . $y['codigo_orgao_emissor'];
    $preenche .=  "|" . $y['titulo_eleitor'];
    $preenche .=  "|" . $y['sexo'];
    $preenche .=  "|" . $y['nome_fantasia'];
    $preenche .=  "|" . $y['responsavel'];
    $preenche .=  "|" . $y['codigo_estado'];
    $preenche .=  "|" . $y['inscricao_estadual'];
    $preenche .=  "|" . $y['inscricao_municipal'];
    $preenche .=  "|" . $y['codigo_cidade'];
	$preenche .=  "|" . $y['cep'];
    $preenche .=  "|" . $y['endereco'];
    $preenche .=  "|" . $y['numero'];
    $preenche .=  "|" . $y['complemento'];
    $preenche .=  "|" . $y['bairro'];
    $preenche .=  "|" . $y['telefone'];
    $preenche .=  "|" . $y['telefone_adicional'];
    $preenche .=  "|" . $y['observacao'];
    $preenche .=  "|" . $y['ativo'];
    
    echo $preenche;
?>