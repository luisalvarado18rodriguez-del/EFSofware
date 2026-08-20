# language: es

Característica: Inicio de sesión en CiberBank
  Como cliente del banco
  Quiero iniciar sesión en la aplicación
  Para consultar el saldo de mis cuentas

  @login
  Escenario: Ingreso exitoso con credenciales válidas
    Dado que Jaime está en la pantalla de login
    Cuando ingresa el usuario "jaime" y la contraseña "Cibertec123"
    Entonces debería ver el saludo "Hola, Jaime Pretell"
    Y el saldo mostrado debería ser "S/ 4,850.00"

  @login
  Escenario: Ingreso con contraseña incorrecta
    Dado que Jaime está en la pantalla de login
    Cuando ingresa el usuario "jaime" y la contraseña "malaClave"
    Entonces debería ver el mensaje de error "Credenciales inválidas"

  @login
  Esquema del escenario: Ingresos rechazados
    Dado que Jaime está en la pantalla de login
    Cuando ingresa el usuario "<usuario>" y la contraseña "<clave>"
    Entonces debería ver el mensaje de error "<mensaje>"

    Ejemplos:
      | usuario   | clave       | mensaje                                |
      | jaime     | otraClave   | Credenciales inválidas                 |
      | bloqueado | Cibertec123 | Usuario bloqueado. Contacte a soporte  |

  @login
  Escenario: Ingreso con campos vacíos
    Dado que Jaime está en la pantalla de login
    Cuando ingresa el usuario "" y la contraseña ""
    Entonces debería ver el error de campo usuario "El usuario es obligatorio"
