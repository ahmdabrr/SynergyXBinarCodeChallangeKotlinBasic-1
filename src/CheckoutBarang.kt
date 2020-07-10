import java.util.*
import java.text.NumberFormat

interface CheckoutBarang{
    var diskon:Double
    var batasDiskon:Int

    fun opening() {
        println(
            """   
            |----------------------------- 
            |Checkout Pelanggan ${dbBarang.pelanggan}
            |-----------------------------
            """.trimMargin()
        )
    }

    fun inputBarang() {
        val input = Scanner(System.`in`)
        opening()

        print("Input Nama Barang : ")
        val inputnama = input.nextLine()
        dbBarang.namaBarang.add(inputnama)

        print("Input Harga Satuan Barang : ")
        val inputharga = input.nextInt()
        dbBarang.hargaBarang.add(inputharga)

        print("Input Jumlah Barang : ")
        val inputjumlah = input.nextInt()
        dbBarang.jumlahBarang.add(inputjumlah)

        dbBarang.i++
    }

    fun hasilInputBarang() {
        val localeID = Locale("in", "ID")
        val numberFormat = NumberFormat.getCurrencyInstance(localeID)

        opening()
        val rangeLoop = dbBarang.i-1
        for (loop in 0..rangeLoop) {
            println("${dbBarang.namaBarang[loop]} X ${dbBarang.jumlahBarang[loop]}    : ${numberFormat.format(dbBarang.hargaBarang[loop] * dbBarang.jumlahBarang[loop]).toString()} ")
            dbBarang.totalSemua = dbBarang.totalSemua + (dbBarang.hargaBarang[loop] * dbBarang.jumlahBarang[loop])
        }
    }

    fun totalBelanja() {
        val localeID = Locale("in", "ID")
        val numberFormat = NumberFormat.getCurrencyInstance(localeID)
        println(
            """   
            |----------------------------- 
            |Total Belanja : ${numberFormat.format(dbBarang.totalSemua).toString()}
            |-----------------------------
            """.trimMargin()
        )
    }

    fun diskon() {
        val localeID = Locale("in", "ID")
        val numberFormat = NumberFormat.getCurrencyInstance(localeID)

        println(
            """   
            |Selamat! Karena total belanjaan lebih 
            |besar dari ${numberFormat.format(batasDiskon).toString()}, maka 
            |mendapatkan potongan sebesar $diskon%. 
            |Cukup Bayar ${numberFormat.format(dbBarang.totalSemua-(dbBarang.totalSemua*diskon/100)).toString()}
            |-----------------------------
            """.trimMargin()
        )
        dbBarang.totalSemua = dbBarang.totalSemua-(dbBarang.totalSemua*diskon/100)
        println("((tekan enter key untuk melanjutkan))")
        readLine()
    }

    fun Bayar() {
        val input = Scanner(System.`in`)
        val localeID = Locale("in", "ID")
        val numberFormat = NumberFormat.getCurrencyInstance(localeID)

        opening()
        print( """   
            |Total Belanja : ${numberFormat.format(dbBarang.totalSemua).toString()}
            |Input Uang Customer :
            """.trimMargin()
        )
        val bayar = input.nextInt()
        if (bayar < dbBarang.totalSemua){
            println( """
            |-----------------------------
            |Mohon maaf, uang yang anda bayarkan kurang
            |Proses pembayaran akan diulangi silahkan masukan nominal uang yang benar
            |-----------------------------
            """.trimMargin()
            )
            println("((tekan enter key untuk melanjutkan))")
            readLine()
            Bayar()
        }
        else {
            println( """   
            |-----------------------------
            |Kembalian : ${numberFormat.format(bayar - dbBarang.totalSemua).toString()}
            |-----------------------------
            |- Terima Kasih - 
            """.trimMargin()
            )
            println("-----------------------------")
            println("((tekan enter key untuk melanjutkan))")
            readLine()
        }

    }

}