<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="util.Resultado,dominio.*, java.util.*"%>
<!DOCTYPE HTML>
<html>

<head>
<title>ME - Contato</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="UTF-8">
<!-- Font -->
<link
	href="https://fonts.googleapis.com/css?family=Poppins:400,500,600,700%7CAllura"
	rel="stylesheet">
<!-- Stylesheets -->
<link href="../estilos/geral/bootstrap.css" rel="stylesheet">
<link href="../estilos/geral/ionicons.css" rel="stylesheet">
<link href="../estilos/contato/css/styles.css" rel="stylesheet">
<link href="../estilos/contato/css/responsive.css" rel="stylesheet">
<link href="../estilos/geral/estilo.css" rel="stylesheet">
</head>

<body>
	<%
		PessoaFisica pf = (PessoaFisica) request.getAttribute("pf");
	%>

	<header>
		<div class="container">
			<!-- <a class="logo" href="#"><img src="images/logo-with-bg.jpg" alt="Logo"></a> -->
			<div class="menu-nav-icon" data-nav-menu="#main-menu">
				<i class="icon ion-navicon"></i>
			</div>
			<ul class="main-menu visible-on-click" id="main-menu">
				<li><a href="index.html">Home</a></li>
				<li><a href="anuncios.html">Anúncios</a></li>
				<li><a href="musicos.html">Músicos</a></li>
				<li><a href="contato.html">Contato</a></li>
				<li><a href="login.html">Entrar</a></li>
				<li><a href="cadastro.html">Cadastrar</a></li>
			</ul>
		</div>
		<!-- container -->
	</header>
	<div class="main-slider"
		style="background-image: url(../imagens/alberto.jpg); height: 700px">
		<div class="display-table center-text">
			<div class="display-table-cell">
				<div class="slider-content">
					<div class="col-md-12">
						<div class="row">
							<div class="col-md-6">
								<div class="card">
									<div class="card-header ">
										<p class="text-center">Músico</p>
									</div>
									<form action="SalvarMusico" method="POST">
										<div class="card-body campos-cadastro">
											<div class="col-md-12 mt-3">
												<div class="row">
													<div class="col-md-6">
														<input class="form-control margin-b-30" type="text"
															placeholder="Nome Artístico" id="txtNome" name="txtNome">
													</div>
													<div class="col-md-6 ">
														<input class="form-control margin-b-30" type="text"
															placeholder="CPF" id="txtCpf" name="txtCpf">
													</div>
												</div>
											</div>
											<div class="col-md-12">
												<div class="row">
													<div class="col-md-6">
														<input class="form-control margin-b-30" type="text"
															placeholder="Estado" id="txtEstado" name="txtEstado">
													</div>
													<div class="col-md-6">
														<input class="form control margin-b-30" type="text"
															placeholder="Cidade" id="txtCidade" name="txtCidade">
													</div>
												</div>
											</div>
											<div class="col-md-12">
												<div class="row">

													<div class="col-md-6">
														<input class="form-control margin-b-30" type="tel"
															placeholder="Telefone" id="txtTelefone"
															name="txtTelefone">
													</div>
													<div class="col-md-6">
														<input class="form-control margin-b-30" type="text"
															placeholder="Nome de usuário" id="txtNomeUsuario"
															name="txtNomeUsuario">
													</div>

												</div>
											</div>
											<div class="col-md-12">
												<div class="row">
													<div class="col-md-12">
														<input class="form-control margin-b-30" type="email"
															placeholder="E-mail" id="txtEmail" name="txtEmail">
													</div>
												</div>
											</div>
											<div class="col-md-12">
												<div class="row">
													<div class="col-md-6">
														<input class="form-control margin-b-30" type="password"
															placeholder="Senha" id="txtSenha" name="txtSenha">
													</div>
													<div class="col-md-6">
														<input class="form-control margin-b-30" type="password"
															placeholder="Senha de confirmação"
															name="txtConfirmacaoSenha" id="txtConfirmacaoSenha">
													</div>

												</div>
											</div>
											<div class="col-md-12 text-center mb-3">
												<button type="submit" class="btn btn-fill" id="operacao"
													name="operacao" value="SALVAR">
													<b>Cadastrar</b><i class="ion-chevron-right"></i><i
														class="ion-chevron-right"></i>
												</button>
											</div>

										</div>
									</form>
								</div>
							</div>
							<div class="col-md-6">
								<div class="card ">
									<div class="card-header ">
										<p class="text-center ">Contratante</p>
									</div>
									<form>
										<div class="card-body campos-cadastro">
											<div class="col-md-12 mt-3">
												<div class="row">
													<div class="col-md-6">
														<input class="form-control margin-b-30" type="text"
															placeholder="Nome" id="txtNome">
													</div>
													<div class="col-md-6">
														<input class="form control margin-b-30" type="text"
															placeholder="CPF/CNPJ" id="txtDocumento">
													</div>
												</div>
											</div>
											<div class="col-md-12">
												<div class="row">
													<div class="col-md-6">
														<input class="form-control margin-b-30" type="text"
															placeholder="Estado" id="txtEstadoContratante">
													</div>
													<div class="col-md-6">
														<input class="form control margin-b-30" type="text"
															placeholder="Cidade" id="txtCidadeContratante">
													</div>
												</div>
											</div>
											<div class="col-md-12">
												<div class="row">

													<div class="col-md-6">
														<input class="form-control margin-b-30" type="tel"
															placeholder="Telefone" id="txtTelefoneContratante">
													</div>
													<div class="col-md-6">
														<input class="form-control margin-b-30" type="text"
															placeholder="Nome de usuário"
															id="txtNomeUsuarioContratante">
													</div>
												</div>
											</div>
											<div class="col-md-12">
												<div class="row">

													<div class="col-md-12">
														<input class="form-control margin-b-30" type="email"
															placeholder="E-mail" id="txtEmailContratante">
													</div>
												</div>
											</div>
											<div class="col-md-12">
												<div class="row">
													<div class="col-md-6">
														<input class="form-control margin-b-30" type="password"
															placeholder="Senha" id="txtSenhaContratante">
													</div>
													<div class="col-md-6">
														<input class="form-control margin-b-30" type="password"
															placeholder="Senha de confirmação"
															id="txtSenhaConfirmacao">
													</div>

												</div>
											</div>
											<div class="col-md-12 text-center mb-3">
												<button type="submit" class="btn btn-fill">
													<b>Cadastrar</b><i class="ion-chevron-right"></i><i
														class="ion-chevron-right"></i>
												</button>
											</div>
										</div>
									</form>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- slider-content-->
		</div>
		<!--display-table-cell-->
	</div>
	<!-- display-table-->

	<footer>
		<div class="container-fluid">
			<div class="row">
				<div class="col-xs-12 col-md-4" align="center">
					<!-- <a class="logo margin-b-10" href="#"><img src="images/logo-white.png" alt="Logo"></a> -->
				</div>
				<div class="col-xs-12 col-md-4" align="center">
					<p class="font-black-lite copyright">
						Copyright &copy;
						<script>
							document.write(new Date().getFullYear());
						</script>
						All rights reserved | This template is made with <i
							class="ion-heart" aria-hidden="true"></i> by <a
							href="https://colorlib.com" target="_blank">Colorlib</a>
					</p>
				</div>
				<div class="col-xs-12 col-md-4" align="center">
					<ul>
						<li class="mr-3"><a href="https://pt-br.facebook.com/"
							target="_blank"><i class="ion-social-facebook font-size-2"></i></a></li>
						<li class="mr-3"><a href="https://twitter.com/"
							target="_blank"><i class="ion-social-twitter font-size-2"></i></a></li>
						<li class="mr-3"><a href="https://br.linkedin.com/"
							target="_blank"><i
								class="ion-social-linkedin-outline font-size-2"></i></a></li>
						<li><a href="https://www.youtube.com/?gl=BR&hl=pt"
							target="_blank"><i class="ion-social-youtube font-size-2"></i></a></li>
					</ul>
				</div>
			</div>
			<!-- row -->
		</div>
		<!-- container -->
	</footer>
	<!-- SCRIPTS -->
	<script src="../javascripts/geral/jquery-3.1.1.min.js"></script>
	<script src="../javascripts/geral/tether.min.js"></script>
	<script src="../javascripts/geral/bootstrap.js"></script>
	<script src="../javascripts/geral/scripts.js"></script>
</body>

</html>
