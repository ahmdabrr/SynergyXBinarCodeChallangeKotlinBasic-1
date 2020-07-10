import java.util.*

fun loginBerhasil() {
    var opening: String = """   
    |----------------------------- 
    |Selamat Datang ${db.username}
    |-----------------------------
    |1. Checkout Pelangan
    |0. Logout
    |-----------------------------
    """.trimMargin()
    val input = Scanner(System.`in`)

    println(opening)
    util.pertanyaanInt()
    val inputInt = input.nextInt()

    when(inputInt) {
        1 -> {
            checkoutPelanggan()
        }
        0 -> {
            util.andaYakin()
            when(util.inputString) {
                "Y" -> {
                    db.username = ""
                    util.selesai()
                    println("((tekan enter key untuk melanjutkan))")
                    readLine()
                    selamatDatang()
                }
                "N" -> {
                    loginBerhasil()
                }
            }
        }
        else -> {
            println("Input yang anda masukkan salah")
            loginBerhasil()
        }
    }
}
