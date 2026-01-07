<h1 align="center"> Challenge: Conversor de Monedas en Java </h1>

Este proyecto fue desarrollado para practicar el consumo de APIs, el manejo de datos JSON y la implementación de buenas prácticas en Java (como el uso de Records y HttpClient).

## Caracteristicas
    Conexión a API en tiempo real: Utiliza ExchangeRate-API para obtener las tasas de cambio actuales.

    Conversión de Monedas: Soporte para convertir entre Dólar (USD) y varias monedas latinoamericanas
    
    Interfaz de Consola: Menú interactivo y fácil de usar.

    Arquitectura Limpia: Separación de responsabilidades entre la consulta a la API, el modelo de datos y la interacción con el usuario.

*[Conversiones disponibles](#Conversiones-disponibles)
- `🇦🇷 Peso Argentino (ARS)`
- `🇧🇴 Boliviano (BOB)`
- `🇧🇷 Real Brasileño (BRL)`
- `🇨🇱 Peso Chileno (CLP)`
- `🇨🇴 Peso Colombiano (COP)`


## Tecnologías Utilizadas

  Java 21: Lenguaje principal.

  Gson 2.13.0: Librería de Google para el parseo de JSON a Objetos Java.

  java.net.http: Cliente HTTP nativo de Java para realizar las solicitudes a la API.

## Estructura del Proyecto
  
📦 src

 ┣ 📜 ConsultarMoneda.java: Clase encargada de la conexión HTTP y solicitud a la API.
 
 ┣ 📜 Main.java: Clase principal con el menú y lógica de interacción.
 
 ┗ 📜 Moneda.java: Record (DTO) para mapear la respuesta JSON.

 *[NOTA](#NOTA)

 Para ejecutar este proyecto, debe configurar una Variable de Entorno llamada API_KEY con su propia clave de API
