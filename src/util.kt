import java.util.*

object util {
    var inputString:String = ""
    var inputInt:Int = 0

    fun pertanyaanInt() {
        print("Pilih dengan menginput angka : ")
    }

    fun pertanyaanString() {
        print("Pilih dengan menginput huruf : ")
    }

    fun andaYakin() {
        println("""   
            |----------------------------- 
            |Apakah anda sudah yakin?(Y/N)
            |-----------------------------
            """.trimMargin())
        val input = Scanner(System.`in`)

        util.pertanyaanString()
        inputString = input.nextLine()
    }

    fun selesai() {
        println("")
        print("- Terimakasih -")
    }
}