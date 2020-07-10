import java.util.*

class PelangganNonMember():CheckoutBarang {
    val input = Scanner(System.`in`)
    override var diskon = 4.1
    override var batasDiskon = 70000


    fun inputBarangLoop() {
        inputBarang()
        println("-----------------------------")
        print("Input Barang Lagi? (Y/N) ")
        val tanya = input.nextLine()

        when(tanya) {
            "Y" -> inputBarangLoop()
            else -> {
                println("((tekan enter key untuk melanjutkan))")
                readLine()
            }

        }
    }





}