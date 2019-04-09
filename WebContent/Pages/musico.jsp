<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <link rel="apple-touch-icon" sizes="76x76" href="../assets/img/apple-icon.png">
  <link rel="icon" type="image/png" href="../assets/img/exclamacao.png">
  <title>Me Encontra</title>
  <!--     Fonts and icons     -->
  <link href="https://fonts.googleapis.com/css?family=Poppins:200,300,400,600,700,800" rel="stylesheet" />
  <link href="https://use.fontawesome.com/releases/v5.0.6/css/all.css" rel="stylesheet">
  <!-- Nucleo Icons -->
  <link href="../assets/css/nucleo-icons.css" rel="stylesheet" />
  <!-- CSS Files -->
  <link href="../assets/css/black-dashboard.css?v=1.0.0" rel="stylesheet" />
  <!-- CSS Just for demo purpose, don't include it in your project -->
  <link href="../assets/demo/demo.css" rel="stylesheet" />
  <link href="../assets/css/estilo.css" rel="stylesheet" />
</head>

<body class="">
  <div class="wrapper">
    <div class="sidebar">
      <!--
        Tip 1: You can change the color of the sidebar using: data-color="blue | green | orange | red"
    -->
      <div class="sidebar-wrapper">
        <div class="logo">
          <a href="javascript:void(0)" class="simple-text logo-mini">
            ME
          </a>
          <a href="javascript:void(0)" class="simple-text logo-normal">
            M�sico
          </a>
        </div>
        <ul class="nav">
          <li class="active ">
            <a href="./musico.html">
              <i class="tim-icons icon-single-02"></i>
              <p>Meus dados</p>
            </a>
          </li>
          <li>
              <a href="./candidaturas.html">
                <i class="tim-icons icon-money-coins"></i>
                <p>Contratos e Candidaturas</p>
            </a>
          </li>
        </ul>
      </div>
    </div>
    <div class="main-panel">
      <!-- Navbar -->
      <nav class="navbar navbar-expand-lg navbar-absolute navbar-transparent">
        <div class="container-fluid">
          <div class="navbar-wrapper">
            <div class="navbar-toggle d-inline">
              <button type="button" class="navbar-toggler">
                <span class="navbar-toggler-bar bar1"></span>
                <span class="navbar-toggler-bar bar2"></span>
                <span class="navbar-toggler-bar bar3"></span>
              </button>
            </div>
            <a class="navbar-brand" href="javascript:void(0)">Me Encontra!</a>
          </div>
          <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navigation"
            aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-bar navbar-kebab"></span>
            <span class="navbar-toggler-bar navbar-kebab"></span>
            <span class="navbar-toggler-bar navbar-kebab"></span>
          </button>
          <div class="collapse navbar-collapse" id="navigation">
            <ul class="navbar-nav ml-auto">
              <li class="search-bar input-group">
                <button class="btn btn-link" id="search-button" data-toggle="modal" data-target="#searchModal"><i
                    class="tim-icons icon-zoom-split"></i>
                  <span class="d-lg-none d-md-block">Pesquisar</span>
                </button>
              </li>

              <li class="dropdown nav-item">
                <a href="#" class="dropdown-toggle nav-link" data-toggle="dropdown">
                  <div class="photo">
                    <img src="../assets/img/emilyz.jpg" alt="Profile Photo">
                  </div>
                  <b class="caret d-none d-lg-block d-xl-block"></b>
                  <p class="d-lg-none">
                    Log out
                  </p>
                </a>
                <ul class="dropdown-menu dropdown-navbar">
                  <li class="nav-link">
                    <a href="javascript:void(0)" class="nav-item dropdown-item">Perfil</a>
                  </li>
                  <li class="nav-link">
                    <a href="javascript:void(0)" class="nav-item dropdown-item">Configura��es</a>
                  </li>
                  <li class="dropdown-divider"></li>
                  <li class="nav-link">
                    <a href="javascript:void(0)" class="nav-item dropdown-item">Sair</a>
                  </li>
                </ul>
              </li>
              <li class="separator d-lg-none"></li>
            </ul>
          </div>
        </div>
      </nav>
      <div class="modal modal-search fade" id="searchModal" tabindex="-1" role="dialog" aria-labelledby="searchModal"
        aria-hidden="true">
        <div class="modal-dialog" role="document">
          <div class="modal-content">
            <div class="modal-header">
              <input type="text" class="form-control" id="inlineFormInputGroup" placeholder="Pesquisar">
              <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                <i class="tim-icons icon-simple-remove"></i>
              </button>
            </div>
          </div>
        </div>
      </div>
      <!-- End Navbar -->
      <div class="content">
        <div class="row">

          <div class="col-md-12">
            <div class="card">
              <div class="card-body">
                <form action="VisualizarDadosMusico" method="GET">
                  <div class="row">
                    <div class="col-md-5" align="center">
                      <a>
                        <img class="avatar" src="../assets/img/emilyz.jpg" alt="..." style="size: 10rem;">
                      </a>
                      <div class="col-md-6 estrelas" align="center">
                        <i class="fas fa-star fa-2x"></i>
                        <i class="fas fa-star fa-2x"></i>
                        <i class="fas fa-star fa-2x"></i>
                        <i class="fas fa-star fa-2x"></i>
                        <i class="fas fa-star fa-2x"></i>
                      </div>
                    </div>
                    <div class="col-md-7">
                      <div class="form-group">
                        <label for="txtNomeArtistico">Nome Art�stico</label>
                        <input type="text" name="txtNomeArtistico" id="txtNomeArtistico" class="form-control "
                          placeholder="Digite seu nome art�stico">
                      </div>
                      <div class="row">
                        <div class="col-md-5">
                          <div class="form-group">
                            <label for="txtTempoExperiencia">Tempo de experi�ncia</label>
                            <input type="text" name="txtTempoExperiencia" id="txtTempoExperiencia" class="form-control "
                              placeholder="Digite seu tempo de experi�ncia">
                          </div>
                        </div>
                        <div class="col-md-7">
                          <div class="form-group">
                            <label for="txtEstiloMusical">Estilo Musical</label>
                            <select class="form-control select">
                              <option>MPB</option>
                              <option>POP</option>
                              <option>ROCK</option>
                              <option>SAMBA</option>
                              <option>Sertanejo</option>
                              <option>Pr�prio</option>
                              <option>Alernativo</option>
                              <option>Cl�ssico</option>
                            </select>
                          </div>

                        </div>
                      </div>
                      <div class="row">
                        <div class="col-md-12 ">
                          <div class="form-group">
                            <label for="txtTipoArtista">Tipo de artista
                            </label>
                            <select class="form-control">
                              <option>CANTOR</option>
                              <option>VIOLONISTA</option>
                              <option>BATERISTA</option>
                              <option>DJ</option>
                              <option>VIOLINISTA</option>
                              <option>TROMPETISTA</option>
                              <option>VIOLINISTA</option>
                              <option>PIANISTA</option>
                            </select>
                          </div>
                        </div>

                      </div>
                    </div>
                  </div>

                  <div class="row">
                    <div class="col-md-4 ">
                      <div class="form-group">
                        <label for="txtNomeUsuario">Nome de usu�rio</label>
                        <input type="text" name="txtNomeUsuario" id="txtNomeUsuario" class="form-control"
                          placeholder="Digite seu nome de usu�rio">
                      </div>
                    </div>
                    <div class="col-md-5 ">
                      <div class="form-group">
                        <label for="txtEmail">Email</label>
                        <input id="txtEmail" name="txtEmail" type="email" class="form-control" placeholder="Digite seu email">
                      </div>
                    </div>
                    <div class="col-md-3 ">
                      <div class="form-group">
                        <label for="txtTelefone">Telefone</label>
                        <input id="txtTelefone" name="txtTelefone" type="text" class="form-control" placeholder="Digite seu telefone">
                      </div>
                    </div>
                  </div>
                  <div class="row">
                    <div class="col-md-6 ">
                      <div class="form-group">
                        <label for="txtNome">Nome</label>
                        <input id="txtNome" name="txtNome" type="text" class="form-control" placeholder="Digite seu nome">
                      </div>
                    </div>
                    <div class="col-md-6 ">
                      <div class="form-group">
                        <label>Sobrenome</label>
                        <input type="text" name="txtSobreNome" id="txtSobreNome" class="form-control" placeholder="Digite seu sobrenome">
                      </div>
                    </div>
                  </div>

                  <div class="row">
                    <div class="col-md-9 ">
                      <div class="form-group">
                        <label for="txtRua">Rua</label>
                        <input id="txtRua" name="txtRua" type="text" class="form-control" placeholder="Digite o nome da rua">
                      </div>
                    </div>
                    <div class="col-md-3 ">
                      <div class="form-group">
                        <label for="txtNumero">N�mero</label>
                        <input id="txtNumero" name="txtNumero" type="number" class="form-control" placeholder="Digite o n�mero">
                      </div>
                    </div>
                  </div>
                  <div class="row">
                    <div class="col-md-4 ">
                      <div class="form-group">
                        <label>Cidade</label>
                        <input type="text" id="txtCidade" name="txtCidade" class="form-control" placeholder="Digite o nome da cidade">
                      </div>
                    </div>
                    <div class="col-md-4 ">
                      <div class="form-group">
                        <label>Estado</label>
                        <input type="text" id="txtEstado" name="txtEstado" class="form-control" placeholder="Digite o nome do estado">
                      </div>
                    </div>
                    <div class="col-md-4 ">
                      <div class="form-group">
                        <label>CEP</label>
                        <input type="number" id="txtCep" name="txtCep" class="form-control" placeholder="Digite o cep">
                      </div>
                    </div>
                  </div>
                </form>
              </div>
              <div class="card-footer" align="right">
                <button type="submit" id="operacao" name="operacao" value="ATUALIZAR" class="btn btn-fill btn-primary">Atualizar</button>
              </div>
            </div>
          </div>

        </div>
      </div>

    </div>
  </div>
  <!--   Core JS Files   -->
  <script src="../assets/js/core/jquery.min.js"></script>
  <script src="../assets/js/core/popper.min.js"></script>
  <script src="../assets/js/core/bootstrap.min.js"></script>
  <script src="../assets/js/plugins/perfect-scrollbar.jquery.min.js"></script>
  <!--  Google Maps Plugin    -->
  <!-- Place this tag in your head or just before your close body tag. -->
  <script src="https://maps.googleapis.com/maps/api/js?key=YOUR_KEY_HERE"></script>
  <!-- Chart JS -->
  <script src="../assets/js/plugins/chartjs.min.js"></script>
  <!--  Notifications Plugin    -->
  <script src="../assets/js/plugins/bootstrap-notify.js"></script>
  <!-- Control Center for Black Dashboard: parallax effects, scripts for the example pages etc -->
  <script src="../assets/js/black-dashboard.min.js?v=1.0.0"></script>
</body>

</html>