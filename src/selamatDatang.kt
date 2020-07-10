import java.util.*

fun selamatDatang() {
    var opening: String = """   
    |----------------------------- 
    |Selamat Datang Di Synrgy Mart
    |-----------------------------
    |1. Login Kasir
    |0. Keluar
    """.trimMargin()

    val input = Scanner(System.`in`)

    println(opening)
    util.pertanyaanInt()
    val inputInt = input.nextInt()

    when(inputInt) {
        1 -> {
            login()
        }
        0 -> {
            util.andaYakin()
            when(util.inputString) {
                "Y" -> {
                    util.selesai()
                }
                "N" -> {
                    selamatDatang()
                }
            }
        }
        else -> {
            println("Input yang anda masukkan salah")
            selamatDatang()
        }
    }
}
