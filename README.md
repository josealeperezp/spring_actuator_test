# spring_actuator_test
Instrucciones para probar programa

1. Ejecutar programa.

2. Hacer una petición a localhost:9000/hello-world. Esto demorará unos segundos. Es intencional esta demora ya que se ha colocado un sleep en el código para simular un retardo en la respuesta y esto quede reflejado en Spring Actuator.

3. Existe un demonio que cada 10 segundos consulta por métricas asociadas al endpoint previamente ejecutado. Tan pronto como termine al menos una invocación del endpoint anterior, se mostrarán estadísticas de los métodos usados en la resolución de la respuesta.
