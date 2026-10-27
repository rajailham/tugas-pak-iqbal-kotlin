class StudentCard(
    val nim: String,
    var nama: String,
    val prodi: String
) {
    var totalSks: Int = 0
        private set

    val status: String
        get() = if (totalSks > 0) "Aktif" else "Baru"

    init {
        require(nim.length >= 7) { "NIM tidak valid" }
    }

    fun ambilSks(jumlah: Int) {
        if (jumlah > 0 && jumlah <= 24 - totalSks) {
            totalSks += jumlah
        }
    }

    fun ringkasan() =
        "$nim | $nama | $prodi | $totalSks SKS"
}

fun main() {
    val mahasiswa = StudentCard("2409020207", "Raja Ilham S.Siregar", "Teknologi Informasi")

    println("Status: ${mahasiswa.status}")
    mahasiswa.ambilSks(18)
    mahasiswa.ambilSks(9)
    println(mahasiswa.ringkasan())
}
