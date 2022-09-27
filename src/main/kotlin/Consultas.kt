import models.Product
import org.jetbrains.kotlinx.dataframe.DataFrame
import org.jetbrains.kotlinx.dataframe.api.*
import org.jetbrains.kotlinx.dataframe.io.readCSV

fun main() {

    val df = DataFrame.readCSV("./data/products.csv")
    df.cast<Product>()

    println(df.schema())

    println("Numero de productos: " + df.count())

    val numSuppliers = df["supplierID"].distinct().count()
    println("Numero de proveedores: $numSuppliers")

    println("Filtrado por ID proveedor: ")
    // Filtrado entero
    //fileToRead.filter { it["supplierID"] == 2 }.print()

    // Filtrado solo mostrando el nombre del producto
    df.filter { it["supplierID"] == 2 }["productName"].print()

    // Mostramos el producto con el mayor precio
    println("Producto mas caro")
    val filtroPrecio = df.groupBy("productID").aggregate { it.max("unitPrice") into "Max" }
    val precioMax = filtroPrecio["Max"].first()
    println("Precio detectado: $precioMax")
    df.filter { it["unitPrice"] == precioMax }.print()
}