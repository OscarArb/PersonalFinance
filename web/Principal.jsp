<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<!-- Boxicons -->
	<link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
	<link href='https://unpkg.com/boxicons@2.1.4/dist/boxicons.js' rel='stylesheet'>
	<!-- My CSS -->
	<link rel="stylesheet" href="css/principal.css">
    
	<title>Personal Finance V-2.2</title>
        <link rel="shortcut icon" href="img/icon.ico"> 
</head>
<body>
	<!-- SIDEBAR -->
	<section id="sidebar">
		<a href="#" class="brand">
			<i class='bx bxs-smile  bx-lg'></i>
			<span class="text">My Finance</span>
		</a>
        
		<ul class="side-menu top">
			<li class="active">
				<a href="Control?menu=Principal" target="myFrame">
					<i class='bx bxs-dashboard bx-sm' ></i>
					<span class="text">Dashboard</span>
				</a>
			</li>
			<li>
				<a href="Control?menu=Gasto" target="myFrame">
					<i class='bx bxs-shopping-bag-alt bx-sm' ></i>
					<span class="text">Gastos</span>
				</a>
			</li>
			<li>
				<a href="Control?menu=Grafica" target="myFrame">
					<i class='bx bxs-doughnut-chart bx-sm' ></i>
					<span class="text">Graficas</span>
				</a>
			</li>
			<li>
				<a href="Control?menu=Ingreso" target="myFrame">
					<i class='bx bxs-message-dots bx-sm' ></i>
					<span class="text">Ingreso</span>
				</a>
			</li>
			<li>
				<a href="Control?menu=Registros" target="myFrame">
					<i class='bx bxs-group bx-sm' ></i>
					<span class="text">Registrar</span>
				</a>
			</li>
		</ul>
		<ul class="side-menu bottom">
			<li>
				<a href="#">
					<i class='bx bxs-cog bx-sm bx-spin-hover' ></i>
					<span class="text">Configuraciones</span>
				</a>
			</li>
			<li>
				<a href="#" class="logout" name="accion" value="Salir">
					<i class='bx bx-power-off bx-sm bx-burst-hover' ></i>
					<span class="text">Salir</span>
				</a>
			</li>
		</ul>
	</section>
	<!-- SIDEBAR -->



	<!-- CONTENT -->
	<section id="content">
		<!-- NAVBAR -->
<nav>
    <i class='bx bx-menu bx-sm' ></i>
    <a href="#" class="nav-link">Categories</a>
    <form action="#">
        <div class="form-input">
            <input type="search" placeholder="Search...">
            <button type="submit" class="search-btn"><i class='bx bx-search' ></i></button>
        </div>
    </form>
    <input type="checkbox" class="checkbox" id="switch-mode" hidden />
    <label class="swith-lm" for="switch-mode">
        <i class="bx bxs-moon"></i>
        <i class="bx bx-sun"></i>
        <div class="ball"></div>
    </label>

    <!-- Notification Bell -->
    <a href="#" class="notification" id="notificationIcon">
        <i class='bx bxs-bell bx-tada-hover' ></i>
        <span class="num">5</span>
    </a>
    <div class="notification-menu" id="notificationMenu">
        <ul>
            <li>New message from John</li>
            <li>Your order has been shipped</li>
            <li>New comment on your post</li>
            <li>Update available for your app</li>
            <li>Reminder: Meeting at 3PM</li>
        </ul>
    </div>

    <!-- Profile Menu -->
    <a href="#" class="profile" id="profileIcon">
        <img src="img/${usuario.getDni()}.jpg" alt="Profile">
    </a>
    <div class="profile-menu" id="profileMenu">
        <ul>
            <li><a href="#">${usuario.getNombre() }</a></li>
            <li><a href="#">${usuario.getUser()}</a></li>
            <li><a href="#">Cel: ${usuario.getTelefono()}</a></li>
            <form action="Validar" method="POST">
                <button name="accion" value="Salir" class="boton" href="#">Salir</button>
            </form>
        </ul>
    </div>
</nav>
<!-- NAVBAR -->


		<!-- MAIN -->
		<main>
			<iframe name="myFrame" style="height: 100%; width: 100%; border: none;">

            </iframe>
		</main>
		<!-- MAIN -->
	</section>
	<!-- CONTENT -->
	

	<script src="js/principal.js"></script>
</body>
</html>