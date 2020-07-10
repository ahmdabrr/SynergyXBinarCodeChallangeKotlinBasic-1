import java.util.*

fun login() {
    var opening: String = """   
    |----------------------------- 
    |Selamat Datang Di Synrgy Mart
    |-----------------------------
    |+Login Kasir+
    """.trimMargin()
    val input = Scanner(System.`in`)

    println(opening)
    print("Username :")
    val inputUsername = input.nextLine()
    print("Password :")
    val inputPassword = input.nextLine()

    when(db.data.containsKey(inputUsername)) {
        true -> {
            if (db.data.get(inputUsername) == inputPassword) {
                db.username = inputUsername
                println("login success")
                println("((tekan enter key untuk melanjutkan ke halaman berikutnya))")
                readLine()
                loginBerhasil()
            } else {
                println("password tidak sesuai dengan username")
                println("((tekan enter key untuk kembali ke halaman login))")
                readLine()
                login()
            }
        }
        false -> {
            println("username tidak ditemukan")
            println("((tekan enter key untuk kembali ke halaman login))")
            readLine()
            login()
        }

    }
}