

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login | Personal Finance V-2.1</title>
    <link rel="stylesheet" href="css/styles.css">
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
    <link rel="shortcut icon" href="img/icon.ico"> 
</head>
<body>
    <div class="container">
        <div class="form-box login">
                <form  action="Validar" method="POST">
                <h1>Ingresar</h1>
                <div class="input-box">
                    <input type="text" placeholder="Username" name="txtuser" required>
                    <i class='bx bxs-user'></i>
                </div>
                <div class="input-box">
                    <input type="password" placeholder="Password" name="txtpass" required>
                    <i class='bx bxs-lock-alt' ></i>
                </div>
                <div class="forgot-link">
                    <a href="#">Olvide mi contraseña?</a>
                </div>
                <button type="submit" class="btn" name="accion" value="Ingresar">Login</button>
                <p>o ingresar con</p>
                <div class="social-icons">
                    <a href="#"><i class='bx bxl-google' ></i></a>
                    <a href="#"><i class='bx bxl-facebook' ></i></a>
                </div>
            </form>
        </div>

        <div class="form-box register">
            <form action="Validar" method="POST">
                <h1>Registrar</h1>
                <div class="input-box">
                    <input type="text" placeholder="Nombres" name="newNombre" required>
                    <i class='bx bxs-user'></i>
                </div>
                <div class="input-box">
                    <input type="number" placeholder="Telefono" name="newTel" required>
                    <i class='bx bxs-phone'></i>
                </div>
                <div class="input-box">
                    <input type="text" placeholder="Usuario" name="newUser" required>
                    <i class='bx bxs-envelope' ></i>
                </div>
                <div class="input-box">
                    <input type="password" placeholder="Password" name="newPas" required>
                    <i class='bx bxs-lock-alt' ></i>
                </div>
                <button type="submit" class="btn" name="accion" value="Registrar">Register</button>
                <p>o registrar con</p>
                <div class="social-icons">
                    <a href="#"><i class='bx bxl-google' ></i></a>
                    <a href="#"><i class='bx bxl-facebook' ></i></a>
                </div>
            </form>
        </div>

        <div class="toggle-box">
            <div class="toggle-panel toggle-left">
                <h1>Hola, Bienvenido!</h1>
                <p>Deseo crear una cuenta?</p>
                <button class="btn register-btn">Registrar</button>
            </div>

            <div class="toggle-panel toggle-right">
                <h1>Bienvenido!</h1>
                <p>Deseo Ingresar?</p>
                <button class="btn login-btn">Login</button>
            </div>
        </div>
    </div>

    <script src="js/scrip_login.js"></script>
</body>
</html>

