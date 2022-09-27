import models.Product
import org.jetbrains.kotlinx.dataframe.DataFrame
import org.jetbrains.kotlinx.dataframe.api.cast
import org.jetbrains.kotlinx.dataframe.api.print
import org.jetbrains.kotlinx.dataframe.io.readCSV

fun main() {

    val fileToRead = DataFrame.readCSV("./data/products.csv")
    fileToRead.cast<Product>()
    fileToRead.print()

}