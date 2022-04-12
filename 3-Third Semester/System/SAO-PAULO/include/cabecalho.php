<?php
    $CorInicial = ' style="color: white;" ';
    $CorAlterarSenha = ' style="color: white;" ';
    $CorCadastros = 'color: #FFF; ';
    $CorProtocolos = 'color: #FFF; ';
    $CorRelatorios = 'color: #FFF; ';
    $CorAdministrador = 'color: #FFF; ';
    if ($PaginaAtual == "Inicial"){
        $CorInicial = ' style="color: #FFFF00;" ';
    }elseif ($PaginaAtual == "Cadastro"){
        $CorCadastros = 'color: #FFFF00; ';
    }elseif ($PaginaAtual == "Protocolos"){
        $CorProtocolos = 'color: #FFFF00; ';
    }elseif ($PaginaAtual == "Relatorios"){
        $CorRelatorios = 'color: #FFFF00; ';
    }elseif ($PaginaAtual == "AlterarSenha"){
        $CorAlterarSenha = ' style="color: #FFFF00;" ';
    }
?>

<header style="background-color: #020252;"> 
    <div> 
        <div>                 	
            <h1 style="margin: 10px">
                <a href="index.php">
                    <img style="height: 60px;" src="images/Logo.png" alt="">
                </a>
            </h1>
            <nav id="menu">
                <ul class="navigation">
					<li <?php echo "$CorInicial"; ?> ><a <?php echo "$CorInicial"; ?> href="index.php">Inicial</a></li>
                    <?php
						//CADASTROS
						echo "<li style = \" $CorCadastros cursor: default;\" >Cadastros<ul style='width:160px'>";
							echo "<li style='background: #F5F5F5; width:160px'><a href='cadastro_estado.php'>Estado</a></li>";
							echo "<li style='background: #F5F5F5; width:160px'><a href='cadastro_cidade.php'>Cidade</a></li>";
							echo "<li style='background: #F5F5F5; width:160px'><a href='cadastro_orgao_emissor.php'>Órgão Emissor</a></li>";
							echo "<li style='background: #F5F5F5; width:160px'><a href='cadastro_pessoa.php'>Pessoa</a></li>";
							echo "<li style='background: #F5F5F5; width:160px'><a href='cadastro_produto.php'>Produto</a></li>";
							echo "<li style='background: #F5F5F5; width:160px'><a href='cadastro_tipo_produto.php'>Tipo Produto</a></li>";
							echo "<li style='background: #F5F5F5; width:160px'><a href='cadastro_usuario.php'>Usuário</a></li>";
						echo "</ul></li>";
						//PROTOCOLOS
						echo "<li style = \" $CorProtocolos cursor: default;\" >Processos<ul style='width:160px;'>";
						echo "<li style='background: #F5F5F5; width:160px'><a href='novo_servico.php'>Novo Serviço</a></li>";
						echo "<li style='background: #F5F5F5; width:160px'><a href='monitora_servico.php'>Monitorar</a></li>";
						echo "</ul></li>";
                    ?>
                    <li <?php echo "$CorAlterarSenha"; ?> ><a <?php echo "$CorAlterarSenha"; ?> href="alterar_senha.php">Alterar Senha</a></li>
                    <li style="color: white;" ><a style="color: white;" href="logout.php">Sair</a></li>
                </ul>
                </nav>
            <div class="clear"></div>
        </div>
    </div>
</header>