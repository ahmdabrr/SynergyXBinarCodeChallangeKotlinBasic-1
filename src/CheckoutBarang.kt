import java.util.*
import java.text.NumberFormat

interface CheckoutBarang {
    var diskon:Double = 0.0
    var batasDiskon:Int = 0
    val localeID = Locale("in", "ID")
    val numberFormat = NumberFormat.getCurrencyInstance(localeID)

    fun opening() {
        var pelanggan: String = "Non Member"
        println(
            """   
            |----------------------------- 
            |Checkout Pelanggan ${pelanggan}
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
        val input = Scanner(System.`in`)
        opening()

        for (loop in 0..dbBarang.i) {
            println("${dbBarang.namaBarang[loop]} X ${dbBarang.jumlahBarang[loop]}    : ${dbBarang.hargaBarang[loop]*${dbBarang.jumlahBarang[loop]}} ")
            var total:Int = dbBarang.hargaBarang[loop]*${dbBarang.jumlahBarang[loop]}
            dbBarang.totalSemua = dbBarang.totalSemua + total
        }
    }

    fun totalBelanja() {
        println(
            """   
            |----------------------------- 
            |Total Belanja : ${dbBarang.totalSemua}
            |-----------------------------
            """.trimMargin()
        )
    }

    fun diskon() {
        println(
            """   
            |Selamat! Karena total belanjaan lebih besar dari ${numberFormat.format(batasDiskon).toString()}, maka mendapatkan potongan sebesar $diskon %. 
            |Cukup Bayar ${numberFormat.format(dbBarang.totalSemua-(dbBarang.totalSemua*diskon/100)).toString()}
            |-----------------------------
            """.trimMargin()
        )
        dbBarang.totalSemua = dbBarang.totalSemua-(dbBarang.totalSemua*diskon)
    }

}