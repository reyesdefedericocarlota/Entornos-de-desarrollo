package es.stemgranada.pt4.pedidos;

/**
 * Representa un producto disponible en el sistema de pedidos.
 * <p>
 * Un producto se identifica mediante un código único y contiene información
 * descriptiva como su nombre, categoría y precio unitario.
 * </p>
 * <p>
 * Los objetos {@code Producto} se utilizan dentro de {@link LineaPedido}
 * para calcular subtotales y, posteriormente, el total de un {@link Pedido}.
 * </p>
 *
 * @see LineaPedido
 * @see Pedido
 * @author Alumno
 * @version 1.0
 * @since 1.0
 */
public class Producto {

    /**
     * Código identificador único del producto.
     */
    private final String codigo;

    /**
     * Nombre descriptivo del producto.
     */
    private final String nombre;

    /**
     * Categoría a la que pertenece el producto.
     */
    private final String categoria;

    /**
     * Precio unitario del producto.
     */
    private final double precioUnitario;

    /**
     * Crea un producto con la información especificada.
     * <p>
     * El código, nombre y categoría no pueden ser {@code null} ni estar en blanco.
     * El precio unitario debe ser mayor o igual que {@code 0}.
     * </p>
     *
     * @param codigo identificador único del producto; no puede ser {@code null} ni vacío
     * @param nombre nombre del producto; no puede ser {@code null} ni vacío
     * @param categoria categoría del producto; no puede ser {@code null} ni vacía
     * @param precioUnitario precio unitario del producto; debe ser mayor o igual que {@code 0}
     *
     * @throws IllegalArgumentException si {@code codigo}, {@code nombre} o {@code categoria}
     *                                  son {@code null} o están en blanco, o si
     *                                  {@code precioUnitario} es negativo
     *
     * @since 1.0
     */
    public Producto(String codigo,
            String nombre,
            String categoria,
            double precioUnitario) {

        if (codigo == null || codigo.isBlank()) {
            throw new IllegalArgumentException("El código no puede estar vacío");
        }

        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }

        if (categoria == null || categoria.isBlank()) {
            throw new IllegalArgumentException("La categoría no puede estar vacía");
        }

        if (precioUnitario < 0) {
            throw new IllegalArgumentException("El precio no puede ser negativo");
        }

        this.codigo = codigo;
        this.nombre = nombre;
        this.categoria = categoria;
        this.precioUnitario = precioUnitario;
    }

    /**
     * Devuelve el código identificador del producto.
     *
     * @return código del producto
     * @since 1.0
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Devuelve el nombre del producto.
     *
     * @return nombre del producto
     * @since 1.0
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Devuelve la categoría del producto.
     *
     * @return categoría del producto
     * @since 1.0
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * Devuelve el precio unitario del producto.
     *
     * @return precio unitario
     * @since 1.0
     */
    public double getPrecioUnitario() {
        return precioUnitario;
    }
}
