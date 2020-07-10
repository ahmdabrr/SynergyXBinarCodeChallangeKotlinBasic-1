import java.util.*

class PelangganMember:CheckoutBarang {
    val input = Scanner(System.`in`)
    override var diskon = 9.5
    override var batasDiskon = 50000

    fun inputNama() {
        print( """   
            |----------------------------- 
            |  Checkout Pelanggan Member
            |-----------------------------
            |Input Nama Member : 
            """.trimMargin()
        )
        val input = Scanner(System.`in`)
        val nama = input.nextLine()
        dbBarang.pelanggan = nama
        println("-----------------------------")
        println("((tekan enter key untuk melanjutkan))")
        readLine()
    }

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