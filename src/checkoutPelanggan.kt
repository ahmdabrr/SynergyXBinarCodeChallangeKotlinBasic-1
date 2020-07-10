import java.util.*

fun checkoutPelanggan() {
    var opening: String = """   
    |----------------------------- 
    |      Checkout Pelanggan
    |-----------------------------
    |1. Checkout Member
    |2. Pelanggan Non-Member
    |-----------------------------
    """.trimMargin()
    val input = Scanner(System.`in`)

    println(opening)
    util.pertanyaanInt()
    val inputInt = input.nextInt()

    when(inputInt) {
        1 -> {
            PelangganMember().inputBarangLoop()
            PelangganMember().hasilInputBarang()
            PelangganMember().totalBelanja()
            if (dbBarang.totalSemua > PelangganMember().batasDiskon)
            {PelangganMember().diskon()}
        }
        2 -> {
            PelangganNonMember().inputBarangLoop()
            PelangganNonMember().hasilInputBarang()
            PelangganNonMember().totalBelanja()
            if (dbBarang.totalSemua > PelangganNonMember().batasDiskon)
            {PelangganNonMember().diskon()}
        }
        else -> {
            println("Input yang anda masukkan salah")
            checkoutPelanggan()
        }
    }
}
