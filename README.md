# 3P Lab1 Tapia

Practica de laboratorio sobre principios AAA y pruebas de repositorios y controladores en Spring Boot.

## Componentes implementados

- `Pedido`: entidad JPA con `id`, `cliente`, `total` y `estado`.
- `PedidoRepository`: repositorio Spring Data JPA con `findByEstado(String estado)`.
- `PedidoService`: servicio que consulta pedidos por estado.
- `PedidoController`: endpoint REST `GET /api/pedidos?estado=PENDIENTE`.
- `PedidoRepositoryTest`: prueba con `@DataJpaTest` y comentarios Arrange, Act y Assert.
- `PedidoControllerTest`: prueba con `@WebMvcTest`, `@MockBean`, Mockito y comentarios Arrange, Act y Assert.

## Ejecucion

```bash
mvn test
```

## Checkpoint

`@DataJpaTest` carga solo la capa de persistencia, usando una base H2 en memoria para probar el repositorio sin levantar toda la aplicacion.

`@WebMvcTest` carga solo la capa web, por eso permite probar el controlador y sus rutas sin usar una base de datos real.

`@MockBean` se usa en la prueba del controlador para reemplazar `PedidoService` por un objeto simulado con Mockito. Asi el test valida la respuesta HTTP del controlador de forma aislada.
