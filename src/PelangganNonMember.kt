import java.util.*

class PelangganNonMember():CheckoutBarang {
    val input = Scanner(System.`in`)
    override diskon:Double = 4.1
    override batasDiskon:Int = 70000

    fun inputBarangLoop() {
        inputBarang()
        println("-----------------------------")
        print("Input Barang Lagi? (Y/N)")
        val tanya = input.nextLine()

        when(tanya) {
            "Y" -> inputBarangLoop()
            "N" -> println("cek")
            "else" -> println("cekelse")
        }
    }





}