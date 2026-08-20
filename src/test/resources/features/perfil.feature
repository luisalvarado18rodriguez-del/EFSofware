# language: es
@perfil
Característica: Cierre de sesión

  Escenario: Cerrar sesión regresa al login y bloquea el reingreso con el botón atrás
    Dado que Jaime inició sesión con el usuario "jaime"
    Cuando cierra sesión
    Entonces debería ver la pantalla de login
    Cuando presiona el botón atrás del sistema
    Entonces no debería reingresar al dashboard
