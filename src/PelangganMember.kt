import java.util.*

class PelangganMember:CheckoutBarang {
    val input = Scanner(System.`in`)
    override diskon:Double = 9.5
    override batasDiskon:Int = 50000

    fun inputnama() {

    }

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